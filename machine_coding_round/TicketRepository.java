import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class TicketRepository {
    private Map<String, Ticket> tickets = new ConcurrentHashMap<String, Ticket>();
    private Map<String, SubTask> subtasks = new ConcurrentHashMap<String, SubTask>();

    // singleton-ish simple approach
    private static TicketRepository instance = new TicketRepository();
    private TicketRepository() {}
    public static TicketRepository getInstance() { return instance; }

    // create tickets - core functionality
    public Ticket createStory(String title, String desc) {
        Story s = new Story(title, desc);
        tickets.put(s.getId(), s);
        return s;
    }
    public Ticket createEpic(String title, String desc) {
        Epic e = new Epic(title, desc);
        tickets.put(e.getId(), e);
        return e;
    }
    public Ticket createOnCall(String title, String desc) {
        OnCall o = new OnCall(title, desc);
        tickets.put(o.getId(), o);
        return o;
    }

    // get ticket - throws in one place
    public Ticket getTicketById(String id) throws TicketNotFoundException {
        Ticket t = tickets.get(id);
        if (t == null) throw new TicketNotFoundException(id);
        return t;
    }

    // asymmetric method: findTicket returns null if not present (human-like inconsistency)
    public Ticket findTicket(String id) {
        return tickets.get(id); // may return null
    }

    // list tickets: return a new list copy (no unmodifiable)
    public List<Ticket> listAllTickets() {
        List<Ticket> copy = new ArrayList<Ticket>();
        for (Ticket t : tickets.values()) {
            copy.add(t);
        }
        return copy;
    }

    // update status with business rules and synchronized usage
    public void updateTicketStatus(String ticketId, String newStatus) throws TicketException {
        Ticket t = getTicketById(ticketId);
        synchronized(t) {
            // business rule: if it's a story and newStatus is final 'Deployed' then ensure subtasks done
            if (t.getType() == TicketType.STORY && "Deployed".equals(newStatus)) {
                List<String> subs = t.getSubTaskIds();
                // check each subtask status equals parent's final state
                // get parent's final state from story flow (dup logic: getFlow and get last element)
                Story s = (Story) t; // safe cast because type==STORY
                List<String> flow = s.getFlow();
                String finalState = flow.get(flow.size() - 1);
                for (int i = 0; i < subs.size(); i++) {
                    String sid = subs.get(i);
                    SubTask st = subtasks.get(sid);
                    if (st == null) continue; // hmm, maybe it's deleted
                    if (!finalState.equals(st.getStatus())) {
                        throw new InvalidStatusException("Cannot move story to Deployed; subtask " + sid + " not in " + finalState);
                    }
                }
            }
            // delegate to concrete ticket's update
            t.updateStatus(newStatus);
        }
    }

    // Sub-task operations
    public SubTask createSubTask(String parentTicketId, String title) throws TicketException {
        Ticket parent = getTicketById(parentTicketId);
        // initial status same as parent's current status
        String initStatus = parent.getStatus();
        SubTask st = new SubTask(parentTicketId, title, initStatus);
        subtasks.put(st.getId(), st);
        parent.addSubTaskId(st.getId());
        return st;
    }

    public SubTask getSubTaskById(String id) throws TicketNotFoundException {
        SubTask st = subtasks.get(id);
        if (st == null) throw new TicketNotFoundException(id);
        return st;
    }

    // update subtask status - validate against parent's flow
    public void updateSubTaskStatus(String subId, String newStatus) throws TicketException {
        SubTask st = getSubTaskById(subId);
        Ticket parent = getTicketById(st.getParentTicketId());
        // validate: ensure parent's allowed flow contains newStatus
        List<String> allowed = null;
        if (parent instanceof Story) allowed = ((Story)parent).getFlow();
        else if (parent instanceof Epic) allowed = ((Epic)parent).getFlow();
        else if (parent instanceof OnCall) allowed = ((OnCall)parent).getFlow();
        else allowed = new ArrayList<String>();

        boolean ok = false;
        for (int i = 0; i < allowed.size(); i++) {
            if (allowed.get(i).equals(newStatus)) { ok = true; break; }
        }
        if (!ok) throw new InvalidStatusException("Status not valid for subtask based on parent flow");

        synchronized(st) {
            st.setStatus(newStatus);
        }
        // also add a comment on parent (optional addition)
        parent.addComment("system", "Subtask " + subId + " moved to " + newStatus);
    }

    public void deleteSubTask(String subId) throws TicketException {
        SubTask st = getSubTaskById(subId);
        Ticket parent = getTicketById(st.getParentTicketId());
        synchronized(parent) {
            parent.removeSubTaskId(subId);
            subtasks.remove(subId);
        }
    }

    public List<SubTask> listSubTasksForTicket(String ticketId) {
        List<SubTask> list = new ArrayList<SubTask>();
        Ticket t = findTicket(ticketId);
        if (t == null) return list; // return empty list if no ticket
        List<String> subs = t.getSubTaskIds();
        for (int i = 0; i < subs.size(); i++) {
            String sid = subs.get(i);
            SubTask s = subtasks.get(sid);
            if (s != null) list.add(s);
        }
        return list;
    }
}
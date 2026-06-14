package JIRA;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TicketStore {
    // maps
    private final ConcurrentMap<String, Ticket> tickets = new ConcurrentHashMap<>();
    private final ConcurrentMap<String, SubTask> subTasks = new ConcurrentHashMap<>();

    // singleton
    private static final TicketStore INSTANCE = new TicketStore();
    private TicketStore() {}
    public static TicketStore getInstance() { return INSTANCE; }

    // create ticket
    public Ticket createTicket(TicketType type, String title, String description, String createdBy) {
        Ticket t = TicketFactory.createTicket(type, title, description, createdBy);
        tickets.put(t.getId(), t);
        return t;
    }

    public Ticket getTicket(String id) throws TicketNotFoundException {
        Ticket t = tickets.get(id);
        if (t == null) throw new TicketNotFoundException(id);
        return t;
    }

    public Collection<Ticket> listAllTickets() { return Collections.unmodifiableCollection(tickets.values()); }

    // Update ticket status with concurrency control and business rules
    public void updateTicketStatus(String ticketId, String newStatus, String user) throws TicketException {
        Ticket t = getTicket(ticketId);
        // lock the ticket to handle concurrent modifications
        t.lock();
        try {
            // If story and moving to final 'Deployed' ensure subtasks complete
            if (t.getType() == TicketType.STORY && "Deployed".equals(newStatus)) {
                // ensure all subtasks are in final state (last in allowed flow)
                List<String> subIds = t.getSubTaskIds();
                for (String sid : subIds) {
                    SubTask st = subTasks.get(sid);
                    if (st == null) continue; // ignore
                    // parent's last status
                    String parentFinal = t.getAllowedFlow().get(t.getAllowedFlow().size()-1);
                    if (!parentFinal.equals(st.getStatus())) {
                        throw new SubTaskNotCompleteException("Cannot mark story deployed while subtask " + sid + " is not " + parentFinal);
                    }
                }
            }
            t.setStatus(newStatus);
            t.addComment(user, "Status updated to " + newStatus);
        } finally { t.unlock(); }
    }

    // subtask management
    public SubTask createSubTask(String parentTicketId, String title) throws TicketNotFoundException {
        Ticket parent = getTicket(parentTicketId);
        // initial status same as parent current status's first element? requirement: same status flow as parent ticket. Set initial status to parent's current status
        String initial = parent.getStatus();
        SubTask st = new SubTask(parentTicketId, title, initial);
        subTasks.put(st.getId(), st);
        parent.addSubTask(st.getId());
        return st;
    }

    public SubTask getSubTask(String id) throws TicketException {
        SubTask st = subTasks.get(id);
        if (st == null) throw new TicketNotFoundException(id);
        return st;
    }

    public void updateSubTaskStatus(String subTaskId, String newStatus, String user) throws TicketException {
        SubTask st = getSubTask(subTaskId);
        String parentId = st.getParentTicketId();
        Ticket parent = getTicket(parentId);
        // validate that newStatus is in parent's flow
        if (!parent.getAllowedFlow().contains(newStatus)) throw new InvalidStatusTransitionException("Status not valid for this subtask based on parent flow");
        // concurrency: lock both parent and subtask to avoid races
        // acquire locks in consistent order: ticket id then subtask id
        parent.lock();
        try {
            st.lock();
            try {
                st.setStatus(newStatus);
                parent.addComment(user, "Subtask " + subTaskId + " status updated to " + newStatus);
            } finally { st.unlock(); }
        } finally { parent.unlock(); }
    }

    public void deleteSubTask(String subTaskId) throws TicketException {
        SubTask st = getSubTask(subTaskId);
        Ticket parent = getTicket(st.getParentTicketId());
        // lock parent
        parent.lock();
        try {
            parent.removeSubTask(subTaskId);
            subTasks.remove(subTaskId);
        } finally { parent.unlock(); }
    }

    // allow deleting ticket (and its subtasks)
    public void deleteTicket(String ticketId) throws TicketException {
        Ticket t = getTicket(ticketId);
        t.lock();
        try {
            // remove subtasks
            for (String sid : t.getSubTaskIds()) subTasks.remove(sid);
            tickets.remove(ticketId);
        } finally { t.unlock(); }
    }
}

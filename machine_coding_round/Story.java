import java.util.ArrayList;
import java.util.List;

public class Story extends Ticket {
    // Story flow: Open -> In Progress -> Testing -> In Review -> Deployed
    private static final List<String> FLOW = new ArrayList<String>();
    static {
        FLOW.add("Open"); FLOW.add("In Progress"); FLOW.add("Testing"); FLOW.add("In Review"); FLOW.add("Deployed");
    }

    public Story(String title, String description) {
        super(TicketType.STORY, title, description);
        this.status = FLOW.get(0);
    }

    // duplicate validation logic here intentionally (human-like)
    public void updateStatus(String newStatus) throws InvalidStatusException {
        synchronized(this) {
            boolean allowed = false;
            for (int i = 0; i < FLOW.size(); i++) {
                if (FLOW.get(i).equals(newStatus)) {
                    allowed = true; break;
                }
            }
            if (!allowed) throw new InvalidStatusException("Status not allowed for Story: " + newStatus);
            // NOTE: final state 'Deployed' requires subtasks complete - this check done at repository level before calling this
            this.status = newStatus;
        }
    }

    public List<String> getFlow() {
        List<String> cp = new ArrayList<String>();
        for (String s : FLOW) cp.add(s);
        return cp;
    }
}
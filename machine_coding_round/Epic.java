import java.util.ArrayList;
import java.util.List;

public class Epic extends Ticket {
    // Epic flow: Open -> In Progress -> Completed
    private static final List<String> FLOW = new ArrayList<String>();
    static { FLOW.add("Open"); FLOW.add("In Progress"); FLOW.add("Completed"); }

    public Epic(String title, String description) {
        super(TicketType.EPIC, title, description);
        this.status = FLOW.get(0);
    }

    public void updateStatus(String newStatus) throws InvalidStatusException {
        synchronized(this) {
            // here we inline validation, different style from Story (asymmetry)
            if (!FLOW.contains(newStatus)) {
                throw new InvalidStatusException("Invalid status for Epic: " + newStatus);
            }
            this.status = newStatus;
        }
    }

    public List<String> getFlow() {
        List<String> copy = new ArrayList<String>();
        for (String s : FLOW) copy.add(s);
        return copy;
    }
}
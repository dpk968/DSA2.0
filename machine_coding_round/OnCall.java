import java.util.ArrayList;
import java.util.List;

public class OnCall extends Ticket {
    // On-call flow: Open -> In Progress -> Resolved
    private static final List<String> FLOW = new ArrayList<String>();
    static { FLOW.add("Open"); FLOW.add("In Progress"); FLOW.add("Resolved"); }

    public OnCall(String title, String description) {
        super(TicketType.ONCALL, title, description);
        this.status = FLOW.get(0);
    }

    // duplicate small part of validation again - human touch
    public void updateStatus(String newStatus) throws InvalidStatusException {
        synchronized(this) {
            boolean ok = false;
            for (int i = 0; i < FLOW.size(); i++) {
                if (FLOW.get(i).equals(newStatus)) { ok = true; break; }
            }
            if (!ok) throw new InvalidStatusException("Bad status for OnCall: " + newStatus);
            this.status = newStatus;
        }
    }

    public List<String> getFlow() {
        List<String> c = new ArrayList<String>();
        for (String s : FLOW) c.add(s);
        return c;
    }
}
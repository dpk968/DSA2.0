package JIRA;

import java.util.Arrays;
import java.util.List;

public class TicketFactory {
    private static final List<String> STORY_FLOW = Arrays.asList("Open", "In Progress", "Testing", "In Review", "Deployed");
    private static final List<String> EPIC_FLOW = Arrays.asList("Open", "In Progress", "Completed");
    private static final List<String> ONCALL_FLOW = Arrays.asList("Open", "In Progress", "Resolved");

    public static Ticket createTicket(TicketType type, String title, String description, String createdBy) {
        switch (type) {
            case STORY:
                return new Ticket(type, title, description, createdBy, STORY_FLOW);
            case EPIC:
                return new Ticket(type, title, description, createdBy, EPIC_FLOW);
            case ONCALL:
                return new Ticket(type, title, description, createdBy, ONCALL_FLOW);
            default:
                throw new IllegalArgumentException("Unsupported ticket type");
        }
    }
}
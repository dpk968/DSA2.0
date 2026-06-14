package JIRA;

public class TicketNotFoundException extends TicketException {
	public TicketNotFoundException(String id) {
		super("Ticket not found: " + id);
	}
}
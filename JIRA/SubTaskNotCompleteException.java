package JIRA;

public class SubTaskNotCompleteException extends TicketException {
	public SubTaskNotCompleteException(String msg) {
		super(msg);
	}
}
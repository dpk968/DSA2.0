package JIRA;

public class InvalidStatusTransitionException extends TicketException {
    public InvalidStatusTransitionException(String msg) { super(msg); }
}
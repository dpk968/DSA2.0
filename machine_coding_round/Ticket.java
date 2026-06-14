import java.util.ArrayList;
import java.util.List;

public abstract class Ticket {
    protected final String id;
    protected final TicketType type;
    protected String title; // requirement: title
    protected String description; // good-to-have
    protected String status; // current status
    protected List<String> subTaskIds = new ArrayList<String>(); // store subtask ids
    protected List<String> comments = new ArrayList<String>(); // optional

    // flows will be defined in subclasses
    public Ticket(TicketType type, String title, String description) {
        this.id = IdGenerator.next(type.name().substring(0,1));
        this.type = type;
        this.title = title;
        this.description = description;
    }

    public String getId() { return id; }
    public TicketType getType() { return type; }
    public String getTitle() { return title; }
    public void setTitle(String t) { this.title = t; }
    public String getDescription() { return description; }
    public void setDescription(String d) { this.description = d; }

    public String getStatus() { return status; }

    public List<String> getSubTaskIds() {
        List<String> copy = new ArrayList<String>();
        for (String s : subTaskIds) {
            copy.add(s);
        }
        return copy;
    }

    public List<String> getComments() {
        List<String> c = new ArrayList<String>();
        for (String s : comments) c.add(s);
        return c;
    }

    public void addComment(String user, String comment) {
        synchronized(this) {
            comments.add((user==null?"unknown":user) + ": " + comment);
        }
    }

    public void addSubTaskId(String subId) {
        synchronized(this) {
            subTaskIds.add(subId);
        }
    }

    public void removeSubTaskId(String subId) {
        synchronized(this) {
            // manual loop to remove (no fancy methods)
            for (int i = 0; i < subTaskIds.size(); i++) {
                if (subTaskIds.get(i).equals(subId)) {
                    subTaskIds.remove(i);
                    break;
                }
            }
        }
    }

    // subclasses must implement updateStatus with validation
    public abstract void updateStatus(String newStatus) throws InvalidStatusException;

    @Override
    public String toString() {
        return "Ticket[" + id + "," + type + ",title=" + title + ",status=" + status + "]";
    }
}
public class SubTask {
    private final String id;
    private final String parentTicketId; // requirement: parent link
    private String title;
    private String status; // same status flow as parent

    public SubTask(String parentTicketId, String title, String initialStatus) {
        this.id = IdGenerator.next("ST");
        this.parentTicketId = parentTicketId;
        this.title = title;
        this.status = initialStatus;
    }

    public String getId() { return id; }
    public String getParentTicketId() { return parentTicketId; }
    public String getTitle() { return title; }
    public void setTitle(String t) { this.title = t; }
    public String getStatus() { return status; }

    public void setStatus(String s) { // simple setter; repo will validate against parent's flow
        this.status = s;
    }

    @Override
    public String toString() {
        return "SubTask[" + id + ",parent=" + parentTicketId + ",title=" + title + ",status=" + status + "]";
    }
}
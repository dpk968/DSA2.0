package JIRA;

import java.time.Instant;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

public class SubTask {
    private final String id;
    private final String parentTicketId;
    private String title;
    private String status;
    private final Instant createdAt;
    private final ReentrantLock lock = new ReentrantLock();

    public SubTask(String parentTicketId, String title, String initialStatus) {
        this.id = IdGenerator.nextId("s");
        this.parentTicketId = Objects.requireNonNull(parentTicketId);
        this.title = Objects.requireNonNull(title);
        this.status = initialStatus;
        this.createdAt = Instant.now();
    }

    public String getId() { return id; }
    public String getParentTicketId() { return parentTicketId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getStatus() { return status; }

    public void lock() { lock.lock(); }
    public void unlock() { lock.unlock(); }

    public void setStatus(String newStatus) {
        lock.lock();
        try { this.status = newStatus; } finally { lock.unlock(); }
    }

    @Override
    public String toString() {
        return "SubTask{" + "id='" + id + '\'' + ", parent='" + parentTicketId + '\'' + ", title='" + title + '\'' + ", status='" + status + '\'' + '}';
    }
}
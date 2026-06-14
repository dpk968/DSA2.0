package JIRA;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket {
    private final String id;
    private final TicketType type;
    private String title;
    private String description;
    private String status;
    private final List<String> allowedFlow; // ordered
    private final List<String> subTaskIds = new ArrayList<>();
    private final ReentrantLock lock = new ReentrantLock();
    private final List<String> comments = new ArrayList<>();
    private final String createdBy;
    private final Instant createdAt;

    public Ticket(TicketType type, String title, String description, String createdBy, List<String> allowedFlow) {
        this.id = IdGenerator.nextId(type.name().substring(0,1));
        this.type = type;
        this.title = Objects.requireNonNull(title);
        this.description = description;
        this.createdBy = createdBy == null ? "anonymous" : createdBy;
        this.allowedFlow = new ArrayList<>(allowedFlow);
        this.status = allowedFlow.get(0); // initial
        this.createdAt = Instant.now();
    }

    public String getId() { return id; }
    public TicketType getType() { return type; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }

    public List<String> getAllowedFlow() { return Collections.unmodifiableList(allowedFlow); }

    public List<String> getSubTaskIds() { return Collections.unmodifiableList(subTaskIds); }

    public void addComment(String user, String comment) {
        lock.lock();
        try {
            comments.add((user==null?"anonymous":user) + ": " + comment);
        } finally { lock.unlock(); }
    }

    public List<String> getComments() { lock.lock(); try { return new ArrayList<>(comments); } finally { lock.unlock(); } }

    public Instant getCreatedAt() { return createdAt; }
    public String getCreatedBy() { return createdBy; }

    // concurrency: operations that mutate must lock the ticket
    public void lock() { lock.lock(); }
    public void unlock() { lock.unlock(); }

    // Validate and set a status — allows any status from allowedFlow but validates order (not strictly only next step)
    public void setStatus(String newStatus) throws InvalidStatusTransitionException {
        lock.lock();
        try {
            if (!allowedFlow.contains(newStatus)) throw new InvalidStatusTransitionException("Status '" + newStatus + "' not in allowed flow for " + type);
            // allow moving forward or backward, but ensure story cannot be 'Deployed' unless subtasks complete — parent enforces externally
            this.status = newStatus;
        } finally { lock.unlock(); }
    }

    public void addSubTask(String subTaskId) {
        lock.lock();
        try { subTaskIds.add(subTaskId); } finally { lock.unlock(); }
    }

    public void removeSubTask(String subTaskId) {
        lock.lock();
        try { subTaskIds.remove(subTaskId); } finally { lock.unlock(); }
    }

    @Override
    public String toString() {
        return "Ticket{" + "id='" + id + '\'' + ", type=" + type + ", title='" + title + '\'' + ", status='" + status + '\'' + '}';
    }
}
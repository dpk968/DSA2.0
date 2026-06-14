package JIRA;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SprintManager {
    private final List<String> storyIds = new CopyOnWriteArrayList<>(); // thread-safe list
    private static final SprintManager INSTANCE = new SprintManager();
    private SprintManager() {}
    public static SprintManager getInstance() { return INSTANCE; }

    public void addStoryToSprint(String storyId) throws SprintException, TicketException {
        // ensure ticket exists and is a story
        Ticket t = TicketStore.getInstance().getTicket(storyId);
        if (t.getType() != TicketType.STORY) throw new SprintException("Only stories can be part of sprint");
        if (storyIds.contains(storyId)) throw new SprintException("Story already in sprint");
        storyIds.add(storyId);
    }

    public void removeStoryFromSprint(String storyId) throws SprintException {
        boolean removed = storyIds.remove(storyId);
        if (!removed) throw new SprintException("Story not in sprint: " + storyId);
    }

    public List<String> listSprintStories() { return Collections.unmodifiableList(storyIds); }
}

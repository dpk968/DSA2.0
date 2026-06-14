import java.util.ArrayList;
import java.util.List;

public class SprintManager {
    // Only story ids allowed in sprint
    private List<String> storyIds = new ArrayList<String>(); // synchronized via methods
    private static SprintManager instance = new SprintManager();
    private SprintManager() {}
    public static SprintManager getInstance() { return instance; }

    public synchronized void addStory(String storyId) throws SprintException, TicketException {
        TicketRepository repo = TicketRepository.getInstance();
        Ticket t = repo.findTicket(storyId);
        if (t == null) throw new SprintException("Story not found: " + storyId);
        if (t.getType() != TicketType.STORY) throw new SprintException("Only stories allowed in sprint");
        // check exists already
        for (int i = 0; i < storyIds.size(); i++) if (storyIds.get(i).equals(storyId)) throw new SprintException("Story already in sprint");
        storyIds.add(storyId);
    }

    public synchronized void removeStory(String storyId) throws SprintException {
        boolean removed = false;
        for (int i = 0; i < storyIds.size(); i++) {
            if (storyIds.get(i).equals(storyId)) { storyIds.remove(i); removed = true; break; }
        }
        if (!removed) throw new SprintException("Story not present in sprint: " + storyId);
    }

    public synchronized List<String> listStories() {
        List<String> cp = new ArrayList<String>();
        for (int i = 0; i < storyIds.size(); i++) cp.add(storyIds.get(i));
        return cp;
    }
}
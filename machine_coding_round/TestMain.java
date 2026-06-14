public class TestMain {
    public static void main(String[] args) {
        try {
            TicketRepository repo = TicketRepository.getInstance();
            SprintManager sprint = SprintManager.getInstance();

            System.out.println("--- Create tickets ---");
            Ticket story = repo.createStory("Implement login feature", "Implement login using email");
            Ticket epic = repo.createEpic("User authentication", "Group of auth related work");
            Ticket oncall = repo.createOnCall("Fix production bug", "critical prod fix");
            System.out.println(story);
            System.out.println(epic);
            System.out.println(oncall);

            System.out.println("\n--- Update story status to In Progress ---");
            repo.updateTicketStatus(story.getId(), "In Progress");
            System.out.println("Story now: " + repo.getTicketById(story.getId()));

            System.out.println("\n--- Sprint operations ---");
            sprint.addStory(story.getId());
            System.out.println("Sprint stories: " + sprint.listStories());
            sprint.removeStory(story.getId());
            System.out.println("Sprint after removal: " + sprint.listStories());

            System.out.println("\n--- Subtask management ---");
            SubTask st = repo.createSubTask(story.getId(), "Design login UI");
            System.out.println("Created subtask: " + st);
            repo.updateSubTaskStatus(st.getId(), "In Progress");
            System.out.println("Subtask after update: " + repo.getSubTaskById(st.getId()));
            repo.deleteSubTask(st.getId());
            System.out.println("Subtasks now: " + repo.listSubTasksForTicket(story.getId()).size());

            System.out.println("\n--- Cannot deploy story with incomplete subtask (expected) ---");
            SubTask st2 = repo.createSubTask(story.getId(), "Implement backend");
            try {
                repo.updateTicketStatus(story.getId(), "Deployed");
                System.err.println("ERROR: story deployed even though subtask incomplete");
            } catch (InvalidStatusException ex) {
                System.out.println("Expected failure: " + ex.getMessage());
            }
            // complete subtask and then deploy
            repo.updateSubTaskStatus(st2.getId(), "Deployed");
            repo.updateTicketStatus(story.getId(), "Deployed");
            System.out.println("Story after deploy: " + repo.getTicketById(story.getId()));

            System.out.println("\n--- Concurrency demo ---");
            final Ticket concurrent = repo.createStory("Concurrent story", "test concurrency");
            Thread a = new Thread(new Runnable(){ public void run() {
                try { repo.updateTicketStatus(concurrent.getId(), "In Progress"); System.out.println("Thread A set In Progress"); }
                catch (Exception e) { System.err.println("A error: " + e.getMessage()); }
            }});
            Thread b = new Thread(new Runnable(){ public void run() {
                try { repo.updateTicketStatus(concurrent.getId(), "Testing"); System.out.println("Thread B set Testing"); }
                catch (Exception e) { System.err.println("B error: " + e.getMessage()); }
            }});
            a.start(); b.start(); a.join(); b.join();
            System.out.println("Final concurrent ticket status: " + repo.getTicketById(concurrent.getId()).getStatus());

            System.out.println("\n--- Done ---");
        } catch (Exception e) {
            System.err.println("Test failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
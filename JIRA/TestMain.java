package JIRA;

public class TestMain {
    public static void main(String[] args) {
        try {
            TicketStore store = TicketStore.getInstance();
            SprintManager sprint = SprintManager.getInstance();

            // Example Scenario: Create tickets
            System.out.println("=== Create Tickets ===");
            Ticket s1 = store.createTicket(TicketType.STORY, "Implement login feature", "Login using email/password", "alice");
            Ticket e1 = store.createTicket(TicketType.EPIC, "User authentication", "Parent epic for auth work", "bob");
            Ticket o1 = store.createTicket(TicketType.ONCALL, "Fix production bug", "High priority prod issue", "carol");
            
            System.out.println(s1);
            System.out.println(e1);
            System.out.println(o1);

            // Update status of story
            System.out.println("\n=== Update Ticket Status ===");
            store.updateTicketStatus(s1.getId(), "In Progress", "alice");
            System.out.println("After status update: " + store.getTicket(s1.getId()));

            // Sprint management
            System.out.println("\n=== Sprint Management ===");
            sprint.addStoryToSprint(s1.getId());
            System.out.println("Sprint stories: " + sprint.listSprintStories());
            sprint.removeStoryFromSprint(s1.getId());
            System.out.println("Sprint stories after removal: " + sprint.listSprintStories());

            // Sub-task management
            System.out.println("\n=== Sub-task Management ===");
            SubTask st1 = store.createSubTask(s1.getId(), "Design login UI");
            System.out.println("Created subtask: " + st1);
            store.updateSubTaskStatus(st1.getId(), "In Progress", "dave");
            System.out.println("Subtask after update: " + store.getSubTask(st1.getId()));
            store.deleteSubTask(st1.getId());
            System.out.println("Subtask deleted. Remaining subtasks: " + store.getTicket(s1.getId()).getSubTaskIds());

            // Edge case: cannot deploy story if subtask not complete
            System.out.println("\n=== Edge case: Deploy story with incomplete subtask (should fail) ===");
            SubTask st2 = store.createSubTask(s1.getId(), "Implement backend auth");
            try {
                store.updateTicketStatus(s1.getId(), "Deployed", "alice");
                System.err.println("ERROR: Story deployed despite incomplete subtasks");
            } catch (SubTaskNotCompleteException ex) {
                System.out.println("Expected failure: " + ex.getMessage());
            }
            // complete subtask
            store.updateSubTaskStatus(st2.getId(), "Deployed", "dave");
            // now deploying story should succeed
            store.updateTicketStatus(s1.getId(), "Deployed", "alice");
            System.out.println("Story after deploy: " + store.getTicket(s1.getId()));

            // Concurrency demo: multiple users updating the same ticket
            System.out.println("\n=== Concurrency Demo ===");
            Ticket concurrentStory = store.createTicket(TicketType.STORY, "Concurrent story", "Test concurrent updates", "eve");
            Runnable r1 = () -> {
                try {
                    store.updateTicketStatus(concurrentStory.getId(), "In Progress", "user1");
                    System.out.println("user1 updated to In Progress");
                } catch (Exception e) { System.err.println("user1 error: " + e.getMessage()); }
            };
            Runnable r2 = () -> {
                try {
                    store.updateTicketStatus(concurrentStory.getId(), "Testing", "user2");
                    System.out.println("user2 updated to Testing");
                } catch (Exception e) { System.err.println("user2 error: " + e.getMessage()); }
            };
            Thread t1Thread = new Thread(r1);
            Thread t2Thread = new Thread(r2);
            t1Thread.start(); t2Thread.start();
            t1Thread.join(); t2Thread.join();
            System.out.println("Final status: " + store.getTicket(concurrentStory.getId()).getStatus());

            System.out.println("\n=== All tests/demo completed ===");

        } catch (Exception e) {
            System.err.println("Test failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
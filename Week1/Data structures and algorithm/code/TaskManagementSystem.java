
class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Task{" +
                "ID=" + taskId +
                ", Name='" + taskName + '\'' +
                ", Status='" + status + '\'' +
                '}';
    }
}

public class TaskManagementSystem {
    private Task head;

    // Add task to the end
    public void addTask(int id, String name, String status) {
        Task newTask = new Task(id, name, status);
        if (head == null) {
            head = newTask;
        } else {
            Task temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newTask;
        }
        System.out.println("Task added.");
    }

    // Search task by ID
    public void searchTask(int id) {
        Task temp = head;
        while (temp != null) {
            if (temp.taskId == id) {
                System.out.println("Found: " + temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Task not found.");
    }

    // Traverse all tasks
    public void traverseTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }
        Task temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    // Delete task by ID
    public void deleteTask(int id) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.taskId == id) {
            head = head.next;
            System.out.println("Task deleted.");
            return;
        }

        Task prev = head;
        Task current = head.next;

        while (current != null) {
            if (current.taskId == id) {
                prev.next = current.next;
                System.out.println("Task deleted.");
                return;
            }
            prev = current;
            current = current.next;
        }

        System.out.println("Task not found.");
    }

    public static void main(String[] args) {
        TaskManagementSystem system = new TaskManagementSystem();

        system.addTask(1, "Design Database", "Pending");
        system.addTask(2, "Write API", "In Progress");
        system.addTask(3, "Test Application", "Pending");

        System.out.println("\nAll Tasks:");
        system.traverseTasks();

        System.out.println("\nSearching for Task ID 2:");
        system.searchTask(2);

        System.out.println("\nDeleting Task ID 2:");
        system.deleteTask(2);

        System.out.println("\nAll Tasks after deletion:");
        system.traverseTasks();
    }
}

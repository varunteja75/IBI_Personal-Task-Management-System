import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
class Task {
    private int taskID;
    private String taskName;
    private Date dueDate;
    private String priority;

    
    public Task(int taskID, String taskName, Date dueDate, String priority) {
        this.taskID = taskID;
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    
    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return "Task ID: " + taskID + ", Name: " + taskName + ", Due Date: " + dateFormat.format(dueDate) + ", Priority: " + priority;
    }
}

public class TaskManager {
    private ArrayList<Task> tasks;
    private Scanner scanner;
    private SimpleDateFormat dateFormat;

    public TaskManager() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    
    public void addTask() {
        try {
            System.out.print("Enter Task ID: ");
            int taskID = Integer.parseInt(scanner.nextLine());
            
            
            if (findTaskById(taskID) != null) {
                System.out.println("Error: Task ID already exists!");
                return;
            }

            System.out.print("Enter Task Name: ");
            String taskName = scanner.nextLine();

            System.out.print("Enter Due Date (yyyy-MM-dd): ");
            String dueDateStr = scanner.nextLine();
            Date dueDate = dateFormat.parse(dueDateStr);

            System.out.print("Enter Priority (High/Medium/Low): ");
            String priority = scanner.nextLine().toLowerCase();
            if (!priority.equals("high") && !priority.equals("medium") && !priority.equals("low")) {
                System.out.println("Error: Invalid priority! Must be High, Medium, or Low.");
                return;
            }

            Task task = new Task(taskID, taskName, dueDate, priority);
            tasks.add(task);
            System.out.println("Task added successfully!");
        } catch (ParseException e) {
            System.out.println("Error: Invalid date format! Please use yyyy-MM-dd");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid Task ID! Must be a number.");
        }
    }

    
    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("\nSort by: 1. Priority 2. Due Date");
        System.out.print("Enter choice (1 or 2): ");
        String sortChoice = scanner.nextLine();

        ArrayList<Task> sortedTasks = new ArrayList<>(tasks);
        if (sortChoice.equals("1")) {
            
            Collections.sort(sortedTasks, (t1, t2) -> {
                int p1 = getPriorityValue(t1.getPriority());
                int p2 = getPriorityValue(t2.getPriority());
                return Integer.compare(p2, p1); // Higher priority first
            });
        } else if (sortChoice.equals("2")) {
            
            Collections.sort(sortedTasks, Comparator.comparing(Task::getDueDate));
        } else {
            System.out.println("Invalid sort option, displaying unsorted list.");
        }

        System.out.println("\nTasks:");
        for (Task task : sortedTasks) {
            System.out.println(task);
        }
    }

    
    private int getPriorityValue(String priority) {
        switch (priority.toLowerCase()) {
            case "high": return 3;
            case "medium": return 2;
            case "low": return 1;
            default: return 0;
        }
    }

    
    public void updateTask() {
        System.out.print("Enter Task ID to update: ");
        try {
            int taskID = Integer.parseInt(scanner.nextLine());
            Task task = findTaskById(taskID);

            if (task == null) {
                System.out.println("Error: Task not found!");
                return;
            }

            System.out.println("Current task: " + task);
            System.out.println("Enter new details (press Enter to keep current value):");

            System.out.print("New Task Name (" + task.getTaskName() + "): ");
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) {
                task.setTaskName(newName);
            }

            System.out.print("New Due Date (" + dateFormat.format(task.getDueDate()) + ") (yyyy-MM-dd): ");
            String newDueDate = scanner.nextLine();
            if (!newDueDate.isEmpty()) {
                try {
                    task.setDueDate(dateFormat.parse(newDueDate));
                } catch (ParseException e) {
                    System.out.println("Error: Invalid date format! Date not updated.");
                }
            }

            System.out.print("New Priority (" + task.getPriority() + ") (High/Medium/Low): ");
            String newPriority = scanner.nextLine().toLowerCase();
            if (!newPriority.isEmpty()) {
                if (newPriority.equals("high") || newPriority.equals("medium") || newPriority.equals("low")) {
                    task.setPriority(newPriority);
                } else {
                    System.out.println("Error: Invalid priority! Priority not updated.");
                }
            }

            System.out.println("Task updated successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid Task ID! Must be a number.");
        }
    }

    
    public void deleteTask() {
        System.out.print("Enter Task ID to delete: ");
        try {
            int taskID = Integer.parseInt(scanner.nextLine());
            Task task = findTaskById(taskID);

            if (task == null) {
                System.out.println("Error: Task not found!");
                return;
            }

            tasks.remove(task);
            System.out.println("Task deleted successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid Task ID! Must be a number.");
        }
    }

    
    private Task findTaskById(int taskID) {
        for (Task task : tasks) {
            if (task.getTaskID() == taskID) {
                return task;
            }
        }
        return null;
    }

    
    public void run() {
        while (true) {
            System.out.println("\nTask Management System");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addTask();
                    break;
                case "2":
                    viewTasks();
                    break;
                case "3":
                    updateTask();
                    break;
                case "4":
                    deleteTask();
                    break;
                case "5":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        manager.run();
    }
}
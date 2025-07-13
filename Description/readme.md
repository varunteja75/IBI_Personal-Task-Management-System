Task Description: You will be developing a console-based application that enables users to store and manage their tasks. The system should allow users to add, view, update, and delete tasks while managing basic task details such as task name, due date, and priority.

Task Steps:

Create Data Model:

Task Class:
Fields: TaskID, TaskName, DueDate, Priority.
Methods:
Constructor to initialize task details.
Getter and Setter methods for each field.
System Functionality:

Add Task: Implement functionality to add a new task. You will collect details like TaskID, TaskName, DueDate, and Priority from the user.
View Tasks: Implement functionality to display a list of all tasks and their details.
Update Task: Allow users to update the task's name, due date, or priority.
Delete Task: Implement functionality to delete a task by its TaskID.
Basic Priority Calculation:

Implement a method to display tasks sorted by priority or due date. For simplicity, consider a priority system where tasks can have High, Medium, or Low priority.
Store Task Data:

Use an ArrayList to store task objects. You will be working with a simple in-memory list for this project, so data will not persist once the program is closed.
Console Interface:

Create a basic text-based user interface (UI) using System.in to interact with the user. The user should be able to:
Add a new task.
View all tasks.
Update task details (name, due date, or priority).
Delete a task.
Sample Menu:

markdown
Copy
1. Add Task
2. View Tasks
3. Update Task
4. Delete Task
5. Exit
Error Handling:

Ensure that the program handles basic errors gracefully, such as invalid input or trying to update or delete a non-existing task.

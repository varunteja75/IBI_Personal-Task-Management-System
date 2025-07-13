1.Add Task (Option 1):
Purpose: Creates a new task and adds it to an in-memory list.
How It Works:
Prompts for:
Task ID: A unique integer identifier.
Task Name: A string describing the task (e.g., "Complete Project").
Due Date: A date in yyyy-MM-dd format (e.g., 2025-07-20).
Priority: One of High, Medium, or Low (case-insensitive).
Validates input:
Ensures Task ID is unique and numeric.
Verifies date format is valid.
Checks priority is one of the allowed values.
Creates a Task object and stores it in an ArrayList.

2.View Tasks (Option 2):
Purpose: Displays all tasks, optionally sorted by priority or due date.
How It Works:
If no tasks exist, shows "No tasks available."
Prompts to sort by:
1. Priority: Sorts tasks with High priority first, then Medium, then Low.
2. Due Date: Sorts tasks chronologically by due date (earliest first).
Displays each task’s ID, name, due date, and priority

3.Update Task (Option 3):
Purpose: Modifies an existing task’s name, due date, or priority.
How It Works:
Prompts for the Task ID to update.
Displays the current task details if found.
Allows updating:
Task Name: Enter a new name or press Enter to keep current.
Due Date: Enter a new date (yyyy-MM-dd) or press Enter to keep current.
Priority: Enter High, Medium, or Low, or press Enter to keep current.
Validates input for date format and priority.

4.Delete Task (Option 4):
Purpose: Removes a task from the list by its Task ID.
How It Works:
Prompts for the Task ID to delete.
Removes the task from the ArrayList if found.

5.Exit (Option 5):
Purpose: Terminates the program.
How It Works:
Closes the Scanner and exits the application.
Data is not saved (in-memory storage, as specified).

package example.tasktracker;

import java.util.List;

import example.json.TaskStorage;
import example.model.Task;

// This task will handle the main commands

public class TaskTrackerCLI {
	public static void main(String[] args) {
		System.out.println(args.toString());
		if (args.length == 0) {
			System.out.println("Usage: java TaskTrackerCLI <command> [arguments]");
			return;
		}
		String command = args[0];
		List<Task> tasks = TaskStorage.readTasks();
		switch (command) {
		case "add":
			if (args.length < 2) {
				System.out.println("Please provide the task description.");
				return;
			}
			String description = args[1];
			int id = tasks.size() + 1;
			Task task = new Task(id, description);
			tasks.add(task);
			TaskStorage.saveTasks(tasks);
			System.out.println("Task added successfully (Id: " + id + ")");
			break;
		case "list":
			for (Task t : tasks) {
				System.out.println(t.getId() + ": " + t.getDescription() + " [" + t.getStatus() + "]");
			}
			break;
		case "update":
			if (args.length < 3) {
				System.out.println("Usage: update <task_id> <new_description>");
				return;
			}
			int updateId = Integer.parseInt(args[1]);
			String newDescription = args[2];
			boolean updated = false;
			for (Task t : tasks) {
				if (t.getId() == updateId) {
					t.setDescription(newDescription);
					updated = true;
					break;
				}
			}
			if (updated) {
				TaskStorage.saveTasks(tasks);
				System.out.println("Task updated successfully.");
			} else {
				System.out.println("Task ID not found.");
			}
			break;
		case "remove":
			// After deletion, the IDs won’t automatically shift. That’s fine for this
			// project; IDs just need to remain unique.
			if (args.length < 2) {
				System.out.println("Usage: delete <task_id>");
				return;
			}
			int deleteId = Integer.parseInt(args[1]);
			boolean removed = tasks.removeIf((t) -> t.getId() == deleteId);
			if (removed) {
				TaskStorage.saveTasks(tasks);
				System.out.println("Task deleted successfully.");
			} else {
				System.out.println("Task ID not found.");
			}
			break;
		case "mark-in-progress":
			if (args.length < 2) {
				System.out.println("Usage: mark-in-progress <task_id>");
				return;
			}
			int progressId = Integer.parseInt(args[1]);
			boolean foundProgress = false;
			for (Task t : tasks) {
				if (t.getId() == progressId) {
					t.setStatus("in-progress");
					foundProgress = true;
					break;
				}
			}
			if (foundProgress) {
				TaskStorage.saveTasks(tasks);
				System.out.println("Task marked as in-progress.");
			} else {
				System.out.println("Task ID not found.");
			}
			break;

		case "mark-done":
			if (args.length < 2) {
				System.out.println("Usage: mark-done <task_id>");
				return;
			}
			int doneId = Integer.parseInt(args[1]);
			boolean foundDone = false;
			for (Task t : tasks) {
				if (t.getId() == doneId) {
					t.setStatus("done");
					foundDone = true;
					break;
				}
			}
			if (foundDone) {
				TaskStorage.saveTasks(tasks);
				System.out.println("Task marked as done.");
			} else {
				System.out.println("Task ID not found.");
			}
			break;
		case "list-by-status":
			String filter = args.length > 1 ? args[1] : "all";
			for (Task t : tasks) {
				if (filter.equals("all") || t.getStatus().equals(filter)) {
					System.out.println(t.getId() + ": " + t.getDescription() + " [" + t.getStatus() + "]");
				}
			}
			break;

		default:
			System.out.println("Unknown Command: " + command);
		}
	}
}

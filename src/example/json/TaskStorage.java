package example.json;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import example.model.Task;

// We will create a helper class TaskStorage.java for reading/writing tasks to tasks.json.
// Note: For the basic version, we can store tasks in a simple |-separated format. Later, we can fully convert it to JSON manually if needed.

public class TaskStorage {
	private static final String FILE_NAME = "tasks.json";
	
	// Read tasks from file
	public static List<Task> readTasks(){
		List<Task> tasks = new ArrayList<Task>();
		File file = new File(FILE_NAME);
		if(!file.exists())
			return tasks; // empty list
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			String line;
			while((line = br.readLine()) != null) {
				// basic parsing (later we can refine)
				if(!line.trim().isEmpty()) {
					String[ ] parts = line.split("\\|");
					Task t = new Task(Integer.parseInt(parts[0]), parts[1]);
					t.setStatus(parts[2]);
					tasks.add(t);
				}
			}
		} catch (IOException e) {
			e.getMessage();
		}
		return tasks;
	}
	
	// Save tasks to file
	public static  void saveTasks(List<Task> tasks) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))){
			for(Task t : tasks) {
				bw.write(t.getId() + "|" + t.getDescription() + "|" + t.getStatus() + "\n");
			}
		} catch (IOException e) {
			e.getMessage();
		}
	}
	
	
}

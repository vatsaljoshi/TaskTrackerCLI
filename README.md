
# Task Tracker CLI (Java)

A simple **Command-Line Interface (CLI)** application to manage your tasks and to-do list. This project allows you to **add, update, delete, and track tasks** with different statuses: `todo`, `in-progress`, and `done`. All tasks are stored in a local file.

---

## Features

- **Add tasks**  
- **Update tasks**  
- **Delete tasks**  
- **Mark tasks as in-progress or done**  
- **List all tasks**  
- **Filter tasks by status** (`todo`, `in-progress`, `done`)  
- Stores tasks locally in a file (`tasks.json` or text file)  

---

## Task Properties

Each task has the following properties:

| Property    | Description                         |
|------------|-------------------------------------|
| `id`       | Unique identifier for the task      |
| `description` | Short description of the task       |
| `status`   | `todo`, `in-progress`, or `done`   |
| `createdAt`| Date and time when task was created |
| `updatedAt`| Date and time when task was last updated |

---

## Project Structure

```

TaskTrackerCLI/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── example/
│                   └── tasktracker/
│                       ├── Task.java
│                       ├── TaskStorage.java
│                       └── TaskTrackerCLI.java
└── tasks.json

````

---

## Prerequisites

- Java JDK 11+ installed  
- Terminal or command prompt  

---

## How to Run

1. Navigate to the `src/main/java` directory:

```bash
cd /path/to/TaskTrackerCLI/src/main/java
````

2. Compile the Java files:

```bash
javac com/example/tasktracker/*.java
```

3. Run the CLI with commands:

```bash
java com.example.tasktracker.TaskTrackerCLI <command> [arguments]
```

---

## Usage Examples

### Add a Task

```bash
java com.example.tasktracker.TaskTrackerCLI add "Buy groceries"
```

Output:

```
Task added successfully (ID: 1)
```

---

### List All Tasks

```bash
java com.example.tasktracker.TaskTrackerCLI list
```

Output:

```
1: Buy groceries [todo]
```

---

### Update a Task

```bash
java com.example.tasktracker.TaskTrackerCLI update 1 "Buy groceries and cook dinner"
```

---

### Delete a Task

```bash
java com.example.tasktracker.TaskTrackerCLI delete 1
```

---

### Mark a Task as In-Progress

```bash
java com.example.tasktracker.TaskTrackerCLI mark-in-progress 1
```

---

### Mark a Task as Done

```bash
java com.example.tasktracker.TaskTrackerCLI mark-done 1
```

---

### List Tasks by Status

```bash
java com.example.tasktracker.TaskTrackerCLI list todo
java com.example.tasktracker.TaskTrackerCLI list in-progress
java com.example.tasktracker.TaskTrackerCLI list done
```

---

## Screenshots

*Add your screenshots here to showcase the CLI in action.*

---

## Notes

* This project uses **only the standard Java library**; no external dependencies.
* The `tasks.json` (or text file) is created automatically in the project root if it does not exist.
* Task IDs remain unique even after deletion.

---

## Screenshots
<img width="558" height="791" alt="Screen Shot 2025-10-03 at 18 57 34" src="https://github.com/user-attachments/assets/661e70e3-f863-4ac4-b3d1-b23f681e007a" />

---

## License

This project is open-source and free to use.

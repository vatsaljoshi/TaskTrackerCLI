package example.model;

import java.time.LocalDateTime;

public class Task {
	private int id;
	private String description;
	private String status;
	private String createdAt;
	private String updatedAt;
	
	public Task(int id, String description) {
		super();
		this.id = id;
		this.description = description;
		this.status = "todo";
		this.createdAt = LocalDateTime.now().toString();
		this.updatedAt = LocalDateTime.now().toString();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}
	
	
	
}

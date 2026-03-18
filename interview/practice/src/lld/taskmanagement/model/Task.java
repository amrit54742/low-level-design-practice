package lld.taskmanagement.model;

import java.time.LocalDate;

public class Task {
    private String id;
    private String title;
    private String description;
    private User assignedUser;
    private TaskStatus status;
    private Priority priority;
    private LocalDate dueDate;

    public Task(String id, String title, String description,
                User assignedUser, Priority priority, LocalDate dueDate) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.assignedUser = assignedUser;
        this.priority = priority;
        this.dueDate = dueDate;
        this.status = TaskStatus.TODO;
    }

    public String getId() { return id; }

    public User getAssignedUser() { return assignedUser; }

    public TaskStatus getStatus() { return status; }

    public Priority getPriority() { return priority; }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public void setAssignedUser(User user) {
        this.assignedUser = user;
    }
}

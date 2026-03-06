package lld.taskscheduler;


public class Task implements Comparable<Task> {

    private long executionTime;
    private Runnable task;

    public Task( String taskId, long executionTime, Runnable task) {
        this.executionTime = executionTime;
        this.task = task;
        this.taskId = taskId;
    }

    private String taskId;


    public long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(long executionTime) {
        this.executionTime = executionTime;
    }

    public Runnable getTask() {
        return task;
    }

    public void setTask(Runnable task) {
        this.task = task;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    @Override
    public int compareTo(Task other) {
        return (Long.compare(this.executionTime , other.executionTime));
    }
}
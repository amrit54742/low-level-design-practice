package lld.taskschedulersecondapproach;

public class SecondTask implements Comparable<SecondTask> {

    private String taskId;
    private long executionTime;
    private Runnable executor;

    public SecondTask(String taskId, long executionTime, Runnable task) {
        this.taskId = taskId;
        this.executionTime = executionTime;
        this.executor = task;
    }

    public long getExecutionTime() {
        return executionTime;
    }

    public Runnable getExecutor() {
        return executor;
    }

    public String getTaskId() {
        return taskId;
    }

    @Override
    public int compareTo(SecondTask other) {
        return Long.compare(this.executionTime, other.executionTime);
    }
}
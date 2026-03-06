package lld.taskscheduler;

public class TaskExecutor {

    public void execute(Task task) {
        System.out.println("running task of id=  " + task.getTaskId());
        task.getTask().run();
    }
}
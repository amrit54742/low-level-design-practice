package lld.taskscheduler;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        TaskScheduler scheduler = TaskScheduler.getInstance();

        Task task1 = new Task(
                "Task1",
                System.currentTimeMillis() + 3000,
                () -> System.out.println("Running Task 1")
        );

        Task task2 = new Task(
                "Task2",
                System.currentTimeMillis() + 1000,
                () -> System.out.println("Running Task 2")
        );

        scheduler.scheduleTask(task1);
        scheduler.scheduleTask(task2);

        Thread.sleep(5000);
        //todo: wait() = release lock + sleep
        //sleep() = NO lock release

    }
}
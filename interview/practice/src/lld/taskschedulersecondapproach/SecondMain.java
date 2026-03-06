package lld.taskschedulersecondapproach;



public class SecondMain {

    public static void main(String[] args) throws InterruptedException {

        SecondTaskScheduler scheduler = SecondTaskScheduler.getInstance();

        SecondTask task1 = new SecondTask(
                "Task1",
                System.currentTimeMillis() + 3000,
                new SecondTaskExecutorAdd(10, 5)
        );

        SecondTask task2 = new SecondTask(
                "Task2",
                System.currentTimeMillis() + 1000,
                new SecondTaskExecutorSub(10, 5)
        );


        scheduler.scheduleTask(task1);
        scheduler.scheduleTask(task2);

        Thread.sleep(5000);
    }
    }
package lld.taskschedulersecondapproach;


import java.util.PriorityQueue;
public class SecondTaskScheduler {

    private static SecondTaskScheduler instance;

    private PriorityQueue<SecondTask> taskQueue;

    private Runnable executor;

    private SecondTaskScheduler() {

        taskQueue = new PriorityQueue<>();
        startScheduler();
    }

    public static synchronized SecondTaskScheduler getInstance() {

        if(instance == null) {
            instance = new SecondTaskScheduler();
        }

        return instance;
    }

    public synchronized void scheduleTask(SecondTask task) {

        taskQueue.offer(task);

        notify();
    }

    private void startScheduler() {

        Thread schedulerThread = new Thread(() -> {

            while(true) {

                try {

                    SecondTask task;

                    synchronized (this) {

                        while(taskQueue.isEmpty()) {
                            wait();
                        }

                        task = taskQueue.peek();

                        long now = System.currentTimeMillis();

                        if(task.getExecutionTime() > now) {

                            wait(task.getExecutionTime() - now);

                            continue;
                        }

                        taskQueue.poll();
                    }
                    System.out.println("Executing: " + task.getTaskId());
                    System.out.println("new thread");

                    task.getExecutor().run();

                } catch(Exception e) {
                    e.printStackTrace();
                }

            }

        });

        schedulerThread.setDaemon(true);
        schedulerThread.start();
        System.out.println("main thread");
    }
}
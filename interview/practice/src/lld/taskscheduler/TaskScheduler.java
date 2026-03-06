package lld.taskscheduler;

import lombok.NoArgsConstructor;

import java.util.PriorityQueue;

public class TaskScheduler {

    private static TaskScheduler instance;

    public TaskScheduler() {
        startScheduler();
    }

    //todo: check offer vs add and compareto function with getter inside the return function
    public static TaskScheduler getInstance(){
        if (instance == null){
            return new TaskScheduler();
        } else {
            return instance;
        }
    }

    private PriorityQueue<Task> taskPriorityQueue= new PriorityQueue<>();
    private TaskExecutor taskExecutor = new TaskExecutor();

    public synchronized void scheduleTask(Task task){
        taskPriorityQueue.offer(task);
        notify();
    }

    private void startScheduler(){
        Thread schedulerThread = new Thread(() -> {
            while (true) {
                try {
                    Task task;
                    synchronized (this){
                        while (taskPriorityQueue.isEmpty()){
                            wait();
                        }
                        task= taskPriorityQueue.peek();
                        long currentTimeInMillis= System.currentTimeMillis();
                        if (task.getExecutionTime() - currentTimeInMillis > 0){
                            wait(task.getExecutionTime() - currentTimeInMillis);
                            continue;
                        }
                        taskPriorityQueue.poll();

                    }
                    taskExecutor.execute(task);


                } catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
        schedulerThread.setDaemon(true);
        schedulerThread.start();
    }


}

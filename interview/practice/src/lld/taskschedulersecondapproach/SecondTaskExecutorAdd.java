package lld.taskschedulersecondapproach;


public class SecondTaskExecutorAdd implements Runnable{



    private int a;
    private int b;

    public SecondTaskExecutorAdd(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        int result = a + b;

        System.out.println(
                "AdditionExecutor: " + a + " + " + b + " = " + result
        );
    }
}
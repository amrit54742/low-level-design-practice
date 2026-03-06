package lld.taskschedulersecondapproach;



public class SecondTaskExecutorSub implements Runnable {

    private int a;
    private int b;

    public SecondTaskExecutorSub(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {

        int result = a - b;

        System.out.println(
                "SubtractionExecutor: " + a + " - " + b + " = " + result
        );
    }
}

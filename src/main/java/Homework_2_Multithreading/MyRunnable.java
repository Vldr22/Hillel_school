package Homework_2_Multithreading;

public class MyRunnable extends ValueCalculator implements Runnable {

    @Override
    public void run() {

        gateGluing();
        reverse();
        shuffling();
        findMaxValue();

        System.out.println(Thread.currentThread().getName() + " completed the task in: "
                + (System.currentTimeMillis() - start + " millis"));

    }
}

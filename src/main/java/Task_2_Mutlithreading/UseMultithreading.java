package Task_2_Mutlithreading;

public interface UseMultithreading {

    default void startWithOneThread() {
        Thread thread1 = new Thread(new MyRunnable(), "Lonely Thread");
        thread1.start();
    }

    default void startWithTwoThreads() {

        Thread thread1 = new Thread(new MyRunnable(), "First Thread");
        Thread thread2 = new Thread(new MyRunnable(), "Second Thread");
        thread1.start();
        thread2.start();
    }

    default void startWithSixThreads(int amountThreads) {
        for (int i = 1; i < amountThreads + 1; i++) {
            Thread thread = new Thread(new MyRunnable(), "Thread number " + i);
            thread.start();
        }
    }

}

package Task_2_Mutlithreading;

public interface UseMultithreading {

     default void startWithThreads(int amountThreads) {
        for (int i = 1; i < amountThreads + 1; i++) {
            Thread thread = new Thread(new MyRunnable(), "Thread number " + i);
            thread.start();
        }
    }

}

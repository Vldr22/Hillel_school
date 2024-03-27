package Task_2_Mutlithreading;

public class App {

    public static void main(String[] args) {

        ValueCalculator valueCalculator1 = new ValueCalculator();
        valueCalculator1.startWithOneThread();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        ValueCalculator valueCalculator2 = new ValueCalculator();
        valueCalculator2.startWithTwoThreads();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        ValueCalculator valueCalculator3 = new ValueCalculator();
        valueCalculator3.startWithSixThreads(10);


    }
}

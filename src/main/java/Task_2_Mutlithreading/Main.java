package Task_2_Mutlithreading;

public class Main {

    public static void main(String[] args) {

        ValueCalculator valueCalculator1 = new ValueCalculator();
        valueCalculator1.startWithThreads(1);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        ValueCalculator valueCalculator2 = new ValueCalculator();
        valueCalculator2.startWithThreads(2);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        ValueCalculator valueCalculator3 = new ValueCalculator();
        valueCalculator3.startWithThreads(10);


    }
}

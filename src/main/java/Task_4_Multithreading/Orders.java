package Task_4_Multithreading;

public class Orders {

    public final String name;
    public final double amount;
    public boolean statusAtWork = false;

    public Orders(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}

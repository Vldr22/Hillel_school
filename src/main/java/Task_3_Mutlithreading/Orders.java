package Task_3_Mutlithreading;

public class Orders {

    public final String name;
    public final double amount;

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

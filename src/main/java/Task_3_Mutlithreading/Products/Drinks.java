package Task_3_Mutlithreading.Products;

public class Drinks {

    private final String name;
    private final double alcoholPercent;
    public volatile double amount;

    public Drinks(String name, double alcoholPercent, double amount) {
        this.name = name;
        this.alcoholPercent = alcoholPercent;
        this.amount = amount;
    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Drinks{" +
                "NAME='" + name + '\'' +
                ", ALCOHOL_PERCENT=" + alcoholPercent +
                ", amount=" + amount +
                '}';
    }
}

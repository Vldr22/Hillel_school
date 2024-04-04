package Task_3_Mutlithreading.Products;

public class Drinks {

    private final String NAME;
    private final double ALCOHOL_PERCENT;
    public volatile double amount;

    public Drinks(String name, double alcoholPercent, double amount) {
        NAME = name;
        ALCOHOL_PERCENT = alcoholPercent;
        this.amount = amount;
    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getNAME() {
        return NAME;
    }

    @Override
    public String toString() {
        return "Drinks{" +
                "NAME='" + NAME + '\'' +
                ", ALCOHOL_PERCENT=" + ALCOHOL_PERCENT +
                ", amount=" + amount +
                '}';
    }
}

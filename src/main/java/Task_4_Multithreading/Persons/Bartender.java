package Task_4_Multithreading.Persons;

import Task_4_Multithreading.Orders;
import Task_4_Multithreading.Bar;
import Task_4_Multithreading.Products.Drinks;
import Task_4_Multithreading.UseMultithreading;

import java.util.ConcurrentModificationException;
import java.util.Map;
import java.util.Objects;

public class Bartender implements Runnable, UseMultithreading {

    public final Bar bar;
    private final String NAME;
    public Orders orderAtWork;
    private final int TIME_OF_WORK;

    public Bartender(Bar bar, String name, int timeOfWork) {
        this.bar = bar;
        NAME = name;
        this.TIME_OF_WORK = timeOfWork;
    }

    @Override
    public void run() {
        executionOfOrders();
        executor.shutdown();
    }

    private synchronized void executionOfOrders() throws ConcurrentModificationException {
        while (!bar.serviceMap.isEmpty()) {
            if (orderAtWork == null) {
                searchFreeOrder();
            } else {
                preparationDrinks();
            }
        }
        System.out.println(NAME + " is finished");
    }

    private void searchFreeOrder() {
        for (Map.Entry<Client, Orders> map : bar.serviceMap.entrySet()) {
            if (map.getValue() != null && !map.getValue().statusAtWork) {
                orderAtWork = map.getValue();
                map.getValue().statusAtWork = true;
                System.out.println(NAME + " is assigned to fulfill the order! " + orderAtWork);
                break;
            }
        }
    }

    private void dispensingDrinks() throws ConcurrentModificationException {

        for (Map.Entry<Client, Orders> map : bar.serviceMap.entrySet()) {
            if (map.getKey().getOrder().equals(orderAtWork)) {
                bar.serviceMap.remove(map.getKey());
                System.out.println(NAME + " completed the order: " + orderAtWork);
                orderAtWork = null;
                break;
            }
        }
    }

    private void preparationDrinks() {
        System.out.println(NAME + "  started to fulfill the order: "
                + orderAtWork);
        for (Drinks drink : bar.drinksList) {
            if (orderAtWork != null && Objects.equals(drink.getName(), orderAtWork.getName())) {
                if (drink.getAmount() - orderAtWork.getAmount() < 0) {
                    notEnoughProduct();
                } else try {
                    wait(TIME_OF_WORK);
                    drink.setAmount(drink.getAmount() - orderAtWork.getAmount());
                    dispensingDrinks();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void notEnoughProduct() {
        System.out.println("There is no such quantity of goods in the bar");
        for (Map.Entry<Client, Orders> map : bar.serviceMap.entrySet()) {
            if (map.getKey().getOrder().equals(orderAtWork)) {
                Client temp = map.getKey();
                bar.serviceMap.remove(temp);
                System.out.println(temp + ", We cannot fulfill your order. Sorry. "
                        + "The order: " + orderAtWork + " has been deleted");
                orderAtWork = null;
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Bartender{" +
                "NAME='" + NAME + '\'' +
                ", orders=" + orderAtWork +
                ", timeOfWork=" + TIME_OF_WORK +
                '}';
    }
}

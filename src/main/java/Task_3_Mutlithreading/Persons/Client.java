package Task_3_Mutlithreading.Persons;

import Task_3_Mutlithreading.Bar;
import Task_3_Mutlithreading.Orders;

import java.util.Map;

public class Client implements Runnable {

    private final String NAME;
    private final Orders order;
    private final Bar bar;

    public Client(Bar bar, String name, Orders order) {
        this.bar = bar;
        this.NAME = name;
        this.order = order;
    }

    public String getNAME() {
        return NAME;
    }

    public Orders getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + NAME + '\'' +
                ", order=" + order +
                '}';
    }

    public synchronized void makeAnOrder() {
        bar.serviceMap.put(Client.this, order);
        System.out.println(getNAME() + " ordered:" + order);
    }

    public synchronized void takeAnOrder() {
        while (isOrderCompleted()) {
            try {
                wait(1000);
                System.out.println(NAME + " is waiting for an order...");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(NAME + " received the order!");
    }


    public boolean isOrderCompleted() {
        boolean flag = false;
        for (Map.Entry<Client, Orders> map : bar.serviceMap.entrySet()) {
            if (map.getKey().equals(Client.this)) {
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public void run() {
        makeAnOrder();
        takeAnOrder();
    }

}



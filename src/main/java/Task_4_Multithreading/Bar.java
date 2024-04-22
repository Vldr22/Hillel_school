package Task_4_Multithreading;

import Task_4_Multithreading.Persons.Client;
import Task_4_Multithreading.Products.Beer;
import Task_4_Multithreading.Products.Cola;
import Task_4_Multithreading.Products.Drinks;
import Task_4_Multithreading.Products.Whiskey;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;


public class Bar implements UseMultithreading {

    public List<Drinks> drinksList = new CopyOnWriteArrayList<>();
    public ConcurrentMap<Client, Orders> serviceMap = new ConcurrentHashMap<>();

    public Bar() {
        drinksList.add(new Beer(200));
        drinksList.add(new Whiskey(50));
        drinksList.add(new Cola(70));
    }

}

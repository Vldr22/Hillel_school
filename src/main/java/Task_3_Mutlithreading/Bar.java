package Task_3_Mutlithreading;

import Task_3_Mutlithreading.Persons.Client;
import Task_3_Mutlithreading.Products.Beer;
import Task_3_Mutlithreading.Products.Cola;
import Task_3_Mutlithreading.Products.Drinks;
import Task_3_Mutlithreading.Products.Whiskey;
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

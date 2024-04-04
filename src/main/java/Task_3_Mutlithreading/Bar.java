package Task_3_Mutlithreading;

import Task_3_Mutlithreading.Persons.Client;
import Task_3_Mutlithreading.Products.Beer;
import Task_3_Mutlithreading.Products.Cola;
import Task_3_Mutlithreading.Products.Drinks;
import Task_3_Mutlithreading.Products.Whiskey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Bar implements UseMultithreading {

    public volatile List<Drinks> drinksList = new ArrayList<>();
    public volatile Map<Client, Orders> serviceMap = new HashMap<>();

    public Bar() {
        drinksList.add(new Beer(200));
        drinksList.add(new Whiskey(50));
        drinksList.add(new Cola(70));
    }

}

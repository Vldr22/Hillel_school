package Task_4_Multithreading;

import Task_4_Multithreading.Persons.Bartender;
import Task_4_Multithreading.Persons.Client;

public class Main {

    public static void main(String[] args) {

        Bar bar = new Bar();

        Bartender bartender1 = new Bartender(bar, "SERGEY", 2000);
        Bartender bartender2 = new Bartender(bar, "VICTOR", 4000);

        Client client1 = new Client(bar, "Vlad",
                new Orders("Beer", 1.5));
        Client client2 = new Client(bar, "Viktoria",
                new Orders("Cola", 0.2));
        Client client3 = new Client(bar, "Alex",
                new Orders("Whiskey", 0.05));
        Client client4 = new Client(bar, "Rob",
                new Orders("Whiskey", 1));
        Client client5 = new Client(bar, "Anna",
                new Orders("Beer", 2000));

        bar.startClientThreads(client1, client2, client3, client4, client5);
        bar.startBartenderThreads(bartender1, bartender2);

    }

}

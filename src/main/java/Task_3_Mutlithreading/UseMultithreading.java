package Task_3_Mutlithreading;

import Task_3_Mutlithreading.Persons.Bartender;
import Task_3_Mutlithreading.Persons.Client;

public interface UseMultithreading {

    default void startClientThreads(Client... clients) {
        for (Client client : clients) {
            Thread thread = new Thread(client);
            thread.start();
        }
    }

    default void startBartenderThreads(Bartender... bartenders) {
        for (Bartender bartender : bartenders) {
            Thread thread = new Thread(bartender);
            thread.start();
        }
    }
}

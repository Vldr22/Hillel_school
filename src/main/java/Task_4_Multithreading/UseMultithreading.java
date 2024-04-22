package Task_4_Multithreading;

import Task_4_Multithreading.Persons.Client;
import Task_4_Multithreading.Persons.Bartender;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public interface UseMultithreading {

    ExecutorService executor = Executors.newCachedThreadPool();

    default void startClientThreads(Client... clients) {
        for (Client client : clients) {
            executor.submit(new Thread(client));
        }
    }

    default void startBartenderThreads(Bartender... bartenders) {
        for (Bartender bartender : bartenders) {
            executor.submit(new Thread(bartender));
        }
    }
}

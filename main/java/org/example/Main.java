package org.example;

import org.example.controllers.TableController;
import org.example.data.PostgresDB;
import org.example.data.interfaces.IDB;
import org.example.repositories.TableRepository;
import org.example.repositories.interfaces.ITableRepository;

public class Main {
    public static void main(String[] args) {
        IDB db = new PostgresDB();
        ITableRepository repository = new TableRepository(db);
        TableController controller = new TableController(repository);
        MyApp app = new MyApp(controller);
        app.start();

    }
}
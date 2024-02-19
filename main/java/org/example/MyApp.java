package org.example;

import org.example.controllers.TableController;
import org.example.models.Table;

import javax.swing.table.TableCellEditor;
import java.sql.Connection;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApp {
    private final TableController controller;
    private final Scanner scanner;

    public MyApp(TableController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean isRunning=true;
        while (isRunning) {
            System.out.println("Welcome to Application For Reserving Tables :)");
            System.out.println("Select option");
            System.out.println("1.Get all tables");
            System.out.println("2.Get table by number(id)");
            System.out.println("3.Create new table");
            System.out.println("4.Reserve table by number(id)");
            System.out.println("5.Edit information about table by number(id)");
            System.out.println("6.Delete table by number(id)");
            System.out.println("0.Exit");
            System.out.println();
            try {
                System.out.println("Enter option(0-6): ");
                int option = scanner.nextInt();
                switch (option) {
                    case 0:
                        isRunning=false;
                        break;
                    case 1:
                        getAllTablesMenu();
                        break;
                    case 2:
                        getTableByIdMenu();
                        break;
                    case 3:
                        createTableMenu();
                        break;
                    case 4:
                        reserveTable();
                        break;
                    case 5:
                        editTableInfo();
                        break;
                    case 6:
                        deleteTableById();
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer: " + e);
                scanner.nextLine();
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("*************************");
        }
    }

    private void deleteTableById() {
        System.out.println("Please enter number(id) of table");
        short id = scanner.nextShort();
        String response = controller.deleteTable(id);
        System.out.println(response);
        scanner.nextLine();
    }

    private void createTableMenu() {
        System.out.println("Please enter name of guest");
        String name = scanner.next();
        System.out.println("Please enter surname of guest");
        String surname = scanner.next();
        System.out.println("How many people will be behind a table");
        short capacity = scanner.nextShort();
        String reserved = "YES";
        System.out.println("Enter phone number of guest");
        String phoneNumber = scanner.next();

        String response = controller.createTable(name, surname, capacity, reserved, phoneNumber);
        System.out.println(response);
    }

    private void getTableByIdMenu() {
        System.out.println("Please enter number(id) of table");
        short id = scanner.nextShort();
        String response = controller.getTable(id);
        System.out.println(response);
    }

    private void getAllTablesMenu() {
        String response = controller.getAllTables();
        System.out.println(response);
    }

    private void reserveTable() {
        System.out.println("Please enter number(id) of table");
        short id = scanner.nextShort();
        String response = controller.reserveTable(id);
        System.out.println(response);
    }

    private void editTableInfo() {
        System.out.println("Please enter number(id) of table to edit:");
        short id = scanner.nextShort();
        System.out.println("Enter new first name:");
        String firstName = scanner.next();
        System.out.println("Enter new second name:");
        String secondName = scanner.next();
        System.out.println("Enter new capacity:");
        short capacity = scanner.nextShort();
        System.out.println("Enter new phone number:");
        String phoneNumber = scanner.next();

        String response = controller.editTableInfo(id, firstName, secondName, capacity, phoneNumber);
        System.out.println(response);
    }
}

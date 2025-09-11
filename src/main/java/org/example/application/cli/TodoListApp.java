package org.example.application.cli;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A simple command-line to-do list application.
 * Allows users to add, mark as done, delete tasks, and exit the application.
 */
public class TodoListApp {
    /**
     * The list of tasks managed by the application.
     */
    private static ArrayList<Task> tasks = new ArrayList<>();

    /**
     * The main entry point for the to-do list application.
     * Handles user input and manages the application loop.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nTODO List:");
            for (int i = 0; i < tasks.size(); i++) {
                Task t = tasks.get(i);
                System.out.printf("%d. [%s] %s\n", i + 1, t.isCompleted() ? "X" : " ", t.getDescription());
            }
            System.out.println("\nOptions: 1) Add 2) Mark Done 3) Delete 4) Exit");
            System.out.print("Choose: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.print("Enter task description: ");
                    tasks.add(new Task(scanner.nextLine()));
                    break;
                case "2":
                    System.out.print("Enter task number to mark as done: ");
                    int doneIdx = Integer.parseInt(scanner.nextLine()) - 1;
                    if (doneIdx >= 0 && doneIdx < tasks.size()) {
                        Task task = tasks.get(doneIdx);
                        if (task.isCompleted()) {
                            System.out.println("Task already completed.");
                        } else {
                            task.markCompleted();
                        }
                    }
                    break;
                case "3":
                    System.out.print("Enter task number to delete: ");
                    int delIdx = Integer.parseInt(scanner.nextLine()) - 1;
                    if (delIdx >= 0 && delIdx < tasks.size()) tasks.remove(delIdx);
                    break;
                case "4":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
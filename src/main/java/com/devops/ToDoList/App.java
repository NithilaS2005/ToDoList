package com.devops.ToDoList;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("📝 Welcome to the To-Do List App");

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1️⃣ Add Task");
            System.out.println("2️⃣ View Tasks");
            System.out.println("3️⃣ Remove Task");
            System.out.println("4️⃣ Exit");

            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    tasks.add(new Task(title));
                    System.out.println("✅ Task added.");
                    break;

                case "2":
                    System.out.println("📋 Your Tasks:");
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println(i + " ➤ " + tasks.get(i).getTitle());
                        }
                    }
                    break;

                case "3":
                    System.out.print("Enter index of task to delete: ");
                    try {
                        int index = Integer.parseInt(scanner.nextLine());
                        if (index >= 0 && index < tasks.size()) {
                            tasks.remove(index);
                            System.out.println("❌ Task removed.");
                        } else {
                            System.out.println("❗ Invalid index.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("⚠️ Please enter a valid number.");
                    }
                    break;

                case "4":
                    running = false;
                    System.out.println("👋 Exiting To-Do List App.");
                    break;

                default:
                    System.out.println("❓ Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
}

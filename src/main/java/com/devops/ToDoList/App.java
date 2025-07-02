package com.devops.ToDoList;

import java.util.ArrayList;
import java.util.List;

public class App {
    private static List<String> tasks = new ArrayList<>();

    public static void main(String[] args) {
        // Check if running inside Jenkins (no user input allowed)
        boolean inJenkins = System.getenv("JENKINS_HOME") != null;

        if (args.length > 0) {
            // Handle commands passed as arguments (for Jenkins)
            String command = args[0];

            switch (command.toLowerCase()) {
                case "add":
                    if (args.length > 1) {
                        tasks.add(args[1]);
                        System.out.println("✅ Task added: " + args[1]);
                    } else {
                        System.out.println("⚠️ Please provide a task to add.");
                    }
                    break;
                case "view":
                    System.out.println("📋 Tasks:");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ". " + tasks.get(i));
                    }
                    break;
                case "remove":
                    if (args.length > 1) {
                        try {
                            int index = Integer.parseInt(args[1]) - 1;
                            if (index >= 0 && index < tasks.size()) {
                                System.out.println("🗑️ Removed: " + tasks.remove(index));
                            } else {
                                System.out.println("⚠️ Invalid task number.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("⚠️ Invalid number format.");
                        }
                    } else {
                        System.out.println("⚠️ Please provide the task number to remove.");
                    }
                    break;
                default:
                    System.out.println("❌ Unknown command. Use add/view/remove.");
            }

        } else if (!inJenkins) {
            // If not running in Jenkins, allow interactive input
            java.util.Scanner sc = new java.util.Scanner(System.in);
            while (true) {
                System.out.println("\n📝 Welcome to the To-Do List App");
                System.out.println("1️⃣ Add Task");
                System.out.println("2️⃣ View Tasks");
                System.out.println("3️⃣ Remove Task");
                System.out.println("4️⃣ Exit");
                System.out.print("Enter your choice: ");

                String choice = sc.nextLine();

                switch (choice) {
                    case "1":
                        System.out.print("Enter task: ");
                        String task = sc.nextLine();
                        tasks.add(task);
                        System.out.println("✅ Task added.");
                        break;
                    case "2":
                        System.out.println("📋 Tasks:");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                        break;
                    case "3":
                        System.out.print("Enter task number to remove: ");
                        int index = Integer.parseInt(sc.nextLine()) - 1;
                        if (index >= 0 && index < tasks.size()) {
                            System.out.println("🗑️ Removed: " + tasks.remove(index));
                        } else {
                            System.out.println("⚠️ Invalid task number.");
                        }
                        break;
                    case "4":
                        System.out.println("👋 Goodbye!");
                        return;
                    default:
                        System.out.println("❌ Invalid choice.");
                }
            }
        } else {
            System.out.println("🤖 Running in Jenkins. Provide arguments like: add/view/remove");
        }
    }
}

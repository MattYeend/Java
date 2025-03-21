/*
 * Author:  Matthew Yeend
 * Project: To Do List
 * Version: 1.1.1
 * Date:    21/03/2025
 */

package matthewyeend.todolist;

import java.util.*;

/**
 *
 * @author matthewyeend
 */
public class ToDoList {
    private static List<String> tasks = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\n--- To-Do List ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Remove Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character
            
            switch (choice) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    removeTask(scanner);
                    break;
                case 4:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);
        
        scanner.close();
    }
    
    private static void addTask(Scanner scanner) {
        System.out.print("Enter the task: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added!");
    }
    
    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in your to-do list.");
        } else {
            System.out.println("\nYour To-Do List:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
    
    private static void removeTask(Scanner scanner) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to remove.");
        } else {
            System.out.print("Enter the task number to remove: ");
            int taskNumber = scanner.nextInt();
            if (taskNumber > 0 && taskNumber <= tasks.size()) {
                tasks.remove(taskNumber - 1);
                System.out.println("Task removed!");
            } else {
                System.out.println("Invalid task number!");
            }
        }
    }
}

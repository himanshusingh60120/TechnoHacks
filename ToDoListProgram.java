import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListProgram {

    private static ArrayList<String> toDoList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    removeItem();
                    break;
                case 3:
                    viewItems();
                    break;
                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n--- To-Do List Program ---");
        System.out.println("1. Add Item");
        System.out.println("2. Remove Item");
        System.out.println("3. View Items");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1; // Invalid input
        }
    }

    private static void addItem() {
        System.out.print("Enter the item to add: ");
        String item = scanner.nextLine();
        toDoList.add(item);
        System.out.println("Item added successfully: " + item);
    }

    private static void removeItem() {
        if (toDoList.isEmpty()) {
            System.out.println("The to-do list is empty. No items to remove.");
            return;
        }

        System.out.println("Current To-Do List:");
        viewItems();

        System.out.print("Enter the index of the item to remove: ");
        try {
            int index = Integer.parseInt(scanner.nextLine());
            if (index >= 0 && index < toDoList.size()) {
                String removedItem = toDoList.remove(index);
                System.out.println("Item removed successfully: " + removedItem);
            } else {
                System.out.println("Invalid index. Please enter a valid index.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid index.");
        }
    }

    private static void viewItems() {
        if (toDoList.isEmpty()) {
            System.out.println("The to-do list is empty.");
        } else {
            System.out.println("To-Do List:");
            for (int i = 0; i < toDoList.size(); i++) {
                System.out.println(i + ". " + toDoList.get(i));
            }
        }
    }
}

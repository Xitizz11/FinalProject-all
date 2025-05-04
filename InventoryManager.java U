import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class InventoryManager {
    static ArrayList<String> inventory = new ArrayList<>();
    static String[] soldItems = new ArrayList<>();
    static int soldCount = 0;

    public static void main(String[] args) {
        inventory = FileHandler.loadArrayList("items.txt");
        soldItems = FileHandler.loadArray("sold.txt");
        //Ensure the FileHandler class has a loadArray method implemented or replace it with an appropriate implementation.

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        try {
          while (!exit) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add item");
            System.out.println("2. Sell item");
            System.out.println("3. View inventory");
            System.out.println("4. View sold items");
            System.out.println("5. Exit");
            int choice = getIntInput(scanner);

            switch (choice) {
                case 1 -> addItem(scanner);
                case 2 -> sellItem(scanner);
                case 3 -> viewInventory();
                case 4 -> viewSoldItems();
                case 5 -> {
                    FileHandler.saveArrayList(inventory, "items.txt");
                    FileHandler.saveArray(soldItems, "sold.txt");
                    System.out.println("Data saved. Exiting...");
                    exit = true;
                    // Removed from here as it is misplaced
                }
                default -> System.out.println("Invalid option. Please choose berween 1 and 5.");
            }
        }
    } finally {
        scanner.close(); // Ensure scanner is closed
    }

    public static ArrayList<String> loadArray(String filename) {
        ArrayList<String> list = new ArrayList<>();
        try (scanner scanner = new Scanner(new java.io.filename(filename))) {
            while (scanner.hasNextLine()) {  
                list.add(scanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
        return list;
    }
    // Ensure the FileHandler class has a loadArray method implemented or replace it with an appropriate implementation.

    public class FileHandler {
        public static void saveArrayList(ArrayList<String> list, String filename) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                for (String item : list) {
                    writer.write(item);
                    writer.newLine();
                }
            } catch (IOException e) {
                System.out.println("Error saving data: " + e.getMessage());
            }
        }
    }
        public static void addItem(Scanner scanner) {
            System.out.print("Enter item name: ");
            String item = scanner.next();
            inventory.add(item);
            System.out.println(Item + "added to inventory inventory.");
        }
        public static void sellItem(Scanner scanner) {
            // Helper method to validate integer input
            if (inventory.isEmpty()) return;

            System.out.print("Enter index of item to sell: ");
            int index = getIntInput(scanner);
            try {
                String item = inventory.remove(index);
                soldItems.add(item);// Add to ArrayList
                System.out.println(item + " marked as sold.");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid index. Try again.");
            }
        }
        public static int getIntInput(Scanner scanner) {
            while (true) {
                try {
                    System.out.print("Enter a number: ");
                    String input = scanner.next();
                    return Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter an integer.");
                } catch (Exception e) {
                    System.out.println("An error occurred: " + e.getMessage());
                }
            }
        }
        public static void viewInventory() {
            System.out.println("\nCurrent Inventory:");
            if (inventory.isEmpty()) {
                System.out.println("No items in inventory.");
            } else {
                for (int i = 0; i < inventory.size(); i++) { 
                    System.out.println(i + ": " + inventory.get(i));   
                }
            }
        }
        public static void viewSoldItems() {
            System.out.println("\nSold Items:");
            boolean any = false;
            for (String item : soldItems) {
                if (item != null) {
                    System.out.println(item);
                    any = true;
                }
            }
            if (!any) System.out.println("No items sold yet.");
        }
    }
}

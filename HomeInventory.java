import java.io.*;
import java.util.*;

public class HomeInventory {
    private ArrayList<Home> homes;

    public HomeInventory() {
        homes = new ArrayList<>();
    }

    public String addHome(Home home) {
        try {
            homes.add(home);
            return "Home successfully added to inventory.";
        } catch (Exception e) {
            return "Failed to add home: " + e.getMessage();
        }
    }

    public String removeHome(int index) {
        try {
            homes.remove(index);
            return "Home successfully removed from inventory.";
        } catch (IndexOutOfBoundsException e) {
            return "Failed to remove home: Invalid index";
        }
    }

    public String updateHomeStatus(int index, String newStatus) {
        try {
            homes.get(index).setSaleStatus(newStatus);
            return "Home status successfully updated.";
        } catch (IndexOutOfBoundsException e) {
            return "Failed to update home: Invalid index";
        } catch (IllegalArgumentException e) {
            return "Failed to update home: " + e.getMessage();
        }
    }

    public void listHomes() {
        for (int i = 0; i < homes.size(); i++) {
            System.out.println("Home #" + (i + 1) + ":");
            System.out.println(homes.get(i));
        }
    }

    public void saveToFile(String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (int i = 0; i < homes.size(); i++) {
                writer.println("Home #" + (i + 1) + ":");
                writer.println(homes.get(i));
            }
            System.out.println("Successfully saved to file: " + filePath);
        } catch (IOException e) {
            System.out.println("Failed to save to file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            HomeInventory inventory = new HomeInventory();
            
            // Sample new home 
            Home home1 = new Home(3000, "86th Street", "Seattle", "WA", 
                                98275, "Luxury Cove", "Available");
            System.out.println(inventory.addHome(home1));
            
            System.out.println("\nInitial Inventory:");
            inventory.listHomes();
            
            // Remove the home
            System.out.println("\n" + inventory.removeHome(0));
            
            // Add a new home
            Home home2 = new Home(3000, "456 Oak Ave", "Dallas", "TX", 
                                75201, "Colonial", "available");
            System.out.println(inventory.addHome(home2));
            
            System.out.println("\nUpdated Inventory:");
            inventory.listHomes();
            
            // Update home status
            System.out.println("\n" + inventory.updateHomeStatus(0, "under contract"));
            
            System.out.println("\nFinal Inventory:");
            inventory.listHomes();
            
            // Prompt user about saving to file
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nWould you like to save the information to a file? (Y/N): ");
            String response = scanner.nextLine();
            
            if (response.equalsIgnoreCase("Y")) {
                // Save in current directory
                inventory.saveToFile("Home.txt");
            } else {
                System.out.println("File will not be printed.");
            }
            
            scanner.close();
            
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}







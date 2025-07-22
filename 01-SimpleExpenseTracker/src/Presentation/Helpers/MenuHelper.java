package Presentation.Helpers;

public class MenuHelper {

    public static void displayMenu() {
        System.out.println("\n=== Expense Tracker ===");
        System.out.println("1. View Expenses");
        System.out.println("2. Add Expenses");
        System.out.println("3. Set Budget");
        System.out.println("4. View Report");
        System.out.println("5. Save and Exit");
        System.out.print("Select option: ");
    }

    public static void invalidOption() {
        System.out.println("Invalid option. Please try again.");
    }

}
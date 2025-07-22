package Presentation;

import java.util.Scanner;

import Application.ExpenseTracker;
import Presentation.Helpers.MenuHelper;

public class Menu {
    private final ExpenseTracker expenseTracker = new ExpenseTracker();

    private static final Scanner scanner = new Scanner(System.in);

    public void MenuLogic(){
        boolean running = true;

        while (running) {
            MenuHelper.displayMenu();
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    expenseTracker.viewExpense();
                    break;
                case "2":
                    expenseTracker.addExpense();
                    break;
                case "3":
                    expenseTracker.setBudget();
                    break;
                case "4":
                    expenseTracker.viewReport();
                    break;
                case "5":
                    saveAndExit();
                    running = false;
                    break;
                default:
                    MenuHelper.invalidOption();
            }
        }

        scanner.close();
    }

    public void saveAndExit() {
        expenseTracker.saveData();
        System.out.println("✅ Data saved to file. See you next time!");
    }

}

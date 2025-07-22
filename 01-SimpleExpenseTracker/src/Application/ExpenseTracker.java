package Application;

import Domain.Budget;
import Domain.Expense;
import Infrastructure.StorageHelper;
import Presentation.Helpers.InputValidators;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ExpenseTracker {
    private final List<Expense> expenseList;
    private final List<Budget> budgetList;

    public ExpenseTracker() {
        expenseList = StorageHelper.loadList("expenses.dat");
        budgetList = StorageHelper.loadList("budgets.dat");
    }

    public void saveData() {
        StorageHelper.saveList(expenseList, "expenses.dat");
        StorageHelper.saveList(budgetList, "budgets.dat");
    }

    public void addExpense() {
        double expenseValue = InputValidators.ValidateInputInt("Please enter the cost of the expense:");
        System.out.println("Please enter the category of the expense:");
        Scanner scan = new Scanner(System.in);
        String expenseCategory = scan.nextLine();
        LocalDate expenseDate = LocalDate.now();

        Expense expense = new Expense(expenseValue, expenseCategory, expenseDate);

        Budget matchingBudget = null;
        for (Budget budget : budgetList) {
            if (budget.category.equalsIgnoreCase(expenseCategory)) {
                matchingBudget = budget;
                break;
            }
        }

        if (matchingBudget == null) {
            System.out.println("❌ Invalid category. No matching budget found.");
            return;
        } else {
            double totalInCategory = 0.0;
            for (Expense e : expenseList) {
                if (e.category.equalsIgnoreCase(expenseCategory)) {
                    totalInCategory += e.amount;
                }
            }

            totalInCategory += expenseValue;

            if (totalInCategory > matchingBudget.monthlyLimit) {
                System.out.println("⚠️ Warning: This expense exceeds your budget for category '" + expenseCategory + "'.");
                System.out.printf("Limit: %.2f | New Total: %.2f%n", matchingBudget.monthlyLimit, totalInCategory);
            }
        }

        expenseList.add(expense);
        System.out.println("Expense added successfully.");
    }

    public void viewExpense() {
        if (expenseList.isEmpty()) {
            System.out.println("No expenses recorded yet.");
            return;
        }

        System.out.println("\n=== Expenses List ===");
        System.out.printf("%-15s %-20s %-10s%n", "Date", "Category", "Amount");
        System.out.println("---------------------------------------------");

        double total = 0.0;
        expenseList.sort((e1, e2) -> e2.date.compareTo(e1.date));
        for (Expense expense : expenseList) {
            System.out.printf("%-15s %-20s %.2f%n",
                    expense.date.toString(),
                    expense.category,
                    expense.amount);
            total += expense.amount;
        }

        System.out.println("---------------------------------------------");
        System.out.printf("Total Spent: %.2f%n", total);
    }

    public void setBudget() {
        double budgetValue = InputValidators.ValidateInputInt("Please enter the budget amount:");
        System.out.println("Please enter the category for the budget:");
        Scanner scan = new Scanner(System.in);
        String budgetCategory = scan.nextLine();

        Budget budget = new Budget(budgetValue, budgetCategory);
        budgetList.add(budget);

        System.out.println("Budget set successfully.");
    }

    public void viewReport() {
        if (budgetList.isEmpty()) {
            System.out.println("No budgets set yet.");
            return;
        }

        System.out.println("\n=== Budget Report ===");
        System.out.printf("%-20s %-10s %-10s %-10s%n", "Category", "Limit", "Spent", "Remaining");
        System.out.println("-----------------------------------------------------");

        LocalDate now = LocalDate.now();
        double grandTotal = 0;

        for (Budget budget : budgetList) {
            double spent = 0;

            for (Expense expense : expenseList) {
                if (
                        expense.category.equalsIgnoreCase(budget.category) &&
                                expense.date.getMonth() == now.getMonth() &&
                                expense.date.getYear() == now.getYear()
                ) {
                    spent += expense.amount;
                }
            }

            double remaining = budget.monthlyLimit - spent;
            grandTotal += spent;

            System.out.printf("%-20s %-10.2f %-10.2f %-10.2f%n",
                    budget.category,
                    budget.monthlyLimit,
                    spent,
                    remaining);

            if (spent > budget.monthlyLimit) {
                System.out.println("⚠️  Over budget in category: " + budget.category);
            }
        }

        System.out.println("-----------------------------------------------------");
        System.out.printf("Total Spent Across All Budgets: %.2f%n", grandTotal);
    }
}

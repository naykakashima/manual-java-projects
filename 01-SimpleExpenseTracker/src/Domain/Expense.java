package Domain;

import java.time.LocalDate;
import java.io.Serializable;

public class Expense implements Serializable {
    public LocalDate date;
    public String category;
    public double amount;

    public Expense(double amount, String category, LocalDate date) {
        this.amount = amount;
        this.category = category;
        this.date = date;
    }
}

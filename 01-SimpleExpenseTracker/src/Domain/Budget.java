package Domain;

import java.io.Serializable;

public class Budget implements Serializable {
    public String category;
    public double monthlyLimit;

    public Budget(double monthlyLimit, String category) {
        this.monthlyLimit = monthlyLimit;
        this.category = category;
    }
}

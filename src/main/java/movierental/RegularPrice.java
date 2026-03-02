package movierental;

public class RegularPrice extends Price {
    private static final double BASE_AMOUNT = 2.0;
    private static final int DAYS_THRESHOLD = 2;
    private static final double EXTRA_CHARGE_PER_DAY = 1.5;
    
    public double getAmount(int daysRented) {
        double amount = BASE_AMOUNT;
        if (daysRented > DAYS_THRESHOLD)
            amount += (daysRented - DAYS_THRESHOLD) * EXTRA_CHARGE_PER_DAY;
        return amount;
    }
}

package movierental;

public class ChildrensPrice extends Price {
    private static final double BASE_AMOUNT = 1.5;
    private static final int DAYS_THRESHOLD = 3;
    private static final double EXTRA_CHARGE_PER_DAY = 1.5;
    
    public int getPriceCode() {
        return Movie.CHILDRENS;
    }
    
    public double getAmount(int daysRented) {
        double amount = BASE_AMOUNT;
        if (daysRented > DAYS_THRESHOLD)
            amount += (daysRented - DAYS_THRESHOLD) * EXTRA_CHARGE_PER_DAY;
        return amount;
    }
}

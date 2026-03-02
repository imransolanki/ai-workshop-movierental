package movierental;

public class NewReleasePrice extends Price {
    private static final double CHARGE_PER_DAY = 3.0;
    private static final int BONUS_THRESHOLD = 1;
    private static final int BONUS_POINTS = 2;
    private static final int REGULAR_POINTS = 1;
    
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }
    
    public double getAmount(int daysRented) {
        return daysRented * CHARGE_PER_DAY;
    }
    
    public int getFrequentRenterPoints(int daysRented) {
        return (daysRented > BONUS_THRESHOLD) ? BONUS_POINTS : REGULAR_POINTS;
    }
}

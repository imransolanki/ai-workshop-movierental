package movierental;

public abstract class Price {
    public abstract double getAmount(int daysRented);
    
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}

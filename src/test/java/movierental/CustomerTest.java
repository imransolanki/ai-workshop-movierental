package movierental;
import static junit.framework.Assert.assertEquals;

import org.junit.Test;

public class CustomerTest {

    @Test
    public void statementWithNoRentals() {
        Customer customer = new Customer("Alice");
        String expected = "Rental Record for Alice\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    public void statementWithSingleRegularRentalUnderThreshold() {
        Customer customer = new Customer("Bob");
        customer.addRental(new Rental(new Movie("Jaws", Movie.REGULAR), 2));
        String expected = "Rental Record for Bob\n" +
                "\tJaws\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    public void statementWithSingleRegularRentalOverThreshold() {
        Customer customer = new Customer("Bob");
        customer.addRental(new Rental(new Movie("Golden Eye", Movie.REGULAR), 3));
        String expected = "Rental Record for Bob\n" +
                "\tGolden Eye\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    public void statementWithSingleNewReleaseOneDayRental() {
        Customer customer = new Customer("Charlie");
        customer.addRental(new Rental(new Movie("Matrix", Movie.NEW_RELEASE), 1));
        String expected = "Rental Record for Charlie\n" +
                "\tMatrix\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    public void statementWithSingleNewReleaseTwoDayRental() {
        Customer customer = new Customer("Diana");
        customer.addRental(new Rental(new Movie("Inception", Movie.NEW_RELEASE), 2));
        String expected = "Rental Record for Diana\n" +
                "\tInception\t6.0\n" +
                "Amount owed is 6.0\n" +
                "You earned 2 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    public void statementWithSingleChildrensRentalUnderThreshold() {
        Customer customer = new Customer("Eve");
        customer.addRental(new Rental(new Movie("Bambi", Movie.CHILDRENS), 3));
        String expected = "Rental Record for Eve\n" +
                "\tBambi\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    public void statementWithSingleChildrensRentalOverThreshold() {
        Customer customer = new Customer("Frank");
        customer.addRental(new Rental(new Movie("Toy Story", Movie.CHILDRENS), 4));
        String expected = "Rental Record for Frank\n" +
                "\tToy Story\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    public void statementWithMultipleRentalsAllTypes() {
        Customer customer = new Customer("Bob");
        customer.addRental(new Rental(new Movie("Jaws", Movie.REGULAR), 2));
        customer.addRental(new Rental(new Movie("Golden Eye", Movie.REGULAR), 3));
        customer.addRental(new Rental(new Movie("Short New", Movie.NEW_RELEASE), 1));
        customer.addRental(new Rental(new Movie("Long New", Movie.NEW_RELEASE), 2));
        customer.addRental(new Rental(new Movie("Bambi", Movie.CHILDRENS), 3));
        customer.addRental(new Rental(new Movie("Toy Story", Movie.CHILDRENS), 4));

        String expected = "Rental Record for Bob\n" +
                "\tJaws\t2.0\n" +
                "\tGolden Eye\t3.5\n" +
                "\tShort New\t3.0\n" +
                "\tLong New\t6.0\n" +
                "\tBambi\t1.5\n" +
                "\tToy Story\t3.0\n" +
                "Amount owed is 19.0\n" +
                "You earned 7 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    public void statementWithLongRegularRental() {
        Customer customer = new Customer("George");
        customer.addRental(new Rental(new Movie("Casablanca", Movie.REGULAR), 10));
        String expected = "Rental Record for George\n" +
                "\tCasablanca\t14.0\n" +
                "Amount owed is 14.0\n" +
                "You earned 1 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    public void statementWithLongNewReleaseRental() {
        Customer customer = new Customer("Helen");
        customer.addRental(new Rental(new Movie("Avatar", Movie.NEW_RELEASE), 5));
        String expected = "Rental Record for Helen\n" +
                "\tAvatar\t15.0\n" +
                "Amount owed is 15.0\n" +
                "You earned 2 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    public void statementWithLongChildrensRental() {
        Customer customer = new Customer("Ian");
        customer.addRental(new Rental(new Movie("Frozen", Movie.CHILDRENS), 7));
        String expected = "Rental Record for Ian\n" +
                "\tFrozen\t7.5\n" +
                "Amount owed is 7.5\n" +
                "You earned 1 frequent renter points";
        assertEquals(expected, customer.statement());
    }
}

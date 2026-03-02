package movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String _name;
    private List<Rental> _rentals = new ArrayList<Rental>();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.add(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        String result = "Rental Record for " + getName() + "\n";
        for (Rental each : _rentals) {
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getAmount()) + "\n";
        }
        result += "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    public String htmlStatement() {
        String result = "<h1>Rental Record for <em>" + getName() + "</em></h1>\n";
        result += "<table>\n";
        for (Rental each : _rentals) {
            result += "  <tr><td>" + each.getMovie().getTitle() + "</td><td>" + each.getAmount() + "</td></tr>\n";
        }
        result += "</table>\n";
        result += "<p>Amount owed is <em>" + getTotalAmount() + "</em></p>\n";
        result += "<p>You earned <em>" + getTotalFrequentRenterPoints() + "</em> frequent renter points</p>";
        return result;
    }

    private double getTotalAmount() {
        double total = 0;
        for (Rental each : _rentals) {
            total += each.getAmount();
        }
        return total;
    }

    private int getTotalFrequentRenterPoints() {
        int total = 0;
        for (Rental each : _rentals) {
            total += each.getFrequentRenterPoints();
        }
        return total;
    }
}

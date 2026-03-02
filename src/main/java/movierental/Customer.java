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
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");
        for (Rental each : _rentals) {
            result.append("\t").append(each.getMovie().getTitle()).append("\t").append(each.getAmount()).append("\n");
        }
        result.append("Amount owed is ").append(getTotalAmount()).append("\n");
        result.append("You earned ").append(getTotalFrequentRenterPoints()).append(" frequent renter points");
        return result.toString();
    }

    public String htmlStatement() {
        StringBuilder result = new StringBuilder("<h1>Rental Record for <em>" + getName() + "</em></h1>\n");
        result.append("<table>\n");
        for (Rental each : _rentals) {
            result.append("  <tr><td>").append(each.getMovie().getTitle()).append("</td><td>").append(each.getAmount()).append("</td></tr>\n");
        }
        result.append("</table>\n");
        result.append("<p>Amount owed is <em>").append(getTotalAmount()).append("</em></p>\n");
        result.append("<p>You earned <em>").append(getTotalFrequentRenterPoints()).append("</em> frequent renter points</p>");
        return result.toString();
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

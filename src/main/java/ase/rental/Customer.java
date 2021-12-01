package ase.rental;
import java.util.ArrayList;
import java.util.List;

public class Customer {
  private final String name;
  private final List<Rental> rentals;
  public Customer(String name) {
    this.name = name;
    rentals = new ArrayList<>();
  }
  public String getName() {
    return name;
  }
  public void addRental(Rental rental) {
    rentals.add(rental);
  }
  private int getTotalCharge(){
    int total = 0;
    for (Rental rental : rentals){
      total += rental.getCharge();
    }
    return total;
  }
  private int getFrequentRenterPoints(){
    int frequentRenterPoints = 0;
    for (Rental rental : rentals){
      frequentRenterPoints += rental.getFrequentRenterPoints(rental);
    }
    return frequentRenterPoints;
  }
  public String htmlStatement(){
    StringBuilder html = new StringBuilder();
    html.append("<body>\n");
    html.append("<h1> Rental record for: " + getName());
    html.append(":</h1>\n");
    for (Rental rental : rentals) {
      // Show figures for this rental
      html.append("<h3>");
      html.append(rental.getCar().getModel());
      html.append(": ");
      html.append(rental.getDaysRented());
      html.append(" days, £");
      html.append(rental.getCharge());
      html.append("</h3>\n");
    }

    html.append("<h1> Amount owed is £");
    html.append(getTotalCharge());
    html.append("</h1>");
    html.append("\n<h1>You earned ");
    html.append(getFrequentRenterPoints());
    html.append(" frequent renter points </h1>\n");

    html.append("</body>");
    return html.toString();
  }

  public String statement() {

    StringBuilder result = new StringBuilder();
    result.append("Rental record for ");
    result.append(getName());
    result.append(":\n");

    // Determine amounts for each rental
    for (Rental rental : rentals) {
      // Show figures for this rental
      result.append("- ");
      result.append(rental.getCar().getModel());
      result.append(": ");
      result.append(rental.getDaysRented());
      result.append(" days, £");
      result.append(rental.getCharge());
      result.append("\n");
    }

    // Add footer lines
    result.append("Amount owed is £");
    result.append(getTotalCharge());
    result.append("\nYou earned ");
    result.append(getFrequentRenterPoints());
    result.append(" frequent renter points\n");

    return result.toString();
  }
}

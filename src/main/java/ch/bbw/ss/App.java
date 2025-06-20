package ch.bbw.ss;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Said Simokovic
 * @version 20.06.2025
 */
public class App 
{
    public static void main( String[] args )
    {
        Customer customer1 = new Customer("Simokovic", "Said", Date.valueOf(LocalDate.now()), 1.7, "0763430307");
        Customer customer2 = new Customer("Nait", "Fort", Date.valueOf(LocalDate.now()), 1.7, "0763430307");
        Customer customer3 = new Customer("Hui", "Judi", Date.valueOf(LocalDate.now()), 1.7, "0763430307");
        List<Customer> customers = new java.util.ArrayList<>(List.of(customer1, customer2, customer3));

        System.out.println("lastname, firstname");
        customers.sort(new CustomerByLastNameFirstName());
        customers.stream().limit(10).forEach(System.out::println);

        customers.sort(new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                int value = o1.getLastname().compareTo(o2.getLastname());
                if (value == 0){
                    value = o1.getFirstname().compareTo(o2.getFirstname());
                }
                return value;
            }
        });

        customers.sort((o1, o2) -> {
            int value = o1.getLastname().compareTo(o2.getLastname());
            if (value == 0){
                value = o1.getFirstname().compareTo(o2.getFirstname());
            }
            return value;
        });

        customers.sort(Comparator.comparing(Customer::getLastname).thenComparing(Customer::getFirstname));

        customers.sort(Comparator.naturalOrder());

        // Aufgabe Nachname & Geburtstag
        //
        customers.sort(Comparator.comparing(Customer::getLastname).thenComparing(Customer::getBirthdate));
        // oder
        customers.sort((c1, c2) -> {
            return c1.getLastname().compareTo(c2.getLastname());
        });
        customers.sort((c1, c2) -> {
            return c1.getBirthdate().compareTo(c2.getBirthdate());
        });


        // Aufgabe "" reversed
        //
        customers.sort((c1, c2) -> {
            int result = c1.getLastname().compareTo(c2.getLastname());
            if(result == 0){
                return 0;
            }
            return result > 0 ? -1 : 1;
        });
        customers.sort((c1, c2) -> {
            int result = c1.getLastname().compareTo(c2.getLastname());
            if(result == 0){
                return 0;
            }
            return result > 0 ? -1 : 1;
        });
        // Variante mit Camparator-Chain
        customers.sort(Comparator.comparing(Customer::getLastname, Comparator.reverseOrder()).thenComparing(Customer::getBirthdate, Comparator.reverseOrder()));
        customers.forEach(System.out::println);


        // Beispiel aus Artikel
        List<Movie> movies = Arrays.asList(
                new Movie("Lord of the rings"),
                new Movie("Back to the future"),
                new Movie("Carlito's way"),
                new Movie("Pulp fiction"));
        movies.sort(Comparator.comparing(Movie::getTitle));
        movies.forEach(System.out::println);
    }
}

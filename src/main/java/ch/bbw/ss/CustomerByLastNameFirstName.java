package ch.bbw.ss;

import java.util.Comparator;

public class CustomerByLastNameFirstName implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        int value = o1.getLastname().compareTo(o2.getLastname());
        if (value == 0){
            value = o1.getFirstname().compareTo(o2.getFirstname());
        }
        return value;
    }
}

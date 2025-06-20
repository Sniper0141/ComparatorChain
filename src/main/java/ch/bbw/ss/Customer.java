package ch.bbw.ss;

import lombok.Value;

import java.util.Comparator;
import java.util.Date;

/**
 * @author Peter Rutschmann
 * @version 05.11.2023
 */
@Value
public class Customer implements Comparable<Customer>{
   private String lastname;
   private String firstname;
   private Date birthdate;
   private double size;
   private String phone;

   public static Comparator<Customer> comparatorACLastNameBirthdate = new Comparator<Customer>() {
      @Override
      public int compare(Customer o1, Customer o2) {
         int value = o1.getLastname().compareTo(o2.getLastname());
         if (value == 0){
            //reversed order
            value = o2.getBirthdate().compareTo(o1.getBirthdate());
         }
         return value;
      }
   };

   public static Comparator<Customer> comparatorLaLastNameBirthdate = (o1, o2) -> {
         int value = o1.getLastname().compareTo(o2.getLastname());
         if (value == 0){
            //reversed order
            value = o2.getBirthdate().compareTo(o1.getBirthdate());
         }
         return value;
      };

   public static Comparator<Customer> comparatorCcLastNameBirthdate =
         Comparator.comparing(Customer::getLastname).thenComparing(Customer::getBirthdate, Comparator.reverseOrder());

   @Override
   public int compareTo(Customer o) {
      int value = this.getLastname().compareTo(o.getLastname());
      if (value == 0) value = this.getFirstname().compareTo(o.getFirstname());
      return value;
   }
}
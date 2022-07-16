import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Tim", 54.96);
        Customer anotherCustomer;
        anotherCustomer = customer; //Java assigned the second customer class to point to the firs class.
        anotherCustomer.setBalance(12.18); //The first class' value has been changed too.
        System.out.println("Balance for customer " + customer.getName() + " is " + customer.getBalance());

        ArrayList<Integer> intList = new ArrayList<>();

        intList.add(1);
        intList.add(3);
        intList.add(4);

        for(int i = 0; i < intList.size(); i++){
            System.out.println(i + ": " + intList.get(i));
        }
        /*
        0: 1
        1: 3
        2: 4
         */

        intList.add(1,2); //adds 2 at index position 1

        for(int i = 0; i < intList.size(); i++){
            System.out.println(i + ": " + intList.get(i));
        }
        /*
        0: 1
        1: 2
        2: 3
        3: 4
         */

        
    }
}

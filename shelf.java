import java.util.Scanner;
import java.util.InputMismatchException;

public class shelf {
    private static Scanner scanner = new Scanner(System.in);
    private static product current_prod = null;

    private static void add_perishable() { // add perishable start

        System.out.println("Enter product ID:");//prod id
        String product_id = scanner.nextLine();

        System.out.println("Enter product name:");//prod name
        String name = scanner.nextLine();

        double price = 0.0; // price scanner with exception start
        while (true) {
            System.out.println("Enter product price:");
            try {
                price = scanner.nextDouble();
                if (price >= 0) { 
                    break;
                } else {
                    System.out.println("!!Error: Price cannot be negative. Please try again!!");
                }
            } catch (InputMismatchException e) {
                System.out.println("!!Error: Please enter a valid number!!");
                scanner.nextLine(); 
            }
        }
}
}
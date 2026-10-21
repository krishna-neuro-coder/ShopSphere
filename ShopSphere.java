
import java.util.ArrayList;
import java.util.Scanner;

public class ShopSphere {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Product> products = new ArrayList<>();

        products.add(new Product(1, "Headphones", 799));
        products.add(new Product(2, "Keyboard", 999));
        products.add(new Product(3, "Mouse", 499));
        products.add(new Product(4, "Backpack", 699));

        ArrayList<Product> cart = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== SHOPSPHERE =====");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    for (Product p : products) {
                        p.display();
                    }
                    break;

                case 2:
                    System.out.print("Enter product ID: ");
                    int id = sc.nextInt();
                    boolean found = false;

                    for (Product p : products) {
                        if (p.getId() == id) {
                            cart.add(p);
                            System.out.println(
                                p.getName() + " added to cart!"
                            );
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Invalid product ID!");
                    }
                    break;

                case 3:
                    double total = 0;

                    System.out.println("\nYour Cart:");

                    for (Product p : cart) {
                        p.display();
                        total += p.getPrice();
                    }

                    System.out.println("Total: Rs. " + total);
                    break;

                case 4:
                    double bill = 0;

                    for (Product p : cart) {
                        bill += p.getPrice();
                    }

                    System.out.println("\n===== BILL =====");
                    System.out.println("Total Amount: Rs. " + bill);
                    System.out.println("Thank you for shopping!");
                    cart.clear();
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}

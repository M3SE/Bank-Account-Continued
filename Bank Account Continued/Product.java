public class Product {
    private double cost;
    private int quantity;
    private String name;

    // Constructor
    public Product(String name, double cost, int quantity) {
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
    }

    // Method to calculate and print the total cost
    public void totalCost() {
        double total = cost * quantity;
        System.out.println("Total cost for " + quantity + " units of " + name + ": $" + total);
    }

    // Method to print the product details
    public void printProduct() {
        System.out.println("Product: " + name);
        System.out.println("Cost per unit: $" + cost);
        System.out.println("Quantity purchased: " + quantity);
    }

    public static void main(String[] args) {
        // Instantiate a Product object with a product that comes to mind
        Product product = new Product("Laptop", 799.99, 2);

        // Call the printProduct() and totalCost() methods
        product.printProduct();
        product.totalCost();
    }
}


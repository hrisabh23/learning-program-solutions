import java.util.HashMap;

// Product class
class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public void updateProduct(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }

    public void displayProduct() {
        System.out.println("Product ID: " + productId + ", Name: " + productName +
                ", Quantity: " + quantity + ", Price: ₹" + price);
    }
}

public class InventoryManagementSystem {
    // HashMap to store products by productId
    private HashMap<Integer, Product> inventory;

    public InventoryManagementSystem() {
        inventory = new HashMap<>();
    }

    // Add product
    public void addProduct(Product product) {
        inventory.put(product.productId, product);
        System.out.println("Product added.");
    }

    // Update product
    public void updateProduct(int productId, int quantity, double price) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.updateProduct(quantity, price);
            System.out.println("Product updated:");
            product.displayProduct();
        } else {
            System.out.println("Product not found.");
        }
    }

    // Delete product
    public void deleteProduct(int productId) {
        if (inventory.remove(productId) != null) {
            System.out.println("Product deleted.");
        } else {
            System.out.println("Product not found.");
        }
    }

    // Display all products
    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Product product : inventory.values()) {
                product.displayProduct();
            }
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();

        // Add products
        ims.addProduct(new Product(101, "Laptop", 10, 75000.0));
        ims.addProduct(new Product(102, "Monitor", 15, 15000.0));

        // Display inventory
        System.out.println("\nCurrent Inventory:");
        ims.displayInventory();

        // Update product
        ims.updateProduct(101, 12, 72000.0);

        // Delete product
        ims.deleteProduct(102);

        // Final Inventory
        System.out.println("\nFinal Inventory:");
        ims.displayInventory();
    }
}

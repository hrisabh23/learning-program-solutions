
import java.util.Arrays;
import java.util.Comparator;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID=" + productId +
                ", Name='" + productName + '\'' +
                ", Category='" + category + '\'' +
                '}';
    }
}

public class ECommerceSearch {

    // Linear Search
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.productId == targetId) {
                return product;
            }
        }
        return null;
    }

    // Binary Search (Array must be sorted by productId)
    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].productId == targetId) {
                return products[mid];
            } else if (products[mid].productId < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Setup Products
        Product[] products = {
                new Product(104, "Mouse", "Electronics"),
                new Product(101, "Laptop", "Electronics"),
                new Product(105, "Notebook", "Stationery"),
                new Product(103, "Shoes", "Apparel"),
                new Product(102, "Backpack", "Bags")
        };

        // Sort products by productId for binary search
        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));

        // Display all products
        System.out.println("Product List:");
        for (Product p : products) {
            System.out.println(p);
        }

        // Searching using Linear Search
        int targetId = 105;
        Product resultLinear = linearSearch(products, targetId);
        System.out.println("\nLinear Search Result for ID " + targetId + ": " + resultLinear);

        // Searching using Binary Search
        Product resultBinary = binarySearch(products, targetId);
        System.out.println("Binary Search Result for ID " + targetId + ": " + resultBinary);
    }
}

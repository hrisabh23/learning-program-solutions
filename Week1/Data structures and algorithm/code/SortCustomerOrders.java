class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "ID=" + orderId +
                ", Customer='" + customerName + '\'' +
                ", Total Price=" + totalPrice +
                '}';
    }
}

public class SortCustomerOrders {

    // Bubble Sort by totalPrice
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    // Swap
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort by totalPrice
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice < pivot) {
                i++;
                // Swap
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        // Swap pivot
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    // Display orders
    public static void displayOrders(Order[] orders, String method) {
        System.out.println("\nOrders Sorted by " + method + ":");
        for (Order o : orders) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        Order[] orders = {
                new Order(101, "Alice", 2500.50),
                new Order(104, "Charlie", 3200.00),
                new Order(102, "Bob", 1800.75),
                new Order(105, "David", 5000.99),
                new Order(103, "Eve", 1500.30)
        };

        // Clone for each sort to compare
        Order[] bubbleSorted = orders.clone();
        Order[] quickSorted = orders.clone();

        // Bubble Sort
        bubbleSort(bubbleSorted);
        displayOrders(bubbleSorted, "Bubble Sort");

        // Quick Sort
        quickSort(quickSorted, 0, quickSorted.length - 1);
        displayOrders(quickSorted, "Quick Sort");
    }
}


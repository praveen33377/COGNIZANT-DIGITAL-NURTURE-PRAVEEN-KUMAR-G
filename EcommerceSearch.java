import java.util.Arrays;
import java.util.Comparator;

class Product {
    int productId;
    String productName;
    double price;

    Product(int productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }
}

public class EcommerceSearch {

    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.productId == targetId) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

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

        Product[] products = {
            new Product(103, "Keyboard", 1200),
            new Product(101, "Laptop", 55000),
            new Product(105, "Mouse", 700),
            new Product(102, "Monitor", 15000),
            new Product(104, "Headphones", 2500)
        };

        int searchId = 104;

        Product result1 = linearSearch(products, searchId);

        if (result1 != null) {
            System.out.println("Linear Search:");
            System.out.println(result1.productName + " - ₹" + result1.price);
        }

        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));

        Product result2 = binarySearch(products, searchId);

        if (result2 != null) {
            System.out.println("Binary Search:");
            System.out.println(result2.productName + " - ₹" + result2.price);
        }
    }
}
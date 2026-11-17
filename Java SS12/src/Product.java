package ra.entity;

import java.util.List;
import java.util.Scanner;

public class Product {
    private static int autoId = 1;
    private int productId;
    private String productName;
    private float price;
    private String category;
    private int quantity;

    public Product() {
        this.productId = autoId++;
    }

    public Product(int productId, String productName, float price, String category, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void inputData(Scanner scanner) {
        System.out.print("Nhập tên sản phẩm (10-50 ký tự): ");
        this.productName = scanner.nextLine().trim();

        System.out.print("Nhập giá sản phẩm (> 0): ");
        this.price = Float.parseFloat(scanner.nextLine().trim());

        System.out.print("Nhập loại sản phẩm (tối đa 200 ký tự): ");
        this.category = scanner.nextLine().trim();

        System.out.print("Nhập số lượng tồn kho (>= 0): ");
        this.quantity = Integer.parseInt(scanner.nextLine().trim());
    }

    public void inputData(Scanner scanner, List<Product> existingProducts) {
        this.productName = inputValidName(scanner, existingProducts, -1);
        this.price = inputValidPrice(scanner);
        this.category = inputValidCategory(scanner);
        this.quantity = inputValidQuantity(scanner);
    }

    public static String inputValidName(Scanner scanner, List<Product> list, int excludeId) {
        while (true) {
            System.out.print("Nhập tên sản phẩm (10-50 ký tự): ");
            String name = scanner.nextLine().trim();
            if (name.length() < 10 || name.length() > 50) {
                System.err.println("Lỗi: Tên sản phẩm phải từ 10 đến 50 ký tự!");
                continue;
            }
            boolean isDuplicate = list.stream()
                    .anyMatch(p -> p.getProductId() != excludeId && p.getProductName().equalsIgnoreCase(name));
            if (isDuplicate) {
                System.err.println("Lỗi: Tên sản phẩm đã tồn tại!");
                continue;
            }
            return name;
        }
    }

    public static float inputValidPrice(Scanner scanner) {
        while (true) {
            System.out.print("Nhập giá sản phẩm (> 0): ");
            try {
                float price = Float.parseFloat(scanner.nextLine().trim());
                if (price > 0) return price;
                System.err.println("Lỗi: Giá sản phẩm phải lớn hơn 0!");
            } catch (NumberFormatException e) {
                System.err.println("Lỗi: Vui lòng nhập số thực hợp lệ!");
            }
        }
    }

    public static String inputValidCategory(Scanner scanner) {
        while (true) {
            System.out.print("Nhập loại sản phẩm (tối đa 200 ký tự): ");
            String category = scanner.nextLine().trim();
            if (!category.isEmpty() && category.length() <= 200) {
                return category;
            }
            System.err.println("Lỗi: Loại sản phẩm không được để trống và tối đa 200 ký tự!");
        }
    }

    public static int inputValidQuantity(Scanner scanner) {
        while (true) {
            System.out.print("Nhập số lượng tồn kho (>= 0): ");
            try {
                int qty = Integer.parseInt(scanner.nextLine().trim());
                if (qty >= 0) return qty;
                System.err.println("Lỗi: Số lượng tồn kho phải lớn hơn hoặc bằng 0!");
            } catch (NumberFormatException e) {
                System.err.println("Lỗi: Vui lòng nhập số nguyên hợp lệ!");
            }
        }
    }

    @Override
    public String toString() {
        return String.format("| %-5d | %-30s | %-12.2f | %-20s | %-10d |",
                productId, productName, price, category, quantity);
    }
}
package ra.business;

import ra.entity.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProductBusiness {
    private final List<Product> productList = new ArrayList<>();

    public void addProduct(Scanner scanner) {
        System.out.println("--- THÊM MỚI SẢN PHẨM ---");
        Product product = new Product();
        product.inputData(scanner, productList);
        productList.add(product);
        System.out.println("Thêm sản phẩm thành công! (Mã SP: " + product.getProductId() + ")");
    }

    public void displayAllProducts() {
        if (productList.isEmpty()) {
            System.out.println("Danh sách sản phẩm hiện đang trống.");
            return;
        }
        printTableHeader();
        productList.forEach(System.out::println);
        printTableFooter();
    }

    public void updateProduct(Scanner scanner) {
        int id = readInt(scanner, "Nhập mã sản phẩm cần cập nhật: ");
        Optional<Product> optProduct = findById(id);

        if (optProduct.isEmpty()) {
            System.err.println("Không tìm thấy sản phẩm có mã: " + id);
            return;
        }

        Product p = optProduct.get();
        System.out.println("Thông tin hiện tại: " + p.getProductName() + " | Giá: " + p.getPrice());

        p.setProductName(Product.inputValidName(scanner, productList, id));
        p.setPrice(Product.inputValidPrice(scanner));
        p.setCategory(Product.inputValidCategory(scanner));
        p.setQuantity(Product.inputValidQuantity(scanner));

        System.out.println("Cập nhật sản phẩm thành công!");
    }

    // 4. Xóa sản phẩm theo mã
    public void deleteProduct(Scanner scanner) {
        int id = readInt(scanner, "Nhập mã sản phẩm cần xóa: ");
        boolean isRemoved = productList.removeIf(p -> p.getProductId() == id);

        if (isRemoved) {
            System.out.println("Đã xóa sản phẩm có mã: " + id);
        } else {
            System.err.println("Không tìm thấy sản phẩm có mã: " + id);
        }
    }

    public void searchProductByName(Scanner scanner) {
        System.out.print("Nhập từ khóa tên sản phẩm cần tìm: ");
        String keyword = scanner.nextLine().trim().toLowerCase();

        List<Product> results = productList.stream()
                .filter(p -> p.getProductName().toLowerCase().contains(keyword))
                .collect(Collectors.toList());

        if (results.isEmpty()) {
            System.out.println("Không tìm thấy sản phẩm nào khớp với từ khóa \"" + keyword + "\".");
        } else {
            System.out.println("Kết quả tìm kiếm (" + results.size() + " sản phẩm):");
            printTableHeader();
            results.forEach(System.out::println);
            printTableFooter();
        }
    }

    public void sortByPriceAscending() {
        if (productList.isEmpty()) {
            System.out.println("Danh sách trống, không thể sắp xếp.");
            return;
        }
        productList.sort(Comparator.comparingDouble(Product::getPrice));
        System.out.println("Đã sắp xếp sản phẩm theo giá tăng dần:");
        displayAllProducts();
    }

    public void sortByQuantityDescending() {
        if (productList.isEmpty()) {
            System.out.println("Danh sách trống, không thể sắp xếp.");
            return;
        }
        productList.sort(Comparator.comparingInt(Product::getQuantity).reversed());
        System.out.println("Đã sắp xếp sản phẩm theo số lượng giảm dần:");
        displayAllProducts();
    }

    private Optional<Product> findById(int id) {
        return productList.stream()
                .filter(p -> p.getProductId() == id)
                .findFirst();
    }

    private int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.err.println("Lỗi: Vui lòng nhập một số nguyên hợp lệ!");
            }
        }
    }

    private void printTableHeader() {
        String line = "+-------+--------------------------------+--------------+----------------------+------------+";
        System.out.println(line);
        System.out.printf("| %-5s | %-30s | %-12s | %-20s | %-10s |\n",
                "Mã SP", "Tên sản phẩm", "Giá", "Loại sản phẩm", "Tồn kho");
        System.out.println(line);
    }

    private void printTableFooter() {
        System.out.println("+-------+--------------------------------+--------------+----------------------+------------+");
    }
}
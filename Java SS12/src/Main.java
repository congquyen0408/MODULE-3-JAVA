import ra.business.ProductBusiness;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductBusiness business = new ProductBusiness();

        while (true) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    business.addProduct(scanner);
                    break;
                case "2":
                    business.displayAllProducts();
                    break;
                case "3":
                    business.updateProduct(scanner);
                    break;
                case "4":
                    business.deleteProduct(scanner);
                    break;
                case "5":
                    business.searchProductByName(scanner);
                    break;
                case "6":
                    business.sortByPriceAscending();
                    break;
                case "7":
                    business.sortByQuantityDescending();
                    break;
                case "8":
                    System.out.println("Thoát chương trình. Tạm biệt!");
                    scanner.close();
                    return;
                default:
                    System.err.println("Lựa chọn không hợp lệ! Vui lòng chọn từ 1 đến 8.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n*********************QUẢN LÝ SẢN PHẨM********************");
        System.out.println("1. Thêm sản phẩm");
        System.out.println("2. Danh sách sản phẩm");
        System.out.println("3. Cập nhật sản phẩm theo mã sản phẩm");
        System.out.println("4. Xóa sản phẩm theo mã sản phẩm");
        System.out.println("5. Tìm kiếm sản phẩm theo tên");
        System.out.println("6. Sắp xếp sản phẩm theo giá tăng dần");
        System.out.println("7. Sắp xếp sản phẩm theo số lượng giảm dần");
        System.out.println("8. Thoát");
        System.out.print("Lựa chọn của bạn: ");
    }
}
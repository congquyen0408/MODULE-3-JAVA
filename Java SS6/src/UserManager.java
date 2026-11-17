import java.util.Scanner;

public class UserManager {
    private static String fullName = "";
    private static String email = "";
    private static String phone = "";
    private static String password = "";
    private static boolean hasData = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (true) {
            printMenu();
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("-> Lỗi: Vui lòng chỉ nhập số từ 1 đến 6!");
                continue;
            }

            switch (choice) {
                case 1:
                    inputUserInfo(scanner);
                    break;
                case 2:
                    if (checkDataExists()) {
                        fullName = normalizeFullName(fullName);
                        System.out.println("-> Họ tên sau khi chuẩn hóa: " + fullName);
                    }
                    break;
                case 3:
                    if (checkDataExists()) {
                        if (isValidEmail(email)) {
                            System.out.println("-> Email (" + email + ") HỢP LỆ.");
                        } else {
                            System.out.println("-> Email (" + email + ") KHÔNG HỢP LỆ.");
                        }
                    }
                    break;
                case 4:
                    if (checkDataExists()) {
                        if (isValidVietnamPhone(phone)) {
                            System.out.println("-> Số điện thoại (" + phone + ") HỢP LỆ.");
                        } else {
                            System.out.println("-> Số điện thoại (" + phone + ") KHÔNG HỢP LỆ.");
                        }
                    }
                    break;
                case 5:
                    if (checkDataExists()) {
                        if (isValidPassword(password)) {
                            System.out.println("-> Mật khẩu HỢP LỆ.");
                        } else {
                            System.out.println("-> Mật khẩu KHÔNG HỢP LỆ (Cần >= 8 ký tự, gồm chữ hoa, chữ thường, số và ký tự đặc biệt).");
                        }
                    }
                    break;
                case 6:
                    System.out.println("-> Đã thoát chương trình. Tạm biệt!");
                    scanner.close();
                    return;
                default:
                    System.out.println("-> Lựa chọn không hợp lệ. Vui lòng chọn từ 1 đến 6!");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n******************QUẢN LÝ NGƯỜI DÙNG****************");
        System.out.println("1. Nhập thông tin người dùng");
        System.out.println("2. Chuẩn hóa họ tên");
        System.out.println("3. Kiểm tra email hợp lệ");
        UserValidatorHelper.printRemainingMenu();
    }

    private static boolean checkDataExists() {
        if (!hasData) {
            System.out.println("-> Cảnh báo: Vui lòng chọn mục 1 để nhập thông tin người dùng trước!");
            return false;
        }
        return true;
    }

    private static void inputUserInfo(Scanner scanner) {
        String[] userData = UserValidatorHelper.inputUserData(scanner);
        fullName = userData[0];
        email = userData[1];
        phone = userData[2];
        password = userData[3];
        hasData = true;
    }

    private static String normalizeFullName(String name) {
        return UserValidatorHelper.formatFullName(name);
    }

    private static boolean isValidEmail(String email) {
        return UserValidatorHelper.checkEmail(email);
    }

    private static boolean isValidVietnamPhone(String phone) {
        return UserValidatorHelper.checkVietnamPhone(phone);
    }

    private static boolean isValidPassword(String password) {
        return UserValidatorHelper.checkPassword(password);
    }
}
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserValidatorHelper {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    private static final String VN_PHONE_REGEX = "^(0|\\+84)(3[2-9]|5[2689]|7[06-9]|8[1-9]|9[0-9])[0-9]{7}$";

    private static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&.#^()_+=\\-])[A-Za-z\\d@$!%*?&.#^()_+=\\-]{8,}$";


    public static void printRemainingMenu() {
        System.out.println("4. Kiểm tra số điện thoại hợp lệ");
        System.out.println("5. Kiểm tra mật khẩu hợp lệ");
        System.out.println("6. Thoát");
        System.out.print("Lựa chọn của bạn: ");
    }


    public static String[] inputUserData(Scanner scanner) {
        String[] data = new String[4];
        System.out.print("Nhập họ và tên: ");
        data[0] = scanner.nextLine();

        System.out.print("Nhập email: ");
        data[1] = scanner.nextLine().trim();

        System.out.print("Nhập số điện thoại: ");
        data[2] = scanner.nextLine().trim();

        System.out.print("Nhập mật khẩu: ");
        data[3] = scanner.nextLine();

        System.out.println("-> Đã lưu thông tin người dùng thành công!");
        return data;
    }

    public static String formatFullName(String rawName) {
        if (rawName == null || rawName.trim().isEmpty()) {
            return "";
        }
        String[] words = rawName.trim().toLowerCase().split("\\s+");
        StringBuilder normalized = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                normalized.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1))
                        .append(" ");
            }
        }
        return normalized.toString().trim();
    }


    public static boolean checkEmail(String email) {
        if (email == null) return false;
        return Pattern.matches(EMAIL_REGEX, email);
    }


    public static boolean checkVietnamPhone(String phone) {
        if (phone == null) return false;
        return Pattern.matches(VN_PHONE_REGEX, phone);
    }


    public static boolean checkPassword(String password) {
        if (password == null) return false;
        return Pattern.matches(PASSWORD_REGEX, password);
    }
}
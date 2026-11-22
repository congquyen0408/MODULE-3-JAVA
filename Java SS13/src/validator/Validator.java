package validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Validator {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    // 1. Nhập số nguyên (dùng cho choice ở Main và student_id)
    public static int readInt(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập một số nguyên hợp lệ!");
            }
        }
    }

    // 2. Nhập chuỗi không rỗng (dùng cho full_name)
    public static String readString(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Lỗi: Dữ liệu không được để trống!");
        }
    }

    // 3. Nhập ngày tháng đúng chuẩn yyyy-MM-dd (dùng cho date_of_birth)
    public static LocalDate readDate(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            try {
                return LocalDate.parse(input, DATE_FORMATTER);
            } catch (DateTimeParseException e) {
                System.out.println("Lỗi: Ngày sinh không hợp lệ! Vui lòng nhập đúng định dạng yyyy-MM-dd (VD: 2003-05-15).");
            }
        }
    }

    // 4. Nhập email đúng định dạng (dùng cho email)
    public static String readEmail(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            if (input.matches(EMAIL_REGEX)) {
                return input;
            }
            System.out.println("Lỗi: Email không đúng định dạng (VD: ten@gmail.com)!");
        }
    }
}
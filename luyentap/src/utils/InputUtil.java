package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputUtil {
    private static final Scanner SCANNER = new Scanner(System.in);
    /**
     * Đọc một số nguyên từ bàn phím với kiểm tra lỗi định dạng.
     */
    public static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                String input = SCANNER.nextLine();
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.println("❌ Lỗi: Vui lòng nhập vào một số nguyên hợp lệ!");
            }
        }
    }

    /**
     * Đọc số nguyên trong một khoảng cho phép [min, max].
     */
    public static int readInt(String prompt, int min, int max) {
        while (true) {
            int value = readInt(prompt);
            if (value >= min && value <= max) {
                return value;
            }
            System.out.println("❌ Lỗi: Giá trị phải nằm trong khoảng từ " + min + " đến " + max + "!");
        }
    }

    /**
     * Đọc một số thực (double) từ bàn phím với kiểm tra lỗi định dạng.
     */
    public static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                String input = SCANNER.nextLine();
                return Double.parseDouble(input.trim());
            } catch (NumberFormatException e) {
                System.out.println("❌ Lỗi: Vui lòng nhập vào một số thực hợp lệ!");
            }
        }
    }

    /**
     * Đọc chuỗi không được để trống.
     */
    public static String readString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = SCANNER.nextLine();
            if (input != null && !input.trim().isEmpty()) {
                return input.trim();
            }
            System.out.println("❌ Lỗi: Nội dung không được để trống!");
        }
    }

    /**
     * Đọc chuỗi thỏa mãn biểu thức chính quy (Regex).
     */
    public static String readString(String prompt, String regex, String errorMessage) {
        while (true) {
            String input = readString(prompt);
            if (input.matches(regex)) {
                return input;
            }
            System.out.println("❌ Lỗi: " + errorMessage);
        }
    }

    // ==================== BỔ SUNG: CÁC PHƯƠNG THỨC XỬ LÝ NGÀY THÁNG ====================

    /**
     * Đọc ngày (LocalDate) theo định dạng mặc định: yyyy-MM-dd
     */
    public static LocalDate readLocalDate(String prompt) {
        return readLocalDate(prompt, "yyyy-MM-dd");
    }

    /**
     * Đọc ngày (LocalDate) theo định dạng tùy chỉnh (ví dụ: dd/MM/yyyy).
     */
    public static LocalDate readLocalDate(String prompt, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        while (true) {
            String input = readString(prompt);
            try {
                return LocalDate.parse(input, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("❌ Lỗi: Sai định dạng ngày tháng! (Yêu cầu định dạng: " + pattern + ")");
            }
        }
    }

    /**
     * Đọc ngày giờ (LocalDateTime) theo định dạng chuẩn khớp với MySQL TIMESTAMP: yyyy-MM-dd HH:mm:ss
     */
    public static LocalDateTime readLocalDateTime(String prompt) {
        return readLocalDateTime(prompt, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * Đọc ngày giờ (LocalDateTime) theo định dạng tùy chỉnh.
     */
    public static LocalDateTime readLocalDateTime(String prompt, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        while (true) {
            String input = readString(prompt);
            try {
                return LocalDateTime.parse(input, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("❌ Lỗi: Sai định dạng ngày giờ! (Yêu cầu định dạng: " + pattern + ", ví dụ: 2026-11-18 20:00:00)");
            }
        }
    }
}
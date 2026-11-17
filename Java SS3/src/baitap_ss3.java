import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class baitap_ss3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> salaries = new ArrayList<>();

        double totalSalary = 0;
        double maxSalary = Double.MIN_VALUE;
        double minSalary = Double.MAX_VALUE;

        int choice;
        do {
            System.out.println("\n*************** MENU QUẢN LÝ LƯƠNG ***************");
            System.out.println("1. Nhập danh sách lương nhân viên");
            System.out.println("2. Xem báo cáo thống kê");
            System.out.println("3. Tính tổng quỹ thưởng nhân viên");
            System.out.println("4. Thoát chương trình");
            System.out.print("Nhập lựa chọn của bạn (1-4): ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("\n--- NHẬP LƯƠNG NHÂN VIÊN (Nhập -1 để dừng) ---");
                    while (true) {
                        System.out.print("Nhập mức lương (VNĐ): ");
                        double salary = Double.parseDouble(scanner.nextLine());

                        if (salary == -1) {
                            System.out.println("Đã kết thúc phiên nhập lương.");
                            break;
                        }

                        if (salary < 0 || salary > 500_000_000) {
                            System.out.println("Lỗi: Mức lương phải nằm trong khoảng 0 đến 500,000,000 VNĐ. Vui lòng nhập lại!");
                            continue;
                        }

                        salaries.add(salary);
                        totalSalary += salary;
                        if (salary > maxSalary) {
                            maxSalary = salary;
                        }
                        if (salary < minSalary) {
                            minSalary = salary;
                        }

                        String rank;
                        if (salary < 5_000_000) {
                            rank = "Thu nhập thấp";
                        } else if (salary <= 15_000_000) {
                            rank = "Thu nhập trung bình";
                        } else if (salary <= 50_000_000) {
                            rank = "Thu nhập khá";
                        } else {
                            rank = "Thu nhập cao";
                        }
                        System.out.println("-> Xếp loại: " + rank);
                    }
                    break;

                case 2:
                    System.out.println("\n--- BÁO CÁO THỐNG KÊ LƯƠNG ---");
                    if (salaries.isEmpty()) {
                        System.out.println("Chưa có dữ liệu.");
                    } else {
                        double averageSalary = totalSalary / salaries.size();
                        System.out.println("Tổng số nhân viên: " + salaries.size());
                        System.out.printf("Lương trung bình: %,.0f VNĐ\n", averageSalary);
                        System.out.printf("Lương cao nhất:   %,.0f VNĐ\n", maxSalary);
                        System.out.printf("Lương thấp nhất:  %,.0f VNĐ\n", minSalary);
                        System.out.printf("Tổng quỹ lương:   %,.0f VNĐ\n", totalSalary);
                    }
                    break;

                case 3:
                    System.out.println("\n--- TÍNH TỔNG TIỀN THƯỞNG ---");
                    if (salaries.isEmpty()) {
                        System.out.println("Chưa có dữ liệu để tính thưởng.");
                    } else {
                        double totalBonus = 0;
                        // Duyệt qua từng mức lương bằng vòng lặp for-each
                        for (double s : salaries) {
                            double rate;
                            if (s < 5_000_000) {
                                rate = 0.05;      // 5%
                            } else if (s <= 15_000_000) {
                                rate = 0.10;      // 10%
                            } else if (s <= 50_000_000) {
                                rate = 0.15;      // 15%
                            } else if (s <= 100_000_000) {
                                rate = 0.20;      // 20%
                            } else {
                                rate = 0.25;      // 25%
                            }
                            totalBonus += s * rate;
                        }
                        System.out.printf("Tổng số tiền thưởng chi trả: %,.0f VNĐ\n", totalBonus);
                    }
                    break;

                case 4:
                    System.out.println("Đang thoát chương trình. Hẹn gặp lại!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn từ 1 đến 4.");
            }
        } while (true);
    }
}
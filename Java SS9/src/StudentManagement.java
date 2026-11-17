package ra.presentation;

import ra.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class StudentManagement {
    private static final List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n*********************QUẢN LÝ SINH VIÊN********************");
            System.out.println("1. Hiển thị danh sách sinh viên");
            System.out.println("3. Thêm sinh viên");
            System.out.println("5. Cập nhật thông tin sinh viên theo mã sinh viên");
            System.out.println("7. Xóa sinh viên theo mã sinh viên");
            System.out.println("9. Tìm sinh viên theo tên sinh viên");
            System.out.println("11. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số nguyên hợp lệ!");
                continue;
            }

            switch (choice) {
                case 1:
                    displayAllStudents();
                    break;
                case 3:
                    addStudents(scanner);
                    break;
                case 5:
                    updateStudentById(scanner);
                    break;
                case 7:
                    deleteStudentById(scanner);
                    break;
                case 9:
                    searchStudentByName(scanner);
                    break;
                case 11:
                    System.out.println("Đã thoát chương trình. Tạm biệt!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
            }
        }
    }

    private static void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("Danh sách sinh viên hiện đang trống.");
            return;
        }
        printTableHeader();
        studentList.forEach(Student::displayData);
        System.out.println("+------------+---------------------------+-------+----------------------+");
    }

    private static void addStudents(Scanner scanner) {
        System.out.print("Nhập số lượng sinh viên cần thêm: ");
        int count;
        try {
            count = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Số lượng không hợp lệ!");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println("\n--- Nhập thông tin sinh viên thứ " + (i + 1) + " ---");
            Student newStudent = new Student();
            newStudent.inputData(scanner);

            boolean isDuplicate = studentList.stream()
                    .anyMatch(s -> s.getStudentId().equalsIgnoreCase(newStudent.getStudentId()));

            if (isDuplicate) {
                System.out.println("Lỗi: Mã sinh viên '" + newStudent.getStudentId() + "' đã tồn tại! Bỏ qua sinh viên này.");
            } else {
                studentList.add(newStudent);
                System.out.println("Thêm sinh viên thành công!");
            }
        }
    }

    private static void updateStudentById(Scanner scanner) {
        System.out.print("Nhập mã sinh viên cần cập nhật: ");
        String targetId = scanner.nextLine().trim();

        Optional<Student> foundStudent = findById(targetId);
        if (foundStudent.isPresent()) {
            Student student = foundStudent.get();
            System.out.println("Tìm thấy sinh viên. Nhập thông tin mới (nhấn Enter để giữ nguyên):");

            System.out.print("Tên mới (" + student.getStudentName() + "): ");
            String newName = scanner.nextLine().trim();
            if (!newName.isEmpty()) {
                student.setStudentName(newName);
            }

            System.out.print("Tuổi mới (" + student.getAge() + "): ");
            String ageInput = scanner.nextLine().trim();
            if (!ageInput.isEmpty()) {
                try {
                    int newAge = Integer.parseInt(ageInput);
                    if (newAge > 0) student.setAge(newAge);
                } catch (NumberFormatException e) {
                    System.out.println("Tuổi không hợp lệ, giữ nguyên tuổi cũ.");
                }
            }

            System.out.print("Chuyên ngành mới (" + student.getMajor() + "): ");
            String newMajor = scanner.nextLine().trim();
            if (!newMajor.isEmpty()) {
                student.setMajor(newMajor);
            }

            System.out.println("Cập nhật thông tin thành công!");
        } else {
            System.out.println("Mã sinh viên '" + targetId + "' không tồn tại trong hệ thống!");
        }
    }

    private static void deleteStudentById(Scanner scanner) {
        System.out.print("Nhập mã sinh viên cần xóa: ");
        String targetId = scanner.nextLine().trim();

        boolean isRemoved = studentList.removeIf(s -> s.getStudentId().equalsIgnoreCase(targetId));
        if (isRemoved) {
            System.out.println("Đã xóa sinh viên có mã '" + targetId + "' thành công!");
        } else {
            System.out.println("Mã sinh viên '" + targetId + "' không tồn tại!");
        }
    }

    private static void searchStudentByName(Scanner scanner) {
        System.out.print("Nhập tên sinh viên cần tìm: ");
        String keyword = scanner.nextLine().trim().toLowerCase();

        List<Student> matchedStudents = studentList.stream()
                .filter(s -> s.getStudentName().toLowerCase().contains(keyword))
                .toList();

        if (matchedStudents.isEmpty()) {
            System.out.println("Không tìm thấy sinh viên nào có tên chứa '" + keyword + "'.");
        } else {
            System.out.println("Kết quả tìm kiếm (" + matchedStudents.size() + " sinh viên):");
            printTableHeader();
            matchedStudents.forEach(Student::displayData);
            System.out.println("+------------+---------------------------+-------+----------------------+");
        }
    }

    private static Optional<Student> findById(String id) {
        return studentList.stream()
                .filter(s -> s.getStudentId().equalsIgnoreCase(id))
                .findFirst();
    }

    private static void printTableHeader() {
        System.out.println("+------------+---------------------------+-------+----------------------+");
        System.out.printf("| %-10s | %-25s | %-5s | %-20s |\n", "Mã SV", "Tên sinh viên", "Tuổi", "Chuyên ngành");
        System.out.println("+------------+---------------------------+-------+----------------------+");
    }
}
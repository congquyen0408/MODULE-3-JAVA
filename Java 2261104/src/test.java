import java.util.ArrayList;
import java.util.Scanner;

public class test {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    private static int countId = 1;

    public static void main(String[] args) {
        Student newStudent = new Student(0, "Nguyễn Văn A", "HCM", "1/2/1990");
        studentList.add(newStudent);


        int choice;

        do {
            showMenu();
            System.out.print("Chọn từ 1 tới 4: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    System.out.println("Thoát");
                    break;
                default:
                    System.out.println("Chọn số khác");
            }
            System.out.println();
        } while (choice != 4);

    }

    private static void showMenu() {
        System.out.println("Danh sách sinh viên");
        System.out.println("1. Thêm");
        System.out.println("2. Hiển thị danh sách");
        System.out.println("3. Xóa");
        System.out.println("4. Thoát");
    }

    private static void addStudent() {
        System.out.println("Thêm sinh viên mới");


        System.out.println("Nhập tên:");
        String name = sc.nextLine();

        System.out.println("Nhập địa chỉ:");
        String address = sc.nextLine();

        System.out.println("Nhập ngày sinh:");
        String dob = sc.nextLine();

        Student newStudent = new Student(countId++, name, address, dob);
        studentList.add(newStudent);
    }

    private static void displayStudent() {
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i));
        }
    }

    private static void deleteStudent() {
        System.out.println("Nhập id sinh viên muốn xóa: ");
        int deleteId = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < studentList.size(); i++) {
            if (deleteId == studentList.get(i).getId()) {
                studentList.remove(i);
                break;
            }
        }
        System.out.println("abc");

    }

}

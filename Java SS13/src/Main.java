import database.Db;
import studentManagement.StudentManagement;
import validator.Validator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();
        Db db = new Db();
        int choice;

        do{
            System.out.println("=====MENU====");
            System.out.println("1.Danh sách tất cả sinh viên");
            System.out.println("2.Thêm mới sinh viên");
            System.out.println("3.Cập nhật sinh viên");
            System.out.println("4.Tìm kiếm theo id sinh viên");
            System.out.println("5.Xóa sinh viên");
            System.out.println("0.Thoát");

            choice = Validator.readInt("Nhập: ");

            switch (choice) {
                case 1:
                    StudentManagement.getAllStudents();
                    break;
                case 2:
                    StudentManagement.addStudent();
                    break;
                case 3:
                    StudentManagement.updateStudent();
                    break;
                case 4:
                    StudentManagement.findStudentById();
                    break;
                case 5:
                    StudentManagement.deleteStudent();
                    break;
                case 0:
                    System.out.println("Bạn đã thoát chương trình");
                    break;
            }
        } while (choice !=0);

    }
}

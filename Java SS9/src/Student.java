package ra.entity;

import java.util.Scanner;

public class Student {
    private String studentId;
    private String studentName;
    private int age;
    private String major;

    public Student() {
    }

    public Student(String studentId, String studentName, int age, String major) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.major = major;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void inputData(Scanner scanner) {
        System.out.print("Nhập mã sinh viên: ");
        this.studentId = scanner.nextLine().trim();

        System.out.print("Nhập tên sinh viên: ");
        this.studentName = scanner.nextLine().trim();

        while (true) {
            try {
                System.out.print("Nhập tuổi sinh viên: ");
                this.age = Integer.parseInt(scanner.nextLine().trim());
                if (this.age > 0) {
                    break;
                }
                System.out.println("Tuổi phải lớn hơn 0. Vui lòng nhập lại!");
            } catch (NumberFormatException e) {
                System.out.println("Tuổi phải là số nguyên. Vui lòng nhập lại!");
            }
        }

        System.out.print("Nhập chuyên ngành: ");
        this.major = scanner.nextLine().trim();
    }

    public void displayData() {
        System.out.printf("| %-10s | %-25s | %-5d | %-20s |\n",
                this.studentId, this.studentName, this.age, this.major);
    }
}
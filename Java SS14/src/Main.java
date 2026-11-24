import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3307/student_mng1";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void addStudents(List<Student> studentList) {
        if (studentList == null || studentList.isEmpty()) {
            System.out.println("Danh sách sinh viên trống, không có dữ liệu để thêm.");
            return;
        }

        String sql = "{CALL add_students(?, ?)}";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            conn.setAutoCommit(false);

            try (CallableStatement cstmt = conn.prepareCall(sql)) {
                for (Student s : studentList) {
                    cstmt.setString(1, s.getName());
                    cstmt.setInt(2, s.getAge());
                    cstmt.addBatch();
                }
                cstmt.executeBatch();
            }

            conn.commit();
            System.out.println("Thành công: Đã thêm " + studentList.size() + " sinh viên vào cơ sở dữ liệu.");

        } catch (SQLException e) {
            System.err.println("Lỗi khi thêm sinh viên: " + e.getMessage());
            if (conn != null) {
                try {
                    conn.rollback();
                    System.err.println("Đã rollback transaction để đảm bảo toàn vẹn dữ liệu.");
                } catch (SQLException rollbackEx) {
                    System.err.println("Lỗi khi rollback: " + rollbackEx.getMessage());
                }
            }
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException closeEx) {
                    System.err.println("Lỗi khi đóng kết nối: " + closeEx.getMessage());
                }
            }
        }
    }

    public static void updateStudent(Student student) {
        if (student == null) {
            System.out.println("Thông tin sinh viên không hợp lệ (null).");
            return;
        }

        String sql = "{CALL update_student(?, ?, ?)}";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            conn.setAutoCommit(false);

            int updatedRows;
            try (CallableStatement cstmt = conn.prepareCall(sql)) {
                cstmt.setInt(1, student.getId());
                cstmt.setString(2, student.getName());
                cstmt.setInt(3, student.getAge());
                updatedRows = cstmt.executeUpdate();
            }

            if (updatedRows > 0) {
                conn.commit();
                System.out.println("Thành công: Đã cập nhật sinh viên có ID = " + student.getId() + " (" + student + ").");
            } else {
                conn.rollback();
                System.out.println("Không tìm thấy sinh viên có ID = " + student.getId() + " để cập nhật. Đã rollback transaction.");
            }

        } catch (SQLException e) {
            System.err.println("Lỗi khi cập nhật sinh viên: " + e.getMessage());
            if (conn != null) {
                try {
                    conn.rollback();
                    System.err.println("Đã rollback transaction để đảm bảo toàn vẹn dữ liệu.");
                } catch (SQLException rollbackEx) {
                    System.err.println("Lỗi khi rollback: " + rollbackEx.getMessage());
                }
            }
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException closeEx) {
                    System.err.println("Lỗi khi đóng kết nối: " + closeEx.getMessage());
                }
            }
        }
    }

    public static void deleteStudentsByAge(int age) {
        String sql = "{CALL delete_students_by_age(?)}";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            conn.setAutoCommit(false);

            int deletedRows;
            try (CallableStatement cstmt = conn.prepareCall(sql)) {
                cstmt.setInt(1, age);
                deletedRows = cstmt.executeUpdate();
            }

            conn.commit();
            System.out.println("Thành công: Số lượng sinh viên đã bị xóa (tuổi < " + age + "): " + deletedRows);

        } catch (SQLException e) {
            System.err.println("Lỗi khi xóa sinh viên theo tuổi: " + e.getMessage());
            if (conn != null) {
                try {
                    conn.rollback();
                    System.err.println("Đã rollback transaction để đảm bảo toàn vẹn dữ liệu.");
                } catch (SQLException rollbackEx) {
                    System.err.println("Lỗi khi rollback: " + rollbackEx.getMessage());
                }
            }
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException closeEx) {
                    System.err.println("Lỗi khi đóng kết nối: " + closeEx.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Student> sampleStudents = List.of(
                new Student("Nguyễn Minh Anh", 19),
                new Student("Trần Quốc Bảo", 20),
                new Student("Lê Thảo Chi", 21),
                new Student("Phạm Gia Huy", 22)
        );

        System.out.println("Danh sách sinh viên mẫu chuẩn bị thêm:");
        sampleStudents.forEach(s -> System.out.println(" - " + s));

        addStudents(sampleStudents);

        Student studentToUpdate = new Student(1, "Nguyễn Minh Anh (Cập nhật)", 20);
        System.out.println("Đang cập nhật sinh viên: " + studentToUpdate);
        updateStudent(studentToUpdate);

        // Xóa tất cả sinh viên có tuổi nhỏ hơn 20
        int ageThreshold = 20;
        System.out.println("Đang xóa sinh viên có độ tuổi nhỏ hơn " + ageThreshold + "...");
        deleteStudentsByAge(ageThreshold);
    }
}
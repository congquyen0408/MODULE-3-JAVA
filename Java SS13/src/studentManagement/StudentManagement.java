package studentManagement;

import database.Db;
import validator.Validator;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class StudentManagement {
    public static void getAllStudents() {
        String querySql = "{CALL get_all_students()}";

        try (CallableStatement stmt = Db.getConn().prepareCall(querySql)) {

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("student_id");
                    String fullName = rs.getString("full_name");
                    LocalDate dob = rs.getDate("date_of_birth").toLocalDate();
                    String email = rs.getString("email");

                    System.out.printf("ID: %d | Họ tên: %s | Ngày sinh: %s | Email: %s%n",
                            id, fullName, dob, email);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addStudent() {
        String fullName = Validator.readString("Nhập họ tên sinh viên: ");
        LocalDate dob = Validator.readDate("Nhập ngày sinh (yyyy-MM-dd): ");
        String email = Validator.readEmail("Nhập email: ");

        String insertSql = "{CALL add_student(?, ?, ?)}";

        try (CallableStatement stmt = Db.getConn().prepareCall(insertSql)) {
            stmt.setString(1, fullName);
            stmt.setDate(2, Date.valueOf(dob));
            stmt.setString(3, email);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Thêm sinh viên thành công!");
            } else {
                System.out.println("Thêm sinh viên thất bại!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateStudent() {
        int id = Validator.readInt("Nhập ID sinh viên cần cập nhật: ");
        String fullName = Validator.readString("Nhập họ tên mới: ");
        LocalDate dob = Validator.readDate("Nhập ngày sinh mới (yyyy-MM-dd): ");
        String email = Validator.readEmail("Nhập email mới: ");

        String updateSql = "{CALL update_student(?, ?, ?, ?)}";

        try (CallableStatement stmt = Db.getConn().prepareCall(updateSql)) {
            stmt.setInt(1, id);
            stmt.setString(2, fullName);
            stmt.setDate(3, Date.valueOf(dob));
            stmt.setString(4, email);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Cập nhật thông tin sinh viên thành công!");
            } else {
                System.out.println("Cập nhật thất bại! Không tìm thấy ID = " + id);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void findStudentById() {
        int id = Validator.readInt("Nhập ID sinh viên cần tìm: ");
        String findSql = "{CALL find_student_by_id(?)}";

        try (CallableStatement stmt = Db.getConn().prepareCall(findSql)) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int studentId = rs.getInt("student_id");
                    String fullName = rs.getString("full_name");
                    LocalDate dob = rs.getDate("date_of_birth").toLocalDate();
                    String email = rs.getString("email");

                    System.out.printf("ID: %d | Họ tên: %s | Ngày sinh: %s | Email: %s%n",
                            studentId, fullName, dob, email);
                } else {
                    System.out.println("Không tìm thấy sinh viên có ID = " + id);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteStudent() {
        int id = Validator.readInt("Nhập ID sinh viên cần xóa: ");
        String deleteSql = "{CALL delete_student(?)}";

        try (CallableStatement stmt = Db.getConn().prepareCall(deleteSql)) {
            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Xóa sinh viên thành công!");
            } else {
                System.out.println("Xóa thất bại! Không tìm thấy ID = " + id);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
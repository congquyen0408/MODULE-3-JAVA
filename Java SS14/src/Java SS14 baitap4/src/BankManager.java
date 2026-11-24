import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BankManager {

    private static final String URL = "jdbc:mysql://localhost:3307/student_mng1";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void transferFunds(int fromAccountId, int toAccountId, BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            System.err.println("Lỗi: Số tiền chuyển phải lớn hơn 0.");
            return;
        }

        String sql = "{CALL transfer_funds(?, ?, ?)}";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            conn.setAutoCommit(false);

            try (CallableStatement cstmt = conn.prepareCall(sql)) {
                cstmt.setInt(1, fromAccountId);
                cstmt.setInt(2, toAccountId);
                cstmt.setBigDecimal(3, amount);
                cstmt.execute();
            }

            conn.commit();
            System.out.println("Thành công: Đã chuyển " + amount + " từ tài khoản ID " + fromAccountId + " sang tài khoản ID " + toAccountId + ".");

        } catch (SQLException e) {
            System.err.println("Lỗi khi chuyển tiền: " + e.getMessage());
            if (conn != null) {
                try {
                    conn.rollback();
                    System.err.println("Đã rollback transaction, dữ liệu tài khoản giữ nguyên.");
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
}
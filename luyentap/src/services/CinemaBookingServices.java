package services;

import databases.Db;
import model.TicketBooking;
import utils.InputUtil;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CinemaBookingServices {
    public void getTicketBooking() {

        String querySql = "{CALL get_ticket_booking_list()}";

        try (CallableStatement stmt = Db.getConn().prepareCall(querySql)) {



            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("booking_id");
                    String title = rs.getString("movie_title");
                    String customername = rs.getString("customer_name");
                    LocalDateTime showtime = rs.getObject("show_time", LocalDateTime.class);
                    LocalDateTime bookingdate = rs.getObject("booking_date",LocalDateTime.class);
                    int seatquantity = rs.getInt("seat_quantity");
                    String status = rs.getString("status");

                    TicketBooking tb = new TicketBooking(id, title, customername, showtime, bookingdate, seatquantity, status);

                    System.out.println(tb);
                }
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void createTikcetBooking() {
            TicketBooking newTb = new TicketBooking();
            newTb.setMovie_title(InputUtil.readString("Nhập tên phim (title): "));
            newTb.setCustomer_name(InputUtil.readString("Nhập tên khách hàng: "));
            newTb.setShow_time(InputUtil.readLocalDateTime("Nhập giờ chiếu (show_time): "));
            newTb.setBooking_date(InputUtil.readLocalDateTime("Nhập ngày đặt (booking_date): "));
            // Bổ sung nhập số lượng ghế (giả sử InputUtil có hàm readInt)
            newTb.setSeat_quantity(InputUtil.readInt("Nhập số lượng ghế: "));
            newTb.setStatus(InputUtil.readString("Nhập trạng thái (confirmed/pending/cancelled): "));

            String insertSql = "{CALL insert_ticket(?, ?, ?, ?, ?, ?)}";

            try (CallableStatement stmt = Db.getConn().prepareCall(insertSql)) {
                // Truyền tham số theo đúng thứ tự trong Stored Procedure insert_ticket
                stmt.setString(1, newTb.getMovie_title());
                stmt.setString(2, newTb.getCustomer_name());
                stmt.setTimestamp(3, Timestamp.valueOf(newTb.getShow_time()));
                stmt.setTimestamp(4, Timestamp.valueOf(newTb.getBooking_date()));
                stmt.setInt(5, newTb.getSeat_quantity());
                stmt.setString(6, newTb.getStatus());

                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Đặt vé thành công!");
                } else {
                    System.out.println("Đặt vé thất bại!");
                }

            } catch (SQLException e) {
                throw new RuntimeException("Lỗi khi thêm vé mới: " + e.getMessage(), e);
            }
        }
}

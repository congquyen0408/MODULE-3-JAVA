create database db_cinema_booking;
use db_cinema_booking;
-- tạo bảng--
CREATE TABLE ticket_bookings (
booking_id BIGINT AUTO_INCREMENT  PRIMARY KEY,
movie_title VARCHAR(150) NOT NULL,
customer_name VARCHAR(100) NOT NULL,
show_time  TIMESTAMP NOT NULL,
booking_date TIMESTAMP NOT NULL,
seat_quantity INT NOT NULL,
status VARCHAR(30) NOT NULL
)

-- tạo procedure lấy danh sách phiếu đặt vé--
    delimiter //
create procedure get_ticket_booking_list()
begin
select * from ticket_bookings;
end //
delimiter ;


-- tạo procedure thêm mới--
delimiter //
create procedure insert_ticket (
    IN p_movie_title VARCHAR(150),
    IN p_customer_name VARCHAR(100),
    IN p_show_time TIMESTAMP,
    IN p_booking_date TIMESTAMP,
    IN p_seat_quantity INT,
    IN p_status VARCHAR(30) )
begin
INSERT INTO  ticket_bookings (movie_title, customer_name, show_time, booking_date, seat_quantity, status)
VALUES ( p_movie_title, p_customer_name, p_show_time, p_booking_date, p_seat_quantity, p_status);
end //
delimiter ;

-- tạo procedure lấy danh sách phiếu đặt vé theo tên khách hàng--
delimiter //
create procedure get_booking_by_customer_name (
    IN p_customer_name VARCHAR(100))
BEGIN
SELECT booking_id
FROM ticket_bookings
WHERE customer_name = p_customer_name;
END //
delimiter ;

-- tạo procedure cập nhật thông tin phiếu đặt vé theo booking_id
DELIMITER //
CREATE PROCEDURE sp_update_booking(
    IN p_booking_id INT,
    IN p_movie_title VARCHAR(150),
    IN p_customer_name VARCHAR(100),
    IN p_show_time TIMESTAMP,
    IN p_booking_date TIMESTAMP,
    IN p_seat_quantity INT,
    IN p_status VARCHAR(30),
    out p_affected_rows INT
)
BEGIN
UPDATE ticket_bookings
SET
    movie_title = p_movie_title,
    customer_name = p_customer_name,
    show_time = p_show_time,
    booking_date = p_booking_date,
    seat_quantity = p_seat_quantity,
    status = p_status
where booking_id = p_booking_id;

SET p_affected_rows = ROW_COUNT();

END//
DELIMITER ;
DROP PROCEDURE sp_update_booking;

--tạo procedure xóa phiếu đặt vé--
DELIMITER //
create procedure delete_ticket_booking_by_id(
    IN p_booking_id INT,
    out p_affected_rows INT
)
begin
delete from ticket_bookings
where booking_id = p_booking_id;
SET p_affected_rows = ROW_COUNT();
end//
DELIMITER ;

-- tạo procedure tìm kiếm phiếu đặt vé theo tên phim
DELIMITER //
create procedure search_by_movie_title (
    IN p_movie_title VARCHAR(150)
)
BEGIN
SELECT * FROM ticket_bookings
WHERE movie_title LIKE CONCAT('%', p_movie_title, '%');
END //
DELIMITER ;

-- dữ liệu test--
INSERT INTO  ticket_bookings (movie_title, customer_name, show_time, booking_date, seat_quantity, status)
VALUES ("Doraemon", "Quyen", "2026-11-18 20:00", "2026-11-18 19:00", 2, "confirmed"),
("Avengers", "John", "2026-11-19 18:00", "2026-11-19 17:00", 4, "confirmed"),
("Inception", "Alice", "2026-11-20 21:00", "2026-11-20 20:00", 1, "pending"),
("The Dark Knight", "Bob", "2026-11-21 19:30", "2026-11-21 18:30", 3, "confirmed"),
("Titanic", "Charlie", "2026-11-22 20:15", "2026-11-22 19:15", 2, "cancelled");


-- kiem thu--
CALL get_ticket_booking_list();

CALL insert_ticket ("Doraemon", "Quyen", "2026-11-18 20:00", "2026-11-18 19:00", 2, "confirmed");

CALL get_booking_by_customer_name ("Bob");


CALL sp_update_booking(3,"Doraemon999", "Quyen3", "2026-11-18 20:00", "2026-11-18 19:00", 2, "confirmed", @daura);
SELECT @daura;

CALL delete_ticket_booking_by_id(1, @daura);
SELECT @daura;

CALL search_by_movie_title("Titanic");
package model;

import java.time.LocalDateTime;

public class TicketBooking {
    private int booking_id;
    private String movie_title;
    private String customer_name;
    private LocalDateTime show_time;
    private LocalDateTime booking_date;
    private int seat_quantity;
    private String status;

    public TicketBooking() {
    }

    public TicketBooking(int booking_id, String movie_title, String customer_name, LocalDateTime show_time, LocalDateTime booking_date, int seat_quantity, String status) {
        this.booking_id = booking_id;
        this.movie_title = movie_title;
        this.customer_name = customer_name;
        this.show_time = show_time;
        this.booking_date = booking_date;
        this.seat_quantity = seat_quantity;
        this.status = status;
    }

    @Override
    public String toString() {
        return "TicketBooking{" +
                "booking_id=" + booking_id +
                ", movie_title='" + movie_title + '\'' +
                ", customer_name='" + customer_name + '\'' +
                ", show_time=" + show_time +
                ", booking_date=" + booking_date +
                ", seat_quantity=" + seat_quantity +
                ", status='" + status + '\'' +
                '}';
    }

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public String getMovie_title() {
        return movie_title;
    }

    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public LocalDateTime getShow_time() {
        return show_time;
    }

    public void setShow_time(LocalDateTime show_time) {
        this.show_time = show_time;
    }

    public LocalDateTime getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(LocalDateTime booking_date) {
        this.booking_date = booking_date;
    }

    public int getSeat_quantity() {
        return seat_quantity;
    }

    public void setSeat_quantity(int seat_quantity) {
        this.seat_quantity = seat_quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

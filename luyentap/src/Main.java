import databases.Db;
import services.CinemaBookingServices;
import utils.InputUtil;

public static void main(String[] args) {

    Db db = new Db();
    CinemaBookingServices cinemaBookingServices = new CinemaBookingServices();
    int choice;

    do{
        System.out.println("=====MENU====");
        System.out.println("1.Danh sách tất cả phiếu đặt vé");
        System.out.println("2.Thêm mới phiếu đặt vé");
        System.out.println("3.Cập nhật thông tin phiếu đặt vé");
        System.out.println("4.Xóa phiếu đặt vé");
        System.out.println("5.Tìm kiếm phiếu đặt vé theo tên khách hàng");
        System.out.println("6.Tìm kiếm phiếu đặt vé theo tên phim");
        System.out.println("0.Thoát");
        System.out.println("Nhập lựa chọn của bạn: ");

        choice = InputUtil.readInt("Nhập: ");

        switch (choice) {
            case 1:
                cinemaBookingServices.getTicketBooking();
                break;
            case 2:
                cinemaBookingServices.createTikcetBooking();
                break;
            case 3:
                System.out.println("Bạn đã lựa chọn 3");
                break;
            case 4:
                System.out.println("Bạn đã lựa chọn 4");
                break;
            case 5:
                System.out.println("Bạn đã lựa chọn 5");
                break;
            case 6:
                System.out.println("Bạn đã lựa chọn 6");
                break;
            case 0:
                System.out.println("Bạn đã thoát chương trình");
                break;
        }
    } while (choice !=0);

}
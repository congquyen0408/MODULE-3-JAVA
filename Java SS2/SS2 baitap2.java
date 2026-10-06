import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
        System.out.println("Nhập 1 số nguyên từ 1 tới 7:");
        int dayNumber = sc.nextInt();

        switch (dayNumber){
            case 1:
                System.out.println("Chủ Nhật");
                break;
            case 2:
                System.out.println("Thứ 2");
                break;
            case 3:
                System.out.println("Thứ 3");
                break;
            case 4:
                System.out.println("Thứ 4");
                break;
            case 5:
                System.out.println("Thứ 5");
                break;
            case 6:
                System.out.println("Thứ 6");
                break;
            case 7:
                System.out.println("Thứ 7");
                break;
            default:
                System.out.println("Số nhập vào không hợp lệ.");
                break;

        }


        }
    }



import java.util.Scanner;

public class ss5_baitap3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập vào 1 chuỗi: ");
        String inputStr = sc.nextLine();

        String replacedStr = inputStr.replaceAll("[0-9]", "*");

        System.out.println("Chuỗi sau khi thay thế: " + replacedStr);

    }
}

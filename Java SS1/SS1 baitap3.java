import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double banKinh;
        double dienTich;

        System.out.println("Nhập bán kính hình tròn:");
        banKinh = sc.nextDouble();

        dienTich = Math.PI * banKinh * banKinh;


        System.out.printf("Diện tính hình tròn có bán kinh %.2f là: %.2f%n", banKinh, dienTich);
    }
}
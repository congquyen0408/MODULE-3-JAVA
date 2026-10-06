import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
        System.out.println("Nhập 1 số nguyên:");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Số nhập vào không hợp lệ");
        } else {
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum = sum + i;
        }
            System.out.printf("Tổng các số từ 1 tới %d là: %d%n,", n, sum);

        }
        }

        }



import java.util.Scanner;

public class ss4_baitap2 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập kích thước của mảng: ");
        int size = sc.nextInt();
        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            System.out.println("Nhập phần tử thứ" + i + ":");
            array[i] = sc.nextInt();
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++){
            sum = sum + array[i];
        }
        System.out.println("Tổng các phần tử là:" +  sum);
}
}
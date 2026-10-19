import java.util.Scanner;

public class ss4_baitap1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập kích thước của mảng: ");
        int size = sc.nextInt();
        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            System.out.println("Nhập phần tử thứ " + i + ":");
            array[i] = sc.nextInt();
        }

        selectionSort(array);

        System.out.println("\nMảng đã sắp xếp theo thứ tự giảm dần:");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        System.out.println("Phần tử lớn nhất:" + array[0]);
    }


    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = temp;
        }
    }
}

package ss4_baitap4;

import java.util.Scanner;

public class ss4_baitap4 {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Nhập kích thước của mảng: ");
            int size = scanner.nextInt();

            if (size <= 0) {
                System.out.println("Kích thước rỗng");
                return;
            }

            int[] array = new int[size];

            System.out.println("Nhập các giá trị cho mảng:");
            for (int i = 0; i < size; i++) {
                System.out.print("Giá trị thứ " + (i + 1) + ": ");
                array[i] = scanner.nextInt();
            }

            System.out.println("Mảng ban đầu:");
             for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
             }
            System.out.println();

            for (int i = 0; i < size / 2; i++) {

                int temp = array[i];
                array[i] = array[size - 1 - i];
                array[size - 1 - i] = temp;
            }

            System.out.println("Mảng sau khi đảo ngược:");
            for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
              }
        }
    }



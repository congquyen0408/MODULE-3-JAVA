import java.util.Scanner;
import java.util.Arrays;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static void main(String[] args) {
        // làm ứng dụng nhập vào 1 số nguyên n, sau đó tao ra array có n kích thước
        // vận dụng vòng lặp để ghi giá trị cho array đó (for + scanner)
        // in ra array vừa nhập

        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập vào 1 số nguyên n: ");
        int number = sc.nextInt();

        int[] numberList = new int[number];

        //thêm phần tử đã nhập vào mảng
        for (int i = 0; i < numberList.length; i++) {
            System.out.println("Nhập phần tử thứ" + i + ":");
           numberList[i] = sc.nextInt();
        }
        for (int i = 0; i < numberList.length; i++) {
            System.out.println(numberList[i]);
        }

        int max = numberList[0];
        int min = numberList[0];

        for (int i = 0; i < numberList.length; i++) {
            if(numberList[i] > max) {
                max = numberList[i];
            }
            if(numberList[i] < min){
                min = numberList[i];
            }
        }

        System.out.println("Giá trị lớn nhất:" + max);
        System.out.println("Giá trị nhỏ nhất:" + min);
        }
    }

//    Bài 2: Tìm giá trị Lớn nhất (Max) và Nhỏ nhất (Min)
//    Mô tả:Tìm phần tử có giá trị lớn nhất ($Max$) và nhỏ nhất ($Min$) trong mảng.
//    In ra giá trị $Max, Min$ kèm theo vị trí (chỉ số - index) của chúng trong mảng.

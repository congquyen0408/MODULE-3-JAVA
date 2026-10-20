import java.util.Scanner;

public class ss5_baitap1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chuỗi văn bản: ");
        String text = sc.nextLine();

        System.out.println("Nhập từ khóa cần tìm: ");
        String wordToFind = sc.nextLine();

        int index = text.indexOf(wordToFind);

        if(index != -1) {
            System.out.println("Từ \"" + wordToFind + "\" xuất hiện tại vị trí " + index + " trong chuỗi.");
        } else {
            System.out.println("Không tìm thấy từ \"" + wordToFind + "\" trong chuỗi.");
        }
    }
}

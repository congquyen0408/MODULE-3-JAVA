public class ss5_baitap2 {
    public static void main(String[] args) {
        StringBuilder firstString = new StringBuilder("Hello, Java World!");

        System.out.println("Chuỗi ban đầu: " + firstString);

        firstString.delete(5,10);
        System.out.println("Chuỗi sau khi xóa: " + firstString);

        int start = firstString.indexOf("World");
        if (start != -1) {
           firstString.replace(start, start + 5, "Universe");
        }
        System.out.println("Chuỗi sau khi thay thế: " + firstString);
    }
}

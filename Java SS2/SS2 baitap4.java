import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Scanner sc = new Scanner(System.in);
    int age = 0;

    do {
        System.out.print("Vui lòng nhập tuổi của bạn: ");
        if (sc.hasNextInt()) {
            age = sc.nextInt();
            if (age <= 0) {
                System.out.println("Vui lòng nhập 1 số nguyên lớn hơn 0.");
            }
        } else {
            System.out.println("Vui lòng nhập 1 số nguyên lớn 0.");
            sc.next();
        }
    } while (age <= 0);

    System.out.printf("Tuổi của bạn là %d !%n", age);
    sc.close();
}


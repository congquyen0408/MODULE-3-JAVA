import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        Account sender = new Account(1, new BigDecimal("1000.00"));
        Account receiver = new Account(2, new BigDecimal("500.00"));
        BigDecimal amountToTransfer = new BigDecimal("250.00");

        System.out.println("Tài khoản nguồn: " + sender);
        System.out.println("Tài khoản đích: " + receiver);
        System.out.println("Số tiền chuyển: " + amountToTransfer);

        BankManager.transferFunds(sender.getId(), receiver.getId(), amountToTransfer);
    }
}
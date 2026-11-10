package task2;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Account account1 = new BankAccount(101, "Иван", new BigDecimal("5000.00"));
        Account account2 = new SavingsAccount(102, "Ольга", new BigDecimal("10000.00"), new BigDecimal("5.5"));
        Account account3 = new CreditAccount(103, "Пётр", new BigDecimal("0.00"), new BigDecimal("15000.00"));

        System.out.println("=== Демонстрация полиморфизма ===");

        Account[] bankSystem = {account1, account2, account3};
        for (Account acc : bankSystem) {
            System.out.println(acc.getDescription());
        }
    }
}

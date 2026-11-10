import task2.*;

import java.math.BigDecimal;

public class Task4 {
    public static void main(String[] args) {
        Account[] bankAccounts = {
            new BankAccount(101, "Иван Петров", new BigDecimal("5000.00")),
            new BankAccount(102, "Анна Сидорова", new BigDecimal("12500.50")),

            new SavingsAccount(201, "Ольга Соколова", new BigDecimal("50000.00"), new BigDecimal("6.0")),
            new SavingsAccount(202, "Дмитрий Смирнов", new BigDecimal("100000.00"), new BigDecimal("7.5")),

            new CreditAccount(301, "Алексей Иванов", new BigDecimal("0.00"), new BigDecimal("30000.00")),
            new CreditAccount(302, "Елена Кузнецова", new BigDecimal("15000.00"), new BigDecimal("50000.00"))
        };

        System.out.println("===== Выводим информацию о всех счетах =====");
        // Метод `getDescription()`
        for (Account account : bankAccounts) {
            System.out.println(account.getDescription());
        }
        System.out.println("\n===== Метод `toString()` =====");
        // Метод `toString()`
        for (Account account : bankAccounts) {
            System.out.println(account);
        }

        BigDecimal totalBankCapital = BigDecimal.ZERO;
        for (Account account : bankAccounts) {
            totalBankCapital = totalBankCapital.add(account.getBalance());
        }
        System.out.println("\nОбщий капитал банка: " + totalBankCapital);
    }
}

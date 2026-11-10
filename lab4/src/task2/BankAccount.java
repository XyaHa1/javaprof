package task2;

import java.math.BigDecimal;

public class BankAccount extends Account {

    public BankAccount(int number, String owner, BigDecimal balance) {
        super(number, owner, balance);
    }

    @Override
    public void deposit(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Сумма пополнения должна быть больше нуля");
        }

        balance = balance.add(amount);
    }

    @Override
    public void withdraw(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Сумма снятия должна быть больше нуля");
        }
        if (balance.subtract(amount).compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Недостаточно средств на счете");

        balance = balance.subtract(amount);
    }

    @Override
    public String getDescription() {
        return "Банковский счет. " + super.getDescription();
    }
}

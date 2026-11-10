package task2;

import java.math.BigDecimal;
import java.util.Objects;

public class CreditAccount extends Account {
    private final BigDecimal creditLimit;

    public CreditAccount(int number, String owner, BigDecimal balance, BigDecimal creditLimit) {
        super(number, owner, balance);
        this.creditLimit = creditLimit;
        validate();
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

        BigDecimal availableFunds = this.balance.add(this.creditLimit);

        if (availableFunds.subtract(amount).compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Превышен кредитный лимит. Недостаточно доступных средств");
        }

        balance = balance.subtract(amount);
    }

    @Override
    public String getDescription() {
        return String.format("Кредитный счёт (Лимит: %s). %s", creditLimit, super.getDescription());
    }

    @Override
    protected void validate() {
        super.validate();
        if (creditLimit.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Кредитный лимит должен быть положительным");
        }
    }

    @Override
    public String toString() {
        return String.format("CreditAccount{number=%d, owner=%s, balance=%s, creditLimit=%s}",
                number, owner, balance, creditLimit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), creditLimit);
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;

        CreditAccount that = (CreditAccount) o;

        return creditLimit.compareTo(that.creditLimit) == 0;
    }
}

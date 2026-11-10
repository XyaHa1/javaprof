package task2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class SavingsAccount extends Account {
    private final BigDecimal interestRate;

    public SavingsAccount(int number, String owner, BigDecimal balance, BigDecimal interestRate) {
        super(number, owner, balance);
        this.interestRate = interestRate;
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
        if (balance.subtract(amount).compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Недостаточно средств на счете");

        balance = balance.subtract(amount);
    }

    public void applyInterest() {
        // Формула: balance * (interestRate / 100)
        BigDecimal interest = balance
                .multiply(interestRate)
                .divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP);

        balance = balance.add(interest);
    }

    @Override
    public String getDescription() {
        return "Сберегательный счёт (Ставка: " + interestRate + "%). " + super.getDescription();
    }

    @Override
    protected void validate() {
        super.validate();
        if (interestRate.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Процентная ставка не может быть отрицательной");
        }
    }

    @Override
    public String toString() {
        return String.format("SavingsAccount{number=%d, owner=%s, balance=%s, interestRate=%s}",
                number, owner, balance, interestRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), interestRate);
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;

        SavingsAccount that = (SavingsAccount) o;

        return interestRate.compareTo(that.interestRate) == 0;
    }
}

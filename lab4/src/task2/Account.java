package task2;

import java.math.BigDecimal;
import java.util.Objects;

abstract public class Account {
    protected final int number;
    protected final String owner;
    protected BigDecimal balance;

    public Account(int number, String owner, BigDecimal balance) {
        this.number = number;
        this.owner = owner;
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getDescription() {
        return "Счёт №" + number + ", владелец: " + owner + ", баланс: " + balance;
    }

    public abstract void deposit(BigDecimal amount);

    public abstract void withdraw(BigDecimal amount);

    protected void validate() {
        if (balance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Баланс не может быть отрицательным");
        }
        if (number < 0) {
            throw new IllegalArgumentException("Аккаунт не может иметь отрицательный номер");
        }
        if (owner == null || owner.isEmpty()) {
            throw new IllegalArgumentException("Владелец не может быть пустым");
        }
    }

    @Override
    public String toString() {
        return "Account{number=" + number +
                ", owner=" + owner +
                ", balance=" + balance + "}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, owner, balance);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Account account = (Account) obj;
        return number == account.number &&
                Objects.equals(owner, account.owner) &&
                Objects.equals(balance, account.balance);
    }
}

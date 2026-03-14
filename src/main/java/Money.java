import java.util.Objects;

public class Money {
    private final long cents;

    public Money(long cents) {
        if (cents < 0) {
            throw new IllegalArgumentException("Amount must be >= 0");
        }
        this.cents = cents;
    }

    public static Money zero() {
        return new Money(0);
    }

    public static Money ofCents(long cents) {
        return new Money(cents);
    }

    public static Money ofDollars(long dollars) {
        return new Money(Math.multiplyExact(dollars, 100));
    }

    public Money add(Money other) {
        Objects.requireNonNull(other, "other");
        return new Money(Math.addExact(this.cents, other.cents));
    }

    public Money subtract(Money other) {
        Objects.requireNonNull(other, "other");
        long res = Math.subtractExact(this.cents, other.cents);
        if (res < 0) throw new IllegalArgumentException("Result must be >= 0");
        return new Money(res);
    }

    public Money multiply(int factor) {
        if (factor < 0) throw new IllegalArgumentException("factor must be >= 0");
        return new Money(Math.multiplyExact(this.cents, factor));
    }

    public Money multiply(long factor) {
        if (factor < 0) throw new IllegalArgumentException("factor must be >= 0");
        return new Money(Math.multiplyExact(this.cents, factor));
    }

    public Money multiplyByPromille(int promille) {
        if (promille < 0) throw new IllegalArgumentException("promille must be >= 0");
        long v = Math.multiplyExact(this.cents, (long) promille);
        long res = (v + 500) / 1000;
        return new Money(res);
    }

    public long cents() {
        return cents;
    }

    @Override
    public String toString() {
        return "Money{cents=" + cents + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money money)) return false;
        return cents == money.cents;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cents);
    }
}
public class CardPayment implements PaymentMethod {
    private static final long LIMIT_CENTS = 35_000L * 100;

    @Override
    public String name() {
        return "CardPayment";
    }

    @Override
    public void pay(Money amount) throws PaymentException {
        if (amount.cents() > LIMIT_CENTS) {
            throw new PaymentException("Card limit exceeded: " + amount.cents() + " cents");
        }
    }
}

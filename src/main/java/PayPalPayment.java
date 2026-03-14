public class PayPalPayment implements PaymentMethod {
    private static final long MIN_CENTS = 400L * 100;

    @Override
    public String name() {
        return "PayPalPayment";
    }

    @Override
    public void pay(Money amount) throws PaymentException {
        if (amount.cents() < MIN_CENTS) {
            throw new PaymentException("PayPal min is 400.00 USD, got " + amount.cents() + " cents");
        }
    }
}
public class BankTransferPayment implements PaymentMethod {
    private static final int FEE = 25;

    @Override
    public String name() {
        return "BankTransferPayment";
    }

    @Override
    public Money adjustAmount(Money baseAmount) {
        return baseAmount.add(baseAmount.multiplyByPromille(FEE));
    }

    @Override
    public void pay(Money amount) throws PaymentException {
        if (amount == null) throw new PaymentException("Amount is null");
        if (amount.cents() == 0) throw new PaymentException("Bank transfer amount must be > 0");
    }
}

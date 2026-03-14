public interface PaymentMethod {
    String name();
    void pay(Money amount);

    default Money adjustAmount(Money baseAmount) {
        return baseAmount;
    }
}

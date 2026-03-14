public class OrderCalculator {
    public Calculation calculate(Order order, PaymentMethod paymentMethod) {
        long totalCents = 0;
        int totalQty = 0;

        for (OrderItem item : order.items()) {
            totalQty += item.quantity();
            totalCents = Math.addExact(totalCents, item.lineTotal().cents());
        }

        Money total = Money.ofCents(totalCents);

        Money discounted = total;
        if (totalQty >= 10) {
            discounted = total.subtract(total.multiplyByPromille(120));
        }

        Money finalTotal = paymentMethod.adjustAmount(discounted);
        return new Calculation(totalQty, total, finalTotal);
    }

    public record Calculation(int totalQty, Money total, Money finalTotal) {}
}
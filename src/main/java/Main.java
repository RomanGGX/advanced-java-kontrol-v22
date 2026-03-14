public class Main {
    public static void main(String[] args) {
        OrderItem[] items = {
                new OrderItem("SKU-1", Money.ofDollars(100), 10)
        };

        Order order = new Order(new Email("user@example.com"), items);

        OrderCalculator calc = new OrderCalculator();

        PaymentMethod bank = new BankTransferPayment();
        var result = calc.calculate(order, bank);

        System.out.println("Payment method: " + bank.name());
        System.out.println("Total cents: " + result.total().cents());
        System.out.println("Final cents (with discount + fee): " + result.finalTotal().cents());

        bank.pay(result.finalTotal());
        System.out.println("Paid OK");
    }
}
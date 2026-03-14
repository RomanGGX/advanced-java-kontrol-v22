import java.util.Objects;

public class OrderItem {
    private final String sku;
    private final Money price;
    private final int quantity;

    public OrderItem(String sku, Money price, int quantity) {
        if (sku == null || sku.isBlank()) throw new IllegalArgumentException("sku is blank");
        this.sku = sku;
        this.price = Objects.requireNonNull(price, "price");
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be > 0");
        this.quantity = quantity;
    }

    public int quantity() { return quantity; }

    public Money lineTotal() {
        return price.multiply(quantity);
    }

    public Money total() {
        return lineTotal();
    }
}

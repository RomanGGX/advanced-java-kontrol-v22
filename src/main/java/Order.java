import java.util.Arrays;
import java.util.Objects;

public class Order {
    private final long id;
    private final Email email;
    private final OrderItem[] items;

    public Order(Email email, OrderItem[] items) {
        this(1L, email, items);
    }

    public Order(long id, Email email, OrderItem[] items) {
        if (id <= 0) throw new IllegalArgumentException("id must be > 0");
        this.id = id;
        this.email = Objects.requireNonNull(email, "email");
        if (items == null || items.length == 0) throw new IllegalArgumentException("items must not be empty");
        this.items = Arrays.copyOf(items, items.length);
    }

    public long id() { return id; }
    public Email email() { return email; }

    public OrderItem[] items() {
        return Arrays.copyOf(items, items.length);
    }
}
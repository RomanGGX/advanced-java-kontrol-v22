import java.util.Objects;

import java.util.Objects;

public class DeliveryAddress {
    private final String city;
    private final String zip; // 5 digits

    public DeliveryAddress(String city, String zip) {
        this.city = Objects.requireNonNull(city, "city");
        this.zip = Objects.requireNonNull(zip, "zip");
    }

    public boolean looksValid() {
        return !city.isBlank() && zip.matches("\\d{5}");
    }
}
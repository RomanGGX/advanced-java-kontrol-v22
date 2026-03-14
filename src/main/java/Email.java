public class Email {
    private final String value;

    public Email(String value) {
        if (value == null || value.isBlank()) throw new IllegalArgumentException("email is blank");
        if (!value.contains("@")) throw new IllegalArgumentException("email must contain @");
        this.value = value.trim().toLowerCase();
    }

    public String value() {
        return value;
    }
}

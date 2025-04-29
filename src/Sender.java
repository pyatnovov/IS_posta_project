import java.util.Objects;

public class Sender extends Person {
    private String email;
    private String phone;

    public Sender(String id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

    public Sender(String id, String firstName, String lastName, String email, String phone) {
        super(id, firstName, lastName);
        this.email = email;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && !email.isEmpty()) {
            this.email = email;
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone != null && !phone.isEmpty()) {
            this.phone = phone;
        }
    }

    @Override
    public String toString() {
        String base = super.toString();
        if (email != null)    base += ", Email: " + email;
        if (phone != null)    base += ", Phone: " + phone;
        return base;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sender)) return false;
        if (!super.equals(o)) return false;
        Sender other = (Sender) o;
        return Objects.equals(email, other.email) &&
                Objects.equals(phone, other.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), email, phone);
    }
}

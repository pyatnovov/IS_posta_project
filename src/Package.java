import java.util.Objects;

public class Package implements PackageComponent {
    private String id;
    private Sender sender;
    private Recipient recipient;
    private Location currentLocation;
    private double weight;
    private String status;

    Package (String id,
             Sender sender,
             Recipient recipient,
             Location location,
             double weight,
             String status) {
        if (id == null || id.isEmpty ()) throw new IllegalArgumentException ("ID cannot be null or empty");
        if (sender == null) throw new IllegalArgumentException ("Sender cannot be null");
        if (recipient == null) throw new IllegalArgumentException ("Recipient cannot be null");
        this.id = id;
        this.sender = sender;
        this.recipient = recipient;
        this.currentLocation = location;
        this.weight = weight;
        this.status = status;
    }

    @Override
    public String getId () {
        return id;
    }

    @Override
    public double getWeight () {
        return weight;
    }

    @Override
    public String getStatus () {
        return status;
    }

    @Override
    public Location getCurrentLocation () {
        return currentLocation;
    }

    @Override
    public void updateLocation (Location loc) {
        this.currentLocation = loc;
    }

    public Sender getSender () {
        return sender;
    }

    public void setSender (Sender sender) {
        this.sender = sender;
    }

    public Recipient getRecipient () {
        return recipient;
    }

    public void setRecipient (Recipient recipient) {
        this.recipient = recipient;
    }

    public void setWeight (double weight) {
        if (weight < 0) throw new IllegalArgumentException ("Weight cannot be negative");
        this.weight = weight;
    }

    public void setStatus (String status) {
        this.status = status;
    }

    @Override
    public String toString () {
        return "Package ID: " + id + "\n"
                + "Sender: " + sender + "\n"
                + "Recipient: " + recipient + "\n"
                + "Current Location: " + currentLocation + "\n"
                + "Weight: " + weight + " kg\n"
                + "Status: " + status;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (!(o instanceof Package)) return false;
        Package other = (Package) o;
        return Objects.equals (id, other.id);
    }

    @Override
    public int hashCode () {
        return Objects.hash (id);
    }
}
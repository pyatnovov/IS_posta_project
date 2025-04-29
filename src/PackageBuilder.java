public class PackageBuilder {
    private String id;
    private Sender sender;
    private Recipient recipient;
    private Location location;
    private double weight;
    private String status;

    public PackageBuilder setId (String id) {
        this.id = id;
        return this;
    }

    public PackageBuilder setSender (Sender sender) {
        this.sender = sender;
        return this;
    }

    public PackageBuilder setRecipient (Recipient recipient) {
        this.recipient = recipient;
        return this;
    }

    public PackageBuilder setLocation (Location location) {
        this.location = location;
        return this;
    }

    public PackageBuilder setWeight (double weight) {
        this.weight = weight;
        return this;
    }

    public PackageBuilder setStatus (String status) {
        this.status = status;
        return this;
    }

    public Package build () throws InvalidSenderException, InvalidRecipientException {
        if (sender == null) throw new InvalidSenderException ("Sender must be specified" , null);
        if (recipient == null) throw new InvalidRecipientException ("Recipient must be specified" , null);
        if (id == null || location == null) {
            throw new IllegalStateException ("Other required fields missing");
        }
        return new Package (id , sender , recipient , location , weight , status);
    }
}
public class InvalidRecipientException extends Exception {
    private final Recipient recipient;

    public InvalidRecipientException(String message, Recipient recipient) {
        super(message);
        this.recipient = recipient;
    }

    public Recipient getRecipient() {
        return recipient;
    }
}
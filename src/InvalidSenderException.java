public class InvalidSenderException extends Exception {
    private final Sender sender;

    public InvalidSenderException(String message, Sender sender) {
        super(message);
        this.sender = sender;
    }

    public Sender getSender() {
        return sender;
    }
}
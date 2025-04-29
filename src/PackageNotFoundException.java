public class PackageNotFoundException extends Exception {
    protected PostalOffice office;

    public PackageNotFoundException() {
        this(null, null);
    }

    public PackageNotFoundException(String message) {
        this(message, null);
    }

    public PackageNotFoundException(String message, PostalOffice office) {
        super(message);
        this.office = office;
    }

    public PostalOffice getPostalOffice() {
        return office;
    }
}
public class PostalOfficeFactory implements PostalOfficeCreator {

    private static int counter = 1;

    @Override
    public PostalOffice createPostalOffice(String name, Location location) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("The name of the branch cannot be empty");
        }
        if (location == null) {
            throw new IllegalArgumentException("Location cannot be null");
        }

        String generatedId = "PO" + (counter++);
        return new PostalOffice(generatedId, name, location);
    }
}
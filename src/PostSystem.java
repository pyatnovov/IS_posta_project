import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class PostSystem {
    private Map<String, PostalOffice> postalOffices;

    public PostSystem() {
        this.postalOffices = new HashMap<>();
    }

    public void addPostalOffice(PostalOffice office) {
        if (office == null || office.getId() == null) {
            throw new IllegalArgumentException("Post office cannot be null");
        }
        postalOffices.put(office.getId(), office);
    }

    public Collection<PostalOffice> getAllOffices() {
        return postalOffices.values();
    }

    public Sender findSenderById(String senderId) {
        for (PostalOffice office : postalOffices.values()) {
            Sender s = office.getSender(senderId);
            if (s != null) return s;
        }
        return null;
    }

    public Recipient findRecipientById(String recipientId) {
        for (PostalOffice office : postalOffices.values()) {
            Recipient r = office.getRecipient(recipientId);
            if (r != null) return r;
        }
        return null;
    }

    public Package findPackageById(String pkgId) {
        for (PostalOffice office : postalOffices.values()) {
            Package p = office.getPackage(pkgId);
            if (p != null) return p;
        }
        return null;
    }

    public void printSummary() {
        System.out.println("=== POST SYSTEM SUMMARY ===");
        for (PostalOffice office : getAllOffices()) {
            System.out.println(office);
            System.out.println("  - " + office.getAllSenders().size() + " senders");
            System.out.println("  - " + office.getAllRecipients().size() + " recipients");
            System.out.println("  - " + office.getAllPackages().size() + " packages");
            System.out.println();
        }
    }
}
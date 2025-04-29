import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class PostalOffice implements Identifiable {
    private String id;
    private String name;
    private Location location;

    private Map<String, Sender> senders;
    private Map<String, Recipient> recipients;
    private Map<String, Package> packages;

    public PostalOffice(String id, String name, Location location) {
        if (id == null || id.isEmpty()) throw new IllegalArgumentException("ID cannot be null or empty");
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty");
        this.id = id;
        this.name = name;
        this.location = location;
        this.senders = new HashMap<>();
        this.recipients = new HashMap<>();
        this.packages = new HashMap<>();
    }

    @Override public String getId()        { return id; }
    public String getName()                { return name; }
    public Location getLocation()          { return location; }

    public void registerSenderOrThrow(Sender s) throws InvalidSenderException {
        if (s == null || s.getId() == null || s.getId().isEmpty()) {
            throw new InvalidSenderException("Invalid sender", s);
        }
        senders.put(s.getId(), s);
    }
    public void registerRecipientOrThrow(Recipient r) throws InvalidRecipientException {
        if (r == null || r.getId() == null || r.getId().isEmpty()) {
            throw new InvalidRecipientException("Invalid recipient", r);
        }
        recipients.put(r.getId(), r);
    }

    public Sender getSender(String id)                     { return senders.get(id); }
    public Recipient getRecipient(String id)               { return recipients.get(id); }

    public void addPackage(Package pkg)                    { packages.put(pkg.getId(), pkg); }
    public Package getPackage(String id)                   { return packages.get(id); }

    public Package getPackageOrThrow(String pkgId)
            throws PackageNotFoundException {
        Package p = packages.get(pkgId);
        if (p == null) throw new PackageNotFoundException("Package with ID '" + pkgId + "' not found", this);
        return p;
    }

    public Collection<Sender> getAllSenders()              { return senders.values(); }
    public Collection<Recipient> getAllRecipients()        { return recipients.values(); }
    public Collection<Package> getAllPackages()            { return packages.values(); }

    public void updatePackageLocation(String pkgId, Location loc) {
        Package p = packages.get(pkgId);
        if (p != null) p.updateLocation(loc);
    }

    @Override
    public String toString() {
        return "Postal Office '" + name + "' (ID: " + id + "), Address: " + location;
    }
}
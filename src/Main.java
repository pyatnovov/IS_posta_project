public class Main {
    public static void main(String[] args) {
        PostSystem system = new PostSystem();

        Location loc1 = new Location("Poštová", "12", "Bratislava", 81101, "Slovakia");
        Location loc2 = new Location("Hlavná",  "7", "Košice",    04001, "Slovakia");

        PostalOfficeCreator factory = new PostalOfficeFactory();
        PostalOffice office1 = factory.createPostalOffice("Bratislava Central", loc1);
        PostalOffice office2 = factory.createPostalOffice("Košice Central",    loc2);

        system.addPostalOffice(office1);
        system.addPostalOffice(office2);

        Sender sender      = new Sender("S001", "Lucia", "Petrová", "lucia@example.com", "0911111111");
        Recipient recipient = new Recipient("R001", "Ján",   "Tóth",    "jan@example.com",   "0944444444");
        try {

            office1.registerSenderOrThrow(sender);
            office1.registerRecipientOrThrow(recipient);


            office2.registerSenderOrThrow(sender);
            office2.registerRecipientOrThrow(recipient);
        } catch (InvalidSenderException e) {
            System.out.println("❗ Failed to register sender: " + e.getMessage());

        } catch (InvalidRecipientException e) {
            System.out.println("❗ Failed to register recipient: " + e.getMessage());
        }


        Package pkg1 = null;
        try {
            pkg1 = new PackageBuilder()
                    .setId("PKG001")
                    .setSender(sender)
                    .setRecipient(recipient)
                    .setLocation(loc1)
                    .setWeight(2.5)
                    .setStatus("Waiting for shipment")
                    .build();
            office1.addPackage(pkg1);
        } catch (InvalidSenderException e) {
            System.out.println("❗ Cannot build package—invalid sender: " + e.getMessage());
        } catch (InvalidRecipientException e) {
            System.out.println("❗ Cannot build package—invalid recipient: " + e.getMessage());
        }

        if (pkg1 != null) {
            InsuredPackage insured = new InsuredPackage(pkg1, 1000.0);
            System.out.println("\n✅ Insured Package:");
            System.out.println(insured);
        }

        Package pkg2 = null;
        try {
            pkg2 = new PackageBuilder()
                    .setId("PKG002")
                    .setSender(sender)
                    .setRecipient(recipient)
                    .setLocation(loc2)
                    .setWeight(3.0)
                    .setStatus("In transit")
                    .build();
            office2.addPackage(pkg2);
        } catch (InvalidSenderException e) {
            System.out.println("❗ Cannot build package 2—invalid sender: " + e.getMessage());
        } catch (InvalidRecipientException e) {
            System.out.println("❗ Cannot build package 2—invalid recipient: " + e.getMessage());
        }

        PackageGroup group = new PackageGroup("GRP-EXPORT");
        if (pkg1 != null) group.addPackage(pkg1);
        if (pkg2 != null) group.addPackage(pkg2);
        group.updateLocation(new Location("Warehouse", "1A", "Žilina", 01001, "Slovakia"));

        System.out.println("\n📦 Package Group:");
        System.out.println(group);

        try {
            Package found = office1.getPackageOrThrow("PKG001");
            System.out.println("\n🔍 Found package: " + found.getId());
        } catch (PackageNotFoundException e) {
            System.out.println("❗ Package not found: " + e.getMessage());
        }

        try {
            office2.getPackageOrThrow("NON_EXISTENT");
        } catch (PackageNotFoundException e) {
            System.out.println("❗ Package not found: " + e.getMessage());
            if (e.getPostalOffice() != null) {
                System.out.println("  in office: " + e.getPostalOffice().getName());
            }
        }


        System.out.println("\n📬 Postal system summary:");
        system.printSummary();
    }
}
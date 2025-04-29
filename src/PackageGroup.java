//Composier

import java.util.ArrayList;
import java.util.List;

public class PackageGroup implements Trackable {
    private String groupId;
    private List<Package> packages;

    public PackageGroup(String groupId) {
        this.groupId = groupId;
        this.packages = new ArrayList<>();
    }

    public void addPackage(Package pkg) {
        if (pkg != null) {
            packages.add(pkg);
        }
    }

    public void removePackage(Package pkg) {
        packages.remove(pkg);
    }

    public double getTotalWeight() {
        double total = 0.0;
        for (Package pkg : packages) {
            total += pkg.getWeight();
        }
        return total;
    }

    @Override
    public Location getCurrentLocation() {
        if (packages.isEmpty()) return null;
        return packages.get(0).getCurrentLocation();
    }

    @Override
    public void updateLocation(Location newLocation) {
        for (Package pkg : packages) {
            pkg.updateLocation(newLocation);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Package Group '").append(groupId).append("' [").append(packages.size()).append(" packages]\n");
        for (Package pkg : packages) {
            sb.append(" - ").append(pkg.getId()).append(" (").append(pkg.getWeight()).append(" kg)\n");
        }
        return sb.toString();
    }
}

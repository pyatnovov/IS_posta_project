import java.util.Objects;

public class InsuredPackage implements PackageComponent {
    private PackageComponent base;
    private double insuranceAmount;

    public InsuredPackage(PackageComponent base, double insuranceAmount) {
        if (base == null) throw new IllegalArgumentException("Base package cannot be null");
        if (insuranceAmount < 0) throw new IllegalArgumentException("Insurance amount cannot be negative");
        this.base = base;
        this.insuranceAmount = insuranceAmount;
    }

    // Additional behavior
    public double getInsuranceAmount() {
        return insuranceAmount;
    }

    // Delegate to base
    @Override
    public String getId () {
        return base.getId();
    }

    @Override
    public Location getCurrentLocation () {
        return base.getCurrentLocation();
    }

    @Override
    public void updateLocation (Location newLocation) {
        base.updateLocation(newLocation);
    }

    @Override
    public double getWeight () {
        return base.getWeight();
    }

    @Override
    public String getStatus () {
        return base.getStatus();
    }

    @Override
    public String toString() {
        return base.toString() +
                "\nINSURANCE: €" + String.format("%.2f", insuranceAmount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InsuredPackage)) return false;
        InsuredPackage other = (InsuredPackage) o;
        return base.equals(other.base);
    }

    @Override
    public int hashCode() {
        return Objects.hash(base);
    }
}
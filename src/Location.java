public class Location {
    private String street;
    private String buildingNumber;
    private String city;
    private int postalCode;
    private String country;

    public Location(String street, String buildingNumber, String city, int postalCode, String country) {
        if (street == null || street.isEmpty()) throw new IllegalArgumentException("Street cannot be null or empty");
        if (city == null || city.isEmpty()) throw new IllegalArgumentException("City cannot be null or empty");
        if (postalCode <= 0) throw new IllegalArgumentException("Index must be greater than zero");

        this.street = street;
        this.buildingNumber = buildingNumber;
        this.city = city;
        this.postalCode = postalCode;
        this.country = (country != null && !country.isEmpty()) ? country : "Slovakia";
    }


    /// getters
    public String getStreet() {
        return street;
    }
    public String getBuildingNumber() {
        return buildingNumber;
    }
    public String getCity() {
        return city;
    }
    public int getPostalCode() {
        return postalCode;
    }
    public String getCountry() {
        return country;
    }

    /// seters
    public void setStreet(String street) {
        if (street == null || street.isEmpty()) throw new IllegalArgumentException("Street cannot be null or empty");
        this.street = street;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }


    public void setCity(String city) {
        if (city == null || city.isEmpty()) throw new IllegalArgumentException("City cannot be null or empty");
        this.city = city;
    }


    public void setPostalCode(int postalCode) {
        if (postalCode <= 0) throw new IllegalArgumentException("PostalCode must be greater than zero");
        this.postalCode = postalCode;
    }

    public void setCountry(String country) {
        if (country != null && !country.isEmpty()) {
            this.country = country;
        }
    }

    @Override
    public String toString() {
        return street + " " + buildingNumber + ", " + postalCode + " " + city + ", " + country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;

        Location other = (Location) o;

        return street.equals(other.street) &&
                city.equals(other.city) &&
                postalCode == other.postalCode;
    }

    @Override
    public int hashCode() {
        int result = street.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + postalCode;
        return result;
    }
}
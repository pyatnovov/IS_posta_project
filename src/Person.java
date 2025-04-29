public abstract class Person implements Identifiable {
    private String id;
    private String firstName;
    private String lastName;

    public Person(String id, String firstName, String lastName) {
        if (id == null) {
            throw new IllegalArgumentException("ID cant be null");
        }
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }



    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.isEmpty()) throw new IllegalArgumentException("Ім’я не може бути порожнім");
        this.firstName = firstName;
    }



    public void setLastName(String lastName) {
        if (lastName == null || lastName.isEmpty()) throw new IllegalArgumentException("The last name cannot be empty");
        this.lastName = lastName;
    }



    @Override
    public String getId() {
        return id;
    }


    @Override
    public String toString() {
        return firstName + " " + lastName + " (ID: " + id + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return id.equals(person.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}

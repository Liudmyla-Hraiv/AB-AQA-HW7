package net.absoft.data;

public enum Customer {
    FIRST_USER_INFO("Ivanov", "Ivan", "65000"),
    SECOND_USER_INFO("Sidorov", "Semen", "31200" );

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String firstName;
    public String lastName;
    public String zipCode;

    Customer(String firstName, String lastName, String zipCode){
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipCode = zipCode;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

}

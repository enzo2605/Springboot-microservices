package com.vincenzo.rest.webservices.restfulwebservices.versoning;

public class Name {
    private String firstName;
    private String lastname;

    public Name(String firstName, String lastname) {
        this.firstName = firstName;
        this.lastname = lastname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}

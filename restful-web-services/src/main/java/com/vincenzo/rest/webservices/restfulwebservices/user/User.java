package com.vincenzo.rest.webservices.restfulwebservices.user;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class User {
    private Integer id;
    @Size(min = 2, message = "Name should have at least two characters")
    private String name;
    @Past(message = "Birthday should be in the past")
    private LocalDate birthday;

    public User() {}

    public User(Integer id, String name, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}

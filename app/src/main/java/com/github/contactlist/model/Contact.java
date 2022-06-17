package com.github.contactlist.model;

import java.io.Serializable;

public class Contact implements Serializable {

    private int age;
    private String name, surname, fullName, email, photo;

    public Contact(int age, String name, String surname, String fullName, String email, String photo) {
        this.age = age;
        this.name = name;
        this.surname = surname;
        this.fullName = fullName;
        this.email = email;
        this.photo = photo;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoto() {
        return photo;
    }
}

package com.github.contactlist.model;

import java.io.Serializable;

public class Contact implements Serializable {

    private final int age;
    private final String name, surname, fullName, email;
    private final byte[] photo;

    public Contact(int age, String name, String surname, String fullName, String email, byte[] photo) {
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

    public byte[] getPhoto() {
        return photo;
    }

}

package com.github.contactlist.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Contact implements Parcelable {

    private int age;
    private String name, surname, fullName, email;
    private Bitmap photo;

    public Contact(int age, String name, String surname, String fullName, String email, Bitmap photo) {
        this.age = age;
        this.name = name;
        this.surname = surname;
        this.fullName = fullName;
        this.email = email;
        this.photo = photo;
    }

    protected Contact(Parcel in) {
        age = in.readInt();
        name = in.readString();
        surname = in.readString();
        fullName = in.readString();
        email = in.readString();
        photo = in.readParcelable(Bitmap.class.getClassLoader());
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

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

    public Bitmap getPhoto() {
        return photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(age);
        parcel.writeString(name);
        parcel.writeString(surname);
        parcel.writeString(fullName);
        parcel.writeString(email);
        parcel.writeParcelable(photo, i);
    }
}

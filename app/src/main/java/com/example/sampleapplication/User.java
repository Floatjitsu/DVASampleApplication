package com.example.sampleapplication;

public class User {

    private String name, email, hobbies;

    public User() {}

    public User(String name, String email, String hobbies) {
        this.name = name;
        this.email = email;
        this.hobbies = hobbies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }
}

package com.example.sampleapplication;

import java.util.List;

public class User {

    private String name, email;
    private List<String> hobbies;

    public User() {}

    public User(String name, String email, List<String> hobbies) {
        this.name = name;
        this.email = email;
        this.hobbies = hobbies;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getHobbies() {
        return hobbies;
    }
}

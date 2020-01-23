package com.example.bykeproject.model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("name")
    String name;
    @SerializedName("id")
    int id;
    @SerializedName("email")
    String email;
    @SerializedName("password")
    String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

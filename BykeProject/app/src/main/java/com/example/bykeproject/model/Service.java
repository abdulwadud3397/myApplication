package com.example.bykeproject.model;

import com.google.gson.annotations.SerializedName;

public class Service {
    @SerializedName("name")
    private  String name;
    @SerializedName("email")
    private String email;
    @SerializedName("service")
    private String service;
    @SerializedName("phone")
    private int phone;
    @SerializedName("country")
    private String  country;
    @SerializedName("message")
    private String  message;

    public Service() {
    }

    public Service(String name, String email, String service, int phone, String country, String message) {
        this.name = name;
        this.email = email;
        this.service = service;
        this.phone = phone;
        this.country = country;
        this.message = message;
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

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

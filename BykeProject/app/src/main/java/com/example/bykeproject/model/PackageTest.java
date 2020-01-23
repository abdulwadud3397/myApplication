package com.example.bykeproject.model;

import com.google.gson.annotations.SerializedName;

public class PackageTest {


    @SerializedName("name")
    String name;
    @SerializedName("byke")
    String byke;
    @SerializedName("email")
    String email;
    @SerializedName("phone")
    int phone;
    @SerializedName("amount")
    int amount;
    @SerializedName("place")
    String place;


    public PackageTest() {
    }

    public PackageTest(String name, String byke, String email, int phone, int amount, String place) {
        this.name = name;
        this.byke = byke;
        this.email = email;
        this.phone = phone;
        this.amount = amount;
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getByke() {
        return byke;
    }

    public void setByke(String byke) {
        this.byke = byke;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}

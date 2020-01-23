package com.example.bykeproject.model;

import com.google.gson.annotations.SerializedName;

public class Booking {
   private String name;
   private int phone;
   private String destination;
   private String email;
   private String date;
   private String location;
   private String bname;
   private String bcolor;
   private String version;

    public Booking() {
    }

    public Booking(String name, int phone, String destination, String email, String date, String location, String bname, String bcolor, String version) {
        this.name = name;
        this.phone = phone;
        this.destination = destination;
        this.email = email;
        this.date = date;
        this.location = location;

        this.bname = bname;
        this.bcolor = bcolor;
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }



    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBcolor() {
        return bcolor;
    }

    public void setBcolor(String bcolor) {
        this.bcolor = bcolor;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}

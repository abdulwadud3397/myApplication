package com.example.bykeproject.model;

import com.google.gson.annotations.SerializedName;

public class Products {
    @SerializedName("name")
    String name;
    @SerializedName("qty")
    int qty;
    @SerializedName("type")
    String type;
    @SerializedName("price")
    int price;
    @SerializedName("color")
    String color;
    @SerializedName("date")
    String date;
    @SerializedName("total")
    double total;

    public Products() {
    }

    public Products(String name, int qty, String type, int price, String color, String date, double total) {
        this.name = name;
        this.qty = qty;
        this.type = type;
        this.price = price;
        this.color = color;
        this.date = date;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}



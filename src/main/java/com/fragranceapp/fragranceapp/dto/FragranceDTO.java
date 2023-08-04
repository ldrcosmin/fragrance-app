package com.fragranceapp.fragranceapp.dto;


public class FragranceDTO {

    private String name;
    private String amount;
    private double price;
    private int quantity;

    public FragranceDTO() {

    }

    public FragranceDTO(String name, String amount, double price, int quantity) {
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

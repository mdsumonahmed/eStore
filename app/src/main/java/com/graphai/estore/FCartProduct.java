package com.graphai.estore;

public class FCartProduct {

    private int id;
    private String title, shortdesc;
    private double price;
    private int image;
    private int count = 1;


    public FCartProduct(int id, String title, String shortdesc, double price, int image) {
        this.id = id;
        this.title = title;
        this.shortdesc = shortdesc;
        this.price = price;
        this.image = image;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public double getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }

}

package com.graphai.estore;

public class Bottomsheet_recycler_design_child {

    int image;
    String title,shortdesc,price;

    public Bottomsheet_recycler_design_child(int image, String title, String shortdesc, String price) {
        this.image = image;
        this.title = title;
        this.shortdesc = shortdesc;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public String getPrice() {
        return price;
    }
}

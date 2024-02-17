package com.graphai.estore;

public class ProductCollection {
     int image;
     String shortDesc;
     String price;
     String oldPrice;
     float rating;
    public ProductCollection(int image, String shortDesc, String price, String oldPrice, float rating) {
        this.image = image;
        this.shortDesc = shortDesc;
        this.price = price;
        this.oldPrice = oldPrice;
        this.rating = rating;
    }

    public int getImage() {
        return image;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public String getPrice() {
        return price;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public float getRating() {return rating; }


}

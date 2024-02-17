package com.graphai.estore;

public class CollectionChild {

    private String TextTitle,TextDesc;
    private int imageLeft,imageRight;

    public CollectionChild(String textTitle, String textDesc, int imageLeft, int imageRight) {
        TextTitle = textTitle;
        TextDesc = textDesc;
        this.imageLeft = imageLeft;
        this.imageRight = imageRight;
    }

    public String getTextTitle() {
        return TextTitle;
    }

    public String getTextDesc() {
        return TextDesc;
    }

    public int getImageLeft() {
        return imageLeft;
    }

    public int getImageRight() {
        return imageRight;
    }
}

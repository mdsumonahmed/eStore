package com.graphai.estore;

import java.util.Comparator;

public class ProductModel {
    private int productImage;
    private String productName;
    private int productPrice;
    private float productRating;
    private String whatView;

    public ProductModel(int productImage, String productName, int productPrice, float productRating, String whatView) {
        this.productImage = productImage;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productRating = productRating;
        this.whatView = whatView;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public float getProductRating() {
        return productRating;
    }

    public void setProductRating(float productRating) {
        this.productRating = productRating;
    }

    public String getWhatView() {
        return whatView;
    }

    public void setWhatView(String whatView) {
        this.whatView = whatView;
    }

    //Sort by Price
    public static Comparator<ProductModel> productPriceComparatorAscending = new Comparator<ProductModel>() {

        public int compare(ProductModel p1, ProductModel p2) {

            int price1 = p1.getProductPrice();
            int price2 = p2.getProductPrice();

            return price1 - price2;
        }
    };
    public static Comparator<ProductModel> productPriceComparatorDescending = new Comparator<ProductModel>() {

        public int compare(ProductModel p1, ProductModel p2) {

            int price1 = p1.getProductPrice();
            int price2 = p2.getProductPrice();

            return price2 - price1;
        }
    };
    public static Comparator<ProductModel> productRatingComparator = new Comparator<ProductModel>() {

        public int compare(ProductModel p1, ProductModel p2) {

            float rating1 = p1.getProductRating();
            float rating2 = p2.getProductRating();

            int r1 = (int)(rating1*10);
            int r2 = (int)(rating2*10);

            return r2 - r1;
        }
    };
}

package com.graphai.estore;


import java.util.ArrayList;

public class ProductInfo {
    private int id;
    private String name;
    private ArrayList<String> productFeature;
    private ArrayList<String> shortDescription;
    private String fullModel;
    private int price;

    public static ArrayList<String> setData(String data){
        String line = "";
        int dataLength=data.length();
        ArrayList<String> combineData = new ArrayList<>();
        for(int i = 0; i< dataLength; i++){
            if(data.substring(i, i+1).equals("\n")){
                combineData.add(line);
                line = "";
            }
            else{
                line+=data.substring(i, i+1);
            }
        }
        combineData.add(line);
        return combineData;
    }

    public ProductInfo(int id, String name, ArrayList<String> productFeature, ArrayList<String> shortDescription, String fullModel, int price) {
        this.id = id;
        this.name = name;
        this.productFeature = productFeature;
        this.shortDescription = shortDescription;
        this.fullModel = fullModel;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getProductFeature() {
        return productFeature;
    }

    public void setProductFeature(ArrayList<String> productFeature) {
        this.productFeature = productFeature;
    }

    public ArrayList<String> getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(ArrayList<String> shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getFullModel() {
        return fullModel;
    }

    public void setFullModel(String fullModel) {
        this.fullModel = fullModel;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

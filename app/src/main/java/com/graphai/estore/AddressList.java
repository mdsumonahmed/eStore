package com.graphai.estore.model;

public class AddressList {

    private String Name;
    private String Edit;
    private String Number;
    private String Home;
    private String ChildLocation;
    private String Location;
    private String ShippingBill;
    private int Image;

    public AddressList(String name, String edit, String number, String home, String childLocation, String location, String shippingBill, int image) {
        Name = name;
        Edit = edit;
        Number = number;
        Home = home;
        ChildLocation = childLocation;
        Location = location;
        ShippingBill = shippingBill;
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEdit() {
        return Edit;
    }

    public void setEdit(String edit) {
        Edit = edit;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getHome() {
        return Home;
    }

    public void setHome(String home) {
        Home = home;
    }

    public String getChildLocation() {
        return ChildLocation;
    }

    public void setChildLocation(String childLocation) {
        ChildLocation = childLocation;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getShippingBill() {
        return ShippingBill;
    }

    public void setShippingBill(String shippingBill) {
        ShippingBill = shippingBill;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}

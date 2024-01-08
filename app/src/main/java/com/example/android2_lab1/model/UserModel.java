package com.example.android2_lab1.model;

public class UserModel {

    private String name;
    private String address;
    private String phone;

    public UserModel( String name, String address, String phone) {

        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public UserModel() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

package com.raul.paginasamarillas.models;

public class Company {

    private Integer id;

    private String category;

    private String name;

    private String address;

    private String phone;

    private String email;

    private String url;

    private String picture;

    private String info;

    public Company(){

    }

    public Company(Integer id, String category, String name, String address, String phone, String email, String url, String picture, String info) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.url = url;
        this.picture = picture;
        this.info = info;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", url='" + url + '\'' +
                ", picture='" + picture + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}

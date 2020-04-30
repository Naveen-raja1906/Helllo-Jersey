package com.hello.jersey;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Menues {
    private int id;
    private String foodname;
    private float price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}

package com.laptopshop.laptopshop.domain;

import jakarta.persistence.Entity;

@Entity
public class Product {
    private long id;
    private String name;
    private double price;
    private String image;
    private String detailDecs;
    private String shortDecs;
    private long quantity;
    private long sold;
    private String factory;
    private String target;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDetailDecs() {
        return detailDecs;
    }

    public void setDetailDecs(String detailDecs) {
        this.detailDecs = detailDecs;
    }

    public String getShortDecs() {
        return shortDecs;
    }

    public void setShortDecs(String shortDecs) {
        this.shortDecs = shortDecs;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public long getSold() {
        return sold;
    }

    public void setSold(long sold) {
        this.sold = sold;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + ", image=" + image + ", detailDecs="
                + detailDecs + ", shortDecs=" + shortDecs + ", quantity=" + quantity + ", sold=" + sold + ", factory="
                + factory + ", target=" + target + "]";
    }

}

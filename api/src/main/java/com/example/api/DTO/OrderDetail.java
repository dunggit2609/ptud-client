package com.example.api.DTO;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public class OrderDetail {
    @Field("ProductID")
    private String productID;
    @Field("Name")
    private String name;
    @Field("ImagePath")
    private String imagePath;
    @Field("Price")
    private int price;
    @Field("Quantity")
    private int quantity;

    public OrderDetail(String productID, String name, String imagePath, int price, int quantity) {
        this.productID = productID;
        this.name = name;
        this.imagePath = imagePath;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

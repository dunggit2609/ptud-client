package com.example.api.DTO;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Document(collection = "Product")
public class Products {
    @Id
    private ObjectId _id;
    @Field("Name")
    private String name;
    @Field("Price")
    private String price;
    @Field("Category")
    private String category;
    @Field("ImagePath")
    private String imagePath;
    @Field("shopID")
    private String shopID;
    @Field("Comments")
    private List<Comments> comments;

    public Products(ObjectId _id, String name, String price, String category, String imagePath, String shopID, List<Comments> comments) {
        this._id = _id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.imagePath = imagePath;
        this.shopID = shopID;
        this.comments = comments;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getShopID() {
        return shopID;
    }

    public void setShopID(String shopID) {
        this.shopID = shopID;
    }
}

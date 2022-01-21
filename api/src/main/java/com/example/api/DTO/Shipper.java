package com.example.api.DTO;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Shipper")
public class Shipper {
    @Id
    private ObjectId _id;
    @Field
    private String name;
    @Field
    private String avatar;
    @Field
    private String phone;
    @Field
    private String address;
    @Field
    private String negative_cert;
    @Field
    private String vaccine_cert;
    @Field
    private String identify;

    public Shipper(ObjectId _id, String name, String avatar, String phone, String address, String negative_cert, String vaccine_cert, String identify) {
        this._id = _id;
        this.name = name;
        this.avatar = avatar;
        this.phone = phone;
        this.address = address;
        this.negative_cert = negative_cert;
        this.vaccine_cert = vaccine_cert;
        this.identify = identify;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNegative_cert() {
        return negative_cert;
    }

    public void setNegative_cert(String negative_cert) {
        this.negative_cert = negative_cert;
    }

    public String getVaccine_cert() {
        return vaccine_cert;
    }

    public void setVaccine_cert(String vaccine_cert) {
        this.vaccine_cert = vaccine_cert;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }
}

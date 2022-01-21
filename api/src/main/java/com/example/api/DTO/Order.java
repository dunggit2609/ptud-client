package com.example.api.DTO;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "Order")

public class Order {
    @Id
    private ObjectId _id;
    @Field
    private String shop_id;
    @Field
    private String customer_id;
    @Field
    private String shipper_id;
    @Field
    private String ship_info;
    @Field
    private int status;
    @Field
    private int total;
    @Field
    private int shipper_fee;
    @Field
    private boolean cert_shop;
    @Field
    private boolean cert_cus;
    @Field
    private Date  created_at;
    @Field
    private Date updated_at;
    @Field("order_detail")
    private List<OrderDetail> order_detail;

    public Order(ObjectId _id, String shop_id, String customer_id, String shipper_id, String ship_info, int status, int total, int shipper_fee, boolean cert_shop, boolean cert_cus, Date created_at, Date updated_at, List<OrderDetail> order_detail) {
        this._id = _id;
        this.shop_id = shop_id;
        this.customer_id = customer_id;
        this.shipper_id = shipper_id;
        this.ship_info = ship_info;
        this.status = status;
        this.total = total;
        this.shipper_fee = shipper_fee;
        this.cert_shop = cert_shop;
        this.cert_cus = cert_cus;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.order_detail = order_detail;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getShipper_id() {
        return shipper_id;
    }

    public void setShipper_id(String shipper_id) {
        this.shipper_id = shipper_id;
    }

    public String getShip_info() {
        return ship_info;
    }

    public void setShip_info(String ship_info) {
        this.ship_info = ship_info;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getShipper_fee() {
        return shipper_fee;
    }

    public void setShipper_fee(int shipper_fee) {
        this.shipper_fee = shipper_fee;
    }

    public boolean isCert_shop() {
        return cert_shop;
    }

    public void setCert_shop(boolean cert_shop) {
        this.cert_shop = cert_shop;
    }

    public boolean isCert_cus() {
        return cert_cus;
    }

    public void setCert_cus(boolean cert_cus) {
        this.cert_cus = cert_cus;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public List<OrderDetail> getOrder_detail() {
        return order_detail;
    }
    public void setOrder_detail(List<OrderDetail> order_detail) {
        this.order_detail = order_detail;
    }
}

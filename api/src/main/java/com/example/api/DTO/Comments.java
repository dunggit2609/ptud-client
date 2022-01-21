package com.example.api.DTO;

import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
public class Comments {
    private String customername;
    private String customeravatar;
    private String customercmt;
    private String customerrating;
    private Date date;
    private String review_id;
    private Long id;

    public Comments(String customername, String customeravatar, String customercmt, String customerrating, Date date, String review_id) {
        this.customername = customername;
        this.customeravatar = customeravatar;
        this.customercmt = customercmt;
        this.customerrating = customerrating;
        this.date = date;
        this.review_id = review_id;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCustomeravatar() {
        return customeravatar;
    }

    public void setCustomeravatar(String customeravatar) {
        this.customeravatar = customeravatar;
    }

    public String getCustomercmt() {
        return customercmt;
    }

    public void setCustomercmt(String customercmt) {
        this.customercmt = customercmt;
    }

    public String getCustomerrating() {
        return customerrating;
    }

    public void setCustomerrating(String customerrating) {
        this.customerrating = customerrating;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReview_id() {
        return review_id;
    }

    public void setReview_id(String review_id) {
        this.review_id = review_id;
    }

}

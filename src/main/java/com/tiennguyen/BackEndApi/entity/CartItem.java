package com.tiennguyen.BackEndApi.entity;

import com.tiennguyen.BackEndApi.entity.keys.KeyCartItem;
import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "cart_item")
public class CartItem {
    @EmbeddedId
    KeyCartItem keys;

    @ManyToOne
    @JoinColumn(name="session_id",insertable = false,updatable = false)
    private UserSession userSession;

    @ManyToOne
    @JoinColumn(name = "product_id",insertable = false,updatable = false)
    private Products products;

    @Column(name = "quantity")
    private int quantity;
    @Column(name="create_date")
    private Date createDate;

    public KeyCartItem getKeys() {
        return keys;
    }

    public void setKeys(KeyCartItem keys) {
        this.keys = keys;
    }

    public UserSession getUserSession() {
        return userSession;
    }

    public void setUserSession(UserSession userSession) {
        this.userSession = userSession;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}

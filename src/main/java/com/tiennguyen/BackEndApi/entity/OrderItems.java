package com.tiennguyen.BackEndApi.entity;

import com.tiennguyen.BackEndApi.entity.keys.KeyOrderItems;
import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "order_items")
public class OrderItems {
    @EmbeddedId
    KeyOrderItems keys;

    @ManyToOne
    @JoinColumn(name = "order_id",insertable = false,updatable = false)
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "product_id",insertable = false,updatable = false)
    private Products products;

    @Column(name = "quantity")
    private int quantity;
    @Column(name="create_date")
    private Date createDate;

    public KeyOrderItems getKeys() {
        return keys;
    }

    public void setKeys(KeyOrderItems keys) {
        this.keys = keys;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
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

package com.tiennguyen.BackEndApi.entity.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class KeyOrderItems implements Serializable {
    @Column(name = "order_id")
    private int orderId;
    @Column(name = "product_id")
    private int productId;
    public KeyOrderItems(){}
    public KeyOrderItems(int orderId, int productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}

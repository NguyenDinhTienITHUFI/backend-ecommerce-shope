package com.tiennguyen.BackEndApi.entity.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class KeyCartItem implements Serializable {
    @Column(name = "session_id")
    private int sessionId;
    @Column(name = "product_id")
    private int productId;
    public KeyCartItem(){}
    public KeyCartItem(int sessionId, int productId) {
        this.sessionId = sessionId;
        this.productId = productId;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}

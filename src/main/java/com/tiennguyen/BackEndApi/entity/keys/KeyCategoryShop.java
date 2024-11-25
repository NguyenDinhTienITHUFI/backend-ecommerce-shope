package com.tiennguyen.BackEndApi.entity.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class KeyCategoryShop implements Serializable {
    @Column(name = "cate_id")
    private int cateId;
    @Column(name = "shop_id")
    private int shopId;
    public KeyCategoryShop(){}

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public KeyCategoryShop(int cateId, int shopId) {
        this.cateId = cateId;
        this.shopId = shopId;
    }
}

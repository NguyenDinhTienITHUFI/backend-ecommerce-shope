package com.tiennguyen.BackEndApi.entity;

import com.tiennguyen.BackEndApi.entity.keys.KeyCategoryShop;
import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "cate_shop")
public class CategoryShop {
    @EmbeddedId
    KeyCategoryShop keys;

    @ManyToOne
    @JoinColumn(name = "cate_id",insertable = false,updatable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "shop_id",insertable = false,updatable = false)
    private Shop shop;

    @Column(name="create_date")
    private Date createDate;

    public KeyCategoryShop getKeys() {
        return keys;
    }

    public void setKeys(KeyCategoryShop keys) {
        this.keys = keys;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}

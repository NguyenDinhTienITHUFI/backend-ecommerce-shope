package com.tiennguyen.BackEndApi.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity(name = "shop")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="title")
    private String title;
    @Column(name="description")
    private String description;
    @Column(name="address")
    private String address;
    @Column(name="image")
    private String image;

    @OneToMany(mappedBy = "shop")
    private Set<CategoryShop> listCategoryShop;

    public Set<CategoryShop> getListCategoryShop() {
        return listCategoryShop;
    }

    public void setListCategoryShop(Set<CategoryShop> listCategoryShop) {
        this.listCategoryShop = listCategoryShop;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Column(name="create_date")
    private Date createDate;
}

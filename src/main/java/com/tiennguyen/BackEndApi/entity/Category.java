package com.tiennguyen.BackEndApi.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_cate")
    private String nameCate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCate() {
        return nameCate;
    }

    public void setNameCate(String nameCate) {
        this.nameCate = nameCate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Column(name="create_date")
    private Date createDate;
    @OneToMany(mappedBy = "category")
    private Set<Products> listProduct;

    public Set<CategoryShop> getListCategoryShop() {
        return listCategoryShop;
    }

    public void setListCategoryShop(Set<CategoryShop> listCategoryShop) {
        this.listCategoryShop = listCategoryShop;
    }

    @OneToMany(mappedBy = "category")
    private Set<CategoryShop> listCategoryShop;
    public Set<Products> getListProduct() {
        return listProduct;
    }

    public void setListProduct(Set<Products> listProduct) {
        this.listProduct = listProduct;
    }


}

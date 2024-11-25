package com.tiennguyen.BackEndApi.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;
    @Column(name = "stock")
    private int stock;
    @Column(name = "brand")
    private String brand;
    @Column(name="description",length = 30000)
    private String description;
    @Column(name="image")
    private String image;
    @Column(name = "price")
    private double price;
    @Column(name="create_date")
    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "cate_id")
    private Category category;

    @OneToMany(mappedBy = "products")
    private Set<Rating> listRating;
    @OneToMany(mappedBy = "products")
    private Set<CartItem> liCartItems;

    public Set<CartItem> getLiCartItems() {
        return liCartItems;
    }

    public void setLiCartItems(Set<CartItem> liCartItems) {
        this.liCartItems = liCartItems;
    }

    @OneToMany(mappedBy = "products")
    private Set<OrderItems> listOrderItems;

    public Set<OrderItems> getListOrderItems() {
        return listOrderItems;
    }

    public void setListOrderItems(Set<OrderItems> listOrderItems) {
        this.listOrderItems = listOrderItems;
    }

    public Set<Rating> getListRating() {
        return listRating;
    }

    public void setListRating(Set<Rating> listRating) {
        this.listRating = listRating;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

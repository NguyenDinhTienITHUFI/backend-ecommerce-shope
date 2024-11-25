package com.tiennguyen.BackEndApi.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity(name = "user_session")
public class UserSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "total")
    private double total;
    @Column(name="create_date")
    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @OneToMany(mappedBy = "userSession")
    private Set<CartItem> listCartItems;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Set<CartItem> getListCartItems() {
        return listCartItems;
    }

    public void setListCartItems(Set<CartItem> listCartItems) {
        this.listCartItems = listCartItems;
    }
}

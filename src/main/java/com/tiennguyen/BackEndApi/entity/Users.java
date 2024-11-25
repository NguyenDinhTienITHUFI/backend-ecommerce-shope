package com.tiennguyen.BackEndApi.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="user_name")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="fullname")
    private String fullname;

    @OneToMany(mappedBy = "users")
    private Set<Rating> listRating;
    @OneToMany(mappedBy = "users")
    private Set<Orders> listOrders;

    public Set<UserSession> getListUserSessions() {
        return listUserSessions;
    }

    public void setListUserSessions(Set<UserSession> listUserSessions) {
        this.listUserSessions = listUserSessions;
    }

    @OneToMany(mappedBy = "users")
    private Set<UserSession> listUserSessions;
    public Set<Orders> getListOrders() {
        return listOrders;
    }

    public void setListOrders(Set<Orders> listOrders) {
        this.listOrders = listOrders;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    @Column(name="create_date")
    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles roles;
}

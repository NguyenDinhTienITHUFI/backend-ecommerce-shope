package com.tiennguyen.BackEndApi.DTO;

import com.tiennguyen.BackEndApi.entity.Users;

import java.util.Date;

public class UserSessionDTO {
    private int id;
    private double total;
    private Date createDate;

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

    private Users users;
}

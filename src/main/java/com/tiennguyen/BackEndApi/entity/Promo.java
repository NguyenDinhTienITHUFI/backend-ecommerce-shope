package com.tiennguyen.BackEndApi.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity(name = "promo")
public class Promo {
    @Id
    @Column(name = "id", length = 30)
    private String id;
    @Column(name = "title")
    private String title;
    @Column(name = "percent")
    private int percent;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @Column(name="create_date")
    private Date createDate;

    @OneToMany(mappedBy = "promo")
    private Set<Orders> lisOrders;

    public Set<Orders> getLisOrders() {
        return lisOrders;
    }

    public void setLisOrders(Set<Orders> lisOrders) {
        this.lisOrders = lisOrders;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}

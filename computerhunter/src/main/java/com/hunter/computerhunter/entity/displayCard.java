package com.hunter.computerhunter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class displayCard {
    @Column(length = 20)
    @Id
    private String dModel;

    @Column(length = 7)
    private String dPrice;
    @Column(length = 100)
    private String dParameter;
    @Column(length = 2000)
    private String dRecommend;
    @Column(length = 5)
    private String dWeight;

    public String getdModel() {
        return dModel;
    }

    public void setdModel(String dModel) {
        this.dModel = dModel;
    }

    public String getdPrice() {
        return dPrice;
    }

    public void setdPrice(String dPrice) {
        this.dPrice = dPrice;
    }

    public String getdParameter() {
        return dParameter;
    }

    public void setdParameter(String dParameter) {
        this.dParameter = dParameter;
    }

    public String getdRecommend() {
        return dRecommend;
    }

    public void setdRecommend(String dRecommend) {
        this.dRecommend = dRecommend;
    }

    public String getdWeight() {
        return dWeight;
    }

    public void setdWeight(String dWeight) {
        this.dWeight = dWeight;
    }
}

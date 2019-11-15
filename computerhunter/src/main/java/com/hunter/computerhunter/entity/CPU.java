package com.hunter.computerhunter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

public class CPU {

    @Column(length = 20)
    @Id
    private String cModel;

    @Column(length = 7)
    private String cPrice;
    @Column(length = 100)
    private String cParameter;
    @Column(length = 2000)
    private String cRecommend;
    @Column(length = 5)
    private String cWeight;

    public String getcModel() {
        return cModel;
    }

    public void setcModel(String cModel) {
        this.cModel = cModel;
    }

    public String getcPrice() {
        return cPrice;
    }

    public void setcPrice(String cPrice) {
        this.cPrice = cPrice;
    }

    public String getcParameter() {
        return cParameter;
    }

    public void setcParameter(String cParameter) {
        this.cParameter = cParameter;
    }

    public String getcRecommend() {
        return cRecommend;
    }

    public void setcRecommend(String cRecommend) {
        this.cRecommend = cRecommend;
    }

    public String getcWeight() {
        return cWeight;
    }

    public void setcWeight(String cWeight) {
        this.cWeight = cWeight;
    }
}

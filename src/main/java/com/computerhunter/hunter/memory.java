package com.computerhunter.hunter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class memory {
    @Column(length = 20)
    @Id
    private String mModel;

    @Column(length = 7)
    private String mPrice;
    @Column(length = 100)
    private String mParameter;
    @Column(length = 2000)
    private String mRecommend;
    @Column(length = 5)
    private String mWeight;

    public String getmModel() {
        return mModel;
    }

    public void setmModel(String mModel) {
        this.mModel = mModel;
    }

    public String getmPrice() {
        return mPrice;
    }

    public void setmPrice(String mPrice) {
        this.mPrice = mPrice;
    }

    public String getmParameter() {
        return mParameter;
    }

    public void setmParameter(String mParameter) {
        this.mParameter = mParameter;
    }

    public String getmRecommend() {
        return mRecommend;
    }

    public void setmRecommend(String mRecommend) {
        this.mRecommend = mRecommend;
    }

    public String getmWeight() {
        return mWeight;
    }

    public void setmWeight(String mWeight) {
        this.mWeight = mWeight;
    }
}

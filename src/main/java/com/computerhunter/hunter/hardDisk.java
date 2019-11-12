package com.computerhunter.hunter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class hardDisk {
    @Column(length = 20)
    @Id
    private String hModel;

    @Column(length = 7)
    private String hPrice;
    @Column(length = 100)
    private String hParameter;
    @Column(length = 2000)
    private String hRecommend;
    @Column(length = 5)
    private String hWeight;

    public String gethModel() {
        return hModel;
    }

    public void sethModel(String hModel) {
        this.hModel = hModel;
    }

    public String gethPrice() {
        return hPrice;
    }

    public void sethPrice(String hPrice) {
        this.hPrice = hPrice;
    }

    public String gethParameter() {
        return hParameter;
    }

    public void sethParameter(String hParameter) {
        this.hParameter = hParameter;
    }

    public String gethRecommend() {
        return hRecommend;
    }

    public void sethRecommend(String hRecommend) {
        this.hRecommend = hRecommend;
    }

    public String gethWeight() {
        return hWeight;
    }

    public void sethWeight(String hWeight) {
        this.hWeight = hWeight;
    }
}

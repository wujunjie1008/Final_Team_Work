package com.test.test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.awt.print.PrinterGraphics;
import java.math.BigDecimal;
@Entity
public class Luckymoney {
    @Id
    @GeneratedValue
    private Integer id;
    private BigDecimal moeny;
    private String producer;  //发送
    private String consumer;  //接受

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMoeny() {
        return moeny;
    }

    public void setMoeny(BigDecimal moeny) {
        this.moeny = moeny;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    public Luckymoney(){

    }
}

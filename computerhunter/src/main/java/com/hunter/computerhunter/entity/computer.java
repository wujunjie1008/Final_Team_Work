package com.hunter.computerhunter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class computer{
    @Id
    private String model;
    //@Column(name = "brand",nullable = false)
    private String brand;
    private int price;
    private int cpuWeight;
    private String cpuName;
    private int displayCardWeight;
    private String displayCardName;
    private int hardDiskWeight;
    private String hardDiskName;
    private int memoryWeight;
    private String memoryName;
    private String characterOne;
    private String characterTwo;
    private String characterThree;
    private String buyUrl1;

    private String buyUrl2;
    private String buyUrl3;
    private String computerExplain;
    private int sumWeight;

    public int getSumWeight() {
        return sumWeight;
    }

    public void setSumWeight(int sumWeight) {
        this.sumWeight = sumWeight;
    }
    public String getCpuName() {
        return cpuName;
    }

    public void setCpuName(String cpuName) {
        this.cpuName = cpuName;
    }

    public String getDisplayCardName() {
        return displayCardName;
    }

    public void setDisplayCardName(String displayCardName) {
        this.displayCardName = displayCardName;
    }

    public String getHardDiskName() {
        return hardDiskName;
    }

    public void setHardDiskName(String hardDiskName) {
        this.hardDiskName = hardDiskName;
    }

    public String getMemoryName() {
        return memoryName;
    }

    public void setMemoryName(String memoryName) {
        this.memoryName = memoryName;
    }

    public String getComputerExplain() {
        return computerExplain;
    }

    public void setComputerExplain(String computerExplain) {
        this.computerExplain = computerExplain;
    }

    public String getCharacterOne() {
        return characterOne;
    }

    public void setCharacterOne(String characterOne) {
        this.characterOne = characterOne;
    }

    public String getCharacterTwo() {
        return characterTwo;
    }

    public void setCharacterTwo(String characterTwo) {
        this.characterTwo = characterTwo;
    }

    public String getCharacterThree() {
        return characterThree;
    }

    public void setCharacterThree(String characterThree) {
        this.characterThree = characterThree;
    }

    public String getBuyUrl1() {
        return buyUrl1;
    }

    public void setBuyUrl1(String buyUrl1) {
        this.buyUrl1 = buyUrl1;
    }

    public String getBuyUrl2() {
        return buyUrl2;
    }

    public void setBuyUrl2(String buyUrl2) {
        this.buyUrl2 = buyUrl2;
    }

    public String getBuyUrl3() {
        return buyUrl3;
    }

    public void setBuyUrl3(String buyUrl3) {
        this.buyUrl3 = buyUrl3;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCpuWeight() {
        return cpuWeight;
    }

    public void setCpuWeight(int cpuWeight) {
        this.cpuWeight = cpuWeight;
    }

    public int getDisplayCardWeight() {
        return displayCardWeight;
    }

    public void setDisplayCardWeight(int displayCardWeight) {
        this.displayCardWeight = displayCardWeight;
    }

    public int getHardDiskWeight() {
        return hardDiskWeight;
    }

    public void setHardDiskWeight(int hardDiskWeight) {
        this.hardDiskWeight = hardDiskWeight;
    }

    public int getMemoryWeight() {
        return memoryWeight;
    }

    public void setMemoryWeight(int memoryWeight) {
        this.memoryWeight = memoryWeight;
    }


}

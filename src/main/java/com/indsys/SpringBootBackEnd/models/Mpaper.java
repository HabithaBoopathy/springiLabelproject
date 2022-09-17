package com.indsys.SpringBootBackEnd.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "MPaper")
public class Mpaper {

    @Id
    private String id;

    private String name;
    private double gsm;
    private double productLength;
    private double productWidth;
    private double rate;
    private double ratePerBoard;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGsm() {
        return gsm;
    }

    public void setGsm(double gsm) {
        this.gsm = gsm;
    }

    public double getProductLength() {
        return productLength;
    }

    public void setProductLength(double productLength) {
        this.productLength = productLength;
    }

    public double getProductWidth() {
        return productWidth;
    }

    public void setProductWidth(double productWidth) {
        this.productWidth = productWidth;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getRatePerBoard() {
        return ratePerBoard;
    }

    public void setRatePerBoard(double ratePerBoard) {
        this.ratePerBoard = ratePerBoard;
    }
}

package com.indsys.SpringBootBackEnd.v2.costingNew.models;

public class SlabRates {
    private String quantitySlab;
    private Double price;

    public String getQuantitySlab() {
        return quantitySlab;
    }

    public void setQuantitySlab(String quantitySlab) {
        this.quantitySlab = quantitySlab;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

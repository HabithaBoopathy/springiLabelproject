package com.indsys.SpringBootBackEnd.models;

public class QuotationBatch {

    private String itemAndDescription;
    private String hsn;
    private String quantity;
    private String rate;

    public String getItemAndDescription() {
        return itemAndDescription;
    }

    public void setItemAndDescription(String itemAndDescription) {
        this.itemAndDescription = itemAndDescription;
    }

    public String getHsn() {
        return hsn;
    }

    public void setHsn(String hsn) {
        this.hsn = hsn;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
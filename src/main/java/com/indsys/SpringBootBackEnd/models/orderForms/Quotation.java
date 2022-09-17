package com.indsys.SpringBootBackEnd.models.orderForms;

import org.springframework.data.annotation.Id;

public class Quotation {

    @Id
    private String id;
    
    private String itemDescription;
	private String hsn;
	private String quantityRange;
	private String rate;
	private String termsAndConditions;

    public Quotation(String id, String itemDescription, String hsn, String quantityRange, String rate,
            String termsAndConditions) {
        this.id = id;
        this.itemDescription = itemDescription;
        this.hsn = hsn;
        this.quantityRange = quantityRange;
        this.rate = rate;
        this.termsAndConditions = termsAndConditions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getHsn() {
        return hsn;
    }

    public void setHsn(String hsn) {
        this.hsn = hsn;
    }

    public String getQuantityRange() {
        return quantityRange;
    }

    public void setQuantityRange(String quantityRange) {
        this.quantityRange = quantityRange;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getTermsAndConditions() {
        return termsAndConditions;
    }

    public void setTermsAndConditions(String termsAndConditions) {
        this.termsAndConditions = termsAndConditions;
    }

    @Override
    public String toString() {
        return "Quotation [hsn=" + hsn + ", id=" + id + ", itemDescription=" + itemDescription + ", quantityRange="
                + quantityRange + ", rate=" + rate + ", termsAndConditions=" + termsAndConditions + "]";
    }
}

package com.indsys.SpringBootBackEnd.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "QuotationReference")
public class QuotationReference {

    @Id
    private String id;

    private String trimType;
    private String quotationReferenceNumber;
    private String refNumber;
    private String nextRefNumber;

    public QuotationReference(String id, String trimType, String quotationReferenceNumber, String refNumber,
            String nextRefNumber) {
        this.id = id;
        this.trimType = trimType;
        this.quotationReferenceNumber = quotationReferenceNumber;
        this.refNumber = refNumber;
        this.nextRefNumber = nextRefNumber;
    }

    @Override
    public String toString() {
        return "QuotationReference [id=" + id + ", nextRefNumber=" + nextRefNumber + ", quotationReferenceNumber="
                + quotationReferenceNumber + ", refNumber=" + refNumber + ", trimType=" + trimType + "]";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTrimType() {
        return trimType;
    }

    public void setTrimType(String trimType) {
        this.trimType = trimType;
    }

    public String getQuotationReferenceNumber() {
        return quotationReferenceNumber;
    }

    public void setQuotationReferenceNumber(String quotationReferenceNumber) {
        this.quotationReferenceNumber = quotationReferenceNumber;
    }

    public String getRefNumber() {
        return refNumber;
    }

    public void setRefNumber(String refNumber) {
        this.refNumber = refNumber;
    }

    public String getNextRefNumber() {
        return nextRefNumber;
    }

    public void setNextRefNumber(String nextRefNumber) {
        this.nextRefNumber = nextRefNumber;
    }
    
}

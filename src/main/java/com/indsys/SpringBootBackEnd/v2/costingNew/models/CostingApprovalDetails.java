package com.indsys.SpringBootBackEnd.v2.costingNew.models;

public class CostingApprovalDetails {
    private String entryDate;
    private String trimType;
    private String refNo;
    private String productName;
    private String customerName;
    private String productLength;
    private String productWidth;
    private String paymentTerms;
    private String approvalLink;
    private SlabRates[] slabRates;

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getTrimType() {
        return trimType;
    }

    public void setTrimType(String trimType) {
        this.trimType = trimType;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductLength() {
        return productLength;
    }

    public void setProductLength(String productLength) {
        this.productLength = productLength;
    }

    public String getProductWidth() {
        return productWidth;
    }

    public void setProductWidth(String productWidth) {
        this.productWidth = productWidth;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public String getApprovalLink() {
        return approvalLink;
    }

    public void setApprovalLink(String approvalLink) {
        this.approvalLink = approvalLink;
    }

    public SlabRates[] getSlabRates() {
        return slabRates;
    }

    public void setSlabRates(SlabRates[] slabRates) {
        this.slabRates = slabRates;
    }
}

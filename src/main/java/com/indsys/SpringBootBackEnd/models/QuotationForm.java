package com.indsys.SpringBootBackEnd.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "QuotationForm")
public class QuotationForm {

    // ID
    @Id
    private String id;

    // Customer Details
    private String customerID;
    private String customerName;
    private String customerStreet1;
    private String customerStreet2;
    private String customerCity;
    private String customerState;
    private String customerGst;
    private String customerEmail;

    //Quotation Reference Number
    @Indexed(unique = true)
    private String quotationReferenceNumber;

    // Quotation Upload
    private String quotationUpload;

    // Common
    private String date;

    //Trim Type
    private String trimType;

    //Array
    private QuotationBatch[] lineitem;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerStreet1() {
        return customerStreet1;
    }

    public void setCustomerStreet1(String customerStreet1) {
        this.customerStreet1 = customerStreet1;
    }

    public String getCustomerStreet2() {
        return customerStreet2;
    }

    public void setCustomerStreet2(String customerStreet2) {
        this.customerStreet2 = customerStreet2;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCustomerState() {
        return customerState;
    }

    public void setCustomerState(String customerState) {
        this.customerState = customerState;
    }

    public String getCustomerGst() {
        return customerGst;
    }

    public void setCustomerGst(String customerGst) {
        this.customerGst = customerGst;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getQuotationReferenceNumber() {
        return quotationReferenceNumber;
    }

    public void setQuotationReferenceNumber(String quotationReferenceNumber) {
        this.quotationReferenceNumber = quotationReferenceNumber;
    }

    public String getQuotationUpload() {
        return quotationUpload;
    }

    public void setQuotationUpload(String quotationUpload) {
        this.quotationUpload = quotationUpload;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTrimType() {
        return trimType;
    }

    public void setTrimType(String trimType) {
        this.trimType = trimType;
    }

    public QuotationBatch[] getLineitem() {
        return lineitem;
    }

    public void setLineitem(QuotationBatch[] lineitem) {
        this.lineitem = lineitem;
    }

   
}
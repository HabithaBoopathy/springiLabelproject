package com.indsys.SpringBootBackEnd.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "MCustomer")
public class Employee {

    @Id
    private String id;
    private String customername;
    private String companyname;
    private String emailId;
    private String alternateemailId;
    private String phone;
    private String website;
    private String radio;
    private String street1;
    private String street2;
    private String city;
    private String zipcode;
    private String state;
    private String country;
    private String customerreference;
    private Number customernum;
    private String paymentTerms;
    private String shipmentTerms;
    private String gstin;
    private String executiveName;
    private String executiveCode;
    private String verificationStatus;
    private Boolean isOk;
    private Boolean customerEmail;
//    private String merchandiser;
    private String territory;
    private String companyId;
    private int isDisabled;

    private String customerCategory;

    public String getCustomerCategory() {
        return customerCategory;
    }

    public void setCustomerCategory(String customerCategory) {
        this.customerCategory = customerCategory;
    }
    //    public Employee(String id, String customername, String companyname, String emailId, String alternateemailId,
//            String phone, String website, String radio, String street1, String street2, String city, String zipcode,
//            String state, String country, String customerreference, Number customernum, String paymentTerms,
//            String shipmentTerms, String gstin, String executiveName, String executiveCode, String verificationStatus,
//            Boolean isOk, Boolean customerEmail, String territory, String companyId, int isDisabled) {
//        this.id = id;
//        this.customername = customername;
//        this.companyname = companyname;
//        this.emailId = emailId;
//        this.alternateemailId = alternateemailId;
//        this.phone = phone;
//        this.website = website;
//        this.radio = radio;
//        this.street1 = street1;
//        this.street2 = street2;
//        this.city = city;
//        this.zipcode = zipcode;
//        this.state = state;
//        this.country = country;
//        this.customerreference = customerreference;
//        this.customernum = customernum;
//        this.paymentTerms = paymentTerms;
//        this.shipmentTerms = shipmentTerms;
//        this.gstin = gstin;
//        this.executiveName = executiveName;
//        this.executiveCode = executiveCode;
//        this.verificationStatus = verificationStatus;
//        this.isOk = isOk;
//        this.customerEmail = customerEmail;
////        this.merchandiser = merchandiser;
//        this.territory = territory;
//        this.companyId = companyId;
//        this.isDisabled = isDisabled;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAlternateemailId() {
        return alternateemailId;
    }

    public void setAlternateemailId(String alternateemailId) {
        this.alternateemailId = alternateemailId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getRadio() {
        return radio;
    }

    public void setRadio(String radio) {
        this.radio = radio;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCustomerreference() {
        return customerreference;
    }

    public void setCustomerreference(String customerreference) {
        this.customerreference = customerreference;
    }

    public Number getCustomernum() {
        return customernum;
    }

    public void setCustomernum(Number customernum) {
        this.customernum = customernum;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public String getShipmentTerms() {
        return shipmentTerms;
    }

    public void setShipmentTerms(String shipmentTerms) {
        this.shipmentTerms = shipmentTerms;
    }

    public String getGstin() {
        return gstin;
    }

    public void setGstin(String gstin) {
        this.gstin = gstin;
    }

    public String getExecutiveName() {
        return executiveName;
    }

    public void setExecutiveName(String executiveName) {
        this.executiveName = executiveName;
    }

    public String getExecutiveCode() {
        return executiveCode;
    }

    public void setExecutiveCode(String executiveCode) {
        this.executiveCode = executiveCode;
    }

    public String getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(String verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public Boolean getIsOk() {
        return isOk;
    }

    public void setIsOk(Boolean isOk) {
        this.isOk = isOk;
    }

    public Boolean getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(Boolean customerEmail) {
        this.customerEmail = customerEmail;
    }

//    public String getMerchandiser() {
//        return merchandiser;
//    }

//    public void setMerchandiser(String merchandiser) {
//        this.merchandiser = merchandiser;
//    }

    public String getTerritory() {
        return territory;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public int getIsDisabled() {
        return isDisabled;
    }

    public void setIsDisabled(int isDisabled) {
        this.isDisabled = isDisabled;
    }
}
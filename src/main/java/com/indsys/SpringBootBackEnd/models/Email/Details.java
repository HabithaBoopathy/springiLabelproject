package com.indsys.SpringBootBackEnd.models.Email;

import com.indsys.SpringBootBackEnd.configurations.RootPath;

public class Details {

    private String executiveCode;
    private String customerName;
    private String sampleRequestNumber;
    private String quotationReferenceNumber;
    private String pageURL;
    public String email;
    private String attachments;
    private String attachment1;
    private String attachment2;
    private String attachment3;

    //Quotation Attachment
    private String quotationAttachmentName;

    public String getExecutiveCode() {
        return executiveCode;
    }

    public void setExecutiveCode(String executiveCode) {
        this.executiveCode = executiveCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSampleRequestNumber() {
        return sampleRequestNumber;
    }

    public void setSampleRequestNumber(String sampleRequestNumber) {
        this.sampleRequestNumber = sampleRequestNumber;
    }

    public String getPageURL() {
        return pageURL;
    }

    public void setPageURL(String pageURL) {
        this.pageURL = pageURL;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // One
    public String getAttachment1Local() {

        //Local
        return "C:/Users/Holdings-Software/Downloads/Coding/Projects/iLabel/SpringBootBackEnd/uploads/" + attachment1;

    }

    public String getAttachment1Server() {

        //Server
        return "C:/Users/Holdings-Software/Downloads/Coding/Projects/iLabel/SpringBootBackEnd/uploads/" + attachment1;

    }

    public String getQuotationAttachmentServer(String localPath) {

        return RootPath.rootPath + localPath;

    }

    public String getQuotationAttachmentServerForQuotationForm(String localPath) {
        return RootPath.rootPath + localPath;
    }

    public String attachmentName1() {
        return attachment1;
    }

    public void setAttachment1(String attachment1) {
        this.attachment1 = attachment1;
    }

    //Two
    public String getAttachment2Local() {

        //Local
        // return "C:/Users/Holdings-Software/Downloads/Coding/Projects/iLabel/SpringBootBackEnd/uploads/" + attachment2;

        //Server
        return "C:/Users/Holdings-Software/Downloads/Coding/Projects/iLabel/SpringBootBackEnd/uploads/" + attachment2;

    }

    public String getAttachment2Server() {

        //Server
        return "C:/Users/Holdings-Software/Downloads/Coding/Projects/iLabel/SpringBootBackEnd/uploads/" + attachment2;

    }

    public String attachmentName2() {
        return attachment2;
    }

    public void setAttachment2(String attachment2) {
        this.attachment2 = attachment2;
    }


    //Three
    public String getAttachment3Local() {

        //Local
        return "C:/Users/Holdings-Software/Downloads/Coding/Projects/iLabel/SpringBootBackEnd/uploads/" + attachment3;

        //Server
        // return "C:/Users/Holdings-Software/Downloads/Coding/Projects/iLabel/SpringBootBackEnd/uploads/" + attachment3;

    }

    public String getAttachment3Server() {

        //Server
        return "C:/Users/Holdings-Software/Downloads/Coding/Projects/iLabel/SpringBootBackEnd/uploads/" + attachment3;

    }

    public String attachmentName3() {
        return attachment3;
    }

    public void setAttachment3(String attachment3) {
        this.attachment3 = attachment3;
    }

    public Details(String executiveCode, String customerName, String sampleRequestNumber, String pageURL, String email,
                   String attachments, String attachment1, String attachment2, String attachment3) {
        this.executiveCode = executiveCode;
        this.customerName = customerName;
        this.sampleRequestNumber = sampleRequestNumber;
        this.pageURL = pageURL;
        this.email = email;
        this.attachments = attachments;
        this.attachment1 = attachment1;
        this.attachment2 = attachment2;
        this.attachment3 = attachment3;
    }

    @Override
    public String toString() {
        return "Details [attachment1=" + attachment1 + ", attachment2=" + attachment2 + ", attachment3=" + attachment3
                + ", attachments=" + attachments + ", customerName=" + customerName + ", email=" + email
                + ", executiveCode=" + executiveCode + ", pageURL=" + pageURL + ", quotationAttachmentName="
                + quotationAttachmentName + ", sampleRequestNumber=" + sampleRequestNumber + "]";
    }

    public Details(String quotationAttachmentName) {
        this.quotationAttachmentName = quotationAttachmentName;
    }

    public String getQuotationAttachmentName() {
        return quotationAttachmentName;
    }

    public void setQuotationAttachmentName(String quotationAttachmentName) {
        this.quotationAttachmentName = quotationAttachmentName;
    }

    public String getQuotationReferenceNumber() {
        return quotationReferenceNumber;
    }

    public void setQuotationReferenceNumber(String quotationReferenceNumber) {
        this.quotationReferenceNumber = quotationReferenceNumber;
    }

}

/*

        //Server AWS
//        return "/code/SpringBootBackEnd/uploads/" + "Quotation-" + sampleRequestNumber + ".pdf";

        //lightsail
//        return "/home/ubuntu/ilabel/uploads/" + "Quotation-" + sampleRequestNumber + ".pdf";

        //Testing Server
//         return "/home/Projects/SpringBootBackEnd/uploads/" + "Quotation-" + sampleRequestNumber + ".pdf";

        // Kannan Local
//          return "E:/spring-boot/SpringBootBackEnd/uploads/" + "Quotation-" + sampleRequestNumber + ".pdf";

        // Sanjay Local
        // return "D:/Indsys/Project - ILabel/SpringBootBackEnd/uploads/" + "Quotation-" + sampleRequestNumber + ".pdf";

        // Local - SH
        // return "C:/Users/Holdings-Software/Downloads/Coding/Projects/iLabel/SpringBootBackEnd/uploads/" + sampleRequestNumber + ".pdf";
*/
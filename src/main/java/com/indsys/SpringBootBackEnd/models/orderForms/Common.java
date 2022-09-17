package com.indsys.SpringBootBackEnd.models.orderForms;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "CommonOrderForm")
public class Common {

    @Id
    private String cid;

    private String date;
    private String oldRefNo;
    private String name;
    private String sampleName;
    private String contactPerson;
    private String phone;
    private String email;
    private String refNo;
    private String execName;

    @Override
    public String toString() {
        return "Common [cid=" + cid + ", contactPerson=" + contactPerson + ", date=" + date + ", email=" + email
                + ", execName=" + execName + ", name=" + name + ", oldRefNo=" + oldRefNo + ", phone=" + phone
                + ", refNo=" + refNo + ", sampleName=" + sampleName + "]";
    }

    public Common(String cid, String date, String oldRefNo, String name, String sampleName, String contactPerson,
            String phone, String email, String refNo, String execName) {
        this.cid = cid;
        this.date = date;
        this.oldRefNo = oldRefNo;
        this.name = name;
        this.sampleName = sampleName;
        this.contactPerson = contactPerson;
        this.phone = phone;
        this.email = email;
        this.refNo = refNo;
        this.execName = execName;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOldRefNo() {
        return oldRefNo;
    }

    public void setOldRefNo(String oldRefNo) {
        this.oldRefNo = oldRefNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSampleName() {
        return sampleName;
    }

    public void setSampleName(String sampleName) {
        this.sampleName = sampleName;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public String getExecName() {
        return execName;
    }

    public void setExecName(String execName) {
        this.execName = execName;
    }

   
    
}

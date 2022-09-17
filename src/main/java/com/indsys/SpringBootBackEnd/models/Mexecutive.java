package com.indsys.SpringBootBackEnd.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "MExecutive")
public class Mexecutive {
    
    @Id
    private String id;

    private String name;
    private String emailId;
    private String code;
    private String phoneNumber;
    private List<String> territories;

    public Mexecutive(String id, String name, String emailId, String code, String phoneNumber, List<String> territories) {
        this.id = id;
        this.name = name;
        this.emailId = emailId;
        this.code = code;
        this.phoneNumber = phoneNumber;
        this.territories = territories;
    }

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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Mexecutive [code=" + code + ", emailId=" + emailId + ", id=" + id + ", name=" + name + ", phoneNumber="
                + phoneNumber + "]";
    }

    public List<String> getTerritories() {
        return territories;
    }

    public void setTerritories(List<String> list) {
        this.territories = list;
    }
}

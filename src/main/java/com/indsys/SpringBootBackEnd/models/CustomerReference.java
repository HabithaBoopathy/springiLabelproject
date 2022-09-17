package com.indsys.SpringBootBackEnd.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "CustomerReference")
public class CustomerReference {

    @Id
    private String id;

    private String customername;
    private String customernum;
    private String customerreference;

    public CustomerReference(String id, String customername, String customernum, String customerreference) {
        this.id = id;
        this.customername = customername;
        this.customernum = customernum;
        this.customerreference = customerreference;
    }

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

    public String getCustomernum() {
        return customernum;
    }

    public void setCustomernum(String customernum) {
        this.customernum = customernum;
    }

    public String getCustomerreference() {
        return customerreference;
    }

    public void setCustomerreference(String customerreference) {
        this.customerreference = customerreference;
    }

    @Override
    public String toString() {
        return "CustomerReference [customername=" + customername + ", customernum=" + customernum
                + ", customerreference=" + customerreference + ", id=" + id + "]";
    }
    
	}

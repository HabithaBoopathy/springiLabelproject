 package com.indsys.SpringBootBackEnd.v2.costingNew.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("MCommonDetailsCosting")
public class CommonDetailsCosting {

    @Id
    private String id;
    private String totalDetailsId;
    private String refNo;
    private String entryDate;
    private String productName;
    private String customerId;
    private String customerName;
    private double orderQuantity;
    private String trimType;
    private int status;
    private boolean archived;
    private String executiveId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTotalDetailsId() {
        return totalDetailsId;
    }

    public void setTotalDetailsId(String totalDetailsId) {
        this.totalDetailsId = totalDetailsId;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTrimType() {
        return trimType;
    }

    public void setTrimType(String trimType) {
        this.trimType = trimType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public String getExecutiveId() {
        return executiveId;
    }

    public void setExecutiveId(String executiveId) {
        this.executiveId = executiveId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(double orderQuantity) {
        this.orderQuantity = orderQuantity;
    }
}

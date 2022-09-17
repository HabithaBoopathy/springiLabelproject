package com.indsys.SpringBootBackEnd.models.orderForms;

public class PaginationInput {
    String[] trimType, transactionStatus, territoryId;
    String sort;
    int page, size;
    String executiveCode;
    String customerEmail;
    String status;
    GlobalSearchInput globalSearchInput;

    public String[] getTrimType() {
        return trimType;
    }

    public void setTrimType(String[] trimType) {
        this.trimType = trimType;
    }

    public String[] getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String[] transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String[] getTerritoryId() {
        return territoryId;
    }

    public void setTerritoryId(String territoryId[]) {
        this.territoryId = territoryId;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getExecutiveCode() {
        return executiveCode;
    }

    public void setExecutiveCode(String executiveCode) {
        this.executiveCode = executiveCode;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public GlobalSearchInput getGlobalSearchInput() {
        return globalSearchInput;
    }

    public void setGlobalSearchInput(GlobalSearchInput globalSearchInput) {
        this.globalSearchInput = globalSearchInput;
    }
}

package com.indsys.SpringBootBackEnd.models.report;

public class Report {

    private String startDate;
    private String endDate;
    private String[] trimType;
    private String[] transactionStatus;
    private String[] territory;
    private int sort;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

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

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String[] getTerritory() {
        return territory;
    }

    public void setTerritory(String[] territory) {
        this.territory = territory;
    }
}

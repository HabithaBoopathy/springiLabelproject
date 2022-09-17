package com.indsys.SpringBootBackEnd.v2.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("MWovenCostingV2")
public class WovenCostingV2 {
    @Id
    private String id;
    private String orderId;
    private String quotationNo;
    private String customerName;
    private float estimatedQuantity;
    private String labelName;
    private float labelWidth;
    private float labelLength;
    private float noOfColors;
    private float totalPicks;
    private float noOfRepeats;

    private float rpmRaiper;
    private float rpmAirjet;
    private float hrRaiper;
    private float hrAirjet;
    private float labelCostRaiper;
    private float labelCostAirjet;

    private float additionalWork;
    private float productionCost;
    private float qcAndPackingCost;
    private float adminCost;
    private float profit;

    private float estimateCostRaiper;
    private float estimateCostAirjet;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getQuotationNo() {
        return quotationNo;
    }

    public void setQuotationNo(String quotationNo) {
        this.quotationNo = quotationNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public float getEstimatedQuantity() {
        return estimatedQuantity;
    }

    public void setEstimatedQuantity(float estimatedQuantity) {
        this.estimatedQuantity = estimatedQuantity;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public float getLabelWidth() {
        return labelWidth;
    }

    public void setLabelWidth(float labelWidth) {
        this.labelWidth = labelWidth;
    }

    public float getLabelLength() {
        return labelLength;
    }

    public void setLabelLength(float labelLength) {
        this.labelLength = labelLength;
    }

    public float getNoOfColors() {
        return noOfColors;
    }

    public void setNoOfColors(float noOfColors) {
        this.noOfColors = noOfColors;
    }

    public float getTotalPicks() {
        return totalPicks;
    }

    public void setTotalPicks(float totalPicks) {
        this.totalPicks = totalPicks;
    }

    public float getNoOfRepeats() {
        return noOfRepeats;
    }

    public void setNoOfRepeats(float noOfRepeats) {
        this.noOfRepeats = noOfRepeats;
    }

    public float getRpmRaiper() {
        return rpmRaiper;
    }

    public void setRpmRaiper(float rpmRaiper) {
        this.rpmRaiper = rpmRaiper;
    }

    public float getRpmAirjet() {
        return rpmAirjet;
    }

    public void setRpmAirjet(float rpmAirjet) {
        this.rpmAirjet = rpmAirjet;
    }

    public float getHrRaiper() {
        return hrRaiper;
    }

    public void setHrRaiper(float hrRaiper) {
        this.hrRaiper = hrRaiper;
    }

    public float getHrAirjet() {
        return hrAirjet;
    }

    public void setHrAirjet(float hrAirjet) {
        this.hrAirjet = hrAirjet;
    }

    public float getLabelCostRaiper() {
        return labelCostRaiper;
    }

    public void setLabelCostRaiper(float labelCostRaiper) {
        this.labelCostRaiper = labelCostRaiper;
    }

    public float getLabelCostAirjet() {
        return labelCostAirjet;
    }

    public void setLabelCostAirjet(float labelCostAirjet) {
        this.labelCostAirjet = labelCostAirjet;
    }

    public float getAdditionalWork() {
        return additionalWork;
    }

    public void setAdditionalWork(float additionalWork) {
        this.additionalWork = additionalWork;
    }

    public float getProductionCost() {
        return productionCost;
    }

    public void setProductionCost(float productionCost) {
        this.productionCost = productionCost;
    }

    public float getQcAndPackingCost() {
        return qcAndPackingCost;
    }

    public void setQcAndPackingCost(float qcAndPackingCost) {
        this.qcAndPackingCost = qcAndPackingCost;
    }

    public float getAdminCost() {
        return adminCost;
    }

    public void setAdminCost(float adminCost) {
        this.adminCost = adminCost;
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    public float getEstimateCostRaiper() {
        return estimateCostRaiper;
    }

    public void setEstimateCostRaiper(float estimateCostRaiper) {
        this.estimateCostRaiper = estimateCostRaiper;
    }

    public float getEstimateCostAirjet() {
        return estimateCostAirjet;
    }

    public void setEstimateCostAirjet(float estimateCostAirjet) {
        this.estimateCostAirjet = estimateCostAirjet;
    }
}

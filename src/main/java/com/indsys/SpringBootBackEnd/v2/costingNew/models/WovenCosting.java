package com.indsys.SpringBootBackEnd.v2.costingNew.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "MWovenCosting")
public class WovenCosting {

    @Id
    private String id;
    @Indexed(unique = true)
    private String refNo;
    private String entryDate;
    private String customerId;
    private String customerName;
    private String trimType;
    private int status;

    private Double estimatedQuantity;
    private String labelName;
    private Double labelWidth;
    private Double labelLength;
    private Double noOfColors;
    private Double totalPicks;
    private Double noOfRepeats;

    private Double rpmRaiper;
    private Double rpmAirjet;
    private Double hrRaiper;
    private Double hrAirjet;
    private Double labelCostRaiper;
    private Double labelCostAirjet;

    private Double additionalWork;
    private Double productionCost;
    private Double qcAndPackingCost;
    private Double adminCost;
    private Double deliveryCost;
    private Double profit;

    private Double estimateCostRaiper;
    private Double estimateCostAirjet;

    private SlabRates[] slabRates;

    private String attachmentExtension;

    private String remarks;
    private String paymentTerms;
    private Double financialChargeRaiper;
    private Double financialChargeAirjet;

    private String[] additionalWorkDetails;

    private Double totalEstimateCostRaiper;
    private Double totalEstimateCostAirjet;
    private String executiveId;
    private String approverId;
    private String tManagerEmail;

    private String customerRejectedReason;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Double getEstimatedQuantity() {
        return estimatedQuantity;
    }

    public void setEstimatedQuantity(Double estimatedQuantity) {
        this.estimatedQuantity = estimatedQuantity;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public Double getLabelWidth() {
        return labelWidth;
    }

    public void setLabelWidth(Double labelWidth) {
        this.labelWidth = labelWidth;
    }

    public Double getLabelLength() {
        return labelLength;
    }

    public void setLabelLength(Double labelLength) {
        this.labelLength = labelLength;
    }

    public Double getNoOfColors() {
        return noOfColors;
    }

    public void setNoOfColors(Double noOfColors) {
        this.noOfColors = noOfColors;
    }

    public Double getTotalPicks() {
        return totalPicks;
    }

    public void setTotalPicks(Double totalPicks) {
        this.totalPicks = totalPicks;
    }

    public Double getNoOfRepeats() {
        return noOfRepeats;
    }

    public void setNoOfRepeats(Double noOfRepeats) {
        this.noOfRepeats = noOfRepeats;
    }

    public Double getRpmRaiper() {
        return rpmRaiper;
    }

    public void setRpmRaiper(Double rpmRaiper) {
        this.rpmRaiper = rpmRaiper;
    }

    public Double getRpmAirjet() {
        return rpmAirjet;
    }

    public void setRpmAirjet(Double rpmAirjet) {
        this.rpmAirjet = rpmAirjet;
    }

    public Double getHrRaiper() {
        return hrRaiper;
    }

    public void setHrRaiper(Double hrRaiper) {
        this.hrRaiper = hrRaiper;
    }

    public Double getHrAirjet() {
        return hrAirjet;
    }

    public void setHrAirjet(Double hrAirjet) {
        this.hrAirjet = hrAirjet;
    }

    public Double getLabelCostRaiper() {
        return labelCostRaiper;
    }

    public void setLabelCostRaiper(Double labelCostRaiper) {
        this.labelCostRaiper = labelCostRaiper;
    }

    public Double getLabelCostAirjet() {
        return labelCostAirjet;
    }

    public void setLabelCostAirjet(Double labelCostAirjet) {
        this.labelCostAirjet = labelCostAirjet;
    }

    public Double getAdditionalWork() {
        return additionalWork;
    }

    public void setAdditionalWork(Double additionalWork) {
        this.additionalWork = additionalWork;
    }

    public Double getProductionCost() {
        return productionCost;
    }

    public void setProductionCost(Double productionCost) {
        this.productionCost = productionCost;
    }

    public Double getQcAndPackingCost() {
        return qcAndPackingCost;
    }

    public void setQcAndPackingCost(Double qcAndPackingCost) {
        this.qcAndPackingCost = qcAndPackingCost;
    }

    public Double getAdminCost() {
        return adminCost;
    }

    public void setAdminCost(Double adminCost) {
        this.adminCost = adminCost;
    }

    public Double getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(Double deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public Double getEstimateCostRaiper() {
        return estimateCostRaiper;
    }

    public void setEstimateCostRaiper(Double estimateCostRaiper) {
        this.estimateCostRaiper = estimateCostRaiper;
    }

    public Double getEstimateCostAirjet() {
        return estimateCostAirjet;
    }

    public void setEstimateCostAirjet(Double estimateCostAirjet) {
        this.estimateCostAirjet = estimateCostAirjet;
    }

    public SlabRates[] getSlabRates() {
        return slabRates;
    }

    public void setSlabRates(SlabRates[] slabRates) {
        this.slabRates = slabRates;
    }

    public String getAttachmentExtension() {
        return attachmentExtension;
    }

    public void setAttachmentExtension(String attachmentExtension) {
        this.attachmentExtension = attachmentExtension;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Double getFinancialChargeRaiper() {
        return financialChargeRaiper;
    }

    public void setFinancialChargeRaiper(Double financialChargeRaiper) {
        this.financialChargeRaiper = financialChargeRaiper;
    }

    public Double getFinancialChargeAirjet() {
        return financialChargeAirjet;
    }

    public void setFinancialChargeAirjet(Double financialChargeAirjet) {
        this.financialChargeAirjet = financialChargeAirjet;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public String[] getAdditionalWorkDetails() {
        return additionalWorkDetails;
    }

    public void setAdditionalWorkDetails(String[] additionalWorkDetails) {
        this.additionalWorkDetails = additionalWorkDetails;
    }

    public Double getTotalEstimateCostRaiper() {
        return totalEstimateCostRaiper;
    }

    public void setTotalEstimateCostRaiper(Double totalEstimateCostRaiper) {
        this.totalEstimateCostRaiper = totalEstimateCostRaiper;
    }

    public Double getTotalEstimateCostAirjet() {
        return totalEstimateCostAirjet;
    }

    public void setTotalEstimateCostAirjet(Double totalEstimateCostAirjet) {
        this.totalEstimateCostAirjet = totalEstimateCostAirjet;
    }

    public String getExecutiveId() {
        return executiveId;
    }

    public void setExecutiveId(String executiveId) {
        this.executiveId = executiveId;
    }

    public String getApproverId() {
        return approverId;
    }

    public void setApproverId(String approverId) {
        this.approverId = approverId;
    }

    public String gettManagerEmail() {
        return tManagerEmail;
    }

    public void settManagerEmail(String tManagerEmail) {
        this.tManagerEmail = tManagerEmail;
    }

    public String getCustomerRejectedReason() {
        return customerRejectedReason;
    }

    public void setCustomerRejectedReason(String customerRejectedReason) {
        this.customerRejectedReason = customerRejectedReason;
    }
}

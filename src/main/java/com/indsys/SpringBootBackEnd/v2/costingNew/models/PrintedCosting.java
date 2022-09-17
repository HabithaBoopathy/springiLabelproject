package com.indsys.SpringBootBackEnd.v2.costingNew.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "MPrintedCosting")
public class PrintedCosting {
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
    private String tapeId;
    private String tapeName;
    private Double tapeWidthMM;
    private Double tapeCostPerMeter;
    private Double labelWidth;
    private Double labelLength;
    private Double noOfLabelsPerMeter;

    private Double tapeCostPerLabel;
    private Double noOfColors;
    private Double plateCost;
    private Double inkCost;
    private Double cuttingCost;
    private Double productionCost;
    private Double qcAndPackingCost;
    private Double adminCost;
    private Double deliveryCost;
    private Double margin;

    private Double estimateCost;
    private Double financialCharge;
    private Double totalEstimateCost;

    private SlabRates[] slabRates;

    private String attachmentExtension;

    private String remarks;
    private String paymentTerms;

    private String[] additionalWorkDetails;
    private String executiveId;
    private String approverId;
    private String tManagerEmail;
    private VariableCostsPrinted variableCosts;
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

    public String getTapeName() {
        return tapeName;
    }

    public void setTapeName(String tapeName) {
        this.tapeName = tapeName;
    }

    public Double getTapeWidthMM() {
        return tapeWidthMM;
    }

    public void setTapeWidthMM(Double tapeWidthMM) {
        this.tapeWidthMM = tapeWidthMM;
    }

    public Double getTapeCostPerMeter() {
        return tapeCostPerMeter;
    }

    public void setTapeCostPerMeter(Double tapeCostPerMeter) {
        this.tapeCostPerMeter = tapeCostPerMeter;
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

    public Double getNoOfLabelsPerMeter() {
        return noOfLabelsPerMeter;
    }

    public void setNoOfLabelsPerMeter(Double noOfLabelsPerMeter) {
        this.noOfLabelsPerMeter = noOfLabelsPerMeter;
    }

    public Double getTapeCostPerLabel() {
        return tapeCostPerLabel;
    }

    public void setTapeCostPerLabel(Double tapeCostPerLabel) {
        this.tapeCostPerLabel = tapeCostPerLabel;
    }

    public Double getNoOfColors() {
        return noOfColors;
    }

    public void setNoOfColors(Double noOfColors) {
        this.noOfColors = noOfColors;
    }

    public Double getPlateCost() {
        return plateCost;
    }

    public void setPlateCost(Double plateCost) {
        this.plateCost = plateCost;
    }

    public Double getInkCost() {
        return inkCost;
    }

    public void setInkCost(Double inkCost) {
        this.inkCost = inkCost;
    }

    public Double getCuttingCost() {
        return cuttingCost;
    }

    public void setCuttingCost(Double cuttingCost) {
        this.cuttingCost = cuttingCost;
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

    public Double getMargin() {
        return margin;
    }

    public void setMargin(Double margin) {
        this.margin = margin;
    }

    public Double getEstimateCost() {
        return estimateCost;
    }

    public void setEstimateCost(Double estimateCost) {
        this.estimateCost = estimateCost;
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

    public Double getFinancialCharge() {
        return financialCharge;
    }

    public void setFinancialCharge(Double financialCharge) {
        this.financialCharge = financialCharge;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public String getTapeId() {
        return tapeId;
    }

    public void setTapeId(String tapeId) {
        this.tapeId = tapeId;
    }

    public Double getTotalEstimateCost() {
        return totalEstimateCost;
    }

    public void setTotalEstimateCost(Double totalEstimateCost) {
        this.totalEstimateCost = totalEstimateCost;
    }

    public String[] getAdditionalWorkDetails() {
        return additionalWorkDetails;
    }

    public void setAdditionalWorkDetails(String[] additionalWorkDetails) {
        this.additionalWorkDetails = additionalWorkDetails;
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

    public VariableCostsPrinted getVariableCosts() {
        return variableCosts;
    }

    public void setVariableCosts(VariableCostsPrinted variableCosts) {
        this.variableCosts = variableCosts;
    }

    public String getCustomerRejectedReason() {
        return customerRejectedReason;
    }

    public void setCustomerRejectedReason(String customerRejectedReason) {
        this.customerRejectedReason = customerRejectedReason;
    }
}

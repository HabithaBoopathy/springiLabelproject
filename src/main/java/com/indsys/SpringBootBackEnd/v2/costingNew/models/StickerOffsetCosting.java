package com.indsys.SpringBootBackEnd.v2.costingNew.models;

import com.indsys.SpringBootBackEnd.models.Mpaper;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "MStickerOffsetCosting")
public class StickerOffsetCosting {

    @Id
    private String id;

    @Indexed(unique = true)
    private String refNo;

    private String entryDate;
    private String customerId;
    private String customerName;
    private String trimType;
    private int status;
    private String executiveId;
    private String approverId;
    private String tManagerEmail;
    private String productName;
    private String attachmentExtension;

    private Mpaper paper1;
    private Mpaper paper2;

    private double productLength;
    private double productWidth;
    private double orderQuantity;
    private double excessPercentage;
    private double excessValue;
    private double ups;
    private double runCopies;
    private double makeReady;
    private String remarks;
    private String shRemarks;

    private double paper1CutSize;
    private double paper2CutSize;
    private double paper1NoOfBoard;
    private double paper2NoOfBoard;
    private double paper1Rate;
    private double paper2Rate;

    private BaseDetails baseDetails;
    private CostingDetails costingDetails;
    private SlabRates[] slabRates;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getAttachmentExtension() {
        return attachmentExtension;
    }

    public void setAttachmentExtension(String attachmentExtension) {
        this.attachmentExtension = attachmentExtension;
    }

    public Mpaper getPaper1() {
        return paper1;
    }

    public void setPaper1(Mpaper paper1) {
        this.paper1 = paper1;
    }

    public Mpaper getPaper2() {
        return paper2;
    }

    public void setPaper2(Mpaper paper2) {
        this.paper2 = paper2;
    }

    public double getProductLength() {
        return productLength;
    }

    public void setProductLength(double productLength) {
        this.productLength = productLength;
    }

    public double getProductWidth() {
        return productWidth;
    }

    public void setProductWidth(double productWidth) {
        this.productWidth = productWidth;
    }

    public double getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(double orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public double getExcessPercentage() {
        return excessPercentage;
    }

    public void setExcessPercentage(double excessPercentage) {
        this.excessPercentage = excessPercentage;
    }

    public double getExcessValue() {
        return excessValue;
    }

    public void setExcessValue(double excessValue) {
        this.excessValue = excessValue;
    }

    public double getUps() {
        return ups;
    }

    public void setUps(double ups) {
        this.ups = ups;
    }

    public double getRunCopies() {
        return runCopies;
    }

    public void setRunCopies(double runCopies) {
        this.runCopies = runCopies;
    }

    public double getMakeReady() {
        return makeReady;
    }

    public void setMakeReady(double makeReady) {
        this.makeReady = makeReady;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getShRemarks() {
        return shRemarks;
    }

    public void setShRemarks(String shRemarks) {
        this.shRemarks = shRemarks;
    }

    public double getPaper1CutSize() {
        return paper1CutSize;
    }

    public void setPaper1CutSize(double paper1CutSize) {
        this.paper1CutSize = paper1CutSize;
    }

    public double getPaper2CutSize() {
        return paper2CutSize;
    }

    public void setPaper2CutSize(double paper2CutSize) {
        this.paper2CutSize = paper2CutSize;
    }

    public double getPaper1NoOfBoard() {
        return paper1NoOfBoard;
    }

    public void setPaper1NoOfBoard(double paper1NoOfBoard) {
        this.paper1NoOfBoard = paper1NoOfBoard;
    }

    public double getPaper2NoOfBoard() {
        return paper2NoOfBoard;
    }

    public void setPaper2NoOfBoard(double paper2NoOfBoard) {
        this.paper2NoOfBoard = paper2NoOfBoard;
    }

    public double getPaper1Rate() {
        return paper1Rate;
    }

    public void setPaper1Rate(double paper1Rate) {
        this.paper1Rate = paper1Rate;
    }

    public double getPaper2Rate() {
        return paper2Rate;
    }

    public void setPaper2Rate(double paper2Rate) {
        this.paper2Rate = paper2Rate;
    }

    public BaseDetails getBaseDetails() {
        return baseDetails;
    }

    public void setBaseDetails(BaseDetails baseDetails) {
        this.baseDetails = baseDetails;
    }

    public CostingDetails getCostingDetails() {
        return costingDetails;
    }

    public void setCostingDetails(CostingDetails costingDetails) {
        this.costingDetails = costingDetails;
    }

    public SlabRates[] getSlabRates() {
        return slabRates;
    }

    public void setSlabRates(SlabRates[] slabRates) {
        this.slabRates = slabRates;
    }

    public String getCustomerRejectedReason() {
        return customerRejectedReason;
    }

    public void setCustomerRejectedReason(String customerRejectedReason) {
        this.customerRejectedReason = customerRejectedReason;
    }
}

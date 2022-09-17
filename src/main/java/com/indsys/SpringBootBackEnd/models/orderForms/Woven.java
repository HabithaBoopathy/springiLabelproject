package com.indsys.SpringBootBackEnd.models.orderForms;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "WovenOrderForm")
public class Woven {


    @Id
    private String Wid;
    private String  unit;
    private String  unitHeight;
    private String  unitWidth;
    private String  expectedQuantity;
    private String  expectedDate;
    private String  folding;
    private String  specialInstruction;
    private String  remarks;
    private String  color;
    private String  orderType;
    private String  colorInfo;
    private String  status;
    private String  finishing;
    private String  labelType;
    private String  approvalType;
    private String  incoming;
    private String  samplePDate;
    private String  executiveCode;
    private String  manager;
    private String  dateTime;
    private String  dispatchDateTime;
    private String  sampleRecDateTime;
    private String  pcm;
    private String  sampleName;
    private String  system;
    private String  tp;
    private String  samplingDate;
    private String  crLimitStatus;
    private String  designer;
    private String  machine;
    private String  width;
    private String  quality;
    private String  length;
    private String  x;
    private String  ColorOptionToBeUsed;
    private String  y;
    private String  noOfRepeats;
    private String  additionalWork;
    private String  wastage;
    private String  colorMatching;
    private String  warpTension;
    private String  doctype;

    public String getWid() {
        return Wid;
    }

    public void setWid(String wid) {
        Wid = wid;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnitHeight() {
        return unitHeight;
    }

    public void setUnitHeight(String unitHeight) {
        this.unitHeight = unitHeight;
    }

    public String getUnitWidth() {
        return unitWidth;
    }

    public void setUnitWidth(String unitWidth) {
        this.unitWidth = unitWidth;
    }

    public String getExpectedQuantity() {
        return expectedQuantity;
    }

    public void setExpectedQuantity(String expectedQuantity) {
        this.expectedQuantity = expectedQuantity;
    }

    public String getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(String expectedDate) {
        this.expectedDate = expectedDate;
    }

    public String getFolding() {
        return folding;
    }

    public void setFolding(String folding) {
        this.folding = folding;
    }

    public String getSpecialInstruction() {
        return specialInstruction;
    }

    public void setSpecialInstruction(String specialInstruction) {
        this.specialInstruction = specialInstruction;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getColorInfo() {
        return colorInfo;
    }

    public void setColorInfo(String colorInfo) {
        this.colorInfo = colorInfo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFinishing() {
        return finishing;
    }

    public void setFinishing(String finishing) {
        this.finishing = finishing;
    }

    public String getLabelType() {
        return labelType;
    }

    public void setLabelType(String labelType) {
        this.labelType = labelType;
    }

    public String getApprovalType() {
        return approvalType;
    }

    public void setApprovalType(String approvalType) {
        this.approvalType = approvalType;
    }

    public String getIncoming() {
        return incoming;
    }

    public void setIncoming(String incoming) {
        this.incoming = incoming;
    }

    public String getSamplePDate() {
        return samplePDate;
    }

    public void setSamplePDate(String samplePDate) {
        this.samplePDate = samplePDate;
    }

    public String getExecutiveCode() {
        return executiveCode;
    }

    public void setExecutiveCode(String executiveCode) {
        this.executiveCode = executiveCode;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getDispatchDateTime() {
        return dispatchDateTime;
    }

    public void setDispatchDateTime(String dispatchDateTime) {
        this.dispatchDateTime = dispatchDateTime;
    }

    public String getSampleRecDateTime() {
        return sampleRecDateTime;
    }

    public void setSampleRecDateTime(String sampleRecDateTime) {
        this.sampleRecDateTime = sampleRecDateTime;
    }

    public String getPcm() {
        return pcm;
    }

    public void setPcm(String pcm) {
        this.pcm = pcm;
    }

    public String getSampleName() {
        return sampleName;
    }

    public void setSampleName(String sampleName) {
        this.sampleName = sampleName;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public String getSamplingDate() {
        return samplingDate;
    }

    public void setSamplingDate(String samplingDate) {
        this.samplingDate = samplingDate;
    }

    public String getCrLimitStatus() {
        return crLimitStatus;
    }

    public void setCrLimitStatus(String crLimitStatus) {
        this.crLimitStatus = crLimitStatus;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getColorOptionToBeUsed() {
        return ColorOptionToBeUsed;
    }

    public void setColorOptionToBeUsed(String colorOptionToBeUsed) {
        ColorOptionToBeUsed = colorOptionToBeUsed;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getNoOfRepeats() {
        return noOfRepeats;
    }

    public void setNoOfRepeats(String noOfRepeats) {
        this.noOfRepeats = noOfRepeats;
    }

    public String getAdditionalWork() {
        return additionalWork;
    }

    public void setAdditionalWork(String additionalWork) {
        this.additionalWork = additionalWork;
    }

    public String getWastage() {
        return wastage;
    }

    public void setWastage(String wastage) {
        this.wastage = wastage;
    }

    public String getColorMatching() {
        return colorMatching;
    }

    public void setColorMatching(String colorMatching) {
        this.colorMatching = colorMatching;
    }

    public String getWarpTension() {
        return warpTension;
    }

    public void setWarpTension(String warpTension) {
        this.warpTension = warpTension;
    }

    public String getDoctype() {
        return doctype;
    }

    public void setDoctype(String doctype) {
        this.doctype = doctype;
    }

    public Woven(String wid, String unit, String unitHeight, String unitWidth, String expectedQuantity,
            String expectedDate, String folding, String specialInstruction, String remarks, String color,
            String orderType, String colorInfo, String status, String finishing, String labelType, String approvalType,
            String incoming, String samplePDate, String executiveCode, String manager, String dateTime,
            String dispatchDateTime, String sampleRecDateTime, String pcm, String sampleName, String system, String tp,
            String samplingDate, String crLimitStatus, String designer, String machine, String width, String quality,
            String length, String x, String colorOptionToBeUsed, String y, String noOfRepeats, String additionalWork,
            String wastage, String colorMatching, String warpTension, String doctype) {
        Wid = wid;
        this.unit = unit;
        this.unitHeight = unitHeight;
        this.unitWidth = unitWidth;
        this.expectedQuantity = expectedQuantity;
        this.expectedDate = expectedDate;
        this.folding = folding;
        this.specialInstruction = specialInstruction;
        this.remarks = remarks;
        this.color = color;
        this.orderType = orderType;
        this.colorInfo = colorInfo;
        this.status = status;
        this.finishing = finishing;
        this.labelType = labelType;
        this.approvalType = approvalType;
        this.incoming = incoming;
        this.samplePDate = samplePDate;
        this.executiveCode = executiveCode;
        this.manager = manager;
        this.dateTime = dateTime;
        this.dispatchDateTime = dispatchDateTime;
        this.sampleRecDateTime = sampleRecDateTime;
        this.pcm = pcm;
        this.sampleName = sampleName;
        this.system = system;
        this.tp = tp;
        this.samplingDate = samplingDate;
        this.crLimitStatus = crLimitStatus;
        this.designer = designer;
        this.machine = machine;
        this.width = width;
        this.quality = quality;
        this.length = length;
        this.x = x;
        ColorOptionToBeUsed = colorOptionToBeUsed;
        this.y = y;
        this.noOfRepeats = noOfRepeats;
        this.additionalWork = additionalWork;
        this.wastage = wastage;
        this.colorMatching = colorMatching;
        this.warpTension = warpTension;
        this.doctype = doctype;
    }

    @Override
    public String toString() {
        return "Woven [ColorOptionToBeUsed=" + ColorOptionToBeUsed + ", Wid=" + Wid + ", additionalWork="
                + additionalWork + ", approvalType=" + approvalType + ", color=" + color + ", colorInfo=" + colorInfo
                + ", colorMatching=" + colorMatching + ", crLimitStatus=" + crLimitStatus + ", dateTime=" + dateTime
                + ", designer=" + designer + ", dispatchDateTime=" + dispatchDateTime + ", doctype=" + doctype
                + ", executiveCode=" + executiveCode + ", expectedDate=" + expectedDate + ", expectedQuantity="
                + expectedQuantity + ", finishing=" + finishing + ", folding=" + folding + ", incoming=" + incoming
                + ", labelType=" + labelType + ", length=" + length + ", machine=" + machine + ", manager=" + manager
                + ", noOfRepeats=" + noOfRepeats + ", orderType=" + orderType + ", pcm=" + pcm + ", quality=" + quality
                + ", remarks=" + remarks + ", sampleName=" + sampleName + ", samplePDate=" + samplePDate
                + ", sampleRecDateTime=" + sampleRecDateTime + ", samplingDate=" + samplingDate
                + ", specialInstruction=" + specialInstruction + ", status=" + status + ", system=" + system + ", tp="
                + tp + ", unit=" + unit + ", unitHeight=" + unitHeight + ", unitWidth=" + unitWidth + ", warpTension="
                + warpTension + ", wastage=" + wastage + ", width=" + width + ", x=" + x + ", y=" + y + "]";
    }



    





}
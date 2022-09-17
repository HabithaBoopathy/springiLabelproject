package com.indsys.SpringBootBackEnd.models.orderForms;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "PrintedOrderForm")
public class Printed {

@Id
private String Pid;

private String unit;
private String unitHeight;
private String unitWidth;
private String expectedQuantity;
private String expectedDate;
private String folding;
private String specialInstruction;
private String remarks;
private String color;
private String orderType;
private String colorInformation;
private String status;
private String finishing;
private String labelType;
private String approvalType;
private String incoming;
private String samplePDate;
private String executiveCode;
private String manager;
private String dateTime;
private String dispatch;
private String sampleReceived;
private String pm;
private String sampleName;
private String system;
private String samplingDate;
private String crlimitStatus;
private String designFileName;
private String machine;
private String width;
private String quality;
private String length;
private String singlePrinting;
private String doublePrinting;
private String colorOption;
private String noOfcolors;
private String additionalWork;

private String sampleBlock;
private String noOfRepeatsPrinted;
private String widthPrinted;
public String getPid() {
	return Pid;
}
public void setPid(String pid) {
	Pid = pid;
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
public String getColorInformation() {
	return colorInformation;
}
public void setColorInformation(String colorInformation) {
	this.colorInformation = colorInformation;
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
public String getDispatch() {
	return dispatch;
}
public void setDispatch(String dispatch) {
	this.dispatch = dispatch;
}
public String getSampleReceived() {
	return sampleReceived;
}
public void setSampleReceived(String sampleReceived) {
	this.sampleReceived = sampleReceived;
}
public String getPm() {
	return pm;
}
public void setPm(String pm) {
	this.pm = pm;
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
public String getSamplingDate() {
	return samplingDate;
}
public void setSamplingDate(String samplingDate) {
	this.samplingDate = samplingDate;
}
public String getCrlimitStatus() {
	return crlimitStatus;
}
public void setCrlimitStatus(String crlimitStatus) {
	this.crlimitStatus = crlimitStatus;
}
public String getDesignFileName() {
	return designFileName;
}
public void setDesignFileName(String designFileName) {
	this.designFileName = designFileName;
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
public String getSinglePrinting() {
	return singlePrinting;
}
public void setSinglePrinting(String singlePrinting) {
	this.singlePrinting = singlePrinting;
}
public String getDoublePrinting() {
	return doublePrinting;
}
public void setDoublePrinting(String doublePrinting) {
	this.doublePrinting = doublePrinting;
}
public String getColorOption() {
	return colorOption;
}
public void setColorOption(String colorOption) {
	this.colorOption = colorOption;
}
public String getNoOfcolors() {
	return noOfcolors;
}
public void setNoOfcolors(String noOfcolors) {
	this.noOfcolors = noOfcolors;
}
public String getAdditionalWork() {
	return additionalWork;
}
public void setAdditionalWork(String additionalWork) {
	this.additionalWork = additionalWork;
}
public String getSampleBlock() {
	return sampleBlock;
}
public void setSampleBlock(String sampleBlock) {
	this.sampleBlock = sampleBlock;
}
public String getNoOfRepeatsPrinted() {
	return noOfRepeatsPrinted;
}
public void setNoOfRepeatsPrinted(String noOfRepeatsPrinted) {
	this.noOfRepeatsPrinted = noOfRepeatsPrinted;
}
public String getWidthPrinted() {
	return widthPrinted;
}
public void setWidthPrinted(String widthPrinted) {
	this.widthPrinted = widthPrinted;
}
public Printed(String pid, String unit, String unitHeight, String unitWidth, String expectedQuantity,
		String expectedDate, String folding, String specialInstruction, String remarks, String color, String orderType,
		String colorInformation, String status, String finishing, String labelType, String approvalType,
		String incoming, String samplePDate, String executiveCode, String manager, String dateTime, String dispatch,
		String sampleReceived, String pm, String sampleName, String system, String samplingDate, String crlimitStatus,
		String designFileName, String machine, String width, String quality, String length, String singlePrinting,
		String doublePrinting, String colorOption, String noOfcolors, String additionalWork, String sampleBlock,
		String noOfRepeatsPrinted, String widthPrinted) {
	super();
	Pid = pid;
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
	this.colorInformation = colorInformation;
	this.status = status;
	this.finishing = finishing;
	this.labelType = labelType;
	this.approvalType = approvalType;
	this.incoming = incoming;
	this.samplePDate = samplePDate;
	this.executiveCode = executiveCode;
	this.manager = manager;
	this.dateTime = dateTime;
	this.dispatch = dispatch;
	this.sampleReceived = sampleReceived;
	this.pm = pm;
	this.sampleName = sampleName;
	this.system = system;
	this.samplingDate = samplingDate;
	this.crlimitStatus = crlimitStatus;
	this.designFileName = designFileName;
	this.machine = machine;
	this.width = width;
	this.quality = quality;
	this.length = length;
	this.singlePrinting = singlePrinting;
	this.doublePrinting = doublePrinting;
	this.colorOption = colorOption;
	this.noOfcolors = noOfcolors;
	this.additionalWork = additionalWork;
	this.sampleBlock = sampleBlock;
	this.noOfRepeatsPrinted = noOfRepeatsPrinted;
	this.widthPrinted = widthPrinted;
}
@Override
public String toString() {
	return "Printed [Pid=" + Pid + ", unit=" + unit + ", unitHeight=" + unitHeight + ", unitWidth=" + unitWidth
			+ ", expectedQuantity=" + expectedQuantity + ", expectedDate=" + expectedDate + ", folding=" + folding
			+ ", specialInstruction=" + specialInstruction + ", remarks=" + remarks + ", color=" + color
			+ ", orderType=" + orderType + ", colorInformation=" + colorInformation + ", status=" + status
			+ ", finishing=" + finishing + ", labelType=" + labelType + ", approvalType=" + approvalType + ", incoming="
			+ incoming + ", samplePDate=" + samplePDate + ", executiveCode=" + executiveCode + ", manager=" + manager
			+ ", dateTime=" + dateTime + ", dispatch=" + dispatch + ", sampleReceived=" + sampleReceived + ", pm=" + pm
			+ ", sampleName=" + sampleName + ", system=" + system + ", samplingDate=" + samplingDate
			+ ", crlimitStatus=" + crlimitStatus + ", designFileName=" + designFileName + ", machine=" + machine
			+ ", width=" + width + ", quality=" + quality + ", length=" + length + ", singlePrinting=" + singlePrinting
			+ ", doublePrinting=" + doublePrinting + ", colorOption=" + colorOption + ", noOfcolors=" + noOfcolors
			+ ", additionalWork=" + additionalWork + ", sampleBlock=" + sampleBlock + ", noOfRepeatsPrinted="
			+ noOfRepeatsPrinted + ", widthPrinted=" + widthPrinted + "]";
}



   
}

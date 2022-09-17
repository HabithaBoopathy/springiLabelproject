package com.indsys.SpringBootBackEnd.models.orderForms;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "StickerOrderForm")
public class Sticker {

@Id
private String Sid;

private String unitHeight;
private String unitWidth;
private String diameter;
private String documentType;
private String colorInfo;
private String stickerType;
private String rollColor;
private String rollSpecification;
private String rollSize;
private String sampleCharge;
private String sampleChargecollected;
private String printType;
private String comments;
private String orderType;
private String expectedQuantity;
private String sampleRequest;
private String flex;
private String offset;
private String incoming;
private String samplePDate;
private String executiveCode;
private String manager;
private String datetime;
private String dispatch;
private String rollCost;
private String rollWastage;
private String stickerPrint;
private String digitalPrint;
private String foil;
private String die;
private String fwdandPacking;
private String total;
private String margin;
private String finalCost;
private String trimPiece;
private String platesizeSticker;

public String getSid() {
	return Sid;
}
public void setSid(String sid) {
	Sid = sid;
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
public String getDiameter() {
	return diameter;
}
public void setDiameter(String diameter) {
	this.diameter = diameter;
}
public String getDocumentType() {
	return documentType;
}
public void setDocumentType(String documentType) {
	this.documentType = documentType;
}
public String getColorInfo() {
	return colorInfo;
}
public void setColorInfo(String colorInfo) {
	this.colorInfo = colorInfo;
}
public String getStickerType() {
	return stickerType;
}
public void setStickerType(String stickerType) {
	this.stickerType = stickerType;
}
public String getRollColor() {
	return rollColor;
}
public void setRollColor(String rollColor) {
	this.rollColor = rollColor;
}
public String getRollSpecification() {
	return rollSpecification;
}
public void setRollSpecification(String rollSpecification) {
	this.rollSpecification = rollSpecification;
}
public String getRollSize() {
	return rollSize;
}
public void setRollSize(String rollSize) {
	this.rollSize = rollSize;
}
public String getSampleCharge() {
	return sampleCharge;
}
public void setSampleCharge(String sampleCharge) {
	this.sampleCharge = sampleCharge;
}
public String getSampleChargecollected() {
	return sampleChargecollected;
}
public void setSampleChargecollected(String sampleChargecollected) {
	this.sampleChargecollected = sampleChargecollected;
}
public String getPrintType() {
	return printType;
}
public void setPrintType(String printType) {
	this.printType = printType;
}
public String getComments() {
	return comments;
}
public void setComments(String comments) {
	this.comments = comments;
}
public String getOrderType() {
	return orderType;
}
public void setOrderType(String orderType) {
	this.orderType = orderType;
}
public String getExpectedQuantity() {
	return expectedQuantity;
}
public void setExpectedQuantity(String expectedQuantity) {
	this.expectedQuantity = expectedQuantity;
}
public String getSampleRequest() {
	return sampleRequest;
}
public void setSampleRequest(String sampleRequest) {
	this.sampleRequest = sampleRequest;
}
public String getFlex() {
	return flex;
}
public void setFlex(String flex) {
	this.flex = flex;
}
public String getOffset() {
	return offset;
}
public void setOffset(String offset) {
	this.offset = offset;
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
public String getDatetime() {
	return datetime;
}
public void setDatetime(String datetime) {
	this.datetime = datetime;
}
public String getDispatch() {
	return dispatch;
}
public void setDispatch(String dispatch) {
	this.dispatch = dispatch;
}
public String getRollCost() {
	return rollCost;
}
public void setRollCost(String rollCost) {
	this.rollCost = rollCost;
}
public String getRollWastage() {
	return rollWastage;
}
public void setRollWastage(String rollWastage) {
	this.rollWastage = rollWastage;
}
public String getStickerPrint() {
	return stickerPrint;
}
public void setStickerPrint(String stickerPrint) {
	this.stickerPrint = stickerPrint;
}
public String getDigitalPrint() {
	return digitalPrint;
}
public void setDigitalPrint(String digitalPrint) {
	this.digitalPrint = digitalPrint;
}
public String getFoil() {
	return foil;
}
public void setFoil(String foil) {
	this.foil = foil;
}
public String getDie() {
	return die;
}
public void setDie(String die) {
	this.die = die;
}
public String getFwdandPacking() {
	return fwdandPacking;
}
public void setFwdandPacking(String fwdandPacking) {
	this.fwdandPacking = fwdandPacking;
}
public String getTotal() {
	return total;
}
public void setTotal(String total) {
	this.total = total;
}
public String getMargin() {
	return margin;
}
public void setMargin(String margin) {
	this.margin = margin;
}
public String getFinalCost() {
	return finalCost;
}
public void setFinalCost(String finalCost) {
	this.finalCost = finalCost;
}
public String getTrimPiece() {
	return trimPiece;
}
public void setTrimPiece(String trimPiece) {
	this.trimPiece = trimPiece;
}
public String getPlatesizeSticker() {
	return platesizeSticker;
}
public void setPlatesizeSticker(String platesizeSticker) {
	this.platesizeSticker = platesizeSticker;
}
public Sticker(String sid, String unitHeight, String unitWidth, String diameter, String documentType, String colorInfo,
		String stickerType, String rollColor, String rollSpecification, String rollSize, String sampleCharge,
		String sampleChargecollected, String printType, String comments, String orderType, String expectedQuantity,
		String sampleRequest, String flex, String offset, String incoming, String samplePDate, String executiveCode,
		String manager, String datetime, String dispatch, String rollCost, String rollWastage, String stickerPrint,
		String digitalPrint, String foil, String die, String fwdandPacking, String total, String margin,
		String finalCost, String trimPiece, String platesizeSticker) {
	super();
	Sid = sid;
	this.unitHeight = unitHeight;
	this.unitWidth = unitWidth;
	this.diameter = diameter;
	this.documentType = documentType;
	this.colorInfo = colorInfo;
	this.stickerType = stickerType;
	this.rollColor = rollColor;
	this.rollSpecification = rollSpecification;
	this.rollSize = rollSize;
	this.sampleCharge = sampleCharge;
	this.sampleChargecollected = sampleChargecollected;
	this.printType = printType;
	this.comments = comments;
	this.orderType = orderType;
	this.expectedQuantity = expectedQuantity;
	this.sampleRequest = sampleRequest;
	this.flex = flex;
	this.offset = offset;
	this.incoming = incoming;
	this.samplePDate = samplePDate;
	this.executiveCode = executiveCode;
	this.manager = manager;
	this.datetime = datetime;
	this.dispatch = dispatch;
	this.rollCost = rollCost;
	this.rollWastage = rollWastage;
	this.stickerPrint = stickerPrint;
	this.digitalPrint = digitalPrint;
	this.foil = foil;
	this.die = die;
	this.fwdandPacking = fwdandPacking;
	this.total = total;
	this.margin = margin;
	this.finalCost = finalCost;
	this.trimPiece = trimPiece;
	this.platesizeSticker = platesizeSticker;
}
@Override
public String toString() {
	return "Sticker [Sid=" + Sid + ", unitHeight=" + unitHeight + ", unitWidth=" + unitWidth + ", diameter=" + diameter
			+ ", documentType=" + documentType + ", colorInfo=" + colorInfo + ", stickerType=" + stickerType
			+ ", rollColor=" + rollColor + ", rollSpecification=" + rollSpecification + ", rollSize=" + rollSize
			+ ", sampleCharge=" + sampleCharge + ", sampleChargecollected=" + sampleChargecollected + ", printType="
			+ printType + ", comments=" + comments + ", orderType=" + orderType + ", expectedQuantity="
			+ expectedQuantity + ", sampleRequest=" + sampleRequest + ", flex=" + flex + ", offset=" + offset
			+ ", incoming=" + incoming + ", samplePDate=" + samplePDate + ", executiveCode=" + executiveCode
			+ ", manager=" + manager + ", datetime=" + datetime + ", dispatch=" + dispatch + ", rollCost=" + rollCost
			+ ", rollWastage=" + rollWastage + ", stickerPrint=" + stickerPrint + ", digitalPrint=" + digitalPrint
			+ ", foil=" + foil + ", die=" + die + ", fwdandPacking=" + fwdandPacking + ", total=" + total + ", margin="
			+ margin + ", finalCost=" + finalCost + ", trimPiece=" + trimPiece + ", platesizeSticker="
			+ platesizeSticker + "]";
}




}

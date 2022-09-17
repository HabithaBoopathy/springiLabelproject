package com.indsys.SpringBootBackEnd.models.orderForms;

import java.util.ArrayList;
// import java.util.Arrays;

import com.indsys.SpringBootBackEnd.models.QuotationBatch;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "EverythingOrderForm")
public class Everything {

    @Id
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String customerId;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	//Order Created By
	private String orderCreatedBy;

	// Checking If Send For Customer Acceptance is Clicked
	private String sendForCustomerAcceptanceClicked;

    // Order Confirmation Date
    private String orderConfirmationDate;

	// Order Line Item
	ArrayList<OrderDetailsLineItem> orderLineItem = new ArrayList<OrderDetailsLineItem>();

    // Status Variables
    private String statusNum;
	private String transactionStatus;
	
	// Lineitem
//	ArrayList<Batch> lineitem = new ArrayList<Batch>();

	private QuotationBatch[] lineitem;
    // Reference Numbers
    private String printreferencenumber;
    private String stickerreferencenumber;
    private String wovenreferencenumber;
	private String tagreferencenumber;
	
	private String customerStreet1;
	private String customerStreet2;
	private String customerCity;
	private String customerState;
	private String customerGst;
	private Boolean customerEmailRequired;
	private String territoryId;

	//costing related fields
	private String costingId;
	private String costingRefNo;
	private String costingDate;
	private boolean costingAttachmentUsed;


    // Common
    private String date;
    private String oldRefNo;
    private String name;
	private String customerName;
	private String companyName;

	private String customerCategory;
	private String merchandiser;
    private String sampleNameCommon;
    private String contactPerson;
    private String phone;
    private String email;

    // @Indexed(unique = true)
	private String refNo;

	private int printRefNum;

	private int wovenRefNum;

	private int tagRefNum;

	private int stickerRefNum;

    private String anotherRefNo;
    private String execName;
    private String check;
    private String sampName;
    private String sampType;

    // Upload
    private String tempUpload;
	private String uploadName;
	private String secondUploadName;
	private String thirdUploadName;
	private String fourthUploadName;
	private String fifthUploadName;
	private String sixthUploadName;
	
	private String rejectedReason;
	
	// Quotation Form

	private String sampleCode;
	private String estimateDate;
	private String placeOfSupply;
	private String billCustomerName;
	private String billCustomerStreet;
	private String billCustomerCity;
	private String billCustomerPincode;
	private String billCustomerState;
	private String billCustomerCountry;
	private String billCustomerGst;
	private String shipCustomerName;
	private String shipCustomerStreet;
	private String shipCustomerCity;
	private String shipCustomerPincode;
	private String shipCustomerState;
	private String shipCustomerCountry;
	private String shipCustomerGst;
	private String itemDescription;
	private String hsn;
	private String quantityRange;
	private String rate;
	private String termsAndConditions;

    // Printed
    private String unitPrinted;
    private String unitHeightPrinted;
    private String unitWidthPrinted;
    private String expectedQuantityPrinted;
    private String expectedDatePrinted;
    private String foldingPrinted;
    private String specialInstructionPrinted;
    private String remarksPrinted;
    private String colorPrinted;
    private String orderTypePrinted;
    private String colorInformation;
    private String statusPrinted;
    private String finishingPrinted;
    private String labelTypePrinted;
    private String approvalTypePrinted;
    private String incomingPrinted;
    private String samplePDatePrinted;
    private String executiveCodePrinted;
    private String managerPrinted;
    private String dateTimePrinted;
    private String dispatchPrinted;
    private String sampleReceived;
    private String pm;
    private String sampleNamePrinted;
    private String systemPrinted;
    private String samplingDatePrinted;
    private String crlimitStatusPrinted;
    private String designFileNamePrinted;
    private String machinePrinted;
    private String qualityPrinted;
    private String lengthPrinted;
    private String singlePrinting;
    private String doublePrinting;
    private String colorOptionToBeUsedPrinted;
    private String noOfcolors;
    private String additionalWorkPrinted;
    private String colorOptionFront;
    private String colorOptionBack;
    
    private String sampleBlock;
    private String noOfRepeatsPrinted;
    private String widthPrinted;


    


    // Tag
    private String unitTag;
    private String unitHeightTag;
    private String unitWidthTag;
    private String tagDevType;
    private String documentTypeTag;
    private String colorInfoTag;
    private String runningBoardSize;
    private String nameOfTheBoard;
    private String boardSpecification;
    private String qualityTag;
    private String boardGSM;
    private String fsc;
    private String printTypeTag;
    private String colorTag;
    private String orderTypeTag;
    private String expectedQuantityTag;
    private String statusTag;
    private String finishingTag;
    private String expectedDateTag;
    private String foldingTag;
    private String approval;
    private String commentsTag;
    private String noOfPlates;
    private String negativePositive;
    private String foilEmbossScreen;
    private String dieTag;
    private String printColorMatching;
    private String foilFace;
    private String foilReverse;
    private String foilColor;
    private String uvFace;
    private String uvReverse;
    private String uvNoOfScreens;
    private String vMatt;
    private String vGloss;
    private String vFace;
    private String vReverse;
    private String vOthers;
    private String lMatt;
    private String lGloss;
    private String lFace;
    private String lReverse;
    private String lOthers;
    private String straightCut;
    private String holeSize;
    private String perforation;
    private String creasing;
    private String designCut;
    private String string;
    private String eyeletColorAndLength;
    private String ifOthers;
    private String hookColorAndLength;
    private String boardCost;
    private String boardWastage;
    private String designFileName;
    private String digitalPrintTag;
    private String offsetPrintTag;
    private String foilTag;
    private String uv;
    private String emboss;
    private String varnish;
    private String lamination;
    private String pasting;
    private String die2;
    private String platesize;
    private String noofups;

    // Sticker

    private String unitSticker;
    private String unitHeightSticker;
    private String unitWidthSticker;
    private String diameter;
    private String documentType;
    private String colorInfoSticker;
    private String stickerType;
    private String rollColor;
    private String rollSpecification;
    private String rollSize;
    private String sampleCharge;
    private String sampleChargecollected;
    private String printType;
    private String comments;
    private String orderTypeSticker;
    private String expectedQuantitySticker;
    private String sampleRequest;
    private String flex;
    private String offset;
    private String incomingSticker;
    private String samplePDateSticker;
    private String executiveCodeSticker;
    private String managerSticker;
    private String dateTimeSticker;
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
    private String inkNameTable[];
    private String platesizeSticker;

    // Woven

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
    private String colorInfo;
    private String status;
    private String finishing;
    private String labelType;
    private String approvalType;
    private String incoming;
    private String samplePDate;
    private String executiveCode;
    private String manager;
    private String dateTime;
    private String dispatchDateTime;
    private String sampleRecDateTime;
    private String pcm;
    private String sampleName;
    private String system;
    private String tp;
    private String samplingDate;
    private String crLimitStatus;
    private String designer;
    private String machine;
    private String width;
    private String quality;
    private String length;
    private String x;
    private String colorOptionToBeUsed;
    private String y;
    private String noOfRepeats;
    private String additionalWork;
    private String wastage;
    private String colorMatching;
    private String warpTension;
    private String doctype;
    private String colorpicks;
	private String colorOptionTable[];

	private String totalpicks;

	public String getTotalpicks() {
		return totalpicks;
	}

	public void setTotalpicks(String totalpicks) {
		this.totalpicks = totalpicks;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

//	public String getId() {
//		return id;
//	}

	public String getCustomerCategory() {
		return customerCategory;
	}

	public void setCustomerCategory(String customerCategory) {
		this.customerCategory = customerCategory;
	}
//
//
//	public void setId(String id) {
//		this.id = id;
//	}


	public String getOrderCreatedBy() {
		return orderCreatedBy;
	}


	public void setOrderCreatedBy(String orderCreatedBy) {
		this.orderCreatedBy = orderCreatedBy;
	}


	public String getSendForCustomerAcceptanceClicked() {
		return sendForCustomerAcceptanceClicked;
	}


	public void setSendForCustomerAcceptanceClicked(String sendForCustomerAcceptanceClicked) {
		this.sendForCustomerAcceptanceClicked = sendForCustomerAcceptanceClicked;
	}


	public String getOrderConfirmationDate() {
		return orderConfirmationDate;
	}


	public void setOrderConfirmationDate(String orderConfirmationDate) {
		this.orderConfirmationDate = orderConfirmationDate;
	}


	public ArrayList<OrderDetailsLineItem> getOrderLineItem() {
		return orderLineItem;
	}


	public void setOrderLineItem(ArrayList<OrderDetailsLineItem> orderLineItem) {
		this.orderLineItem = orderLineItem;
	}


	public String getStatusNum() {
		return statusNum;
	}


	public void setStatusNum(String statusNum) {
		this.statusNum = statusNum;
	}


	public String getTransactionStatus() {
		return transactionStatus;
	}


	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}


	public QuotationBatch[] getLineitem() {
		return lineitem;
	}


	public void setLineitem(QuotationBatch[] lineitem) {
		this.lineitem = lineitem;
	}


	public String getPrintreferencenumber() {
		return printreferencenumber;
	}


	public void setPrintreferencenumber(String printreferencenumber) {
		this.printreferencenumber = printreferencenumber;
	}


	public String getStickerreferencenumber() {
		return stickerreferencenumber;
	}


	public void setStickerreferencenumber(String stickerreferencenumber) {
		this.stickerreferencenumber = stickerreferencenumber;
	}


	public String getWovenreferencenumber() {
		return wovenreferencenumber;
	}


	public void setWovenreferencenumber(String wovenreferencenumber) {
		this.wovenreferencenumber = wovenreferencenumber;
	}


	public String getTagreferencenumber() {
		return tagreferencenumber;
	}


	public void setTagreferencenumber(String tagreferencenumber) {
		this.tagreferencenumber = tagreferencenumber;
	}


	public String getCustomerStreet1() {
		return customerStreet1;
	}


	public void setCustomerStreet1(String customerStreet1) {
		this.customerStreet1 = customerStreet1;
	}


	public String getCustomerStreet2() {
		return customerStreet2;
	}


	public void setCustomerStreet2(String customerStreet2) {
		this.customerStreet2 = customerStreet2;
	}


	public String getCustomerCity() {
		return customerCity;
	}


	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}


	public String getCustomerState() {
		return customerState;
	}


	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}


	public String getCustomerGst() {
		return customerGst;
	}


	public void setCustomerGst(String customerGst) {
		this.customerGst = customerGst;
	}


	public Boolean getCustomerEmailRequired() {
		return customerEmailRequired;
	}


	public void setCustomerEmailRequired(Boolean customerEmailRequired) {
		this.customerEmailRequired = customerEmailRequired;
	}

	public String getTerritoryId() {
		return territoryId;
	}

	public void setTerritoryId(String territoryId) {
		this.territoryId = territoryId;
	}

	public String getCostingId() {
		return costingId;
	}

	public void setCostingId(String costingId) {
		this.costingId = costingId;
	}

	public String getCostingRefNo() {
		return costingRefNo;
	}

	public void setCostingRefNo(String costingRefNo) {
		this.costingRefNo = costingRefNo;
	}

	public String getCostingDate() {
		return costingDate;
	}

	public void setCostingDate(String costingDate) {
		this.costingDate = costingDate;
	}

	public boolean isCostingAttachmentUsed() {
		return costingAttachmentUsed;
	}

	public void setCostingAttachmentUsed(boolean costingAttachmentUsed) {
		this.costingAttachmentUsed = costingAttachmentUsed;
	}

	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getOldRefNo() {
		return oldRefNo;
	}


	public void setOldRefNo(String oldRefNo) {
		this.oldRefNo = oldRefNo;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSampleNameCommon() {
		return sampleNameCommon;
	}


	public void setSampleNameCommon(String sampleNameCommon) {
		this.sampleNameCommon = sampleNameCommon;
	}


	public String getContactPerson() {
		return contactPerson;
	}


	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getRefNo() {
		return refNo;
	}


	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}


	public int getPrintRefNum() {
		return printRefNum;
	}


	public void setPrintRefNum(int printRefNum) {
		this.printRefNum = printRefNum;
	}


	public int getWovenRefNum() {
		return wovenRefNum;
	}


	public void setWovenRefNum(int wovenRefNum) {
		this.wovenRefNum = wovenRefNum;
	}


	public int getTagRefNum() {
		return tagRefNum;
	}


	public void setTagRefNum(int tagRefNum) {
		this.tagRefNum = tagRefNum;
	}


	public int getStickerRefNum() {
		return stickerRefNum;
	}


	public void setStickerRefNum(int stickerRefNum) {
		this.stickerRefNum = stickerRefNum;
	}


	public String getAnotherRefNo() {
		return anotherRefNo;
	}


	public void setAnotherRefNo(String anotherRefNo) {
		this.anotherRefNo = anotherRefNo;
	}


	public String getExecName() {
		return execName;
	}


	public void setExecName(String execName) {
		this.execName = execName;
	}


	public String getCheck() {
		return check;
	}


	public void setCheck(String check) {
		this.check = check;
	}


	public String getSampName() {
		return sampName;
	}


	public void setSampName(String sampName) {
		this.sampName = sampName;
	}


	public String getSampType() {
		return sampType;
	}


	public void setSampType(String sampType) {
		this.sampType = sampType;
	}


	public String getTempUpload() {
		return tempUpload;
	}


	public void setTempUpload(String tempUpload) {
		this.tempUpload = tempUpload;
	}


	public String getUploadName() {
		return uploadName;
	}


	public void setUploadName(String uploadName) {
		this.uploadName = uploadName;
	}


	public String getSecondUploadName() {
		return secondUploadName;
	}


	public void setSecondUploadName(String secondUploadName) {
		this.secondUploadName = secondUploadName;
	}


	public String getThirdUploadName() {
		return thirdUploadName;
	}


	public void setThirdUploadName(String thirdUploadName) {
		this.thirdUploadName = thirdUploadName;
	}


	public String getFourthUploadName() {
		return fourthUploadName;
	}


	public void setFourthUploadName(String fourthUploadName) {
		this.fourthUploadName = fourthUploadName;
	}


	public String getFifthUploadName() {
		return fifthUploadName;
	}


	public void setFifthUploadName(String fifthUploadName) {
		this.fifthUploadName = fifthUploadName;
	}


	public String getSixthUploadName() {
		return sixthUploadName;
	}


	public void setSixthUploadName(String sixthUploadName) {
		this.sixthUploadName = sixthUploadName;
	}


	public String getRejectedReason() {
		return rejectedReason;
	}


	public void setRejectedReason(String rejectedReason) {
		this.rejectedReason = rejectedReason;
	}


	public String getSampleCode() {
		return sampleCode;
	}


	public void setSampleCode(String sampleCode) {
		this.sampleCode = sampleCode;
	}


	public String getEstimateDate() {
		return estimateDate;
	}


	public void setEstimateDate(String estimateDate) {
		this.estimateDate = estimateDate;
	}


	public String getPlaceOfSupply() {
		return placeOfSupply;
	}


	public void setPlaceOfSupply(String placeOfSupply) {
		this.placeOfSupply = placeOfSupply;
	}


	public String getBillCustomerName() {
		return billCustomerName;
	}


	public void setBillCustomerName(String billCustomerName) {
		this.billCustomerName = billCustomerName;
	}


	public String getBillCustomerStreet() {
		return billCustomerStreet;
	}


	public void setBillCustomerStreet(String billCustomerStreet) {
		this.billCustomerStreet = billCustomerStreet;
	}


	public String getBillCustomerCity() {
		return billCustomerCity;
	}


	public void setBillCustomerCity(String billCustomerCity) {
		this.billCustomerCity = billCustomerCity;
	}


	public String getBillCustomerPincode() {
		return billCustomerPincode;
	}


	public void setBillCustomerPincode(String billCustomerPincode) {
		this.billCustomerPincode = billCustomerPincode;
	}


	public String getBillCustomerState() {
		return billCustomerState;
	}


	public void setBillCustomerState(String billCustomerState) {
		this.billCustomerState = billCustomerState;
	}


	public String getBillCustomerCountry() {
		return billCustomerCountry;
	}


	public void setBillCustomerCountry(String billCustomerCountry) {
		this.billCustomerCountry = billCustomerCountry;
	}


	public String getBillCustomerGst() {
		return billCustomerGst;
	}


	public void setBillCustomerGst(String billCustomerGst) {
		this.billCustomerGst = billCustomerGst;
	}


	public String getShipCustomerName() {
		return shipCustomerName;
	}


	public void setShipCustomerName(String shipCustomerName) {
		this.shipCustomerName = shipCustomerName;
	}


	public String getShipCustomerStreet() {
		return shipCustomerStreet;
	}


	public void setShipCustomerStreet(String shipCustomerStreet) {
		this.shipCustomerStreet = shipCustomerStreet;
	}


	public String getShipCustomerCity() {
		return shipCustomerCity;
	}


	public void setShipCustomerCity(String shipCustomerCity) {
		this.shipCustomerCity = shipCustomerCity;
	}


	public String getShipCustomerPincode() {
		return shipCustomerPincode;
	}


	public void setShipCustomerPincode(String shipCustomerPincode) {
		this.shipCustomerPincode = shipCustomerPincode;
	}


	public String getShipCustomerState() {
		return shipCustomerState;
	}


	public void setShipCustomerState(String shipCustomerState) {
		this.shipCustomerState = shipCustomerState;
	}


	public String getShipCustomerCountry() {
		return shipCustomerCountry;
	}


	public void setShipCustomerCountry(String shipCustomerCountry) {
		this.shipCustomerCountry = shipCustomerCountry;
	}


	public String getShipCustomerGst() {
		return shipCustomerGst;
	}


	public void setShipCustomerGst(String shipCustomerGst) {
		this.shipCustomerGst = shipCustomerGst;
	}


	public String getItemDescription() {
		return itemDescription;
	}


	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}


	public String getHsn() {
		return hsn;
	}


	public void setHsn(String hsn) {
		this.hsn = hsn;
	}


	public String getQuantityRange() {
		return quantityRange;
	}


	public void setQuantityRange(String quantityRange) {
		this.quantityRange = quantityRange;
	}


	public String getRate() {
		return rate;
	}


	public void setRate(String rate) {
		this.rate = rate;
	}


	public String getTermsAndConditions() {
		return termsAndConditions;
	}


	public void setTermsAndConditions(String termsAndConditions) {
		this.termsAndConditions = termsAndConditions;
	}


	public String getUnitPrinted() {
		return unitPrinted;
	}


	public void setUnitPrinted(String unitPrinted) {
		this.unitPrinted = unitPrinted;
	}


	public String getUnitHeightPrinted() {
		return unitHeightPrinted;
	}


	public void setUnitHeightPrinted(String unitHeightPrinted) {
		this.unitHeightPrinted = unitHeightPrinted;
	}


	public String getUnitWidthPrinted() {
		return unitWidthPrinted;
	}


	public void setUnitWidthPrinted(String unitWidthPrinted) {
		this.unitWidthPrinted = unitWidthPrinted;
	}


	public String getExpectedQuantityPrinted() {
		return expectedQuantityPrinted;
	}


	public void setExpectedQuantityPrinted(String expectedQuantityPrinted) {
		this.expectedQuantityPrinted = expectedQuantityPrinted;
	}


	public String getExpectedDatePrinted() {
		return expectedDatePrinted;
	}


	public void setExpectedDatePrinted(String expectedDatePrinted) {
		this.expectedDatePrinted = expectedDatePrinted;
	}


	public String getFoldingPrinted() {
		return foldingPrinted;
	}


	public void setFoldingPrinted(String foldingPrinted) {
		this.foldingPrinted = foldingPrinted;
	}


	public String getSpecialInstructionPrinted() {
		return specialInstructionPrinted;
	}


	public void setSpecialInstructionPrinted(String specialInstructionPrinted) {
		this.specialInstructionPrinted = specialInstructionPrinted;
	}


	public String getRemarksPrinted() {
		return remarksPrinted;
	}


	public void setRemarksPrinted(String remarksPrinted) {
		this.remarksPrinted = remarksPrinted;
	}


	public String getColorPrinted() {
		return colorPrinted;
	}


	public void setColorPrinted(String colorPrinted) {
		this.colorPrinted = colorPrinted;
	}


	public String getOrderTypePrinted() {
		return orderTypePrinted;
	}


	public void setOrderTypePrinted(String orderTypePrinted) {
		this.orderTypePrinted = orderTypePrinted;
	}


	public String getColorInformation() {
		return colorInformation;
	}


	public void setColorInformation(String colorInformation) {
		this.colorInformation = colorInformation;
	}


	public String getStatusPrinted() {
		return statusPrinted;
	}


	public void setStatusPrinted(String statusPrinted) {
		this.statusPrinted = statusPrinted;
	}


	public String getFinishingPrinted() {
		return finishingPrinted;
	}


	public void setFinishingPrinted(String finishingPrinted) {
		this.finishingPrinted = finishingPrinted;
	}


	public String getLabelTypePrinted() {
		return labelTypePrinted;
	}


	public void setLabelTypePrinted(String labelTypePrinted) {
		this.labelTypePrinted = labelTypePrinted;
	}


	public String getApprovalTypePrinted() {
		return approvalTypePrinted;
	}


	public void setApprovalTypePrinted(String approvalTypePrinted) {
		this.approvalTypePrinted = approvalTypePrinted;
	}


	public String getIncomingPrinted() {
		return incomingPrinted;
	}


	public void setIncomingPrinted(String incomingPrinted) {
		this.incomingPrinted = incomingPrinted;
	}


	public String getSamplePDatePrinted() {
		return samplePDatePrinted;
	}


	public void setSamplePDatePrinted(String samplePDatePrinted) {
		this.samplePDatePrinted = samplePDatePrinted;
	}


	public String getExecutiveCodePrinted() {
		return executiveCodePrinted;
	}


	public void setExecutiveCodePrinted(String executiveCodePrinted) {
		this.executiveCodePrinted = executiveCodePrinted;
	}


	public String getManagerPrinted() {
		return managerPrinted;
	}


	public void setManagerPrinted(String managerPrinted) {
		this.managerPrinted = managerPrinted;
	}


	public String getDateTimePrinted() {
		return dateTimePrinted;
	}


	public void setDateTimePrinted(String dateTimePrinted) {
		this.dateTimePrinted = dateTimePrinted;
	}


	public String getDispatchPrinted() {
		return dispatchPrinted;
	}


	public void setDispatchPrinted(String dispatchPrinted) {
		this.dispatchPrinted = dispatchPrinted;
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


	public String getSampleNamePrinted() {
		return sampleNamePrinted;
	}


	public void setSampleNamePrinted(String sampleNamePrinted) {
		this.sampleNamePrinted = sampleNamePrinted;
	}


	public String getSystemPrinted() {
		return systemPrinted;
	}


	public void setSystemPrinted(String systemPrinted) {
		this.systemPrinted = systemPrinted;
	}


	public String getSamplingDatePrinted() {
		return samplingDatePrinted;
	}


	public void setSamplingDatePrinted(String samplingDatePrinted) {
		this.samplingDatePrinted = samplingDatePrinted;
	}


	public String getCrlimitStatusPrinted() {
		return crlimitStatusPrinted;
	}


	public void setCrlimitStatusPrinted(String crlimitStatusPrinted) {
		this.crlimitStatusPrinted = crlimitStatusPrinted;
	}


	public String getDesignFileNamePrinted() {
		return designFileNamePrinted;
	}


	public void setDesignFileNamePrinted(String designFileNamePrinted) {
		this.designFileNamePrinted = designFileNamePrinted;
	}


	public String getMachinePrinted() {
		return machinePrinted;
	}


	public void setMachinePrinted(String machinePrinted) {
		this.machinePrinted = machinePrinted;
	}


	public String getQualityPrinted() {
		return qualityPrinted;
	}


	public void setQualityPrinted(String qualityPrinted) {
		this.qualityPrinted = qualityPrinted;
	}


	public String getLengthPrinted() {
		return lengthPrinted;
	}


	public void setLengthPrinted(String lengthPrinted) {
		this.lengthPrinted = lengthPrinted;
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


	public String getColorOptionToBeUsedPrinted() {
		return colorOptionToBeUsedPrinted;
	}


	public void setColorOptionToBeUsedPrinted(String colorOptionToBeUsedPrinted) {
		this.colorOptionToBeUsedPrinted = colorOptionToBeUsedPrinted;
	}


	public String getNoOfcolors() {
		return noOfcolors;
	}


	public void setNoOfcolors(String noOfcolors) {
		this.noOfcolors = noOfcolors;
	}


	public String getAdditionalWorkPrinted() {
		return additionalWorkPrinted;
	}


	public void setAdditionalWorkPrinted(String additionalWorkPrinted) {
		this.additionalWorkPrinted = additionalWorkPrinted;
	}


	public String getColorOptionFront() {
		return colorOptionFront;
	}


	public void setColorOptionFront(String colorOptionFront) {
		this.colorOptionFront = colorOptionFront;
	}


	public String getColorOptionBack() {
		return colorOptionBack;
	}


	public void setColorOptionBack(String colorOptionBack) {
		this.colorOptionBack = colorOptionBack;
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


	public String getUnitTag() {
		return unitTag;
	}


	public void setUnitTag(String unitTag) {
		this.unitTag = unitTag;
	}


	public String getUnitHeightTag() {
		return unitHeightTag;
	}


	public void setUnitHeightTag(String unitHeightTag) {
		this.unitHeightTag = unitHeightTag;
	}


	public String getUnitWidthTag() {
		return unitWidthTag;
	}


	public void setUnitWidthTag(String unitWidthTag) {
		this.unitWidthTag = unitWidthTag;
	}


	public String getTagDevType() {
		return tagDevType;
	}


	public void setTagDevType(String tagDevType) {
		this.tagDevType = tagDevType;
	}


	public String getDocumentTypeTag() {
		return documentTypeTag;
	}


	public void setDocumentTypeTag(String documentTypeTag) {
		this.documentTypeTag = documentTypeTag;
	}


	public String getColorInfoTag() {
		return colorInfoTag;
	}


	public void setColorInfoTag(String colorInfoTag) {
		this.colorInfoTag = colorInfoTag;
	}


	public String getRunningBoardSize() {
		return runningBoardSize;
	}


	public void setRunningBoardSize(String runningBoardSize) {
		this.runningBoardSize = runningBoardSize;
	}


	public String getNameOfTheBoard() {
		return nameOfTheBoard;
	}


	public void setNameOfTheBoard(String nameOfTheBoard) {
		this.nameOfTheBoard = nameOfTheBoard;
	}


	public String getBoardSpecification() {
		return boardSpecification;
	}


	public void setBoardSpecification(String boardSpecification) {
		this.boardSpecification = boardSpecification;
	}


	public String getQualityTag() {
		return qualityTag;
	}


	public void setQualityTag(String qualityTag) {
		this.qualityTag = qualityTag;
	}


	public String getBoardGSM() {
		return boardGSM;
	}


	public void setBoardGSM(String boardGSM) {
		this.boardGSM = boardGSM;
	}


	public String getFsc() {
		return fsc;
	}


	public void setFsc(String fsc) {
		this.fsc = fsc;
	}


	public String getPrintTypeTag() {
		return printTypeTag;
	}


	public void setPrintTypeTag(String printTypeTag) {
		this.printTypeTag = printTypeTag;
	}


	public String getColorTag() {
		return colorTag;
	}


	public void setColorTag(String colorTag) {
		this.colorTag = colorTag;
	}


	public String getOrderTypeTag() {
		return orderTypeTag;
	}


	public void setOrderTypeTag(String orderTypeTag) {
		this.orderTypeTag = orderTypeTag;
	}


	public String getExpectedQuantityTag() {
		return expectedQuantityTag;
	}


	public void setExpectedQuantityTag(String expectedQuantityTag) {
		this.expectedQuantityTag = expectedQuantityTag;
	}


	public String getStatusTag() {
		return statusTag;
	}


	public void setStatusTag(String statusTag) {
		this.statusTag = statusTag;
	}


	public String getFinishingTag() {
		return finishingTag;
	}


	public void setFinishingTag(String finishingTag) {
		this.finishingTag = finishingTag;
	}


	public String getExpectedDateTag() {
		return expectedDateTag;
	}


	public void setExpectedDateTag(String expectedDateTag) {
		this.expectedDateTag = expectedDateTag;
	}


	public String getFoldingTag() {
		return foldingTag;
	}


	public void setFoldingTag(String foldingTag) {
		this.foldingTag = foldingTag;
	}


	public String getApproval() {
		return approval;
	}


	public void setApproval(String approval) {
		this.approval = approval;
	}


	public String getCommentsTag() {
		return commentsTag;
	}


	public void setCommentsTag(String commentsTag) {
		this.commentsTag = commentsTag;
	}


	public String getNoOfPlates() {
		return noOfPlates;
	}


	public void setNoOfPlates(String noOfPlates) {
		this.noOfPlates = noOfPlates;
	}


	public String getNegativePositive() {
		return negativePositive;
	}


	public void setNegativePositive(String negativePositive) {
		this.negativePositive = negativePositive;
	}


	public String getFoilEmbossScreen() {
		return foilEmbossScreen;
	}


	public void setFoilEmbossScreen(String foilEmbossScreen) {
		this.foilEmbossScreen = foilEmbossScreen;
	}


	public String getDieTag() {
		return dieTag;
	}


	public void setDieTag(String dieTag) {
		this.dieTag = dieTag;
	}


	public String getPrintColorMatching() {
		return printColorMatching;
	}


	public void setPrintColorMatching(String printColorMatching) {
		this.printColorMatching = printColorMatching;
	}


	public String getFoilFace() {
		return foilFace;
	}


	public void setFoilFace(String foilFace) {
		this.foilFace = foilFace;
	}


	public String getFoilReverse() {
		return foilReverse;
	}


	public void setFoilReverse(String foilReverse) {
		this.foilReverse = foilReverse;
	}


	public String getFoilColor() {
		return foilColor;
	}


	public void setFoilColor(String foilColor) {
		this.foilColor = foilColor;
	}


	public String getUvFace() {
		return uvFace;
	}


	public void setUvFace(String uvFace) {
		this.uvFace = uvFace;
	}


	public String getUvReverse() {
		return uvReverse;
	}


	public void setUvReverse(String uvReverse) {
		this.uvReverse = uvReverse;
	}


	public String getUvNoOfScreens() {
		return uvNoOfScreens;
	}


	public void setUvNoOfScreens(String uvNoOfScreens) {
		this.uvNoOfScreens = uvNoOfScreens;
	}


	public String getvMatt() {
		return vMatt;
	}


	public void setvMatt(String vMatt) {
		this.vMatt = vMatt;
	}


	public String getvGloss() {
		return vGloss;
	}


	public void setvGloss(String vGloss) {
		this.vGloss = vGloss;
	}


	public String getvFace() {
		return vFace;
	}


	public void setvFace(String vFace) {
		this.vFace = vFace;
	}


	public String getvReverse() {
		return vReverse;
	}


	public void setvReverse(String vReverse) {
		this.vReverse = vReverse;
	}


	public String getvOthers() {
		return vOthers;
	}


	public void setvOthers(String vOthers) {
		this.vOthers = vOthers;
	}


	public String getlMatt() {
		return lMatt;
	}


	public void setlMatt(String lMatt) {
		this.lMatt = lMatt;
	}


	public String getlGloss() {
		return lGloss;
	}


	public void setlGloss(String lGloss) {
		this.lGloss = lGloss;
	}


	public String getlFace() {
		return lFace;
	}


	public void setlFace(String lFace) {
		this.lFace = lFace;
	}


	public String getlReverse() {
		return lReverse;
	}


	public void setlReverse(String lReverse) {
		this.lReverse = lReverse;
	}


	public String getlOthers() {
		return lOthers;
	}


	public void setlOthers(String lOthers) {
		this.lOthers = lOthers;
	}


	public String getStraightCut() {
		return straightCut;
	}


	public void setStraightCut(String straightCut) {
		this.straightCut = straightCut;
	}


	public String getHoleSize() {
		return holeSize;
	}


	public void setHoleSize(String holeSize) {
		this.holeSize = holeSize;
	}


	public String getPerforation() {
		return perforation;
	}


	public void setPerforation(String perforation) {
		this.perforation = perforation;
	}


	public String getCreasing() {
		return creasing;
	}


	public void setCreasing(String creasing) {
		this.creasing = creasing;
	}


	public String getDesignCut() {
		return designCut;
	}


	public void setDesignCut(String designCut) {
		this.designCut = designCut;
	}


	public String getString() {
		return string;
	}


	public void setString(String string) {
		this.string = string;
	}


	public String getEyeletColorAndLength() {
		return eyeletColorAndLength;
	}


	public void setEyeletColorAndLength(String eyeletColorAndLength) {
		this.eyeletColorAndLength = eyeletColorAndLength;
	}


	public String getIfOthers() {
		return ifOthers;
	}


	public void setIfOthers(String ifOthers) {
		this.ifOthers = ifOthers;
	}


	public String getHookColorAndLength() {
		return hookColorAndLength;
	}


	public void setHookColorAndLength(String hookColorAndLength) {
		this.hookColorAndLength = hookColorAndLength;
	}


	public String getBoardCost() {
		return boardCost;
	}


	public void setBoardCost(String boardCost) {
		this.boardCost = boardCost;
	}


	public String getBoardWastage() {
		return boardWastage;
	}


	public void setBoardWastage(String boardWastage) {
		this.boardWastage = boardWastage;
	}


	public String getDesignFileName() {
		return designFileName;
	}


	public void setDesignFileName(String designFileName) {
		this.designFileName = designFileName;
	}


	public String getDigitalPrintTag() {
		return digitalPrintTag;
	}


	public void setDigitalPrintTag(String digitalPrintTag) {
		this.digitalPrintTag = digitalPrintTag;
	}


	public String getOffsetPrintTag() {
		return offsetPrintTag;
	}


	public void setOffsetPrintTag(String offsetPrintTag) {
		this.offsetPrintTag = offsetPrintTag;
	}


	public String getFoilTag() {
		return foilTag;
	}


	public void setFoilTag(String foilTag) {
		this.foilTag = foilTag;
	}


	public String getUv() {
		return uv;
	}


	public void setUv(String uv) {
		this.uv = uv;
	}


	public String getEmboss() {
		return emboss;
	}


	public void setEmboss(String emboss) {
		this.emboss = emboss;
	}


	public String getVarnish() {
		return varnish;
	}


	public void setVarnish(String varnish) {
		this.varnish = varnish;
	}


	public String getLamination() {
		return lamination;
	}


	public void setLamination(String lamination) {
		this.lamination = lamination;
	}


	public String getPasting() {
		return pasting;
	}


	public void setPasting(String pasting) {
		this.pasting = pasting;
	}


	public String getDie2() {
		return die2;
	}


	public void setDie2(String die2) {
		this.die2 = die2;
	}


	public String getPlatesize() {
		return platesize;
	}


	public void setPlatesize(String platesize) {
		this.platesize = platesize;
	}


	public String getNoofups() {
		return noofups;
	}


	public void setNoofups(String noofups) {
		this.noofups = noofups;
	}


	public String getUnitSticker() {
		return unitSticker;
	}


	public void setUnitSticker(String unitSticker) {
		this.unitSticker = unitSticker;
	}


	public String getUnitHeightSticker() {
		return unitHeightSticker;
	}


	public void setUnitHeightSticker(String unitHeightSticker) {
		this.unitHeightSticker = unitHeightSticker;
	}


	public String getUnitWidthSticker() {
		return unitWidthSticker;
	}


	public void setUnitWidthSticker(String unitWidthSticker) {
		this.unitWidthSticker = unitWidthSticker;
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


	public String getColorInfoSticker() {
		return colorInfoSticker;
	}


	public void setColorInfoSticker(String colorInfoSticker) {
		this.colorInfoSticker = colorInfoSticker;
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


	public String getOrderTypeSticker() {
		return orderTypeSticker;
	}


	public void setOrderTypeSticker(String orderTypeSticker) {
		this.orderTypeSticker = orderTypeSticker;
	}


	public String getExpectedQuantitySticker() {
		return expectedQuantitySticker;
	}


	public void setExpectedQuantitySticker(String expectedQuantitySticker) {
		this.expectedQuantitySticker = expectedQuantitySticker;
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


	public String getIncomingSticker() {
		return incomingSticker;
	}


	public void setIncomingSticker(String incomingSticker) {
		this.incomingSticker = incomingSticker;
	}


	public String getSamplePDateSticker() {
		return samplePDateSticker;
	}


	public void setSamplePDateSticker(String samplePDateSticker) {
		this.samplePDateSticker = samplePDateSticker;
	}


	public String getExecutiveCodeSticker() {
		return executiveCodeSticker;
	}


	public void setExecutiveCodeSticker(String executiveCodeSticker) {
		this.executiveCodeSticker = executiveCodeSticker;
	}


	public String getManagerSticker() {
		return managerSticker;
	}


	public void setManagerSticker(String managerSticker) {
		this.managerSticker = managerSticker;
	}


	public String getDateTimeSticker() {
		return dateTimeSticker;
	}


	public void setDateTimeSticker(String dateTimeSticker) {
		this.dateTimeSticker = dateTimeSticker;
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


	public String[] getInkNameTable() {
		return inkNameTable;
	}


	public void setInkNameTable(String[] inkNameTable) {
		this.inkNameTable = inkNameTable;
	}


	public String getPlatesizeSticker() {
		return platesizeSticker;
	}


	public void setPlatesizeSticker(String platesizeSticker) {
		this.platesizeSticker = platesizeSticker;
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
		return colorOptionToBeUsed;
	}


	public void setColorOptionToBeUsed(String colorOptionToBeUsed) {
		this.colorOptionToBeUsed = colorOptionToBeUsed;
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


	public String getColorpicks() {
		return colorpicks;
	}


	public void setColorpicks(String colorpicks) {
		this.colorpicks = colorpicks;
	}


	public String[] getColorOptionTable() {
		return colorOptionTable;
	}


	public void setColorOptionTable(String[] colorOptionTable) {
		this.colorOptionTable = colorOptionTable;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMerchandiser() {
		return merchandiser;
	}

	public void setMerchandiser(String merchandiser) {
		this.merchandiser = merchandiser;
	}
}

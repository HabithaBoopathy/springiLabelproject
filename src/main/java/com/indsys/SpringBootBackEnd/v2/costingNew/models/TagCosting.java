package com.indsys.SpringBootBackEnd.v2.costingNew.models;

import com.indsys.SpringBootBackEnd.models.Mpaper;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

class BaseDetails{
    private double runBoardLength;
    private double runBoardWidth;
    private double gumArea1;
    private double gumArea2;
    private double pastingArea1;
    private double pastingArea2;

    public double getRunBoardLength() {
        return runBoardLength;
    }

    public void setRunBoardLength(double runBoardLength) {
        this.runBoardLength = runBoardLength;
    }

    public double getRunBoardWidth() {
        return runBoardWidth;
    }

    public void setRunBoardWidth(double runBoardWidth) {
        this.runBoardWidth = runBoardWidth;
    }

    public double getGumArea1() {
        return gumArea1;
    }

    public void setGumArea1(double gumArea1) {
        this.gumArea1 = gumArea1;
    }

    public double getGumArea2() {
        return gumArea2;
    }

    public void setGumArea2(double gumArea2) {
        this.gumArea2 = gumArea2;
    }

    public double getPastingArea1() {
        return pastingArea1;
    }

    public void setPastingArea1(double pastingArea1) {
        this.pastingArea1 = pastingArea1;
    }

    public double getPastingArea2() {
        return pastingArea2;
    }

    public void setPastingArea2(double pastingArea2) {
        this.pastingArea2 = pastingArea2;
    }
}

class Type1{
    private double value;
    private double rate;
    private double quantity;
    private double cost;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}

class Type2{
    private double rate;
    private double quantity;
    private double cost;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}

class CostingDetails{
    private double designAndProofCost;
    private double adminCharge;
    private double paper1Quantity;
    private double paper1Cost;
    private double paper2Quantity;
    private double paper2Cost;
    private Type2 plate;
    private String plateMachineId;
    private Type1 ink;
    private double inkCopies;
    private Type2 screen;
    private Type1 die;
    private Type1 foilBlock;
    private Type1 emboBlock;
    private Type1 screenPrint;
    private Type2 offsetPrint;
    private String offsetPrintMachineId;
    private Type1 gumming;
    private Type1 pasting;
    private Type1 lamination;
    private Type1 uv;
    private Type1 foil;
    private Type1 varnish;
    private Type1 aquasCoating;
    private Type1 embossOrDeboss;
    private Type1 punching;
    private Type1 cutting;
    private Type1 pOrF;
    private Type1 digital;
    private Type1 stringOrJute;
    private Type1 eyelet;
    private Type1 knurling;
    private Type1 film;
    private Type1 scoring;
    private double rawMaterialCost;
    private double rawMaterialRatePerPiece;
    private double cost;
    private double profitPercentage;
    private double profit;
    private double deliveryCost;
    private double totalCost;
    private double ratePerPiece;

    public double getDesignAndProofCost() {
        return designAndProofCost;
    }

    public void setDesignAndProofCost(double designAndProofCost) {
        this.designAndProofCost = designAndProofCost;
    }

    public double getAdminCharge() {
        return adminCharge;
    }

    public void setAdminCharge(double adminCharge) {
        this.adminCharge = adminCharge;
    }

    public double getPaper1Quantity() {
        return paper1Quantity;
    }

    public void setPaper1Quantity(double paper1Quantity) {
        this.paper1Quantity = paper1Quantity;
    }

    public double getPaper1Cost() {
        return paper1Cost;
    }

    public void setPaper1Cost(double paper1Cost) {
        this.paper1Cost = paper1Cost;
    }

    public double getPaper2Quantity() {
        return paper2Quantity;
    }

    public void setPaper2Quantity(double paper2Quantity) {
        this.paper2Quantity = paper2Quantity;
    }

    public double getPaper2Cost() {
        return paper2Cost;
    }

    public void setPaper2Cost(double paper2Cost) {
        this.paper2Cost = paper2Cost;
    }

    public Type2 getPlate() {
        return plate;
    }

    public void setPlate(Type2 plate) {
        this.plate = plate;
    }

    public String getPlateMachineId() {
        return plateMachineId;
    }

    public void setPlateMachineId(String plateMachineId) {
        this.plateMachineId = plateMachineId;
    }

    public Type1 getInk() {
        return ink;
    }

    public void setInk(Type1 ink) {
        this.ink = ink;
    }

    public double getInkCopies() {
        return inkCopies;
    }

    public void setInkCopies(double inkCopies) {
        this.inkCopies = inkCopies;
    }

    public Type2 getScreen() {
        return screen;
    }

    public void setScreen(Type2 screen) {
        this.screen = screen;
    }

    public Type1 getDie() {
        return die;
    }

    public void setDie(Type1 die) {
        this.die = die;
    }

    public Type1 getFoilBlock() {
        return foilBlock;
    }

    public void setFoilBlock(Type1 foilBlock) {
        this.foilBlock = foilBlock;
    }

    public Type1 getEmboBlock() {
        return emboBlock;
    }

    public void setEmboBlock(Type1 emboBlock) {
        this.emboBlock = emboBlock;
    }

    public Type1 getScreenPrint() {
        return screenPrint;
    }

    public void setScreenPrint(Type1 screenPrint) {
        this.screenPrint = screenPrint;
    }

    public Type2 getOffsetPrint() {
        return offsetPrint;
    }

    public void setOffsetPrint(Type2 offsetPrint) {
        this.offsetPrint = offsetPrint;
    }

    public String getOffsetPrintMachineId() {
        return offsetPrintMachineId;
    }

    public void setOffsetPrintMachineId(String offsetPrintMachineId) {
        this.offsetPrintMachineId = offsetPrintMachineId;
    }

    public Type1 getGumming() {
        return gumming;
    }

    public void setGumming(Type1 gumming) {
        this.gumming = gumming;
    }

    public Type1 getPasting() {
        return pasting;
    }

    public void setPasting(Type1 pasting) {
        this.pasting = pasting;
    }

    public Type1 getLamination() {
        return lamination;
    }

    public void setLamination(Type1 lamination) {
        this.lamination = lamination;
    }

    public Type1 getUv() {
        return uv;
    }

    public void setUv(Type1 uv) {
        this.uv = uv;
    }

    public Type1 getFoil() {
        return foil;
    }

    public void setFoil(Type1 foil) {
        this.foil = foil;
    }

    public Type1 getVarnish() {
        return varnish;
    }

    public void setVarnish(Type1 varnish) {
        this.varnish = varnish;
    }

    public Type1 getAquasCoating() {
        return aquasCoating;
    }

    public void setAquasCoating(Type1 aquasCoating) {
        this.aquasCoating = aquasCoating;
    }

    public Type1 getEmbossOrDeboss() {
        return embossOrDeboss;
    }

    public void setEmbossOrDeboss(Type1 embossOrDeboss) {
        this.embossOrDeboss = embossOrDeboss;
    }

    public Type1 getPunching() {
        return punching;
    }

    public void setPunching(Type1 punching) {
        this.punching = punching;
    }

    public Type1 getCutting() {
        return cutting;
    }

    public void setCutting(Type1 cutting) {
        this.cutting = cutting;
    }

    public Type1 getpOrF() {
        return pOrF;
    }

    public void setpOrF(Type1 pOrF) {
        this.pOrF = pOrF;
    }

    public Type1 getDigital() {
        return digital;
    }

    public void setDigital(Type1 digital) {
        this.digital = digital;
    }

    public Type1 getStringOrJute() {
        return stringOrJute;
    }

    public void setStringOrJute(Type1 stringOrJute) {
        this.stringOrJute = stringOrJute;
    }

    public Type1 getEyelet() {
        return eyelet;
    }

    public void setEyelet(Type1 eyelet) {
        this.eyelet = eyelet;
    }

    public Type1 getKnurling() {
        return knurling;
    }

    public void setKnurling(Type1 knurling) {
        this.knurling = knurling;
    }

    public Type1 getFilm() {
        return film;
    }

    public void setFilm(Type1 film) {
        this.film = film;
    }

    public Type1 getScoring() {
        return scoring;
    }

    public void setScoring(Type1 scoring) {
        this.scoring = scoring;
    }

    public double getRawMaterialCost() {
        return rawMaterialCost;
    }

    public void setRawMaterialCost(double rawMaterialCost) {
        this.rawMaterialCost = rawMaterialCost;
    }

    public double getRawMaterialRatePerPiece() {
        return rawMaterialRatePerPiece;
    }

    public void setRawMaterialRatePerPiece(double rawMaterialRatePerPiece) {
        this.rawMaterialRatePerPiece = rawMaterialRatePerPiece;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getProfitPercentage() {
        return profitPercentage;
    }

    public void setProfitPercentage(double profitPercentage) {
        this.profitPercentage = profitPercentage;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(double deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }

    public void setRatePerPiece(double ratePerPiece) {
        this.ratePerPiece = ratePerPiece;
    }
}

@Document(collection = "MTagCosting")
public class TagCosting {

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

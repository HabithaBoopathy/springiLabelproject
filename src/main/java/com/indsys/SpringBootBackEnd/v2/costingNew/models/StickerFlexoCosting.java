package com.indsys.SpringBootBackEnd.v2.costingNew.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

class Costing{
    private double cost;
    private double description;
    private double unitRate;
    private double totalRate;

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getDescription() {
        return description;
    }

    public void setDescription(double description) {
        this.description = description;
    }

    public double getUnitRate() {
        return unitRate;
    }

    public void setUnitRate(double unitRate) {
        this.unitRate = unitRate;
    }

    public double getTotalRate() {
        return totalRate;
    }

    public void setTotalRate(double totalRate) {
        this.totalRate = totalRate;
    }
}

@Document(collection = "MStickerFlexoCosting")
public class StickerFlexoCosting {

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
    private String stickerName;
    private String attachmentExtension;
    private String jobNo;
    private double printingQuantity;

    private double stickerLength;
    private double stickerWidth;
    private String stickerShape;
    private double noOfColors;
    private String materialId;
    private double materialPrice;
    private String remarks;
    private String shRemarks;

    private double reelWidth;
    private double acrossUps;
    private double repeatLength;
    private double aroundUps;
    private double totalPCSPerRepeat;
    private double requiredMeter;
    private double requiredSquareMeter;

    private Costing artWorkHrs;
    private Costing proofReadingHrs;
    private Costing die;
    private Costing plate;
    private Costing requiredSquareMeter1;
    private Costing requiredSquareMeter2;
    private Costing rollChangeWaste;
    private Costing ink;
    private Costing printingMachineHours;
    private Costing digital;
    private Costing rhyguanSlitting;
    private Costing foil;
    private Costing laminationAdhesive;
    private Costing lamination;
    private Costing dieCutting;
    private Costing packing;
    private Costing admin;

    private double cost;
    private double totalCost;
    private double profitPercentage;
    private double profit;
    private double ratePerPcs;

    private SlabRates[] slabRates;
    private double deliveryCost;
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

    public String getStickerName() {
        return stickerName;
    }

    public void setStickerName(String stickerName) {
        this.stickerName = stickerName;
    }

    public String getAttachmentExtension() {
        return attachmentExtension;
    }

    public void setAttachmentExtension(String attachmentExtension) {
        this.attachmentExtension = attachmentExtension;
    }

    public String getJobNo() {
        return jobNo;
    }

    public void setJobNo(String jobNo) {
        this.jobNo = jobNo;
    }

    public double getPrintingQuantity() {
        return printingQuantity;
    }

    public void setPrintingQuantity(double printingQuantity) {
        this.printingQuantity = printingQuantity;
    }

    public double getStickerLength() {
        return stickerLength;
    }

    public void setStickerLength(double stickerLength) {
        this.stickerLength = stickerLength;
    }

    public double getStickerWidth() {
        return stickerWidth;
    }

    public void setStickerWidth(double stickerWidth) {
        this.stickerWidth = stickerWidth;
    }

    public String getStickerShape() {
        return stickerShape;
    }

    public void setStickerShape(String stickerShape) {
        this.stickerShape = stickerShape;
    }

    public double getNoOfColors() {
        return noOfColors;
    }

    public void setNoOfColors(double noOfColors) {
        this.noOfColors = noOfColors;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public double getMaterialPrice() {
        return materialPrice;
    }

    public void setMaterialPrice(double materialPrice) {
        this.materialPrice = materialPrice;
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

    public double getReelWidth() {
        return reelWidth;
    }

    public void setReelWidth(double reelWidth) {
        this.reelWidth = reelWidth;
    }

    public double getAcrossUps() {
        return acrossUps;
    }

    public void setAcrossUps(double acrossUps) {
        this.acrossUps = acrossUps;
    }

    public double getRepeatLength() {
        return repeatLength;
    }

    public void setRepeatLength(double repeatLength) {
        this.repeatLength = repeatLength;
    }

    public double getAroundUps() {
        return aroundUps;
    }

    public void setAroundUps(double aroundUps) {
        this.aroundUps = aroundUps;
    }

    public double getTotalPCSPerRepeat() {
        return totalPCSPerRepeat;
    }

    public void setTotalPCSPerRepeat(double totalPCSPerRepeat) {
        this.totalPCSPerRepeat = totalPCSPerRepeat;
    }

    public double getRequiredMeter() {
        return requiredMeter;
    }

    public void setRequiredMeter(double requiredMeter) {
        this.requiredMeter = requiredMeter;
    }

    public double getRequiredSquareMeter() {
        return requiredSquareMeter;
    }

    public void setRequiredSquareMeter(double requiredSquareMeter) {
        this.requiredSquareMeter = requiredSquareMeter;
    }

    public Costing getArtWorkHrs() {
        return artWorkHrs;
    }

    public void setArtWorkHrs(Costing artWorkHrs) {
        this.artWorkHrs = artWorkHrs;
    }

    public Costing getProofReadingHrs() {
        return proofReadingHrs;
    }

    public void setProofReadingHrs(Costing proofReadingHrs) {
        this.proofReadingHrs = proofReadingHrs;
    }

    public Costing getDie() {
        return die;
    }

    public void setDie(Costing die) {
        this.die = die;
    }

    public Costing getPlate() {
        return plate;
    }

    public void setPlate(Costing plate) {
        this.plate = plate;
    }

    public Costing getRequiredSquareMeter1() {
        return requiredSquareMeter1;
    }

    public void setRequiredSquareMeter1(Costing requiredSquareMeter1) {
        this.requiredSquareMeter1 = requiredSquareMeter1;
    }

    public Costing getRequiredSquareMeter2() {
        return requiredSquareMeter2;
    }

    public void setRequiredSquareMeter2(Costing requiredSquareMeter2) {
        this.requiredSquareMeter2 = requiredSquareMeter2;
    }

    public Costing getRollChangeWaste() {
        return rollChangeWaste;
    }

    public void setRollChangeWaste(Costing rollChangeWaste) {
        this.rollChangeWaste = rollChangeWaste;
    }

    public Costing getInk() {
        return ink;
    }

    public void setInk(Costing ink) {
        this.ink = ink;
    }

    public Costing getPrintingMachineHours() {
        return printingMachineHours;
    }

    public void setPrintingMachineHours(Costing printingMachineHours) {
        this.printingMachineHours = printingMachineHours;
    }

    public Costing getDigital() {
        return digital;
    }

    public void setDigital(Costing digital) {
        this.digital = digital;
    }

    public Costing getRhyguanSlitting() {
        return rhyguanSlitting;
    }

    public void setRhyguanSlitting(Costing rhyguanSlitting) {
        this.rhyguanSlitting = rhyguanSlitting;
    }

    public Costing getFoil() {
        return foil;
    }

    public void setFoil(Costing foil) {
        this.foil = foil;
    }

    public Costing getLaminationAdhesive() {
        return laminationAdhesive;
    }

    public void setLaminationAdhesive(Costing laminationAdhesive) {
        this.laminationAdhesive = laminationAdhesive;
    }

    public Costing getLamination() {
        return lamination;
    }

    public void setLamination(Costing lamination) {
        this.lamination = lamination;
    }

    public Costing getDieCutting() {
        return dieCutting;
    }

    public void setDieCutting(Costing dieCutting) {
        this.dieCutting = dieCutting;
    }

    public Costing getPacking() {
        return packing;
    }

    public void setPacking(Costing packing) {
        this.packing = packing;
    }

    public Costing getAdmin() {
        return admin;
    }

    public void setAdmin(Costing admin) {
        this.admin = admin;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
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

    public double getRatePerPcs() {
        return ratePerPcs;
    }

    public void setRatePerPcs(double ratePerPcs) {
        this.ratePerPcs = ratePerPcs;
    }

    public SlabRates[] getSlabRates() {
        return slabRates;
    }

    public void setSlabRates(SlabRates[] slabRates) {
        this.slabRates = slabRates;
    }

    public double getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(double deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public String getCustomerRejectedReason() {
        return customerRejectedReason;
    }

    public void setCustomerRejectedReason(String customerRejectedReason) {
        this.customerRejectedReason = customerRejectedReason;
    }
}

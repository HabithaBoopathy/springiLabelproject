package com.indsys.SpringBootBackEnd.models.orderForms;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CostingSheet")
public class CostingSheet {

    @Id
    private String id;

    @Indexed(unique = true)
    private String orderId;

    //rawMaterialCost
    private String boardName;
    private String boardSize;
    private float gsm;
    private double boardRate;
    private double inks;
    private double otherRawMaterialCost;
    private double upsBoard;
    private double boardCost;
    private double totalRawMaterialCost;

    //wokCenterCost
    private double printing;
    private double varnish;
    private double lamination;
    private double pasting;
    private double dieCut;
    private double packing;
    private double boardCutting;
    private double sidePasting;
    private double totalProcessingCost;

    //finalCost
    private double adminCharges;
    private double courierDeliveryCharges;
    private double sumOfCosts;
    private double margin;
    private double marginAmount;
    private double totalFinalCost;

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

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public String getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(String boardSize) {
        this.boardSize = boardSize;
    }

    public float getGsm() {
        return gsm;
    }

    public void setGsm(float gsm) {
        this.gsm = gsm;
    }

    public double getBoardRate() {
        return boardRate;
    }

    public void setBoardRate(double boardRate) {
        this.boardRate = boardRate;
    }

    public double getInks() {
        return inks;
    }

    public void setInks(double inks) {
        this.inks = inks;
    }

    public double getOtherRawMaterialCost() {
        return otherRawMaterialCost;
    }

    public void setOtherRawMaterialCost(double otherRawMaterialCost) {
        this.otherRawMaterialCost = otherRawMaterialCost;
    }

    public double getUpsBoard() {
        return upsBoard;
    }

    public void setUpsBoard(double upsBoard) {
        this.upsBoard = upsBoard;
    }

    public double getBoardCost() {
        return boardCost;
    }

    public void setBoardCost(double boardCost) {
        this.boardCost = boardCost;
    }

    public double getTotalRawMaterialCost() {
        return totalRawMaterialCost;
    }

    public void setTotalRawMaterialCost(double totalRawMaterialCost) {
        this.totalRawMaterialCost = totalRawMaterialCost;
    }

    public double getPrinting() {
        return printing;
    }

    public void setPrinting(double printing) {
        this.printing = printing;
    }

    public double getVarnish() {
        return varnish;
    }

    public void setVarnish(double varnish) {
        this.varnish = varnish;
    }

    public double getLamination() {
        return lamination;
    }

    public void setLamination(double lamination) {
        this.lamination = lamination;
    }

    public double getPasting() {
        return pasting;
    }

    public void setPasting(double pasting) {
        this.pasting = pasting;
    }

    public double getDieCut() {
        return dieCut;
    }

    public void setDieCut(double dieCut) {
        this.dieCut = dieCut;
    }

    public double getPacking() {
        return packing;
    }

    public void setPacking(double packing) {
        this.packing = packing;
    }

    public double getBoardCutting() {
        return boardCutting;
    }

    public void setBoardCutting(double boardCutting) {
        this.boardCutting = boardCutting;
    }

    public double getSidePasting() {
        return sidePasting;
    }

    public void setSidePasting(double sidePasting) {
        this.sidePasting = sidePasting;
    }

    public double getTotalProcessingCost() {
        return totalProcessingCost;
    }

    public void setTotalProcessingCost(double totalProcessingCost) {
        this.totalProcessingCost = totalProcessingCost;
    }

    public double getAdminCharges() {
        return adminCharges;
    }

    public void setAdminCharges(double adminCharges) {
        this.adminCharges = adminCharges;
    }

    public double getCourierDeliveryCharges() {
        return courierDeliveryCharges;
    }

    public void setCourierDeliveryCharges(double courierDeliveryCharges) {
        this.courierDeliveryCharges = courierDeliveryCharges;
    }

    public double getSumOfCosts() {
        return sumOfCosts;
    }

    public void setSumOfCosts(double sumOfCosts) {
        this.sumOfCosts = sumOfCosts;
    }

    public double getMargin() {
        return margin;
    }

    public void setMargin(double margin) {
        this.margin = margin;
    }

    public double getMarginAmount() {
        return marginAmount;
    }

    public void setMarginAmount(double marginAmount) {
        this.marginAmount = marginAmount;
    }

    public double getTotalFinalCost() {
        return totalFinalCost;
    }

    public void setTotalFinalCost(double totalFinalCost) {
        this.totalFinalCost = totalFinalCost;
    }
}

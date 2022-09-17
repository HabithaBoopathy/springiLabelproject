package com.indsys.SpringBootBackEnd.v2.costingNew.models;

public class VariableCostsPrinted {
    private double plateCost;
    private double inkCost;
    private double cuttingCost;
    private double productionCost;
    private double qcAndPackingCost;
    private double adminCost;
    private double margin;

    public double getPlateCost() {
        return plateCost;
    }

    public void setPlateCost(double plateCost) {
        this.plateCost = plateCost;
    }

    public double getInkCost() {
        return inkCost;
    }

    public void setInkCost(double inkCost) {
        this.inkCost = inkCost;
    }

    public double getCuttingCost() {
        return cuttingCost;
    }

    public void setCuttingCost(double cuttingCost) {
        this.cuttingCost = cuttingCost;
    }

    public double getProductionCost() {
        return productionCost;
    }

    public void setProductionCost(double productionCost) {
        this.productionCost = productionCost;
    }

    public double getQcAndPackingCost() {
        return qcAndPackingCost;
    }

    public void setQcAndPackingCost(double qcAndPackingCost) {
        this.qcAndPackingCost = qcAndPackingCost;
    }

    public double getAdminCost() {
        return adminCost;
    }

    public void setAdminCost(double adminCost) {
        this.adminCost = adminCost;
    }

    public double getMargin() {
        return margin;
    }

    public void setMargin(double margin) {
        this.margin = margin;
    }
}

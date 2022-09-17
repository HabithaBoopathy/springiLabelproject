package com.indsys.SpringBootBackEnd.models.orderForms;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "TagOrderForm")
public class Tag {


    @Id
    private String Tid;
    private String unitHeight;
    private String unitWidth;
    private String tagDevType;
    private String documentType;
    private String colorInfo;
    private String runningBoardSize;
    private String nameOfTheBoard;
    private String boardSpecification;
    private String quality;
    private String boardGSM;
    private String fsc;
    private String printType;
    private String color;
    private String orderType;
    private String expectedQuantity;
    private String status;
    private String finishing;
    private String expectedDate;
    private String folding;
    private String approval;
    private String comments;
    private String noOfPlates;
    private String negativePositive;
    private String foilEmbossScreen;
    private String die;
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
    private String digitalPrint;
    private String offsetPrint;
    private String foil;
    private String uv;
    private String emboss;
    private String varnish;
    private String lamination;
    private String pasting;
    private String die2;
    private String platesize;

    public String getTid() {
        return Tid;
    }

    public void setTid(String tid) {
        Tid = tid;
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

    public String getTagDevType() {
        return tagDevType;
    }

    public void setTagDevType(String tagDevType) {
        this.tagDevType = tagDevType;
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

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
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

    public String getPrintType() {
        return printType;
    }

    public void setPrintType(String printType) {
        this.printType = printType;
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

    public String getExpectedQuantity() {
        return expectedQuantity;
    }

    public void setExpectedQuantity(String expectedQuantity) {
        this.expectedQuantity = expectedQuantity;
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

    public String getApproval() {
        return approval;
    }

    public void setApproval(String approval) {
        this.approval = approval;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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

    public String getDie() {
        return die;
    }

    public void setDie(String die) {
        this.die = die;
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

    public String getDigitalPrint() {
        return digitalPrint;
    }

    public void setDigitalPrint(String digitalPrint) {
        this.digitalPrint = digitalPrint;
    }

    public String getOffsetPrint() {
        return offsetPrint;
    }

    public void setOffsetPrint(String offsetPrint) {
        this.offsetPrint = offsetPrint;
    }

    public String getFoil() {
        return foil;
    }

    public void setFoil(String foil) {
        this.foil = foil;
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

    public Tag(String tid, String unitHeight, String unitWidth, String tagDevType, String documentType,
            String colorInfo, String runningBoardSize, String nameOfTheBoard, String boardSpecification, String quality,
            String boardGSM, String fsc, String printType, String color, String orderType, String expectedQuantity,
            String status, String finishing, String expectedDate, String folding, String approval, String comments,
            String noOfPlates, String negativePositive, String foilEmbossScreen, String die, String printColorMatching,
            String foilFace, String foilReverse, String foilColor, String uvFace, String uvReverse,
            String uvNoOfScreens, String vMatt, String vGloss, String vFace, String vReverse, String vOthers,
            String lMatt, String lGloss, String lFace, String lReverse, String lOthers, String straightCut,
            String holeSize, String perforation, String creasing, String designCut, String string,
            String eyeletColorAndLength, String ifOthers, String hookColorAndLength, String boardCost,
            String boardWastage, String designFileName, String digitalPrint, String offsetPrint, String foil, String uv,
            String emboss, String varnish, String lamination, String pasting, String die2, String platesize) {
        Tid = tid;
        this.unitHeight = unitHeight;
        this.unitWidth = unitWidth;
        this.tagDevType = tagDevType;
        this.documentType = documentType;
        this.colorInfo = colorInfo;
        this.runningBoardSize = runningBoardSize;
        this.nameOfTheBoard = nameOfTheBoard;
        this.boardSpecification = boardSpecification;
        this.quality = quality;
        this.boardGSM = boardGSM;
        this.fsc = fsc;
        this.printType = printType;
        this.color = color;
        this.orderType = orderType;
        this.expectedQuantity = expectedQuantity;
        this.status = status;
        this.finishing = finishing;
        this.expectedDate = expectedDate;
        this.folding = folding;
        this.approval = approval;
        this.comments = comments;
        this.noOfPlates = noOfPlates;
        this.negativePositive = negativePositive;
        this.foilEmbossScreen = foilEmbossScreen;
        this.die = die;
        this.printColorMatching = printColorMatching;
        this.foilFace = foilFace;
        this.foilReverse = foilReverse;
        this.foilColor = foilColor;
        this.uvFace = uvFace;
        this.uvReverse = uvReverse;
        this.uvNoOfScreens = uvNoOfScreens;
        this.vMatt = vMatt;
        this.vGloss = vGloss;
        this.vFace = vFace;
        this.vReverse = vReverse;
        this.vOthers = vOthers;
        this.lMatt = lMatt;
        this.lGloss = lGloss;
        this.lFace = lFace;
        this.lReverse = lReverse;
        this.lOthers = lOthers;
        this.straightCut = straightCut;
        this.holeSize = holeSize;
        this.perforation = perforation;
        this.creasing = creasing;
        this.designCut = designCut;
        this.string = string;
        this.eyeletColorAndLength = eyeletColorAndLength;
        this.ifOthers = ifOthers;
        this.hookColorAndLength = hookColorAndLength;
        this.boardCost = boardCost;
        this.boardWastage = boardWastage;
        this.designFileName = designFileName;
        this.digitalPrint = digitalPrint;
        this.offsetPrint = offsetPrint;
        this.foil = foil;
        this.uv = uv;
        this.emboss = emboss;
        this.varnish = varnish;
        this.lamination = lamination;
        this.pasting = pasting;
        this.die2 = die2;
        this.platesize = platesize;
    }

    @Override
    public String toString() {
        return "Tag [Tid=" + Tid + ", approval=" + approval + ", boardCost=" + boardCost + ", boardGSM=" + boardGSM
                + ", boardSpecification=" + boardSpecification + ", boardWastage=" + boardWastage + ", color=" + color
                + ", colorInfo=" + colorInfo + ", comments=" + comments + ", creasing=" + creasing + ", designCut="
                + designCut + ", designFileName=" + designFileName + ", die=" + die + ", die2=" + die2
                + ", digitalPrint=" + digitalPrint + ", documentType=" + documentType + ", emboss=" + emboss
                + ", expectedDate=" + expectedDate + ", expectedQuantity=" + expectedQuantity
                + ", eyeletColorAndLength=" + eyeletColorAndLength + ", finishing=" + finishing + ", foil=" + foil
                + ", foilColor=" + foilColor + ", foilEmbossScreen=" + foilEmbossScreen + ", foilFace=" + foilFace
                + ", foilReverse=" + foilReverse + ", folding=" + folding + ", fsc=" + fsc + ", holeSize=" + holeSize
                + ", hookColorAndLength=" + hookColorAndLength + ", ifOthers=" + ifOthers + ", lFace=" + lFace
                + ", lGloss=" + lGloss + ", lMatt=" + lMatt + ", lOthers=" + lOthers + ", lReverse=" + lReverse
                + ", lamination=" + lamination + ", nameOfTheBoard=" + nameOfTheBoard + ", negativePositive="
                + negativePositive + ", noOfPlates=" + noOfPlates + ", offsetPrint=" + offsetPrint + ", orderType="
                + orderType + ", pasting=" + pasting + ", perforation=" + perforation + ", platesize=" + platesize
                + ", printColorMatching=" + printColorMatching + ", printType=" + printType + ", quality=" + quality
                + ", runningBoardSize=" + runningBoardSize + ", status=" + status + ", straightCut=" + straightCut
                + ", string=" + string + ", tagDevType=" + tagDevType + ", unitHeight=" + unitHeight + ", unitWidth="
                + unitWidth + ", uv=" + uv + ", uvFace=" + uvFace + ", uvNoOfScreens=" + uvNoOfScreens + ", uvReverse="
                + uvReverse + ", vFace=" + vFace + ", vGloss=" + vGloss + ", vMatt=" + vMatt + ", vOthers=" + vOthers
                + ", vReverse=" + vReverse + ", varnish=" + varnish + "]";
    }



    




}
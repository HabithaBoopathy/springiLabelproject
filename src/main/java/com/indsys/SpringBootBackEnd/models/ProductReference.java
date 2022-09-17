package com.indsys.SpringBootBackEnd.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "ProductReference")
public class ProductReference {

    @Id
    private String id;

    private String printcolorname;
    private String tagcolorname;
    private String stickercolorname;
    private String wovencolorname;


    private String printreferencenumber;
    private String tagreferencenumber;
    private String stickerreferencenumber;
    private String wovenreferencenumber;

    private int printNum;
    private int tagNum;
    private int stickerNum;
    private int wovenNum;

    private String printnext;
    private String tagnext;
    private String stickernext;
    private String wovennext;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrintcolorname() {
        return printcolorname;
    }

    public void setPrintcolorname(String printcolorname) {
        this.printcolorname = printcolorname;
    }

    public String getTagcolorname() {
        return tagcolorname;
    }

    public void setTagcolorname(String tagcolorname) {
        this.tagcolorname = tagcolorname;
    }

    public String getStickercolorname() {
        return stickercolorname;
    }

    public void setStickercolorname(String stickercolorname) {
        this.stickercolorname = stickercolorname;
    }

    public String getWovencolorname() {
        return wovencolorname;
    }

    public void setWovencolorname(String wovencolorname) {
        this.wovencolorname = wovencolorname;
    }

    public String getPrintreferencenumber() {
        return printreferencenumber;
    }

    public void setPrintreferencenumber(String printreferencenumber) {
        this.printreferencenumber = printreferencenumber;
    }

    public String getTagreferencenumber() {
        return tagreferencenumber;
    }

    public void setTagreferencenumber(String tagreferencenumber) {
        this.tagreferencenumber = tagreferencenumber;
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

    public int getPrintNum() {
        return printNum;
    }

    public void setPrintNum(int printNum) {
        this.printNum = printNum;
    }

    public int getTagNum() {
        return tagNum;
    }

    public void setTagNum(int tagNum) {
        this.tagNum = tagNum;
    }

    public int getStickerNum() {
        return stickerNum;
    }

    public void setStickerNum(int stickerNum) {
        this.stickerNum = stickerNum;
    }

    public int getWovenNum() {
        return wovenNum;
    }

    public void setWovenNum(int wovenNum) {
        this.wovenNum = wovenNum;
    }

    public String getPrintnext() {
        return printnext;
    }

    public void setPrintnext(String printnext) {
        this.printnext = printnext;
    }

    public String getTagnext() {
        return tagnext;
    }

    public void setTagnext(String tagnext) {
        this.tagnext = tagnext;
    }

    public String getStickernext() {
        return stickernext;
    }

    public void setStickernext(String stickernext) {
        this.stickernext = stickernext;
    }

    public String getWovennext() {
        return wovennext;
    }

    public void setWovennext(String wovennext) {
        this.wovennext = wovennext;
    }

    public ProductReference(String id, String printcolorname, String tagcolorname, String stickercolorname,
            String wovencolorname, String printreferencenumber, String tagreferencenumber,
            String stickerreferencenumber, String wovenreferencenumber, String printnext, String tagnext,
            String stickernext, String wovennext) {
        this.id = id;
        this.printcolorname = printcolorname;
        this.tagcolorname = tagcolorname;
        this.stickercolorname = stickercolorname;
        this.wovencolorname = wovencolorname;
        this.printreferencenumber = printreferencenumber;
        this.tagreferencenumber = tagreferencenumber;
        this.stickerreferencenumber = stickerreferencenumber;
        this.wovenreferencenumber = wovenreferencenumber;
        this.printnext = printnext;
        this.tagnext = tagnext;
        this.stickernext = stickernext;
        this.wovennext = wovennext;
    }
    
    
   
}

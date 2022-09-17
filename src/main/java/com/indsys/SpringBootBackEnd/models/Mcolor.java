package com.indsys.SpringBootBackEnd.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "MColor")
public class Mcolor {

    @Id
    private String id;

    private String colorname;
    private String printed;
    private String sticker;
    private String tag;
    private String woven;

    public Mcolor(String id, String colorname, String printed, String sticker, String tag, String woven) {
        this.id = id;
        this.colorname = colorname;
        this.printed = printed;
        this.sticker = sticker;
        this.tag = tag;
        this.woven = woven;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColorname() {
        return colorname;
    }

    public void setColorname(String colorname) {
        this.colorname = colorname;
    }

    public String getPrinted() {
        return printed;
    }

    public void setPrinted(String printed) {
        this.printed = printed;
    }

    public String getSticker() {
        return sticker;
    }

    public void setSticker(String sticker) {
        this.sticker = sticker;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getWoven() {
        return woven;
    }

    public void setWoven(String woven) {
        this.woven = woven;
    }

    @Override
    public String toString() {
        return "Mcolor [colorname=" + colorname + ", id=" + id + ", printed=" + printed + ", sticker=" + sticker
                + ", tag=" + tag + ", woven=" + woven + "]";
    }

   
}

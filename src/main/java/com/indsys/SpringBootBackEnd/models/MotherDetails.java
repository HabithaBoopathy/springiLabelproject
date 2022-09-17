package com.indsys.SpringBootBackEnd.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "OtherDetails")
public class MotherDetails {

    @Id
    private String id;

    private String name;
    private String otherdetails;
    private String printed;
    private String sticker;
    private String tag;
    private String woven;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOtherdetails() {
        return otherdetails;
    }

    public void setOtherdetails(String otherdetails) {
        this.otherdetails = otherdetails;
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

    public MotherDetails(String id, String name, String otherdetails, String printed, String sticker, String tag,
            String woven) {
        this.id = id;
        this.name = name;
        this.otherdetails = otherdetails;
        this.printed = printed;
        this.sticker = sticker;
        this.tag = tag;
        this.woven = woven;
    }

    @Override
    public String toString() {
        return "MotherDetails [id=" + id + ", name=" + name + ", otherdetails=" + otherdetails + ", printed=" + printed
                + ", sticker=" + sticker + ", tag=" + tag + ", woven=" + woven + "]";
    }
   
    
}

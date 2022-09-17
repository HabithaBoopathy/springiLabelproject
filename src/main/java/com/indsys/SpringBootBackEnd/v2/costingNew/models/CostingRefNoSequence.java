package com.indsys.SpringBootBackEnd.v2.costingNew.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "MCostingRefNoSequence")
public class CostingRefNoSequence {

    @Id
    private String id;

    private int woven;
    private int tag;
    private int stickerFlexo;
    private int printed;
    private int stickerOffset;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getWoven() {
        return woven;
    }

    public void setWoven(int woven) {
        this.woven = woven;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public int getStickerFlexo() {
        return stickerFlexo;
    }

    public void setStickerFlexo(int stickerFlexo) {
        this.stickerFlexo = stickerFlexo;
    }

    public int getPrinted() {
        return printed;
    }

    public void setPrinted(int printed) {
        this.printed = printed;
    }

    public int getStickerOffset() {
        return stickerOffset;
    }

    public void setStickerOffset(int stickerOffset) {
        this.stickerOffset = stickerOffset;
    }
}

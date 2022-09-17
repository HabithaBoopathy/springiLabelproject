package com.indsys.SpringBootBackEnd.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "QuotationSequence")
public class QuotationSequence {

    @Id
    private String id;

    private int sequenceNo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(int sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public QuotationSequence(String id, int sequenceNo) {
        this.id = id;
        this.sequenceNo = sequenceNo;
    }
}

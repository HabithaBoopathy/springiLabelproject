package com.indsys.SpringBootBackEnd.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Logs")
public class Logs {

    // ID
    @Id
    private String id;

    private String logAccess;
    private String logNum;

    @Override
    public String toString() {
        return "Logs [id=" + id + ", logAccess=" + logAccess + ", logNum=" + logNum + "]";
    }

    public Logs(String id, String logAccess, String logNum) {
        this.id = id;
        this.logAccess = logAccess;
        this.logNum = logNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogAccess() {
        return logAccess;
    }

    public void setLogAccess(String logAccess) {
        this.logAccess = logAccess;
    }

    public String getLogNum() {
        return logNum;
    }

    public void setLogNum(String logNum) {
        this.logNum = logNum;
    }   
    
}

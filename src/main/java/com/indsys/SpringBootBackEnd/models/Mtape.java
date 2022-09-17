package com.indsys.SpringBootBackEnd.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "MTape")
public class Mtape {

    @Id
    private String id;

    private String name;
    private Double width;
    private Double costPerMeter;

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

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getCostPerMeter() {
        return costPerMeter;
    }

    public void setCostPerMeter(Double costPerMeter) {
        this.costPerMeter = costPerMeter;
    }
}

package com.indsys.SpringBootBackEnd.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Territory")
public class Territory {
    @Id
    private String id;
    private String name;
    private Boolean isActive;
    private String[] executiveIds;

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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String[] getExecutiveIds() {
        return executiveIds;
    }

    public void setExecutiveIds(String[] executiveIds) {
        this.executiveIds = executiveIds;
    }

}
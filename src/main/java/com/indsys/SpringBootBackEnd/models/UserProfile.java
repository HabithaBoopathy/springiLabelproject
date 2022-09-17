package com.indsys.SpringBootBackEnd.models;

import java.util.Arrays;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "UserProfiles")
public class UserProfile {


    // ID
    @Id
    private String id;


    // User Profile Variables
    private String username;
    private String loginId;
    private String password;
    private String accessRights;
    private String trimTypes[];
    private String customerName;
    private String status;
    private Boolean superUser;

    //Login Privileges
    private String logAccess;


    //Date and Time Variables
    private Boolean completed = false;
    private Date createdAt = new Date();

    private String[] territoryId;

    @Override
    public String toString() {
        return "UserProfile [accessRights=" + accessRights + ", completed=" + completed + ", createdAt=" + createdAt
                + ", customerName=" + customerName + ", id=" + id + ", logAccess=" + logAccess + ", loginId=" + loginId
                + ", password=" + password + ", trimTypes=" + Arrays.toString(trimTypes) + ", username=" + username
                + "]";
    }

    public UserProfile(String id, String username, String loginId, String password, String accessRights,
            String[] trimTypes, String customerName, String logAccess, Boolean completed, Date createdAt, String territoryId[]) {
        this.id = id;
        this.username = username;
        this.loginId = loginId;
        this.password = password;
        this.accessRights = accessRights;
        this.trimTypes = trimTypes;
        this.customerName = customerName;
        this.logAccess = logAccess;
        this.completed = completed;
        this.createdAt = createdAt;
        this.territoryId = territoryId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccessRights() {
        return accessRights;
    }

    public void setAccessRights(String accessRights) {
        this.accessRights = accessRights;
    }

    public String[] getTrimTypes() {
        return trimTypes;
    }

    public void setTrimTypes(String[] trimTypes) {
        this.trimTypes = trimTypes;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLogAccess() {
        return logAccess;
    }

    public void setLogAccess(String logAccess) {
        this.logAccess = logAccess;
    }

    public String[] getTerritoryId() {
        return territoryId;
    }

    public void setTerritoryId(String[] territoryId) {
        this.territoryId = territoryId;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getSuperUser() {
        return superUser;
    }

    public void setSuperUser(Boolean superUser) {
        this.superUser = superUser;
    }
}

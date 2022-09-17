package com.indsys.SpringBootBackEnd.models.Email;

public class CustomerUserProfileDetails {

    private String executiveName;
    private String customerName;
    private String customerType;
    public String loginID;
    public String password;
    public String email;
    public String name;

    public CustomerUserProfileDetails(String executiveName, String customerName, String customerType, String loginID,
            String password, String email, String name) {
        this.executiveName = executiveName;
        this.customerName = customerName;
        this.customerType = customerType;
        this.loginID = loginID;
        this.password = password;
        this.email = email;
        this.name = name;
    }

    @Override
    public String toString() {
        return "CustomerUserProfileDetails [customerName=" + customerName + ", customerType=" + customerType
                + ", email=" + email + ", executiveName=" + executiveName + ", loginID=" + loginID + ", name=" + name
                + ", password=" + password + "]";
    }

    public String getExecutiveName() {
        return executiveName;
    }

    public void setExecutiveName(String executiveName) {
        this.executiveName = executiveName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}

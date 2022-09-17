package com.indsys.SpringBootBackEnd.models.Email;

public class CustomerVerification {

    private String executiveName;
    private String customerName;
    private String customerType;
    public String email;
    public String verificationLink;

    public CustomerVerification(String executiveName, String customerName, String customerType, String email,
            String verificationLink) {
        this.executiveName = executiveName;
        this.customerName = customerName;
        this.customerType = customerType;
        this.email = email;
        this.verificationLink = verificationLink;
    }

    @Override
    public String toString() {
        return "CustomerVerification [customerName=" + customerName + ", customerType=" + customerType + ", email="
                + email + ", executiveName=" + executiveName + ", verificationLink=" + verificationLink + "]";
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVerificationLink() {
        return verificationLink;
    }

    public void setVerificationLink(String verificationLink) {
        this.verificationLink = verificationLink;
    }        
    
}

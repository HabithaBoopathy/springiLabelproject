package com.indsys.SpringBootBackEnd.controllers;

import com.indsys.SpringBootBackEnd.models.Email.CustomerVerificationWithLogin;
import com.indsys.SpringBootBackEnd.models.UserProfile;
import com.indsys.SpringBootBackEnd.repositories.UserRepository;
import com.indsys.SpringBootBackEnd.v2.costingNew.models.CostingApprovalDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.internet.MimeMessage;

import com.indsys.SpringBootBackEnd.models.Email.CustomerUserProfileDetails;
import com.indsys.SpringBootBackEnd.models.Email.CustomerVerification;
import com.indsys.SpringBootBackEnd.models.Email.Details;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RequestMapping("/ilabel")
@Controller
public class EmailSendController {

    @Autowired
    SpringTemplateEngine templateEngine;

    @Autowired
    private JavaMailSender sender;

    @Autowired
    UserRepository userRepository;

    String fromEmail = "ilabeltesting@outlook.com";

    @RequestMapping("/email")
    public @ResponseBody Details sendMail(@RequestBody Details details) throws Exception {

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("executiveCode",details.getExecutiveCode());
        model.put("customerName",details.getCustomerName());
        model.put("sampleRequestNumber",details.getSampleRequestNumber());
        model.put("pageURL",details.getPageURL());

        Context context = new Context();
        context.setVariables(model);
        String html = templateEngine.process("email-template", context);

        try {
            helper.setTo(details.getEmail());
            helper.setText(html,true);
            helper.setSubject("ilabel Request Approval");
//            helper.setCc("it@sainmarks.com");
            helper.setFrom(fromEmail);

            System.out.println("E-mail Sent Successfully"); 

        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
        sender.send(message);

        return details;

    }

    @RequestMapping("/rejectedemail")
    public @ResponseBody Details rejectedMail(@RequestBody Details details) throws Exception {

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("executiveCode",details.getExecutiveCode());
        model.put("customerName",details.getCustomerName());
        model.put("sampleRequestNumber",details.getSampleRequestNumber());
        model.put("pageURL",details.getPageURL());

        Context context = new Context();
        context.setVariables(model);
        String html = templateEngine.process("rejected-email", context);

        try {
            helper.setTo(details.getEmail());
            helper.setText(html,true);
            helper.setSubject("iLabel Sample Order Rejected");
//            helper.setCc("it@sainmarks.com");
            helper.setFrom(fromEmail);

            System.out.println("E-mail Sent Successfully");

        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
        sender.send(message);

        return details;

    }

    @RequestMapping("/costingApproval")
    public @ResponseBody
    Boolean
    sendCostingApprovalMail(@RequestBody CostingApprovalDetails costingApprovalDetails) throws Exception {

        Boolean flag = false;
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        Map<String, Object> detailsObj = new HashMap<String, Object>();
        detailsObj.put("entryDate",costingApprovalDetails.getEntryDate());
        detailsObj.put("trimType", costingApprovalDetails.getTrimType());
        detailsObj.put("refNo",costingApprovalDetails.getRefNo());
        detailsObj.put("productName",costingApprovalDetails.getProductName());
        detailsObj.put("customerName",costingApprovalDetails.getCustomerName());
        detailsObj.put("productLength",costingApprovalDetails.getProductLength());
        detailsObj.put("productWidth",costingApprovalDetails.getProductWidth());
        detailsObj.put("paymentTerms",costingApprovalDetails.getPaymentTerms());
        detailsObj.put("approvalLink",costingApprovalDetails.getApprovalLink());
        detailsObj.put("slabRates", costingApprovalDetails.getSlabRates());

        Context context = new Context();
        context.setVariables(detailsObj);
        String html = templateEngine.process("costing-approval", context);


        List<UserProfile> userProfiles =
                userRepository.getByAccessRightsAndSuperUser("Administrator", true);

        if(userProfiles.size()>0){
            for(int i = 0; i<userProfiles.size(); i++){

                try {
                    helper.setTo(userProfiles.get(i).getLoginId());
                    helper.setText(html,true);
                    helper.setSubject("iLabel Costing Approval - "
                            + costingApprovalDetails.getRefNo()
                            + " - " +
                            costingApprovalDetails.getProductName());
//                    helper.setCc("it@sainmarks.com");
                    helper.setFrom(fromEmail);

                    sender.send(message);
                    System.out.println("E-mail Sent Successfully");
                    flag = true;

                } catch (javax.mail.MessagingException e) {
                    e.printStackTrace();
                }
            }
        }

        return flag;

    }

    @RequestMapping("/costingApprovalForCustomer/{emailId}")
    public @ResponseBody
    Boolean
    sendCostingApprovalMailForCustomer(@RequestBody CostingApprovalDetails costingApprovalDetails,
                                       @PathVariable("emailId") String emailId) throws Exception {

        Boolean flag = false;
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        Map<String, Object> detailsObj = new HashMap<String, Object>();
        detailsObj.put("entryDate",costingApprovalDetails.getEntryDate());
        detailsObj.put("trimType", costingApprovalDetails.getTrimType());
        detailsObj.put("refNo",costingApprovalDetails.getRefNo());
        detailsObj.put("productName",costingApprovalDetails.getProductName());
        detailsObj.put("customerName",costingApprovalDetails.getCustomerName());
        detailsObj.put("productLength",costingApprovalDetails.getProductLength());
        detailsObj.put("productWidth",costingApprovalDetails.getProductWidth());
        detailsObj.put("paymentTerms",costingApprovalDetails.getPaymentTerms());
        detailsObj.put("approvalLink",costingApprovalDetails.getApprovalLink());
        detailsObj.put("slabRates", costingApprovalDetails.getSlabRates());

        Context context = new Context();
        context.setVariables(detailsObj);
        String html = templateEngine.process("costing-approval-customer", context);

        try {
            helper.setTo(emailId);
            helper.setText(html,true);
            helper.setSubject("iLabel Costing Approval - "
                    + costingApprovalDetails.getRefNo()
                    + " - " +
                    costingApprovalDetails.getProductName());
//            helper.setCc("it@sainmarks.com");
            helper.setFrom(fromEmail);

            sender.send(message);
            System.out.println("E-mail Sent Successfully");
            flag = true;

        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }


        return flag;

    }

    @RequestMapping("/costingApprovedMail/{emailId}/{approveFlag}/")
    public @ResponseBody
    Boolean
    sendCostingApprovedOrRejectedMail(@RequestBody CostingApprovalDetails costingApprovalDetails,
                                       @PathVariable("emailId") String emailId,
                                      @PathVariable("approveFlag") boolean approveFlag) throws Exception {

        Boolean flag = false;
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        Map<String, Object> detailsObj = new HashMap<String, Object>();
        detailsObj.put("entryDate",costingApprovalDetails.getEntryDate());
        detailsObj.put("trimType", costingApprovalDetails.getTrimType());
        detailsObj.put("refNo",costingApprovalDetails.getRefNo());
        detailsObj.put("productName",costingApprovalDetails.getProductName());
        detailsObj.put("customerName",costingApprovalDetails.getCustomerName());
        detailsObj.put("productLength",costingApprovalDetails.getProductLength());
        detailsObj.put("productWidth",costingApprovalDetails.getProductWidth());
        detailsObj.put("paymentTerms",costingApprovalDetails.getPaymentTerms());
        detailsObj.put("approvalLink",costingApprovalDetails.getApprovalLink());
        detailsObj.put("slabRates", costingApprovalDetails.getSlabRates());

        Context context = new Context();
        context.setVariables(detailsObj);
        String html = "";

        if(approveFlag){
            html = templateEngine.process("costing-approved", context);
        }else{
            html = templateEngine.process("costing-rejected", context);
        }


        try {
            helper.setTo(emailId);
            helper.setText(html,true);
            if(approveFlag){
                helper.setSubject("iLabel Costing Approved By Customer - "
                        + costingApprovalDetails.getRefNo()
                        + " - " +
                        costingApprovalDetails.getProductName());
            }else{
                helper.setSubject("iLabel Costing Rejected By Customer - "
                        + costingApprovalDetails.getRefNo()
                        + " - " +
                        costingApprovalDetails.getProductName());
            }

//            helper.setCc("it@sainmarks.com");
            helper.setFrom(fromEmail);

            sender.send(message);
            System.out.println("E-mail Sent Successfully");
            flag = true;

        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }


        return flag;

    }

    //customer verification email new
    @RequestMapping("/customerverificationnew")
    public @ResponseBody CustomerVerificationWithLogin sendCustomerVerificationEmailNew(@RequestBody CustomerVerificationWithLogin customerVerificationWithLogin) throws Exception {

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("customerName",customerVerificationWithLogin.getCustomerName());
        model.put("executiveName",customerVerificationWithLogin.getExecutiveName());
        model.put("loginID",customerVerificationWithLogin.getLoginId());
        model.put("password",customerVerificationWithLogin.getPassword());
        model.put("verificationLink",customerVerificationWithLogin.getVerificationLink());

        Context context = new Context();
        context.setVariables(model);
        String html = templateEngine.process("customer-verification-with-login-details", context);

        try {
            helper.setTo(customerVerificationWithLogin.getLoginId());
            helper.setText(html,true);
            helper.setSubject("ilabel Customer Verification & Login Details");
            helper.setCc("it@sainmarks.com");
            helper.setFrom(fromEmail);
            sender.send(message);
            System.out.println("E-mail Sent Successfully");
            return customerVerificationWithLogin;

        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }




    }

    // Customer Verification E-mail
    @RequestMapping("/customerverification")
    public @ResponseBody CustomerVerification sendCustomerVerificationEmail(@RequestBody CustomerVerification customerVerification) throws Exception {

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("executiveName",customerVerification.getExecutiveName());
        model.put("customerName",customerVerification.getCustomerName());
        model.put("customerType",customerVerification.getCustomerType());
        model.put("verificationLink",customerVerification.getVerificationLink());

        Context context = new Context();
        context.setVariables(model);
        String html = templateEngine.process("customer-verification", context);

        try {
            helper.setTo(customerVerification.getEmail());
            helper.setText(html,true);
            helper.setSubject("ilabel Customer Verification E-mail");
//            helper.setCc("it@sainmarks.com");
            helper.setFrom(fromEmail);

            System.out.println("E-mail Sent Successfully"); 

        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
        sender.send(message);

        return customerVerification;

    }

    @RequestMapping("/customerlogindetails")
    public @ResponseBody CustomerUserProfileDetails sendCustomerLoginDetailsEmail(@RequestBody CustomerUserProfileDetails customerVerification) throws Exception {

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("executiveName",customerVerification.getExecutiveName());
        model.put("customerName",customerVerification.getCustomerName());
        model.put("customerType",customerVerification.getCustomerType());
        model.put("loginID",customerVerification.getLoginID());
        model.put("password",customerVerification.getPassword());

        Context context = new Context();
        context.setVariables(model);
        String html = templateEngine.process("customer-login-details", context);

        try {
            helper.setTo(customerVerification.getEmail());
            helper.setText(html,true);
            helper.setSubject("ilabel Customer Login Details");
//            helper.setCc("it@sainmarks.com");
            helper.setFrom(fromEmail);

            System.out.println("E-mail Sent Successfully"); 

        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
        sender.send(message);

        return customerVerification;

    }

    @RequestMapping("/sendlogindetails")
    public @ResponseBody CustomerUserProfileDetails sendLoginDetailsEmail(@RequestBody CustomerUserProfileDetails customerVerification) throws Exception {

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("name",customerVerification.getName());
        model.put("customerType",customerVerification.getCustomerType());
        model.put("loginID",customerVerification.getLoginID());
        model.put("password",customerVerification.getPassword());

        Context context = new Context();
        context.setVariables(model);
        String html = templateEngine.process("login-details", context);

        try {
            helper.setTo(customerVerification.getEmail());
            helper.setText(html,true);
            helper.setSubject("ilabel Customer Login Details");
//            helper.setCc("it@sainmarks.com");
            helper.setFrom(fromEmail);

            System.out.println("E-mail Sent Successfully"); 

        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
        sender.send(message);

        return customerVerification;

    }

    @RequestMapping("/singleattachment")
    public @ResponseBody Details sendMailWithSingleAttachment(@RequestBody Details details) throws Exception {

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("executiveCode",details.getExecutiveCode());
        model.put("customerName",details.getCustomerName());
        model.put("sampleRequestNumber",details.getSampleRequestNumber());
        model.put("pageURL",details.getPageURL());

        Context context = new Context();
        context.setVariables(model);
        String html = templateEngine.process("email-template", context);

        try {
            helper.setTo(details.getEmail());
            helper.setText(html,true);
            helper.setSubject("ilabel Request Approval");
//            helper.setCc("it@sainmarks.com");
            helper.setFrom(fromEmail);

            //Local Single Mail Attachment
            helper.addAttachment(details.attachmentName1(), new FileSystemResource(details.getAttachment1Local()));

            //Server Single Mail Attachment
            // helper.addAttachment(details.attachmentName1(), new FileSystemResource(details.getAttachment1Server()));

            System.out.println("E-mail Sent Successfully"); 

        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
        sender.send(message);

        return details;

    }

    @RequestMapping("/quotationattachment/{localPath}/")
    public @ResponseBody Details sendMailWithQuotationAttachment(@PathVariable("localPath") String localPath, @RequestBody Details details) throws Exception {

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("executiveCode",details.getExecutiveCode());
        model.put("customerName",details.getCustomerName());
        model.put("sampleRequestNumber",details.getSampleRequestNumber());
        model.put("pageURL",details.getPageURL());

        Context context = new Context();
        context.setVariables(model);
        String html = templateEngine.process("email-template", context);

        try {
            helper.setTo(details.getEmail());
            helper.setText(html,true);
            helper.setSubject("ilabel Request Approval");
//            helper.setCc("it@sainmarks.com");
            helper.setFrom(fromEmail);

            localPath = localPath.replace("---", "/");
            //Quotation Attachment
            helper.addAttachment("Quotation Form.pdf", new FileSystemResource(details.getQuotationAttachmentServer(localPath)));

            System.out.println("E-mail Sent Successfully"); 

        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
        sender.send(message);

        return details;

    }

    @RequestMapping("/quotationformattachment/{localPath}/")
    public @ResponseBody Details sendMailWithQuotationAttachmentForQuotationForm(@RequestBody Details details, @PathVariable("localPath") String localPath) throws Exception {

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("customerName",details.getCustomerName());
        model.put("quotationReferenceNumber",details.getQuotationReferenceNumber());
        model.put("pageURL",details.getPageURL());

        Context context = new Context();
        context.setVariables(model);
        String html = templateEngine.process("quotation-form-email-template", context);

        try {
            helper.setTo(details.getEmail());
            helper.setText(html,true);
            helper.setSubject("ilabel Quotation Form");
//            helper.setCc("it@sainmarks.com");
            helper.setFrom(fromEmail);

            localPath = localPath.replace("---", "/");

            //Quotation Attachment
            helper.addAttachment("Quotation Form.pdf", new FileSystemResource(details.getQuotationAttachmentServerForQuotationForm(localPath)));

            System.out.println("E-mail Sent Successfully");

        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
        sender.send(message);

        return details;

    }

    @RequestMapping("/doubleattachment")
    public @ResponseBody Details sendMailWithDoubleAttachment(@RequestBody Details details) throws Exception {

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("executiveCode",details.getExecutiveCode());
        model.put("customerName",details.getCustomerName());
        model.put("sampleRequestNumber",details.getSampleRequestNumber());
        model.put("pageURL",details.getPageURL());

        Context context = new Context();
        context.setVariables(model);
        String html = templateEngine.process("email-template", context);

        try {
            helper.setTo(details.getEmail());
            helper.setText(html,true);
            helper.setSubject("ilabel Request Approval");
//            helper.setCc("it@sainmarks.com");
            helper.setFrom(fromEmail);

            //Local Double Attachment 
            helper.addAttachment(details.attachmentName1(), new FileSystemResource(details.getAttachment1Local()));
            helper.addAttachment(details.attachmentName2(), new FileSystemResource(details.getAttachment2Local()));

            //Server Double Attachment 
            helper.addAttachment(details.attachmentName1(), new FileSystemResource(details.getAttachment1Server()));
            helper.addAttachment(details.attachmentName2(), new FileSystemResource(details.getAttachment2Server()));

            System.out.println("E-mail Sent Successfully"); 

        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
        sender.send(message);

        return details;

    }


}

package com.indsys.SpringBootBackEnd.v2.costingNew.controllers;


import com.fasterxml.jackson.databind.util.JSONPObject;
import com.indsys.SpringBootBackEnd.configurations.RootPath;
import com.indsys.SpringBootBackEnd.models.Employee;
import com.indsys.SpringBootBackEnd.models.ProductReference;
import com.indsys.SpringBootBackEnd.models.QuotationBatch;
import com.indsys.SpringBootBackEnd.models.orderForms.Everything;
import com.indsys.SpringBootBackEnd.repositories.EmployeeRepository;
import com.indsys.SpringBootBackEnd.repositories.ProductReferenceRepository;
import com.indsys.SpringBootBackEnd.repositories.orderForms.EverythingRepository;
import com.indsys.SpringBootBackEnd.service.FilesStorageService;
import com.indsys.SpringBootBackEnd.v2.costingNew.models.CommonDetailsCosting;
import com.indsys.SpringBootBackEnd.v2.costingNew.models.RejectedReason;
import com.indsys.SpringBootBackEnd.v2.costingNew.models.WovenCosting;
import com.indsys.SpringBootBackEnd.v2.costingNew.repositories.WovenCostingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@RestController
@RequestMapping("/api/master/costing/woven")
@CrossOrigin(origins = "*")
public class WovenCostingController {

    @Autowired
    WovenCostingRepository wovenCostingRepository;

    @Autowired
    CostingRefNoSequenceController costingRefNoSequenceController;

    @Autowired
    FilesStorageService storageService;

    @Autowired
    CommonDetailsCostingController commonDetailsCostingController;

    @Autowired
    ProductReferenceRepository productReferenceRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EverythingRepository everythingRepository;

    private boolean setRefNo(WovenCosting wovenCosting, int recursionCount){
        wovenCosting.setRefNo("SESWOV00" + (costingRefNoSequenceController.getLatestWovenSequence()+1));
        try{
            wovenCosting =  wovenCostingRepository.save(wovenCosting);
            //saved successfully. Now, increase the sequence
            costingRefNoSequenceController.incrementWovenSequence();
            return true;
        } catch (DuplicateKeyException e){
            //Two or more users have created woven costing at same time
            //recurse through the same function again till it saves
            //Also limit the recursion to be within 10 to avoid memory overflow
            if(recursionCount<10) {
                return setRefNo(wovenCosting, recursionCount++);
            }else{
                return false;
            }
        }
    }

    private void assignCommonDetails(CommonDetailsCosting commonDetailsCosting, WovenCosting wovenCosting){
        commonDetailsCosting.setId(null);
        commonDetailsCosting.setTotalDetailsId(wovenCosting.getId());
        commonDetailsCosting.setRefNo(wovenCosting.getRefNo());
        commonDetailsCosting.setEntryDate(wovenCosting.getEntryDate());
        commonDetailsCosting.setCustomerId(wovenCosting.getCustomerId());
        commonDetailsCosting.setCustomerName(wovenCosting.getCustomerName());
        commonDetailsCosting.setProductName(wovenCosting.getLabelName());
        commonDetailsCosting.setTrimType(wovenCosting.getTrimType());
        commonDetailsCosting.setOrderQuantity(wovenCosting.getEstimatedQuantity());
        commonDetailsCosting.setStatus(wovenCosting.getStatus());
        commonDetailsCosting.setArchived(false);
        commonDetailsCosting.setExecutiveId(wovenCosting.getExecutiveId());
    }

    @PostMapping("/create")
    public WovenCosting createWovenCosting(@RequestBody WovenCosting wovenCosting){
        if(setRefNo(wovenCosting, 0)){
            CommonDetailsCosting commonDetailsCosting = new CommonDetailsCosting();
            assignCommonDetails(commonDetailsCosting, wovenCosting);
            CommonDetailsCosting commonDetailsCosting1 =
                    commonDetailsCostingController.createInternal(commonDetailsCosting);
            if(commonDetailsCosting1.getId()!=null || !commonDetailsCosting1.getId().equals("")){
                return wovenCosting;
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    @PostMapping("/attachment/{date}/{refNo}/")
    public Boolean saveAttachment(@RequestParam("file") MultipartFile file,
                                  @PathVariable("date") String date,
                                  @PathVariable("refNo") String refNo){
        //Creating the file storage path based on date
        String path = date.replace('-', '/') + "/costing/";
//        System.out.println("path:"  + path);

        try {
            storageService.saveCosting(file, path);
            return true;
        }catch (Exception e) {
            String message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            System.out.println(message);
            System.out.println(e);
            return false;
        }
    }

    @GetMapping(value = "/getAttachmentImage/{filename}", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getImage(@PathVariable String filename) throws IOException {
        filename=filename.replace("-","/");
        File serverFile = new File(RootPath.rootPath + filename);
        return Files.readAllBytes(serverFile.toPath());
    }

    @GetMapping(value = "/getAttachmentPdf/{filename}", produces = MediaType.APPLICATION_PDF_VALUE)
    @ResponseBody
    public byte[] getPdf(@PathVariable String filename) throws IOException {
        filename=filename.replace("-","/");
        File serverFile = new File(RootPath.rootPath + filename);
        return Files.readAllBytes(serverFile.toPath());
    }

    @PutMapping("/update")
    public WovenCosting editWovenCosting(@RequestBody WovenCosting wovenCosting){
        wovenCostingRepository.save(wovenCosting);
        //update commonDetails
        CommonDetailsCosting commonDetailsCosting = new CommonDetailsCosting();
        assignCommonDetails(commonDetailsCosting, wovenCosting);
        CommonDetailsCosting commonDetailsCosting1 =
                commonDetailsCostingController.updateInternal(commonDetailsCosting);
        if(commonDetailsCosting1.getId()!=null || !commonDetailsCosting1.getId().equals("")){
            return wovenCosting;
        }else{
            return null;
        }
    }

    @GetMapping("/approveByCustomer/{costingId}")
    public boolean approveByCustomer(@PathVariable("costingId") String costingId){
        Optional<WovenCosting> wovenCosting = wovenCostingRepository.findById(costingId);
        if(wovenCosting.isPresent()){
            wovenCosting.get().setStatus(5);
            wovenCostingRepository.save(wovenCosting.get());
            //update commonDetails
            CommonDetailsCosting commonDetailsCosting = new CommonDetailsCosting();
            assignCommonDetails(commonDetailsCosting, wovenCosting.get());
            CommonDetailsCosting commonDetailsCosting1 =
                    commonDetailsCostingController.updateInternal(commonDetailsCosting);
            if(commonDetailsCosting1.getId()!=null || !commonDetailsCosting1.getId().equals("")){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    @PutMapping("/rejectByCustomer/{costingId}")
    public boolean rejectByCustomer(@RequestBody RejectedReason reason, @PathVariable("costingId") String costingId){

        Optional<WovenCosting> wovenCosting = wovenCostingRepository.findById(costingId);
        if(wovenCosting.isPresent()){
            wovenCosting.get().setStatus(6);
            wovenCosting.get().setCustomerRejectedReason(reason.getReason());
            wovenCostingRepository.save(wovenCosting.get());
            //update commonDetails
            CommonDetailsCosting commonDetailsCosting = new CommonDetailsCosting();
            assignCommonDetails(commonDetailsCosting, wovenCosting.get());
            CommonDetailsCosting commonDetailsCosting1 =
                    commonDetailsCostingController.updateInternal(commonDetailsCosting);
            if(commonDetailsCosting1.getId()!=null || !commonDetailsCosting1.getId().equals("")){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    @GetMapping("/id/{id}")
    public WovenCosting getWovenCostingById(@PathVariable("id") String id){
        Optional<WovenCosting> optionalWovenCosting = wovenCostingRepository.findById(id);
        return optionalWovenCosting.orElse(null);
    }

    public Everything assignOrderDetails(Everything order, WovenCosting wovenCosting, Employee customer, String date, int max){
        //costing related fields
        order.setCostingId(wovenCosting.getId());
        order.setCostingDate(wovenCosting.getEntryDate());
        order.setCostingRefNo(wovenCosting.getRefNo());
        order.setUploadName(wovenCosting.getRefNo()+"."+wovenCosting.getAttachmentExtension());
        order.setCostingAttachmentUsed(true);

        order.setDate(date);
        order.setSampName(wovenCosting.getLabelName());
        order.setSampleName(wovenCosting.getTrimType());

        order.setCustomerName(wovenCosting.getCustomerName());
        //name refers to company name in orders master
        //customerName refers to company name in customer master
        order.setName(customer.getCustomername());
        order.setPhone(customer.getPhone());
        order.setEmail(customer.getEmailId());
        order.setExecName(customer.getExecutiveName());
        order.setExecutiveCode(customer.getExecutiveCode());
        order.setTerritoryId(customer.getTerritory());
        order.setCustomerStreet1(customer.getStreet1());
        order.setCustomerStreet2(customer.getStreet2());
        order.setCustomerCity(customer.getCity());
        order.setCustomerState(customer.getState());
        order.setCustomerGst(customer.getGstin());
        order.setCustomerEmailRequired(customer.getCustomerEmail());

        order.setRefNo("WOV00" + (max+1));
        order.setWovenreferencenumber((max+1)+"");
        order.setCheck("active");
        order.setPlaceOfSupply("Tamil Nadu");

        order.setTransactionStatus("Sample Request Initiated");
        order.setStatusNum(1+"");
        order.setIncoming(date);
        order.setIncomingPrinted(date);
        order.setIncomingSticker(date);

        QuotationBatch a[] = {};
        order.setLineitem(a);
        order.setOrderCreatedBy("Sales Team");
        String arr[] = {};
        order.setColorOptionTable(arr);
        order.setInkNameTable(arr);

        return order;
    }



    @PostMapping("/createDraftOrder/{costingId}/{date}")
    public Boolean createDraftOrder(@PathVariable("costingId") String costingId,
                                    @PathVariable("date") String date,
                                    @RequestBody ProductReference productReference){
        Optional<WovenCosting> optionalWovenCosting = wovenCostingRepository.findById(costingId);
        if(optionalWovenCosting.isPresent()){

            //fetch costing object
            WovenCosting wovenCosting = optionalWovenCosting.get();
            //Create a new order object
            Everything order = new Everything();
            //get the last refNo for woven orders
            int maxWoven = productReferenceRepository.wovenMax();
            //get the customer details
            Optional<Employee> customer = employeeRepository.findById(wovenCosting.getCustomerId());
            if(customer.isPresent()){
                order = assignOrderDetails(order, wovenCosting, customer.get(), date, maxWoven);

                productReference.setWovencolorname(wovenCosting.getTrimType());
                productReference.setWovenreferencenumber(order.getRefNo());
                productReference.setWovenNum(maxWoven+1);
                productReference.setWovennext((maxWoven+2) + "");

                productReferenceRepository.save(productReference);
                everythingRepository.save(order);
                wovenCosting.setStatus(7);
                editWovenCosting(wovenCosting);

                return true;

            }else{
                return false;
            }
        }else{
            return  false;
        }
    }
    @PostMapping("/createDraftCosting/{orderId}/{date}")
    public Boolean createDraftCosting(@PathVariable("orderId") String costingId,
                                    @PathVariable("date") String date,
                                    @RequestBody ProductReference productReference){
        Optional<WovenCosting> optionalWovenCosting = wovenCostingRepository.findById(costingId);
        if(optionalWovenCosting.isPresent()){

            //fetch costing object
            WovenCosting wovenCosting = optionalWovenCosting.get();
            //Create a new order object
            Everything order = new Everything();
            //get the last refNo for woven orders
            int maxWoven = productReferenceRepository.wovenMax();
            //get the customer details
            Optional<Employee> customer = employeeRepository.findById(wovenCosting.getCustomerId());
            if(customer.isPresent()){
                order = assignOrderDetails(order, wovenCosting, customer.get(), date, maxWoven);

                productReference.setWovencolorname(wovenCosting.getTrimType());
                productReference.setWovenreferencenumber(order.getRefNo());
                productReference.setWovenNum(maxWoven+1);
                productReference.setWovennext((maxWoven+2) + "");

                productReferenceRepository.save(productReference);
                everythingRepository.save(order);
                wovenCosting.setStatus(7);
                editWovenCosting(wovenCosting);

                return true;

            }else{
                return false;
            }
        }else{
            return  false;
        }
    }
}

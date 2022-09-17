package com.indsys.SpringBootBackEnd.v2.costingNew.controllers;

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
import com.indsys.SpringBootBackEnd.v2.costingNew.models.StickerFlexoCosting;
import com.indsys.SpringBootBackEnd.v2.costingNew.repositories.StickerFlexoCostingRepository;
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
@RequestMapping("/api/master/costing/stickerFlexo")
@CrossOrigin(origins = "*")
public class StickerFlexoCostingController {

    @Autowired
    StickerFlexoCostingRepository stickerFlexoCostingRepository;

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

    private boolean setRefNo(StickerFlexoCosting stickerFlexoCosting, int recursionCount){

        stickerFlexoCosting.setRefNo("SESFLEX00" + (costingRefNoSequenceController.getLatestStickerFlexoSequence() + 1) );
        try{
            stickerFlexoCostingRepository.save(stickerFlexoCosting);
            //saved successfully. Now, increase the sequence
            costingRefNoSequenceController.incrementStickerFlexoSequence();
            return true;
        }catch (DuplicateKeyException e){
            //Two or more users have created sticker costing at same time
            //recurse through the same function again till it saves
            //Also limit the recursion to be within 10 to avoid memory overflow
            if(recursionCount<10){
                return setRefNo(stickerFlexoCosting, recursionCount++);
            }else{
                return false;
            }
        }

    }

    private void assignCommonDetails(CommonDetailsCosting commonDetailsCosting,
                                     StickerFlexoCosting stickerFlexoCosting) {
        commonDetailsCosting.setId(null);
        commonDetailsCosting.setTotalDetailsId(stickerFlexoCosting.getId());
        commonDetailsCosting.setRefNo(stickerFlexoCosting.getRefNo());
        commonDetailsCosting.setEntryDate(stickerFlexoCosting.getEntryDate());
        commonDetailsCosting.setCustomerId(stickerFlexoCosting.getCustomerId());
        commonDetailsCosting.setCustomerName(stickerFlexoCosting.getCustomerName());
        commonDetailsCosting.setProductName(stickerFlexoCosting.getStickerName());
        commonDetailsCosting.setTrimType(stickerFlexoCosting.getTrimType());
        commonDetailsCosting.setOrderQuantity(stickerFlexoCosting.getPrintingQuantity());
        commonDetailsCosting.setStatus(stickerFlexoCosting.getStatus());
        commonDetailsCosting.setArchived(false);
        commonDetailsCosting.setExecutiveId(stickerFlexoCosting.getExecutiveId());

    }

    @PostMapping("/create")
    public StickerFlexoCosting createStickerCosting(@RequestBody StickerFlexoCosting stickerFlexoCosting){
        if(setRefNo(stickerFlexoCosting, 0)){
            CommonDetailsCosting commonDetailsCosting = new CommonDetailsCosting();
            assignCommonDetails(commonDetailsCosting, stickerFlexoCosting);
            CommonDetailsCosting commonDetailsCosting1 =
                    commonDetailsCostingController.createInternal(commonDetailsCosting);
            if(commonDetailsCosting1.getId()!=null || !commonDetailsCosting1.getId().equals("")){
                return stickerFlexoCosting;
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    @PostMapping("/attachment/{date}/{refNo}")
    public Boolean saveAttachment(@RequestParam("file") MultipartFile file,
                                  @PathVariable("date") String date,
                                  @PathVariable("refNo") String refNo){
        //Creating the file storage path based on date
        String path = date.replace('-', '/') + "/costing/";

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
    public StickerFlexoCosting editStickerFlexoCosting(@RequestBody StickerFlexoCosting stickerFlexoCosting){

        stickerFlexoCostingRepository.save(stickerFlexoCosting);

        //update commonDetails
        CommonDetailsCosting commonDetailsCosting = new CommonDetailsCosting();
        assignCommonDetails(commonDetailsCosting, stickerFlexoCosting);
        CommonDetailsCosting commonDetailsCosting1 =
                commonDetailsCostingController.updateInternal(commonDetailsCosting);
        if(commonDetailsCosting1.getId()!=null || !commonDetailsCosting1.getId().equals("")){
            return stickerFlexoCosting;
        }else{
            return null;
        }
    }

    @GetMapping("/approveByCustomer/{costingId}")
    public boolean approveByCustomer(@PathVariable("costingId") String costingId){
        Optional<StickerFlexoCosting> stickerFlexoCosting = stickerFlexoCostingRepository.findById(costingId);
        if(stickerFlexoCosting.isPresent()){
            stickerFlexoCosting.get().setStatus(5);
            stickerFlexoCostingRepository.save(stickerFlexoCosting.get());
            //update commonDetails
            CommonDetailsCosting commonDetailsCosting = new CommonDetailsCosting();
            assignCommonDetails(commonDetailsCosting, stickerFlexoCosting.get());
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

        Optional<StickerFlexoCosting> stickerFlexoCosting = stickerFlexoCostingRepository.findById(costingId);
        if(stickerFlexoCosting.isPresent()){
            stickerFlexoCosting.get().setStatus(6);
            stickerFlexoCosting.get().setCustomerRejectedReason(reason.getReason());
            stickerFlexoCostingRepository.save(stickerFlexoCosting.get());
            //update commonDetails
            CommonDetailsCosting commonDetailsCosting = new CommonDetailsCosting();
            assignCommonDetails(commonDetailsCosting, stickerFlexoCosting.get());
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
    public StickerFlexoCosting getStickerCostingById(@PathVariable("id") String id){
        Optional<StickerFlexoCosting> optionalStickerFlexoCosting = stickerFlexoCostingRepository.findById(id);
        return optionalStickerFlexoCosting.orElse(null);
    }

    public Everything assignOrderDetails(Everything order, StickerFlexoCosting stickerFlexoCosting, Employee customer, String date, int max){
        //costing related fields
        order.setCostingId(stickerFlexoCosting.getId());
        order.setCostingDate(stickerFlexoCosting.getEntryDate());
        order.setCostingRefNo(stickerFlexoCosting.getRefNo());
        order.setUploadName(stickerFlexoCosting.getRefNo()+"."+stickerFlexoCosting.getAttachmentExtension());
        order.setCostingAttachmentUsed(true);

        order.setDate(date);
        order.setSampName(stickerFlexoCosting.getStickerName());
        order.setSampleName("Sticker");

        order.setCustomerName(stickerFlexoCosting.getCustomerName());
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

        order.setRefNo("ST00" + (max+1));
        order.setStickerreferencenumber((max+1)+"");
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
        Optional<StickerFlexoCosting> optionalStickerFlexoCosting = stickerFlexoCostingRepository.findById(costingId);
        if(optionalStickerFlexoCosting.isPresent()){

            //fetch costing object
            StickerFlexoCosting stickerFlexoCosting = optionalStickerFlexoCosting.get();
            //Create a new order object
            Everything order = new Everything();
            //get the last refNo for sticker orders
            int maxSticker = productReferenceRepository.stickerMax();
            //get the customer details
            Optional<Employee> customer = employeeRepository.findById(stickerFlexoCosting.getCustomerId());
            if(customer.isPresent()){
                order = assignOrderDetails(order, stickerFlexoCosting, customer.get(), date, maxSticker);

                productReference.setStickercolorname("Sticker");
                productReference.setStickerreferencenumber(order.getRefNo());
                productReference.setStickerNum(maxSticker+1);
                productReference.setStickernext((maxSticker+2) + "");

                productReferenceRepository.save(productReference);
                everythingRepository.save(order);
                stickerFlexoCosting.setStatus(7);
                editStickerFlexoCosting(stickerFlexoCosting);

                return true;

            }else{
                return false;
            }
        }else{
            return  false;
        }
    }
}

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
import com.indsys.SpringBootBackEnd.v2.costingNew.models.StickerOffsetCosting;
import com.indsys.SpringBootBackEnd.v2.costingNew.models.WovenCosting;
import com.indsys.SpringBootBackEnd.v2.costingNew.repositories.StickerOffsetCostingRepository;
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
@RequestMapping("/api/master/costing/stickerOffset")
@CrossOrigin(origins = "*")
public class StickerOffsetCostingController {

    @Autowired
    StickerOffsetCostingRepository stickerOffsetCostingRepository;

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

    private boolean setRefNo(StickerOffsetCosting stickerOffsetCosting, int recursionCount){

        stickerOffsetCosting.setRefNo("SESST00" + (costingRefNoSequenceController.getLatestStickerOffsetSequence() + 1) );
        try{
            stickerOffsetCostingRepository.save(stickerOffsetCosting);
            //saved successfully. Now, increase the sequence
            costingRefNoSequenceController.incrementStickerOffsetSequence();
            return true;
        }catch (DuplicateKeyException e){
            //Two or more users have created StickerOffset costing at same time
            //recurse through the same function again till it saves
            //Also limit the recursion to be within 10 to avoid memory overflow
            if(recursionCount<10){
                return setRefNo(stickerOffsetCosting, recursionCount++);
            }else{
                return false;
            }
        }

    }

    private void assignCommonDetails(CommonDetailsCosting commonDetailsCosting,
                                     StickerOffsetCosting stickerOffsetCosting) {
        commonDetailsCosting.setId(null);
        commonDetailsCosting.setTotalDetailsId(stickerOffsetCosting.getId());
        commonDetailsCosting.setRefNo(stickerOffsetCosting.getRefNo());
        commonDetailsCosting.setEntryDate(stickerOffsetCosting.getEntryDate());
        commonDetailsCosting.setCustomerId(stickerOffsetCosting.getCustomerId());
        commonDetailsCosting.setCustomerName(stickerOffsetCosting.getCustomerName());
        commonDetailsCosting.setProductName(stickerOffsetCosting.getProductName());
        commonDetailsCosting.setTrimType(stickerOffsetCosting.getTrimType());
        commonDetailsCosting.setOrderQuantity(stickerOffsetCosting.getOrderQuantity());
        commonDetailsCosting.setStatus(stickerOffsetCosting.getStatus());
        commonDetailsCosting.setArchived(false);
        commonDetailsCosting.setExecutiveId(stickerOffsetCosting.getExecutiveId());

    }

    @PostMapping("/create")
    public StickerOffsetCosting createStickerOffsetCosting(@RequestBody StickerOffsetCosting stickerOffsetCosting){
        if(setRefNo(stickerOffsetCosting, 0)){
            CommonDetailsCosting commonDetailsCosting = new CommonDetailsCosting();
            assignCommonDetails(commonDetailsCosting, stickerOffsetCosting);
            CommonDetailsCosting commonDetailsCosting1 =
                    commonDetailsCostingController.createInternal(commonDetailsCosting);
            if(commonDetailsCosting1.getId()!=null || !commonDetailsCosting1.getId().equals("")){
                return stickerOffsetCosting;
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
    public StickerOffsetCosting editStickerOffsetCosting(@RequestBody StickerOffsetCosting stickerOffsetCosting){

        stickerOffsetCostingRepository.save(stickerOffsetCosting);

        //update commonDetails
        CommonDetailsCosting commonDetailsCosting = new CommonDetailsCosting();
        assignCommonDetails(commonDetailsCosting, stickerOffsetCosting);
        CommonDetailsCosting commonDetailsCosting1 =
                commonDetailsCostingController.updateInternal(commonDetailsCosting);
        if(commonDetailsCosting1.getId()!=null || !commonDetailsCosting1.getId().equals("")){
            return stickerOffsetCosting;
        }else{
            return null;
        }
    }

    @GetMapping("/approveByCustomer/{costingId}")
    public boolean approveByCustomer(@PathVariable("costingId") String costingId){
        Optional<StickerOffsetCosting> stickerOffsetCosting = stickerOffsetCostingRepository.findById(costingId);
        if(stickerOffsetCosting.isPresent()){
            stickerOffsetCosting.get().setStatus(5);
            stickerOffsetCostingRepository.save(stickerOffsetCosting.get());
            //update commonDetails
            CommonDetailsCosting commonDetailsCosting = new CommonDetailsCosting();
            assignCommonDetails(commonDetailsCosting, stickerOffsetCosting.get());
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

        Optional<StickerOffsetCosting> stickerOffsetCosting = stickerOffsetCostingRepository.findById(costingId);
        if(stickerOffsetCosting.isPresent()){
            stickerOffsetCosting.get().setStatus(6);
            stickerOffsetCosting.get().setCustomerRejectedReason(reason.getReason());
            stickerOffsetCostingRepository.save(stickerOffsetCosting.get());
            //update commonDetails
            CommonDetailsCosting commonDetailsCosting = new CommonDetailsCosting();
            assignCommonDetails(commonDetailsCosting, stickerOffsetCosting.get());
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
    public StickerOffsetCosting getStickerOffsetCostingById(@PathVariable("id") String id){
        Optional<StickerOffsetCosting> optionalStickerOffsetCosting = stickerOffsetCostingRepository.findById(id);
        return optionalStickerOffsetCosting.orElse(null);
    }

    public Everything assignOrderDetails(Everything order, StickerOffsetCosting stickerOffsetCosting, Employee customer, String date, int max){
        //costing related fields
        order.setCostingId(stickerOffsetCosting.getId());
        order.setCostingDate(stickerOffsetCosting.getEntryDate());
        order.setCostingRefNo(stickerOffsetCosting.getRefNo());
        order.setUploadName(stickerOffsetCosting.getRefNo()+"."+stickerOffsetCosting.getAttachmentExtension());
        order.setCostingAttachmentUsed(true);

        order.setDate(date);
        order.setSampName(stickerOffsetCosting.getProductName());
        order.setSampleName("Sticker");

        order.setCustomerName(stickerOffsetCosting.getCustomerName());
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
        Optional<StickerOffsetCosting> optionalStickerOffsetCosting = stickerOffsetCostingRepository.findById(costingId);
        if(optionalStickerOffsetCosting.isPresent()){

            //fetch costing object
            StickerOffsetCosting stickerOffsetCosting = optionalStickerOffsetCosting.get();
            //Create a new order object
            Everything order = new Everything();
            //get the last refNo for sticker orders
            int maxSticker = productReferenceRepository.stickerMax();
            //get the customer details
            Optional<Employee> customer = employeeRepository.findById(stickerOffsetCosting.getCustomerId());
            if(customer.isPresent()){
                order = assignOrderDetails(order, stickerOffsetCosting, customer.get(), date, maxSticker);

                productReference.setStickercolorname("Sticker");
                productReference.setStickerreferencenumber(order.getRefNo());
                productReference.setStickerNum(maxSticker+1);
                productReference.setStickernext((maxSticker+2) + "");

                productReferenceRepository.save(productReference);
                everythingRepository.save(order);
                stickerOffsetCosting.setStatus(7);
                editStickerOffsetCosting(stickerOffsetCosting);

                return true;

            }else{
                return false;
            }
        }else{
            return  false;
        }
    }
}

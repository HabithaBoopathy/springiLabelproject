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
import com.indsys.SpringBootBackEnd.v2.costingNew.models.TagCosting;
import com.indsys.SpringBootBackEnd.v2.costingNew.repositories.TagCostingRepository;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@RestController
@RequestMapping("/api/master/costing/tag")
@CrossOrigin(origins = "*")
public class TagCostingController {

    @Autowired
    TagCostingRepository tagCostingRepository;

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

    private boolean setRefNo(TagCosting tagCosting, int recursionCount){

        tagCosting.setRefNo("SESTAG00" + (costingRefNoSequenceController.getLatestTagSequence() + 1) );
        try{
            tagCostingRepository.save(tagCosting);
            //saved successfully. Now, increase the sequence
            costingRefNoSequenceController.incrementTagSequence();
            return true;
        }catch (DuplicateKeyException e){
            //Two or more users have created tag costing at same time
            //recurse through the same function again till it saves
            //Also limit the recursion to be within 10 to avoid memory overflow
            if(recursionCount<10){
                return setRefNo(tagCosting, recursionCount++);
            }else{
                return false;
            }
        }

    }

    private void assignCommonDetails(CommonDetailsCosting commonDetailsCosting,
                                                     TagCosting tagCosting) {
        commonDetailsCosting.setId(null);
        commonDetailsCosting.setTotalDetailsId(tagCosting.getId());
        commonDetailsCosting.setRefNo(tagCosting.getRefNo());
        commonDetailsCosting.setEntryDate(tagCosting.getEntryDate());
        commonDetailsCosting.setCustomerId(tagCosting.getCustomerId());
        commonDetailsCosting.setCustomerName(tagCosting.getCustomerName());
        commonDetailsCosting.setProductName(tagCosting.getProductName());
        commonDetailsCosting.setTrimType(tagCosting.getTrimType());
        commonDetailsCosting.setOrderQuantity(tagCosting.getOrderQuantity());
        commonDetailsCosting.setStatus(tagCosting.getStatus());
        commonDetailsCosting.setArchived(false);
        commonDetailsCosting.setExecutiveId(tagCosting.getExecutiveId());

    }

    @PostMapping("/create")
    public TagCosting createTagCosting(@RequestBody TagCosting tagCosting){
        if(setRefNo(tagCosting, 0)){
            CommonDetailsCosting commonDetailsCosting = new CommonDetailsCosting();
            assignCommonDetails(commonDetailsCosting, tagCosting);
            CommonDetailsCosting commonDetailsCosting1 =
                    commonDetailsCostingController.createInternal(commonDetailsCosting);
            if(commonDetailsCosting1.getId()!=null || !commonDetailsCosting1.getId().equals("")){
                return tagCosting;
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
    public TagCosting editTagCosting(@RequestBody TagCosting tagCosting){

        tagCostingRepository.save(tagCosting);

        //update commonDetails
        CommonDetailsCosting commonDetailsCosting = new CommonDetailsCosting();
        assignCommonDetails(commonDetailsCosting, tagCosting);
        CommonDetailsCosting commonDetailsCosting1 =
                commonDetailsCostingController.updateInternal(commonDetailsCosting);
        if(commonDetailsCosting1.getId()!=null || !commonDetailsCosting1.getId().equals("")){
            return tagCosting;
        }else{
            return null;
        }
    }

    @GetMapping("/approveByCustomer/{costingId}")
    public boolean approveByCustomer(@PathVariable("costingId") String costingId){
        Optional<TagCosting> tagCosting = tagCostingRepository.findById(costingId);
        if(tagCosting.isPresent()){
            tagCosting.get().setStatus(5);
            tagCostingRepository.save(tagCosting.get());
            //update commonDetails
            CommonDetailsCosting commonDetailsCosting = new CommonDetailsCosting();
            assignCommonDetails(commonDetailsCosting, tagCosting.get());
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

        Optional<TagCosting> tagCosting = tagCostingRepository.findById(costingId);
        if(tagCosting.isPresent()){
            tagCosting.get().setStatus(6);
            tagCosting.get().setCustomerRejectedReason(reason.getReason());
            tagCostingRepository.save(tagCosting.get());
            //update commonDetails
            CommonDetailsCosting commonDetailsCosting = new CommonDetailsCosting();
            assignCommonDetails(commonDetailsCosting, tagCosting.get());
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
    public TagCosting getTagCostingById(@PathVariable("id") String id){
        Optional<TagCosting> optionalTagCosting = tagCostingRepository.findById(id);
        return optionalTagCosting.orElse(null);
    }


    public Everything assignOrderDetails(Everything order, TagCosting tagCosting, Employee customer, String date, int max){
        //costing related fields
        order.setCostingId(tagCosting.getId());
        order.setCostingDate(tagCosting.getEntryDate());
        order.setCostingRefNo(tagCosting.getRefNo());
        order.setUploadName(tagCosting.getRefNo()+"."+tagCosting.getAttachmentExtension());
        order.setCostingAttachmentUsed(true);

        order.setDate(date);
        order.setSampName(tagCosting.getProductName());
        order.setSampleName(tagCosting.getTrimType());

        order.setCustomerName(tagCosting.getCustomerName());
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

        order.setRefNo("TAG00" + (max+1));
        order.setTagreferencenumber((max+1)+"");
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
        Optional<TagCosting> optionalTagCosting = tagCostingRepository.findById(costingId);
        if(optionalTagCosting.isPresent()){

            //fetch costing object
            TagCosting tagCosting = optionalTagCosting.get();
            //Create a new order object
            Everything order = new Everything();
            //get the last refNo for tag orders
            int maxTag = productReferenceRepository.tagMax();
            //get the customer details
            Optional<Employee> customer = employeeRepository.findById(tagCosting.getCustomerId());
            if(customer.isPresent()){
                order = assignOrderDetails(order, tagCosting, customer.get(), date, maxTag);

                productReference.setTagcolorname(tagCosting.getTrimType());
                productReference.setTagreferencenumber(order.getRefNo());
                productReference.setTagNum(maxTag+1);
                productReference.setTagnext((maxTag+2) + "");

                productReferenceRepository.save(productReference);
                everythingRepository.save(order);
                tagCosting.setStatus(7);
                editTagCosting(tagCosting);

                return true;

            }else{
                return false;
            }
        }else{
            return  false;
        }
    }
}

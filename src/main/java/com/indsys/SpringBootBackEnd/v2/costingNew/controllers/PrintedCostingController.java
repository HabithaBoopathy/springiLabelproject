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
import com.indsys.SpringBootBackEnd.v2.costingNew.models.PrintedCosting;
import com.indsys.SpringBootBackEnd.v2.costingNew.models.RejectedReason;
import com.indsys.SpringBootBackEnd.v2.costingNew.repositories.PrintedCostingRepository;
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
@RequestMapping("/api/master/costing/printed")
@CrossOrigin(origins = "*")
public class PrintedCostingController {

    @Autowired
    PrintedCostingRepository printedCostingRepository;

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

    private boolean setRefNo(PrintedCosting printedCosting, int recursionCount){

        printedCosting.setRefNo("SESPFL00" + (costingRefNoSequenceController.getLatestPrintedSequence()+1));
        try{
            printedCosting =  printedCostingRepository.save(printedCosting);
            //saved successfully. Now, increase the sequence
            costingRefNoSequenceController.incrementPrintedSequence();
            return true;
        } catch (DuplicateKeyException e){
            //Two or more users have created printed costing at same time
            //recurse through the same function again till it saves
            //Also limit the recursion to be within 10 to avoid memory overflow
            if(recursionCount<10) {
                return setRefNo(printedCosting, recursionCount++);
            }else{
                return false;
            }
        }
    }

    private void assignCommonDetails(CommonDetailsCosting commonDetailsCosting, PrintedCosting printedCosting){
        commonDetailsCosting.setId(null);
        commonDetailsCosting.setTotalDetailsId(printedCosting.getId());
        commonDetailsCosting.setRefNo(printedCosting.getRefNo());
        commonDetailsCosting.setEntryDate(printedCosting.getEntryDate());
        commonDetailsCosting.setCustomerId(printedCosting.getCustomerId());
        commonDetailsCosting.setCustomerName(printedCosting.getCustomerName());
        commonDetailsCosting.setProductName(printedCosting.getTapeName());
        commonDetailsCosting.setTrimType(printedCosting.getTrimType());
        commonDetailsCosting.setOrderQuantity(printedCosting.getEstimatedQuantity());
        commonDetailsCosting.setStatus(printedCosting.getStatus());
        commonDetailsCosting.setArchived(false);
        commonDetailsCosting.setExecutiveId(printedCosting.getExecutiveId());
    }

    @PostMapping("/create")
    public PrintedCosting createPrintedCosting(@RequestBody PrintedCosting printedCosting){
        if(setRefNo(printedCosting, 0)){
            CommonDetailsCosting commonDetailsCosting = new CommonDetailsCosting();
            assignCommonDetails(commonDetailsCosting, printedCosting);
            CommonDetailsCosting commonDetailsCosting1 =
                    commonDetailsCostingController.createInternal(commonDetailsCosting);
            if(commonDetailsCosting1.getId()!=null || !commonDetailsCosting1.getId().equals("")){
                return printedCosting;
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
    public PrintedCosting editPrintedCosting(@RequestBody PrintedCosting printedCosting){
        printedCostingRepository.save(printedCosting);
        //update commonDetails
        CommonDetailsCosting commonDetailsCosting = new CommonDetailsCosting();
        assignCommonDetails(commonDetailsCosting, printedCosting);
        CommonDetailsCosting commonDetailsCosting1 =
                commonDetailsCostingController.updateInternal(commonDetailsCosting);
        if(commonDetailsCosting1.getId()!=null || !commonDetailsCosting1.getId().equals("")){
            return printedCosting;
        }else{
            return null;
        }
    }


    @GetMapping("/approveByCustomer/{costingId}")
    public boolean approveByCustomer(@PathVariable("costingId") String costingId){
        Optional<PrintedCosting> printedCosting = printedCostingRepository.findById(costingId);
        if(printedCosting.isPresent()){
            printedCosting.get().setStatus(5);
            printedCostingRepository.save(printedCosting.get());
            //update commonDetails
            CommonDetailsCosting commonDetailsCosting = new CommonDetailsCosting();
            assignCommonDetails(commonDetailsCosting, printedCosting.get());
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

        Optional<PrintedCosting> printedCosting = printedCostingRepository.findById(costingId);
        if(printedCosting.isPresent()){
            printedCosting.get().setStatus(6);
            printedCosting.get().setCustomerRejectedReason(reason.getReason());
            printedCostingRepository.save(printedCosting.get());
            //update commonDetails
            CommonDetailsCosting commonDetailsCosting = new CommonDetailsCosting();
            assignCommonDetails(commonDetailsCosting, printedCosting.get());
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
    public PrintedCosting getPrintedCostingById(@PathVariable("id") String id){
        Optional<PrintedCosting> optionalPrintedCosting = printedCostingRepository.findById(id);
        return optionalPrintedCosting.orElse(null);
    }

    public Everything assignOrderDetails(Everything order, PrintedCosting printedCosting, Employee customer, String date, int max){
        //costing related fields
        order.setCostingId(printedCosting.getId());
        order.setCostingDate(printedCosting.getEntryDate());
        order.setCostingRefNo(printedCosting.getRefNo());
        order.setUploadName(printedCosting.getRefNo()+"."+printedCosting.getAttachmentExtension());
        order.setCostingAttachmentUsed(true);

        order.setDate(date);
        order.setSampName(printedCosting.getTapeName());
        order.setSampleName(printedCosting.getTrimType());

        order.setCustomerName(printedCosting.getCustomerName());
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

        order.setRefNo("PFL00" + (max+1));
        order.setPrintreferencenumber((max+1)+"");
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
        Optional<PrintedCosting> optionalPrintedCosting = printedCostingRepository.findById(costingId);
        if(optionalPrintedCosting.isPresent()){

            //fetch costing object
            PrintedCosting printedCosting = optionalPrintedCosting.get();
            //Create a new order object
            Everything order = new Everything();
            //get the last refNo for printed orders
            int maxPrinted = productReferenceRepository.printMax();
            //get the customer details
            Optional<Employee> customer = employeeRepository.findById(printedCosting.getCustomerId());
            if(customer.isPresent()){
                order = assignOrderDetails(order, printedCosting, customer.get(), date, maxPrinted);

                productReference.setPrintcolorname(printedCosting.getTrimType());
                productReference.setPrintreferencenumber(order.getRefNo());
                productReference.setPrintNum(maxPrinted+1);
                productReference.setPrintnext((maxPrinted+2) + "");

                productReferenceRepository.save(productReference);
                everythingRepository.save(order);
                printedCosting.setStatus(7);
                editPrintedCosting(printedCosting);

                return true;

            }else{
                return false;
            }
        }else{
            return  false;
        }
    }
}

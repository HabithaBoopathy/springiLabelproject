package com.indsys.SpringBootBackEnd.controllers.orderForms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.indsys.SpringBootBackEnd.models.Employee;
import com.indsys.SpringBootBackEnd.models.ProductReference;
import com.indsys.SpringBootBackEnd.models.Territory;
import com.indsys.SpringBootBackEnd.repositories.orderForms.WovenRepository;
import com.indsys.SpringBootBackEnd.v2.costingNew.models.CommonDetailsCosting;
import com.indsys.SpringBootBackEnd.v2.costingNew.models.WovenCosting;
import com.indsys.SpringBootBackEnd.v2.costingNew.repositories.CommonDetailsCostingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indsys.SpringBootBackEnd.exceptions.ResourceNotFoundException;
import com.indsys.SpringBootBackEnd.models.orderForms.Everything;
import com.indsys.SpringBootBackEnd.repositories.orderForms.EverythingRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/orders")
public class EverythingController {
	@Autowired
	private WovenRepository wovenCostingRepository;
	@Autowired
	MongoTemplate mongoTemplate;
	@Autowired
	private EverythingRepository everythingRepository;

	@GetMapping("/customer/{customerId}")
	public List<Everything> getAllForCustomer(@PathVariable("customerId") String customerId){
		return everythingRepository.getForCustomer(customerId);
	}

	@GetMapping("/everything/wovencount")
	public int WovenCount() {
		List<Everything> wovenList = everythingRepository.getBysampleName("Woven"); 
		return wovenList.size();
	}

	@GetMapping("/everything/customeremail/{v}")
	public List<Everything> getByCustomerName(@PathVariable("v") String v){
		return everythingRepository.getByCustomerName(v);
	}

	public List<Everything> getBysample1(@PathVariable("v") String v){

		if(v.equals("Customer Executive Approval")){
			v = "Customer / Executive Approval";
		}
		else if(v.equals("Quotation Dispatch")){
			v = "Quotation / Dispatch";
		}

		return everythingRepository.getBytransactionStatus(v);
	}

	@GetMapping("/everything/refno/{v}")
	public Everything getByEverythingReferenceNumberCheck(@PathVariable("v") String v){
		return everythingRepository.getByEverythingReferenceNumber(v);
	}

	@GetMapping("/everything/printmax")
	public int printMax() {
		long zeroCheck = everythingRepository.count();
		if(zeroCheck != 0)
		{
			int max = everythingRepository.printMax();
			return max;
		}
		else
		{
			return 0;
		}
	}

	@GetMapping("/everything/wovenmax")
	public int wovenMax() {
		long zeroCheck = everythingRepository.count();
		if(zeroCheck != 0)
		{
			int max = everythingRepository.wovenMax();
			return max;
		}
		else
		{
			return 0;
		} 
	}

	@GetMapping("/everything/tagmax")
	public int tagMax() {
		long zeroCheck = everythingRepository.count();
		if(zeroCheck != 0)
		{
			int max = everythingRepository.tagMax();
			return max;
		}
		else
		{
			return 0;
		}
	}

	@GetMapping("/everything/stickermax")
	public int stickerMax() {
		long zeroCheck = everythingRepository.count();
		if(zeroCheck != 0)
		{
			int max = everythingRepository.stickerMax();
			return max;
		}
		else
		{
			return 0;
		}
	}

	@GetMapping("/everything/executivecode/{v}")
	public List<Everything> getByExecutiveCode(@PathVariable("v") String v){
		return everythingRepository.getByExecutiveCode(v);
	}

	@GetMapping("/everything/checknum/{v}")
	public List<Everything> getByExecutiveCheckNumCheck(@PathVariable("v") int v){
		return everythingRepository.getByExecutiveCheckNum(v);
	}

	@GetMapping("/everything/new")
	public ResponseEntity<Everything> geteverythingAgainById(@PathVariable(value = "id") String everythingId)
			throws ResourceNotFoundException {
		Everything everything = everythingRepository.findById(everythingId)
				.orElseThrow(() -> new ResourceNotFoundException("NEW SAMPLE IS BEING CREATED" + everythingId));
		return ResponseEntity.ok().body(everything);
	}

	@GetMapping("/everything/{id}")
	public ResponseEntity<Everything> geteverythingById(@PathVariable(value = "id") String everythingId)
			throws ResourceNotFoundException {
		Everything everything = everythingRepository.findById(everythingId)
				.orElseThrow(() -> new ResourceNotFoundException("everything not found for this id :: " + everythingId));
		return ResponseEntity.ok().body(everything);
	}


	// Dashboard Details Start

	// Admin Dashboard Details Starts
	@GetMapping("/everything/TrimTypesCount")
	public int[] getAdminTrimTypesCount() {
		int[] countArr = new int[4];

		countArr[0] =  everythingRepository.getAdminSampleNameCount("Woven", "active").size();
		countArr[1] =  everythingRepository.getAdminSampleNameCount("Sticker", "active").size();
		countArr[2] =  everythingRepository.getAdminSampleNameCount("Tag", "active").size();
		countArr[3] =  everythingRepository.getAdminSampleNameCount("Printed", "active").size();
		return countArr;
	}

	@GetMapping("/everything/transactioncount")
	public int[] getAdminTransactionStatusCount() {
		int[] countArr = new int[8];

		countArr[0] =  everythingRepository.getAdminTransactionCount("Sample Request Initiated", "active").size();
		countArr[1] =  everythingRepository.getAdminTransactionCount("Customer / Executive Approval", "active").size();
		countArr[2] =  everythingRepository.getAdminTransactionCount("Sample Initiated", "active").size();
		countArr[3] =  everythingRepository.getAdminTransactionCount("Rejection (Production)", "active").size();
		countArr[4] =  everythingRepository.getAdminTransactionCount("Production", "active").size();
		countArr[5] =  everythingRepository.getAdminTransactionCount("Quotation / Dispatch", "active").size();
		countArr[6] =  everythingRepository.getAdminTransactionCount("Sample Approved", "active").size();
		countArr[7] =  everythingRepository.getAdminTransactionCount("Sample Rejected", "active").size();
		return countArr;
	}

	@GetMapping("/everything/admindetails")
	public int[] getAdminTransactionStatusCountandSampleCount() {
		int[] countArr = new int[32];

		countArr[0] =  everythingRepository.getByAdminSampleNameAndTransactionCount("Sample Request Initiated", "Woven", "active").size();
		countArr[1] =  everythingRepository.getByAdminSampleNameAndTransactionCount("Customer / Executive Approval", "Woven", "active").size();
		countArr[2] =  everythingRepository.getByAdminSampleNameAndTransactionCount("Sample Initiated", "Woven", "active").size();
		countArr[3] =  everythingRepository.getByAdminSampleNameAndTransactionCount("Rejection (Production)", "Woven", "active").size();
		countArr[4] =  everythingRepository.getByAdminSampleNameAndTransactionCount("Production", "Woven", "active").size();
		countArr[5] =  everythingRepository.getByAdminSampleNameAndTransactionCount("Quotation / Dispatch", "Woven", "active").size();
		countArr[6] =  everythingRepository.getByAdminSampleNameAndTransactionCount("Sample Approved", "Woven", "active").size();
		countArr[7] =  everythingRepository.getByAdminSampleNameAndTransactionCount("Sample Rejected", "Woven", "active").size();

		countArr[8] =  everythingRepository.getByAdminSampleNameAndTransactionCount("Sample Request Initiated", "Sticker", "active").size();
		countArr[9] =  everythingRepository.getByAdminSampleNameAndTransactionCount("Customer / Executive Approval", "Sticker", "active").size();
		countArr[10] =  everythingRepository.getByAdminSampleNameAndTransactionCount("Sample Initiated", "Sticker", "active").size();
		countArr[11] =  everythingRepository.getByAdminSampleNameAndTransactionCount("Rejection (Production)", "Sticker", "active").size();
		countArr[12] =  everythingRepository.getByAdminSampleNameAndTransactionCount("Production", "Sticker", "active").size();
		countArr[13] =  everythingRepository.getByAdminSampleNameAndTransactionCount("Quotation / Dispatch", "Sticker", "active").size();
		countArr[14] =  everythingRepository.getByAdminSampleNameAndTransactionCount("Sample Approved", "Sticker", "active").size();
		countArr[15] =  everythingRepository.getByAdminSampleNameAndTransactionCount("Sample Rejected", "Sticker", "active").size();

		countArr[16] =  everythingRepository.getByAdminSampleNameAndTransactionCount("Sample Request Initiated", "Tag", "active").size();
		countArr[17] =  everythingRepository.getByAdminSampleNameAndTransactionCount("Customer / Executive Approval", "Tag", "active").size();
		countArr[18] =  everythingRepository.getByAdminSampleNameAndTransactionCount("Sample Initiated", "Tag", "active").size();
		countArr[19] =  everythingRepository.getByAdminSampleNameAndTransactionCount("Rejection (Production)", "Tag", "active").size();
		countArr[20] =  everythingRepository.getByAdminSampleNameAndTransactionCount("Production", "Tag", "active").size();
		countArr[21] =  everythingRepository.getByAdminSampleNameAndTransactionCount("Quotation / Dispatch", "Tag", "active").size();
		countArr[22] =  everythingRepository.getByAdminSampleNameAndTransactionCount("Sample Approved", "Tag", "active").size();
		countArr[23] =  everythingRepository.getByAdminSampleNameAndTransactionCount("Sample Rejected", "Tag", "active").size();

		countArr[24] =  everythingRepository.getByAdminSampleNameAndTransactionCount("Sample Request Initiated", "Printed", "active").size();
		countArr[25] =  everythingRepository.getByAdminSampleNameAndTransactionCount("Customer / Executive Approval", "Printed", "active").size();
		countArr[26] =  everythingRepository.getByAdminSampleNameAndTransactionCount("Sample Initiated", "Printed", "active").size();
		countArr[27] =  everythingRepository.getByAdminSampleNameAndTransactionCount("Rejection (Production)", "Printed", "active").size();
		countArr[28] =  everythingRepository.getByAdminSampleNameAndTransactionCount("Production", "Printed", "active").size();
		countArr[29] =  everythingRepository.getByAdminSampleNameAndTransactionCount("Quotation / Dispatch", "Printed", "active").size();
		countArr[30] =  everythingRepository.getByAdminSampleNameAndTransactionCount("Sample Approved", "Printed", "active").size();
		countArr[31] =  everythingRepository.getByAdminSampleNameAndTransactionCount("Sample Rejected", "Printed", "active").size();
		return countArr;
	}
	// Admin Dashboard Details Ends


	// Customer Dashboard Details Starts
	@GetMapping("/everything/customer/trimtypecount/{a}")
	public int[] getByCustomerSampleNameCount(@PathVariable("a") String a){

		int[] countArr = new int[4];

		countArr[0] = everythingRepository.getCustomerSampleCount(a, "Woven", "active").size();
		countArr[1] = everythingRepository.getCustomerSampleCount(a, "Sticker", "active").size();
		countArr[2] = everythingRepository.getCustomerSampleCount(a, "Tag", "active").size();
		countArr[3] = everythingRepository.getCustomerSampleCount(a, "Printed", "active").size();

		return countArr;	
	}
	

	@GetMapping("/everything/customer/transactionstatuscount/{a}")
	public int[] getByCustomerTransactionCount(@PathVariable("a") String a){

		int[] countArr = new int[8];

		countArr[0] = everythingRepository.getCustomerTransactionCount(a, "Sample Request Initiated", "active").size();
		countArr[1] = everythingRepository.getCustomerTransactionCount(a, "Customer / Executive Approval", "active").size();
		countArr[2] = everythingRepository.getCustomerTransactionCount(a, "Sample Initiated", "active").size();
		countArr[3] = everythingRepository.getCustomerTransactionCount(a, "Rejection (Production)", "active").size();
		countArr[4] = everythingRepository.getCustomerTransactionCount(a, "Production", "active").size();
		countArr[5] = everythingRepository.getCustomerTransactionCount(a, "Quotation / Dispatch", "active").size();
		countArr[6] = everythingRepository.getCustomerTransactionCount(a, "Sample Approved", "active").size();
		countArr[7] = everythingRepository.getCustomerTransactionCount(a, "Sample Rejected", "active").size();

		return countArr;
	}

	@GetMapping("/everything/customerdetails/{a}")
	public int[] getByCustomerSampleAndTransactionCount(@PathVariable("a") String a){

		int[] countArr = new int[32];

		countArr[0] = everythingRepository.getCustomerSampleAndTransactionCount(a, "Sample Request Initiated", "Woven", "active").size();
		countArr[1] = everythingRepository.getCustomerSampleAndTransactionCount(a, "Customer / Executive Approval", "Woven", "active").size();
		countArr[2] = everythingRepository.getCustomerSampleAndTransactionCount(a, "Sample Initiated", "Woven", "active").size();
		countArr[3] = everythingRepository.getCustomerSampleAndTransactionCount(a, "Rejection (Production)", "Woven", "active").size();
		countArr[4] = everythingRepository.getCustomerSampleAndTransactionCount(a, "Production", "Woven", "active").size();
		countArr[5] = everythingRepository.getCustomerSampleAndTransactionCount(a, "Quotation / Dispatch", "Woven", "active").size();
		countArr[6] = everythingRepository.getCustomerSampleAndTransactionCount(a, "Sample Approved", "Woven", "active").size();
		countArr[7] = everythingRepository.getCustomerSampleAndTransactionCount(a, "Sample Rejected", "Woven", "active").size();

		countArr[8] = everythingRepository.getCustomerSampleAndTransactionCount(a, "Sample Request Initiated", "Sticker", "active").size();
		countArr[9] = everythingRepository.getCustomerSampleAndTransactionCount(a, "Customer / Executive Approval", "Sticker", "active").size();
		countArr[10] = everythingRepository.getCustomerSampleAndTransactionCount(a, "Sample Initiated", "Sticker", "active").size();
		countArr[11] = everythingRepository.getCustomerSampleAndTransactionCount(a, "Rejection (Production)", "Sticker", "active").size();
		countArr[12] = everythingRepository.getCustomerSampleAndTransactionCount(a, "Production", "Sticker", "active").size();
		countArr[13] = everythingRepository.getCustomerSampleAndTransactionCount(a, "Quotation / Dispatch", "Sticker", "active").size();
		countArr[14] = everythingRepository.getCustomerSampleAndTransactionCount(a, "Sample Approved", "Sticker", "active").size();
		countArr[15] = everythingRepository.getCustomerSampleAndTransactionCount(a, "Sample Rejected", "Sticker", "active").size();

		countArr[16] = everythingRepository.getCustomerSampleAndTransactionCount(a, "Sample Request Initiated", "Tag", "active").size();
		countArr[17] = everythingRepository.getCustomerSampleAndTransactionCount(a, "Customer / Executive Approval", "Tag", "active").size();
		countArr[18] = everythingRepository.getCustomerSampleAndTransactionCount(a, "Sample Initiated", "Tag", "active").size();
		countArr[19] = everythingRepository.getCustomerSampleAndTransactionCount(a, "Rejection (Production)", "Tag", "active").size();
		countArr[20] = everythingRepository.getCustomerSampleAndTransactionCount(a, "Production", "Tag", "active").size();
		countArr[21] = everythingRepository.getCustomerSampleAndTransactionCount(a, "Quotation / Dispatch", "Tag", "active").size();
		countArr[22] = everythingRepository.getCustomerSampleAndTransactionCount(a, "Sample Approved", "Tag", "active").size();
		countArr[23] = everythingRepository.getCustomerSampleAndTransactionCount(a, "Sample Rejected", "Tag", "active").size();

		countArr[24] = everythingRepository.getCustomerSampleAndTransactionCount(a, "Sample Request Initiated", "Printed", "active").size();
		countArr[25] = everythingRepository.getCustomerSampleAndTransactionCount(a, "Customer / Executive Approval", "Printed", "active").size();
		countArr[26] = everythingRepository.getCustomerSampleAndTransactionCount(a, "Sample Initiated", "Printed", "active").size();
		countArr[27] = everythingRepository.getCustomerSampleAndTransactionCount(a, "Rejection (Production)", "Printed", "active").size();
		countArr[28] = everythingRepository.getCustomerSampleAndTransactionCount(a, "Production", "Printed", "active").size();
		countArr[29] = everythingRepository.getCustomerSampleAndTransactionCount(a, "Quotation / Dispatch", "Printed", "active").size();
		countArr[30] = everythingRepository.getCustomerSampleAndTransactionCount(a, "Sample Approved", "Printed", "active").size();
		countArr[31] = everythingRepository.getCustomerSampleAndTransactionCount(a, "Sample Rejected", "Printed", "active").size();

		return countArr;
	}
	// Customer Dashboard Details Ends


	// Executive Dashboard Details Starts
	@GetMapping("/everything/executive/trimtypecount/{a}")
	public int[] executiveSampleNameCount(@PathVariable("a") String a){

		int[] countArr = new int[4];

		countArr[0] = everythingRepository.getExecutiveSampleNameCount(a, "Woven", "active").size();
		countArr[1] = everythingRepository.getExecutiveSampleNameCount(a, "Sticker", "active").size();
		countArr[2] = everythingRepository.getExecutiveSampleNameCount(a, "Tag", "active").size();
		countArr[3] = everythingRepository.getExecutiveSampleNameCount(a, "Printed", "active").size();

		return countArr;
	}

	@GetMapping("/everything/executive/transactionstatuscount/{a}")
	public int[] executiveTransactionCount(@PathVariable("a") String a){

		int[] counttotal = new int[8];

		counttotal[0] = everythingRepository.getExecutiveTransactionStatusCount(a, "Sample Request Initiated", "active").size();
		counttotal[1] = everythingRepository.getExecutiveTransactionStatusCount(a, "Customer / Executive Approval", "active").size();
		counttotal[2] = everythingRepository.getExecutiveTransactionStatusCount(a, "Sample Initiated", "active").size();
		counttotal[3] = everythingRepository.getExecutiveTransactionStatusCount(a, "Rejection (Production)", "active").size();
		counttotal[4] = everythingRepository.getExecutiveTransactionStatusCount(a, "Production", "active").size();
		counttotal[5] = everythingRepository.getExecutiveTransactionStatusCount(a, "Quotation / Dispatch", "active").size();
		counttotal[6] = everythingRepository.getExecutiveTransactionStatusCount(a, "Sample Approved", "active").size();
		counttotal[7] = everythingRepository.getExecutiveTransactionStatusCount(a, "Sample Rejected", "active").size();

		return counttotal;
	}


	@GetMapping("/everything/executivedetails/{a}")
	public int[] getExecutiveTransactionStatusCountandSampleCount(@PathVariable("a") String a){

		int[] countArr = new int[32];

		countArr[0] = everythingRepository.getExecutiveSampleNameAndTransactionCount(a, "Sample Request Initiated", "Woven", "active").size();
		countArr[1] = everythingRepository.getExecutiveSampleNameAndTransactionCount(a, "Customer / Executive Approval", "Woven", "active").size();
		countArr[2] = everythingRepository.getExecutiveSampleNameAndTransactionCount(a, "Sample Initiated", "Woven", "active").size();
		countArr[3] = everythingRepository.getExecutiveSampleNameAndTransactionCount(a, "Rejection (Production)", "Woven", "active").size();
		countArr[4] = everythingRepository.getExecutiveSampleNameAndTransactionCount(a, "Production", "Woven", "active").size();
		countArr[5] = everythingRepository.getExecutiveSampleNameAndTransactionCount(a, "Quotation / Dispatch", "Woven", "active").size();
		countArr[6] = everythingRepository.getExecutiveSampleNameAndTransactionCount(a, "Sample Approved", "Woven", "active").size();
		countArr[7] = everythingRepository.getExecutiveSampleNameAndTransactionCount(a, "Sample Rejected", "Woven", "active").size();

		countArr[8] = everythingRepository.getExecutiveSampleNameAndTransactionCount(a, "Sample Request Initiated", "Sticker", "active").size();
		countArr[9] = everythingRepository.getExecutiveSampleNameAndTransactionCount(a, "Customer / Executive Approval", "Sticker", "active").size();
		countArr[10] = everythingRepository.getExecutiveSampleNameAndTransactionCount(a, "Sample Initiated", "Sticker", "active").size();
		countArr[11] = everythingRepository.getExecutiveSampleNameAndTransactionCount(a, "Rejection (Production)", "Sticker", "active").size();
		countArr[12] = everythingRepository.getExecutiveSampleNameAndTransactionCount(a, "Production", "Sticker", "active").size();
		countArr[13] = everythingRepository.getExecutiveSampleNameAndTransactionCount(a, "Quotation / Dispatch", "Sticker", "active").size();
		countArr[14] = everythingRepository.getExecutiveSampleNameAndTransactionCount(a, "Sample Approved", "Sticker", "active").size();
		countArr[15] = everythingRepository.getExecutiveSampleNameAndTransactionCount(a, "Sample Rejected", "Sticker", "active").size();

		countArr[16] = everythingRepository.getExecutiveSampleNameAndTransactionCount(a, "Sample Request Initiated", "Tag", "active").size();
		countArr[17] = everythingRepository.getExecutiveSampleNameAndTransactionCount(a, "Customer / Executive Approval", "Tag", "active").size();
		countArr[18] = everythingRepository.getExecutiveSampleNameAndTransactionCount(a, "Sample Initiated", "Tag", "active").size();
		countArr[19] = everythingRepository.getExecutiveSampleNameAndTransactionCount(a, "Rejection (Production)", "Tag", "active").size();
		countArr[20] = everythingRepository.getExecutiveSampleNameAndTransactionCount(a, "Production", "Tag", "active").size();
		countArr[21] = everythingRepository.getExecutiveSampleNameAndTransactionCount(a, "Quotation / Dispatch", "Tag", "active").size();
		countArr[22] = everythingRepository.getExecutiveSampleNameAndTransactionCount(a, "Sample Approved", "Tag", "active").size();
		countArr[23] = everythingRepository.getExecutiveSampleNameAndTransactionCount(a, "Sample Rejected", "Tag", "active").size();

		countArr[24] = everythingRepository.getExecutiveSampleNameAndTransactionCount(a, "Sample Request Initiated", "Printed", "active").size();
		countArr[25] = everythingRepository.getExecutiveSampleNameAndTransactionCount(a, "Customer / Executive Approval", "Printed", "active").size();
		countArr[26] = everythingRepository.getExecutiveSampleNameAndTransactionCount(a, "Sample Initiated", "Printed", "active").size();
		countArr[27] = everythingRepository.getExecutiveSampleNameAndTransactionCount(a, "Rejection (Production)", "Printed", "active").size();
		countArr[28] = everythingRepository.getExecutiveSampleNameAndTransactionCount(a, "Production", "Printed", "active").size();
		countArr[29] = everythingRepository.getExecutiveSampleNameAndTransactionCount(a, "Quotation / Dispatch", "Printed", "active").size();
		countArr[30] = everythingRepository.getExecutiveSampleNameAndTransactionCount(a, "Sample Approved", "Printed", "active").size();
		countArr[31] = everythingRepository.getExecutiveSampleNameAndTransactionCount(a, "Sample Rejected", "Printed", "active").size();

		return countArr;
	}
	// Executive Dashboard Details Ends


	// Dashboard Details Ends

	@PostMapping("/everything")
	public Everything createeverything(@Validated @RequestBody Everything everything) {
		return everythingRepository.save(everything);
	}

	@PutMapping("/everything/{id}")
	public ResponseEntity<Everything> updateeverything(@PathVariable(value = "id") String everythingId,
	@Validated @RequestBody Everything everythingDetails) throws ResourceNotFoundException {
		Everything everything = everythingRepository.findById(everythingId)
		.orElseThrow(() -> new ResourceNotFoundException("everything not found for this id :: " + everythingId));

		//Order Confirmation Date
		everything.setOrderConfirmationDate(everythingDetails.getOrderConfirmationDate());

		//Order Created By
		everything.setOrderCreatedBy(everythingDetails.getOrderCreatedBy());

		// Order Details Line Item
		everything.setOrderLineItem(everythingDetails.getOrderLineItem());
		
		// Common
		everything.setDate(everythingDetails.getDate());
		everything.setOldRefNo(everythingDetails.getOldRefNo());
		everything.setName(everythingDetails.getName());
		everything.setSampleName(everythingDetails.getSampleName());
		everything.setContactPerson(everythingDetails.getContactPerson());
		everything.setPhone(everythingDetails.getPhone());
		everything.setEmail(everythingDetails.getEmail());
		everything.setRefNo(everythingDetails.getRefNo());
		everything.setAnotherRefNo(everythingDetails.getAnotherRefNo());
		everything.setExecName(everythingDetails.getExecName());
		everything.setCheck(everythingDetails.getCheck());
		everything.setSampName(everythingDetails.getSampName());
		everything.setSampType(everythingDetails.getSampType());
		everything.setCustomerId(everythingDetails.getCustomerId());

		//Update Reference Numbers
		everything.setWovenRefNum(everythingDetails.getWovenRefNum());
		everything.setPrintRefNum(everythingDetails.getPrintRefNum());
		everything.setTagRefNum(everythingDetails.getTagRefNum());
		everything.setStickerRefNum(everythingDetails.getStickerRefNum());

		// Upload
		everything.setUploadName(everythingDetails.getUploadName());
		everything.setSecondUploadName(everythingDetails.getSecondUploadName());

		everything.setRejectedReason(everythingDetails.getRejectedReason());

		// Quotation Form
		everything.setSampleCode(everythingDetails.getSampleCode());
		everything.setEstimateDate(everythingDetails.getEstimateDate());
		everything.setPlaceOfSupply(everythingDetails.getPlaceOfSupply());
		everything.setBillCustomerName(everythingDetails.getBillCustomerName());
		everything.setBillCustomerCity(everythingDetails.getBillCustomerCity());
		everything.setBillCustomerPincode(everythingDetails.getBillCustomerPincode());
		everything.setBillCustomerState(everythingDetails.getBillCustomerState());
		everything.setBillCustomerCountry(everythingDetails.getBillCustomerCountry());
		everything.setBillCustomerStreet(everythingDetails.getBillCustomerStreet());
		everything.setBillCustomerGst(everythingDetails.getBillCustomerGst());
		everything.setShipCustomerName(everythingDetails.getShipCustomerName());
		everything.setShipCustomerStreet(everythingDetails.getShipCustomerStreet());
		everything.setShipCustomerCity(everythingDetails.getShipCustomerCity());
		everything.setShipCustomerPincode(everythingDetails.getShipCustomerPincode());
		everything.setShipCustomerState(everythingDetails.getShipCustomerState());
		everything.setShipCustomerCountry(everythingDetails.getShipCustomerCountry());
		everything.setShipCustomerGst(everythingDetails.getShipCustomerGst());
		everything.setItemDescription(everythingDetails.getItemDescription());
		everything.setHsn(everythingDetails.getHsn());
		everything.setQuantityRange(everythingDetails.getQuantityRange());
		everything.setRate(everythingDetails.getRate());
		everything.setTermsAndConditions(everythingDetails.getTermsAndConditions());

		// Printed
		everything.setUnitPrinted(everythingDetails.getUnitPrinted());
		everything.setUnitHeight(everythingDetails.getUnitHeight());
		everything.setUnitWidth(everythingDetails.getUnitWidth());
		everything.setExpectedQuantity(everythingDetails.getExpectedQuantity());
		everything.setFolding(everythingDetails.getFolding());
		everything.setSpecialInstruction(everythingDetails.getSpecialInstruction());
		everything.setRemarks(everythingDetails.getRemarks());
		everything.setColor(everythingDetails.getColor());
		everything.setOrderType(everythingDetails.getOrderType());
		everything.setColorInformation(everythingDetails.getColorInformation());
		everything.setStatus(everythingDetails.getStatus());
		everything.setFinishing(everythingDetails.getFinishing());
		everything.setLabelType(everythingDetails.getLabelType());
		everything.setApprovalType(everythingDetails.getApprovalType());
		everything.setIncoming(everythingDetails.getIncoming());
		everything.setSamplePDate(everythingDetails.getSamplePDate());
		everything.setExecutiveCode(everythingDetails.getExecutiveCode());
		everything.setManager(everythingDetails.getManager());
		everything.setDateTime(everythingDetails.getDateTime());
		everything.setDispatch(everythingDetails.getDispatch());
		everything.setSampleReceived(everythingDetails.getSampleReceived());
		everything.setPm(everythingDetails.getPm());
		everything.setSampleName(everythingDetails.getSampleName());
		everything.setSystem(everythingDetails.getSystem());
	//	everything.setSampleBlock(everythingDetails.getSampleBlock());
		everything.setSamplingDate(everythingDetails.getSamplingDate());
		everything.setCrlimitStatusPrinted(everythingDetails.getCrlimitStatusPrinted());
		everything.setDesignFileName(everythingDetails.getDesignFileName());
		everything.setMachine(everythingDetails.getMachine());
		everything.setWidth(everythingDetails.getWidth());
		everything.setQuality(everythingDetails.getQuality());
		everything.setLength(everythingDetails.getLength());
		everything.setSinglePrinting(everythingDetails.getSinglePrinting());
		everything.setDoublePrinting(everythingDetails.getDoublePrinting());
		everything.setColorOptionToBeUsedPrinted(everythingDetails.getColorOptionToBeUsedPrinted());
		everything.setNoOfcolors(everythingDetails.getNoOfcolors());
		everything.setAdditionalWork(everythingDetails.getAdditionalWork());
		everything.setColorOptionFront(everythingDetails.getColorOptionFront());
		everything.setColorOptionBack(everythingDetails.getColorOptionBack());
		everything.setSinglePrinting(everythingDetails.getSinglePrinting());
		everything.setDoublePrinting(everythingDetails.getDoublePrinting());


		everything.setSampleBlock(everythingDetails.getSampleBlock());
		everything.setNoOfRepeatsPrinted(everythingDetails.getNoOfRepeatsPrinted());
		everything.setWidthPrinted(everythingDetails.getWidthPrinted());

		// Sticker 
		everything.setUnitSticker(everythingDetails.getUnitSticker());
		everything.setUnitHeight(everythingDetails.getUnitHeight());
		everything.setUnitWidth(everythingDetails.getUnitWidth());
		everything.setDiameter(everythingDetails.getDiameter());
		everything.setDocumentType(everythingDetails.getDocumentType());
		everything.setColorInfo(everythingDetails.getColorInfo());
		everything.setStickerType(everythingDetails.getStickerType());
		everything.setRollColor(everythingDetails.getRollColor());
		everything.setRollSpecification(everythingDetails.getRollSpecification());
		everything.setRollSize(everythingDetails.getRollSize());
		everything.setSampleCharge(everythingDetails.getSampleCharge());
		everything.setSampleChargecollected(everythingDetails.getSampleChargecollected());
		everything.setPrintType(everythingDetails.getPrintType());
		everything.setComments(everythingDetails.getComments());
		everything.setOrderType(everythingDetails.getOrderType());
		everything.setExpectedQuantity(everythingDetails.getExpectedQuantity());
		everything.setSampleRequest(everythingDetails.getSampleRequest());
		everything.setFlex(everythingDetails.getFlex());
		everything.setOffset(everythingDetails.getOffset());
		everything.setIncoming(everythingDetails.getIncoming());
		everything.setSamplePDate(everythingDetails.getSamplePDate());
		everything.setExecutiveCode(everythingDetails.getExecutiveCode());
		everything.setManager(everythingDetails.getManager());
		everything.setDateTimeSticker(everythingDetails.getDateTimeSticker());
		everything.setDispatch(everythingDetails.getDispatch());
		everything.setRollCost(everythingDetails.getRollCost());
		everything.setRollWastage(everythingDetails.getRollWastage());
		everything.setStickerPrint(everythingDetails.getStickerPrint());
		everything.setDigitalPrint(everythingDetails.getDigitalPrint());
		everything.setFoil(everythingDetails.getFoil());
		everything.setDie(everythingDetails.getDie());
		everything.setFwdandPacking(everythingDetails.getFwdandPacking());
		everything.setTotal(everythingDetails.getTotal());
		everything.setMargin(everythingDetails.getMargin());
		everything.setFinalCost(everythingDetails.getFinalCost());
		everything.setTrimPiece(everythingDetails.getTrimPiece());
		everything.setInkNameTable(everythingDetails.getInkNameTable());
		everything.setPlatesizeSticker(everythingDetails.getPlatesizeSticker());



		// Tag
		everything.setUnitTag(everythingDetails.getUnitTag());
		everything.setUnitHeight(everythingDetails.getUnitHeight());
		everything.setUnitWidth(everythingDetails.getUnitWidth());
		everything.setTagDevType(everythingDetails.getTagDevType());
		everything.setDocumentType(everythingDetails.getDocumentType());
		everything.setColorInfo(everythingDetails.getColorInfo());
		everything.setRunningBoardSize(everythingDetails.getRunningBoardSize());
		everything.setNameOfTheBoard(everythingDetails.getNameOfTheBoard());
		everything.setBoardSpecification(everythingDetails.getBoardSpecification());
		everything.setQuality(everythingDetails.getQuality());
		everything.setBoardGSM(everythingDetails.getBoardGSM());
		everything.setFsc(everythingDetails.getFsc());
		everything.setPrintType(everythingDetails.getPrintType());
		everything.setColor(everythingDetails.getColor());
		everything.setOrderType(everythingDetails.getOrderType());
		everything.setExpectedQuantity(everythingDetails.getExpectedQuantity());
		everything.setStatus(everythingDetails.getStatus());
		everything.setFinishing(everythingDetails.getFinishing());
		everything.setExpectedDate(everythingDetails.getExpectedDate());
		everything.setFolding(everythingDetails.getFolding());
		everything.setApproval(everythingDetails.getApproval());
		everything.setComments(everythingDetails.getComments());
		everything.setNoOfPlates(everythingDetails.getNoOfPlates());
		everything.setNegativePositive(everythingDetails.getNegativePositive());
		everything.setFoilEmbossScreen(everythingDetails.getFoilEmbossScreen());
		everything.setDie(everythingDetails.getDie());
		everything.setPrintColorMatching(everythingDetails.getPrintColorMatching());
		everything.setFoilFace(everythingDetails.getFoilFace());
		everything.setFoilReverse(everythingDetails.getFoilReverse());
		everything.setFoilColor(everythingDetails.getFoilColor());
		everything.setUvFace(everythingDetails.getUvFace());
		everything.setUvReverse(everythingDetails.getUvReverse());
		everything.setUvNoOfScreens(everythingDetails.getUvNoOfScreens());
		everything.setvMatt(everythingDetails.getvMatt());
		everything.setvGloss(everythingDetails.getvGloss());
		everything.setvFace(everythingDetails.getvFace());
		everything.setvReverse(everythingDetails.getvReverse());
		everything.setvOthers(everythingDetails.getvOthers());
		everything.setlMatt(everythingDetails.getlMatt());
		everything.setlGloss(everythingDetails.getlGloss());
		everything.setlFace(everythingDetails.getlFace());
		everything.setlReverse(everythingDetails.getlReverse());
		everything.setlOthers(everythingDetails.getlOthers());
		everything.setStraightCut(everythingDetails.getStraightCut());
		everything.setHoleSize(everythingDetails.getHoleSize());
		everything.setPerforation(everythingDetails.getPerforation());
		everything.setCreasing(everythingDetails.getCreasing());
		everything.setDesignCut(everythingDetails.getDesignCut());
		everything.setString(everythingDetails.getString());
		everything.setEyeletColorAndLength(everythingDetails.getEyeletColorAndLength());
		everything.setIfOthers(everythingDetails.getIfOthers());
		everything.setHookColorAndLength(everythingDetails.getHookColorAndLength());
		everything.setBoardCost(everythingDetails.getBoardCost());
		everything.setDesignFileName(everythingDetails.getDesignFileName());
		everything.setDigitalPrintTag(everythingDetails.getDigitalPrintTag());
		everything.setOffsetPrintTag(everythingDetails.getOffsetPrintTag());
		everything.setFoil(everythingDetails.getFoil());
		everything.setUv(everythingDetails.getUv());
		everything.setEmboss(everythingDetails.getEmboss());
		everything.setVarnish(everythingDetails.getVarnish());
		everything.setLamination(everythingDetails.getLamination());
		everything.setPasting(everythingDetails.getPasting());
		everything.setDie2(everythingDetails.getDie2());
		everything.setNoofups(everythingDetails.getNoofups());
		
		


        //woven
		everything.setUnit(everythingDetails.getUnit());
		everything.setUnitHeight(everythingDetails.getUnitHeight());
		everything.setUnitWidth(everythingDetails.getUnitWidth());
		everything.setExpectedQuantity(everythingDetails.getExpectedQuantity());
		everything.setExpectedDate(everythingDetails.getExpectedDate());
		everything.setFolding(everythingDetails.getFolding());
		everything.setSpecialInstruction(everythingDetails.getSpecialInstruction());
		everything.setRemarks(everythingDetails.getRemarks());
		everything.setColor(everythingDetails.getColor());
		everything.setOrderType(everythingDetails.getOrderType());
		everything.setColorInfo(everythingDetails.getColorInfo());
		everything.setStatus(everythingDetails.getStatus());
		everything.setFinishing(everythingDetails.getFinishing());
		everything.setLabelType(everythingDetails.getLabelType());
		everything.setApprovalType(everythingDetails.getApprovalType());
		everything.setIncoming(everythingDetails.getIncoming());
		everything.setSamplePDate(everythingDetails.getSamplePDate());
		everything.setExecutiveCode(everythingDetails.getExecutiveCode());
		everything.setManager(everythingDetails.getManager());
		everything.setDateTime(everythingDetails.getDateTime());
		everything.setDispatchDateTime(everythingDetails.getDispatchDateTime());
		everything.setSampleRecDateTime(everythingDetails.getSampleRecDateTime());
		everything.setPcm(everythingDetails.getPcm());
		everything.setSampleName(everythingDetails.getSampleName());
		everything.setSystem(everythingDetails.getSystem());
		everything.setTp(everythingDetails.getTp());
		everything.setSamplingDate(everythingDetails.getSamplingDate());
		everything.setCrLimitStatus(everythingDetails.getCrLimitStatus());
		everything.setDesigner(everythingDetails.getDesigner());
		everything.setMachine(everythingDetails.getMachine());
		everything.setWidth(everythingDetails.getWidth());
		everything.setQuality(everythingDetails.getQuality());
		everything.setLength(everythingDetails.getLength());
		everything.setX(everythingDetails.getX());
		everything.setColorOptionToBeUsed(everythingDetails.getColorOptionToBeUsed());
		everything.setY(everythingDetails.getY());
		everything.setNoOfRepeats(everythingDetails.getNoOfRepeats());
		everything.setAdditionalWork(everythingDetails.getAdditionalWork());
		everything.setWastage(everythingDetails.getWastage());
		everything.setColorMatching(everythingDetails.getColorMatching());
		everything.setWarpTension(everythingDetails.getWarpTension());
		everything.setColorOptionTable(everythingDetails.getColorOptionTable());
		everything.setDoctype(everythingDetails.getDoctype());
		everything.setColorpicks(everythingDetails.getColorpicks());

		everything.setCustomerEmailRequired(everythingDetails.getCustomerEmailRequired());
		

		
		final Everything updatedeverything = everythingRepository.save(everything);
		return ResponseEntity.ok(updatedeverything);
	}

	@DeleteMapping("/everything/{id}")
	public Map<String, Boolean> deleteeverything(@PathVariable(value = "id") String everythingId)
			throws ResourceNotFoundException {
				Everything everything = everythingRepository.findById(everythingId)
				.orElseThrow(() -> new ResourceNotFoundException("Colours not found for this id :: " + everythingId));

		everythingRepository.delete(everything);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}


}
 
package com.indsys.SpringBootBackEnd.v2.costingNew.controllers;

import com.indsys.SpringBootBackEnd.repositories.UserRepository;
import com.indsys.SpringBootBackEnd.service.FilesStorageService;
import com.indsys.SpringBootBackEnd.v2.costingNew.models.CommonDetailsCosting;
import com.indsys.SpringBootBackEnd.v2.costingNew.models.PrintedCosting;
import com.indsys.SpringBootBackEnd.v2.costingNew.models.TagCosting;
import com.indsys.SpringBootBackEnd.v2.costingNew.models.WovenCosting;
import com.indsys.SpringBootBackEnd.v2.costingNew.repositories.CommonDetailsCostingRepository;
import com.indsys.SpringBootBackEnd.v2.costingNew.repositories.PrintedCostingRepository;
import com.indsys.SpringBootBackEnd.v2.costingNew.repositories.TagCostingRepository;
import com.indsys.SpringBootBackEnd.v2.costingNew.repositories.WovenCostingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping("/api/master/costing/commonDetails")
@CrossOrigin(origins = "*")
public class CommonDetailsCostingController {

    @Autowired
    CommonDetailsCostingRepository commonDetailsCostingRepository;

    @Autowired
    FilesStorageService storageService;

    @Autowired
    WovenCostingRepository wovenCostingRepository;

    @Autowired
    PrintedCostingRepository printedCostingRepository;

    @Autowired
    TagCostingRepository tagCostingRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/create")
    public CommonDetailsCosting create(@RequestBody CommonDetailsCosting commonDetailsCosting){
        return commonDetailsCostingRepository.save(commonDetailsCosting);
    }

    @GetMapping("/totalDetails/{costingId}")
    public CommonDetailsCosting getByTotalDetailsId(@PathVariable("costingId") String costingId){

        return commonDetailsCostingRepository.getByTotalDetailsId(costingId);
    }

    @GetMapping("/all")
    public List<CommonDetailsCosting> getAll(){
        return commonDetailsCostingRepository.getByArchived(false);
    }

    @GetMapping("/waitingForApproval")
    public List<CommonDetailsCosting> getAllWaitingForApproval(){
        return commonDetailsCostingRepository.getByStatus(1);
    }

    @PutMapping("/update")
    public CommonDetailsCosting update(@RequestBody CommonDetailsCosting commonDetailsCosting){
        // this request will be sent from the specific costing screen
        // thus, it doesn't have the id
        // fetch the id using the totalDetailsId received and then update it
        String id = commonDetailsCostingRepository.getByTotalDetailsId(
                commonDetailsCosting.getTotalDetailsId()).getId();
        commonDetailsCosting.setId(id);
        return commonDetailsCostingRepository.save(commonDetailsCosting);
    }

    @PostMapping("/sampleHead")
    public List<CommonDetailsCosting> getAllForSampleHead(@RequestBody String[] trimTypes){
        return commonDetailsCostingRepository.getForSampleHead(trimTypes);
    }

    @GetMapping("/customer/{customerId}")
    public List<CommonDetailsCosting> getAllForCustomer(@PathVariable("customerId") String customerId){
        return commonDetailsCostingRepository.getForCustomer(customerId);
    }

    @GetMapping("/rejectedByCustomer")
    public List<CommonDetailsCosting> getAllRejectedByCustomer(){
        return commonDetailsCostingRepository.getByStatus(6);
    }

    @GetMapping("/TManager/{userId}")
    public List<CommonDetailsCosting>
    getAllForTManager(@PathVariable("userId") String userId){
        String[] territoryIds = userRepository.findById(userId).get().getTerritoryId();
        return commonDetailsCostingRepository.getForTerritoryManager(territoryIds);
    }

    @GetMapping("/executive/{id}")
    public List<CommonDetailsCosting> getAllForExecutive(@PathVariable("id") String id){
        return commonDetailsCostingRepository.getForExecutive(id);
    }

    @PutMapping("/archive")
    public CommonDetailsCosting archiveCommonDetails(@RequestBody CommonDetailsCosting commonDetailsCosting){
        return commonDetailsCostingRepository.save(commonDetailsCosting);
    }

    @GetMapping("/archived")
    public List<CommonDetailsCosting> getArchived(){
        return commonDetailsCostingRepository.getByArchived(true);
    }

    //Internal Calls from spring boot itself (costing sheet Controller - all trim type)
    public CommonDetailsCosting createInternal(CommonDetailsCosting commonDetailsCosting){
        return commonDetailsCostingRepository.save(commonDetailsCosting);
    }

    public CommonDetailsCosting updateInternal(CommonDetailsCosting commonDetailsCosting){
        // this request will be sent from the specific costing screen
        // thus, it doesn't have the id
        // fetch the id using the totalDetailsId received and then update it
        String id = commonDetailsCostingRepository.getByTotalDetailsId(
                commonDetailsCosting.getTotalDetailsId()).getId();
        commonDetailsCosting.setId(id);
        return commonDetailsCostingRepository.save(commonDetailsCosting);
    }

    @GetMapping("/copyAttachment/{date}/{fileName1}/{fileName2}")
    public Boolean copyAttachment(@PathVariable("date") String date,
                                  @PathVariable("fileName1") String fileName1,
                                  @PathVariable("fileName2") String fileName2){
        String path = date.replace('-', '/') + "/costing/";

        try {
            storageService.copyCosting(path, fileName1, fileName2);
            return true;
        }catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

}

package com.indsys.SpringBootBackEnd.v2.costingNew.controllers;

import com.indsys.SpringBootBackEnd.v2.costingNew.models.CostingRefNoSequence;
import com.indsys.SpringBootBackEnd.v2.costingNew.repositories.CostingRefNoSequenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sequence/costing")
@CrossOrigin(origins = "*")
public class CostingRefNoSequenceController {

    @Autowired
    CostingRefNoSequenceRepository costingRefNoSequenceRepository;

    @GetMapping("/woven")
    public int getLatestWovenSequence(){
        return costingRefNoSequenceRepository.findAll().get(0).getWoven();
    }

    @GetMapping("/printed")
    public int getLatestPrintedSequence(){
        return costingRefNoSequenceRepository.findAll().get(0).getPrinted();
    }

    @GetMapping("/tag")
    public int getLatestTagSequence(){
        return costingRefNoSequenceRepository.findAll().get(0).getTag();
    }

    @GetMapping("/stickerFlexo")
    public int getLatestStickerFlexoSequence(){
        return costingRefNoSequenceRepository.findAll().get(0).getStickerFlexo();
    }

    @GetMapping("/stickerOffset")
    public int getLatestStickerOffsetSequence(){
        return costingRefNoSequenceRepository.findAll().get(0).getStickerOffset();
    }

    public void incrementWovenSequence(){
        CostingRefNoSequence sequenceObj =  costingRefNoSequenceRepository.findAll().get(0);
        sequenceObj.setWoven(sequenceObj.getWoven()+1);
        costingRefNoSequenceRepository.save(sequenceObj);
    }

    public void incrementPrintedSequence(){
        CostingRefNoSequence sequenceObj =  costingRefNoSequenceRepository.findAll().get(0);
        sequenceObj.setPrinted(sequenceObj.getPrinted()+1);
        costingRefNoSequenceRepository.save(sequenceObj);
    }

    public void incrementTagSequence(){
        CostingRefNoSequence sequenceObj =  costingRefNoSequenceRepository.findAll().get(0);
        sequenceObj.setTag(sequenceObj.getTag()+1);
        costingRefNoSequenceRepository.save(sequenceObj);
    }

    public void incrementStickerFlexoSequence(){
        CostingRefNoSequence sequenceObj =  costingRefNoSequenceRepository.findAll().get(0);
        sequenceObj.setStickerFlexo(sequenceObj.getStickerFlexo()+1);
        costingRefNoSequenceRepository.save(sequenceObj);
    }

    public void incrementStickerOffsetSequence(){
        CostingRefNoSequence sequenceObj =  costingRefNoSequenceRepository.findAll().get(0);
        sequenceObj.setStickerOffset(sequenceObj.getStickerOffset()+1);
        costingRefNoSequenceRepository.save(sequenceObj);
    }

    @GetMapping("/initialize/{code}")
    public CostingRefNoSequence initializeForFirstUse(@PathVariable("code") String code){
        CostingRefNoSequence costingRefNoSequence = new CostingRefNoSequence();
        costingRefNoSequence.setWoven(0);
        costingRefNoSequence.setPrinted(0);
        costingRefNoSequence.setTag(0);
        costingRefNoSequence.setStickerFlexo(0);
        costingRefNoSequence.setStickerOffset(0);
        if(code.equals("indsys$123@")) {
            return costingRefNoSequenceRepository.save(costingRefNoSequence);
        }else{
            return costingRefNoSequence;
        }
    }
}

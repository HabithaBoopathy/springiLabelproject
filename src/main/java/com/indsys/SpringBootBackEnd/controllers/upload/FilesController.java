package com.indsys.SpringBootBackEnd.controllers.upload;

import java.util.List;
import java.util.stream.Collectors;

import com.indsys.SpringBootBackEnd.message.ResponseMessage;
import com.indsys.SpringBootBackEnd.models.upload.FileInfo;
import com.indsys.SpringBootBackEnd.service.FilesStorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

@Controller
@CrossOrigin("*")
public class FilesController {

  @Autowired
  FilesStorageService storageService;

  @PostMapping("/upload/{date}/{refno}/")
  public ResponseEntity<ResponseMessage> uploadFile(
          @PathVariable("date") String date,
          @PathVariable("refno") String refno,
          @RequestParam("file") MultipartFile file) {


    String path = "";

    if(!date.equals(" ")){
      String[] dateArr = date.split("-");
      path += dateArr[2]+"/"+dateArr[1]+"/"+dateArr[0]+"/";
    }

    if(!refno.equals(" ")){
      path += refno + "/";
    }

    System.out.println("Upload path " + path);

    String message = "";
    String latestName = "";
    try {
      storageService.save(file, path);

      message = "Uploaded the file successfully: " + file.getOriginalFilename();
      System.out.println(message);
      latestName = file.getOriginalFilename();

      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(latestName));
    } catch (Exception e) {
      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
      System.out.println(message);
      System.out.println(e);
//      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("File upload error. Please try again"));
    }
  }

  @PostMapping("/uploadquotation/{date}/{refno}/")
  public ResponseEntity<ResponseMessage> uploadQuotationFile(
          @PathVariable("date") String date,
          @PathVariable("refno") String refno,
          @RequestParam("file") MultipartFile file) {


    String path = "";

    if(!date.equals(" ")){
      String[] dateArr = date.split("-");
      path += dateArr[2]+"/"+dateArr[1]+"/"+dateArr[0]+"/";
    }

    if(!refno.equals(" ")){
      path += refno + "/";
    }

    System.out.println("Upload path " + path);

    String message = "";
    String latestName = "";
    try {
      storageService.saveQuotation(file, path);

      message = "Uploaded the file successfully: " + file.getOriginalFilename();
      System.out.println(message);
      latestName = file.getOriginalFilename();

      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(latestName));
    } catch (Exception e) {
      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
      System.out.println(message);
      System.out.println(e);
//      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("File upload error. Please try again"));
    }
  }

  @PostMapping("/uploadDirectQuotation/{date}/{fileName}/")
  public ResponseEntity<ResponseMessage> uploadDirectQuotation(
          @PathVariable("date") String date,
          @PathVariable("fileName") String fileName,
          @RequestParam("file") MultipartFile file) {


    String path = "";

    if(!date.equals(" ")){
      String[] dateArr = date.split("-");
      path += dateArr[2]+"/"+dateArr[1]+"/"+dateArr[0]+"/DirectQuotation/";
    }

    if(!fileName.equals(" ")){
      path += fileName + "/";
    }

    System.out.println("Upload path " + path);

    String message = "";
    String latestName = "";
    try {
      storageService.saveDirectQuotation(file, path);

      message = "Uploaded the file successfully: " + file.getOriginalFilename();
      System.out.println(message);
      latestName = file.getOriginalFilename();

      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(latestName));
    } catch (Exception e) {
      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
      System.out.println(message);
      System.out.println(e);
//      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("File upload error. Please try again"));
    }
  }
/*
  @PostMapping("/upload/{path}")
  public ResponseEntity<ResponseMessage> uploadArtWorkFile(@PathVariable("path") String path, @RequestParam("file") MultipartFile file) {
    String message = "";
    String latestName = "";
    try {
      System.out.println("Path : " + path);
      storageService.saveArtWork(file, path);

      message = "Uploaded the file successfully: " + file.getOriginalFilename();
      System.out.println(message);
      latestName = file.getOriginalFilename();

      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(latestName));
    } catch (Exception e) {
      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
      System.out.println(message);
      System.out.println(e);
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
    }
  }*/

  @GetMapping("/files")
  public ResponseEntity<List<FileInfo>> getListFiles() {
    List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
      String filename = path.getFileName().toString();
      String url = MvcUriComponentsBuilder
          .fromMethodName(FilesController.class, "getFile", path.getFileName().toString()).build().toString();

      return new FileInfo(filename, url);
    }).collect(Collectors.toList());

    return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
  }

  @GetMapping("/files/{filename:.+}")
  public ResponseEntity<Resource> getFile(@PathVariable String filename) {

    Resource file = storageService.load(filename);
    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
  }

  @GetMapping("/movefile/{date}/{refno}/{filename}/")
  public void movefile( @PathVariable("date") String date,
                        @PathVariable("refno") String refno,
                        @PathVariable("filename") String filename){


    storageService.move(date, refno, filename);
  }
}

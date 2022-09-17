package com.indsys.SpringBootBackEnd.controllers.upload;

import com.indsys.SpringBootBackEnd.configurations.RootPath;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.*;

@RestController
@RequestMapping("/deletefile")
@CrossOrigin("*")
public class DeleteFilesController {

    @GetMapping("/{date}/{refno}/{filename}/")
    public String del(
            @PathVariable("date") String date,
            @PathVariable("refno") String refno,
            @PathVariable("filename") String filename) throws IOException {

        String rootPath = RootPath.rootPath;

        Path path;

        if(!date.equals(" ")){
            String[] dateArr = date.split("-");
            rootPath += dateArr[2]+"/"+dateArr[1]+"/"+dateArr[0]+"/";
        }

        if(!refno.equals(" ")){
            rootPath += refno + "/";
        }

        if(!filename.equals(" ")){
            rootPath += filename;
        }

        System.out.println("Delete Path " + rootPath);
        path = Paths.get(rootPath);

//        if(filename.contains("---")){
//            String[] arr = filename.split("---");
//            String[] dateArr = arr[1].split("-");
//            filename = dateArr[2]+"/"+dateArr[1]+"/"+dateArr[0]+"/"+arr[0];
//        }
//        System.out.println("FName : " + filename);
//        System.out.println("Date : " + date);
//        System.out.println("refNo : " + refno);

        try {
            Files.delete(path);
            System.out.println("File or directory deleted successfully");
            return "File or directory deleted successfully";

        } catch (NoSuchFileException ex) {
            System.out.printf("No such file or directory: %s\n", path);
            return "No such file or directory: %s\n" + path;

        } catch (DirectoryNotEmptyException ex) {
            System.out.printf("Directory %s is not empty\n", path);
            return "Directory %s is not empty\n" + path;
            
        } catch (IOException ex) {
            System.out.println(ex);
            return ex.toString();
        }

    }
}

/*    // Testing Server
//        path = Paths.get("/home/Projects/SpringBootBackEnd/uploads/" + filename);
//    path=Paths.get("E:/spring-boot/SpringBootBackEnd/uploads/" + filename);

    //AWS
//        path = Paths.get("/code/SpringBootBackEnd/uploads/" + filename);

    //lightsail
//        path = Paths.get("/home/ubuntu/ilabel/uploads/" + filename);*/



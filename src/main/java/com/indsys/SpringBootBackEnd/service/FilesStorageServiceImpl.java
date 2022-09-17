package com.indsys.SpringBootBackEnd.service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
// import java.nio.file.StandardCopyOption;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

import com.indsys.SpringBootBackEnd.configurations.RootPath;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FilesStorageServiceImpl implements FilesStorageService {

  String rootPath = RootPath.rootPath;

  @Override
  public void init() {
    try {
      Files.createDirectory(Paths.get(rootPath.substring(0, rootPath.length()-1)));
    } catch (IOException e) {
      throw new RuntimeException("Could not initialize folder for upload!");
    }
  }

  @Override
  public void save(MultipartFile file, String path) {

//    rootPath += path;

    // backslash at the end is already added in the path string received
    if(!(new File(rootPath+path).exists())){
      new File(rootPath+path).mkdirs();
    }

    //now add filename to the rootPath
//    rootPath += file.getOriginalFilename();

    try {
//      Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
      Files.copy(file.getInputStream(), Paths.get(rootPath+path+file.getOriginalFilename()));
    } catch (Exception e) {
      throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
    }
  }

  @Override
  public void saveQuotation(MultipartFile file, String path) {

    // backslash at the end is already added in the path string received
    if(!(new File(rootPath+path).exists())){
      new File(rootPath+path).mkdirs();
    }

    try {
//      Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
      Files.copy(file.getInputStream(), Paths.get(rootPath+path+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
    } catch (Exception e) {
      throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
    }
  }

  @Override
  public void saveCosting(MultipartFile file, String path) {

//    rootPath += path;

    // backslash at the end is already added in the path string received
    if(!(new File(rootPath+path).exists())){
      new File(rootPath+path).mkdirs();
    }

    //now add filename to the rootPath
//    rootPath += file.getOriginalFilename();

    try {
//      Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
      Files.copy(file.getInputStream(), Paths.get(rootPath+path+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
    } catch (Exception e) {
      throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
    }
  }

  @Override
  public void copyCosting(String path, String fileName1, String fileName2){
    try {
      Files.copy(
              Paths.get(rootPath+path+fileName1),
              Paths.get(rootPath+path+fileName2)
      );
//              Paths.get(rootPath+path+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
    } catch (Exception e) {
      throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
    }
  }

  @Override
  public void saveDirectQuotation(MultipartFile file, String path) {

//    rootPath += path;

    // backslash at the end is already added in the path string received
    if(!(new File(rootPath+path).exists())){
      new File(rootPath+path).mkdirs();
    }

    //now add filename to the rootPath
//    rootPath += file.getOriginalFilename();

    try {
//      Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
      Files.copy(file.getInputStream(), Paths.get(rootPath+path+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
    } catch (Exception e) {
      throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
    }
  }

//  @Override
//  public void saveArtWork(MultipartFile file, String path) {
//
//    String[] dateArr = path.split("-");
//
//    if(!(new File(rootPath + dateArr[2] + "/").exists())){
//      new File(rootPath + dateArr[2] + "/").mkdir();
//    }
//
//    if(!(new File(rootPath + dateArr[2] + "/" + dateArr[1] + "/").exists())){
//      new File(rootPath + dateArr[2] + "/"  + dateArr[1] + "/").mkdir();
//    }
//
//    if(!(new File(rootPath + dateArr[2] + "/" + dateArr[1] + "/" + dateArr[0] + "/").exists())){
//      new File(rootPath + dateArr[2] + "/"  + dateArr[1] + "/" + dateArr[0] + "/").mkdir();
//    }
//
//    Path rootNew = Paths.get(rootPath + dateArr[2] + "/"  + dateArr[1] + "/" + dateArr[0]);
//
//    try {
//      Files.copy(file.getInputStream(), rootNew.resolve(file.getOriginalFilename()));
//    } catch (Exception e) {
//      throw new RuntimeException("Could not store the Artwork file. Error: " + e.getMessage());
//    }
//  }

  @Override
  public void move(String date, String refno, String filename){

    String oldPath = "", newPath = "";

    String[] dateArr = date.split("-");
    oldPath += dateArr[2]+"/"+dateArr[1]+"/"+dateArr[0]+"/";
    newPath += dateArr[2]+"/"+dateArr[1]+"/"+dateArr[0]+"/" + refno + "/";

    System.out.println("Old " + oldPath);
    System.out.println("New  " + newPath);
    System.out.println("fileName  " + filename);

    try {

      //create the directory
      if(!(new File(rootPath + newPath).exists())){

        new File(rootPath + newPath).mkdir();
        System.out.println("Directory created successfully");
      }else{
        System.out.println("Directory doesn't exist");
      }

      Files.move(Paths.get(rootPath + oldPath + filename), Paths.get(rootPath + newPath + filename));

      System.out.println("File moved successfully");

    } catch (Exception e) {
      throw new RuntimeException("Could not store the Artwork file. Error: " + e);
    }

  }

  @Override
  public Resource load(String filename) {
    Path file;
    if(filename.contains("---")){
      filename = filename.replace("---", "/");
      file = Paths.get(rootPath+filename);
    }else{
//      file = root.resolve(filename);
      throw new RuntimeException("Could not read the file. Invalid File path!");
    }

    try {
//      Path file = root.resolve(filename);
      Resource resource = new UrlResource(file.toUri());

      if (resource.exists() || resource.isReadable()) {
        return resource;
      } else {
        throw new RuntimeException("Could not read the file!");
      }
    } catch (MalformedURLException e) {
      throw new RuntimeException("Error: " + e.getMessage());
    }
  }

  @Override
  public void deleteAll() {
    FileSystemUtils.deleteRecursively(Paths.get(rootPath).toFile());
  }

  @Override
  public Stream<Path> loadAll() {
    try {
      return Files.walk(Paths.get(rootPath), 1).filter(path -> !path.equals(Paths.get(rootPath))).map(Paths.get(rootPath)::relativize);
    } catch (IOException e) {
      throw new RuntimeException("Could not load the files!");
    }
  }

}


  // AWS Server
//   private final Path root = Paths.get("/code/SpringBootBackEnd/uploads");

  //lightsail
//  private final Path root = Paths.get("/home/ubuntu/ilabel/uploads");

// Testing Server
//    private final Path root = Paths.get("/home/Projects/SpringBootBackEnd/uploads");

// Local
//    private final Path root = Paths.get("uploads");

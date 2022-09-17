package com.indsys.SpringBootBackEnd.service;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FilesStorageService {
  public void init();

  public void save(MultipartFile file, String path);

  public void saveCosting(MultipartFile file, String path);

  public void copyCosting(String path, String fileName1, String fileName2);

  public void saveQuotation(MultipartFile file, String path);

  public void saveDirectQuotation(MultipartFile file, String path);

  public void move(String date, String refno, String filename);

  public Resource load(String filename);

  public void deleteAll();

  public Stream<Path> loadAll();
}

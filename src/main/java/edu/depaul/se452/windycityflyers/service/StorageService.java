package edu.depaul.se452.windycityflyers.service;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import java.nio.file.Path;

public interface StorageService {

    void init();

    String store(MultipartFile file);


    Path load(String filename);

    Resource loadAsResource(String filename);

    void delete();

}
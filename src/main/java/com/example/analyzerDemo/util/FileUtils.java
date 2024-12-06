package com.example.analyzerDemo.util;

import com.example.analyzerDemo.dto.ImageDataDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {
    public static void generateJsonFileToPath(String path, ImageDataDTO pointList){
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(path.replace(".png", ".json")), pointList);
        }catch (Exception e){

        }
    }
}

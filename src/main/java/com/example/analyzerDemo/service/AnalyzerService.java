package com.example.analyzerDemo.service;

import com.example.analyzerDemo.dto.PointDTO;
import com.example.analyzerDemo.dto.ImageDataDTO;
import com.example.analyzerDemo.util.FileUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnalyzerService {
    private final OpacityService opacityService;

    public void generatePixelsDataAsJson(String pathToImageFile) {
        List<PointDTO> pointList = new ArrayList<>();
        ImageDataDTO pointListDTO = new ImageDataDTO(null,pointList);
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(pathToImageFile));
        } catch (Exception e) {

        }
        int width = image.getWidth();
        int height = image.getHeight();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = image.getRGB(x, y);
                double pixelOpacity = opacityService.calculatePixelOpacityBasedOnRGB(rgb);
                pointList.add(new PointDTO(x, y, pixelOpacity));
            }
        }
        FileUtils.generateJsonFileToPath(pathToImageFile, pointListDTO);
    }
}
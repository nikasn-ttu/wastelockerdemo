package com.example.analyzerDemo.service;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class OpacityService{
    private final DecimalFormat df = new DecimalFormat("#.##");

    public double calculatePixelOpacityBasedOnRGB(int rgb) {
        int red = (rgb >> 16) & 0xFF;
        int green = (rgb >> 8) & 0xFF;
        int blue = rgb & 0xFF;
        double brightness = 0.299 * red + 0.587 * green + 0.114 * blue;
        double opacity = 1 - (brightness / 255.0);
        return Double.parseDouble(df.format(opacity));
    }
}

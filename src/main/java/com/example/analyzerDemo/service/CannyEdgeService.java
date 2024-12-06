package com.example.analyzerDemo.service;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.springframework.stereotype.Service;

@Service
public class CannyEdgeService {
    public void test(){
        // Load OpenCV native library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        // Read the input image
        String inputFilePath = "/Users/nikitakasnikov/Downloads/FugitiveEmissions-SampleFrames-1/0001.png";
        Mat src = Imgcodecs.imread(inputFilePath);

        if (src.empty()) {
            System.out.println("Error: Cannot load image!");
            return;
        }

        // Convert the image to grayscale
        Mat gray = new Mat();
        Imgproc.cvtColor(src, gray, Imgproc.COLOR_BGR2GRAY);

        // Apply Gaussian Blur to reduce noise
        Mat blurred = new Mat();
        Imgproc.GaussianBlur(gray, blurred, new Size(5, 5), 1.5);

        // Apply Canny edge detection
        Mat edges = new Mat();
        double lowerThreshold = 50;  // Lower threshold for edge detection
        double upperThreshold = 150; // Upper threshold for edge detection
        Imgproc.Canny(blurred, edges, lowerThreshold, upperThreshold);

        // Save the output image
        String outputFilePath = "edges.jpg";
        Imgcodecs.imwrite(outputFilePath, edges);

        System.out.println("Canny edge detection completed. Output saved to " + outputFilePath);
    }
}

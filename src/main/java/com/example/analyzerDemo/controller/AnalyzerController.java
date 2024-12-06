package com.example.analyzerDemo.controller;

import com.example.analyzerDemo.dto.FilePathDTO;
import com.example.analyzerDemo.service.AnalyzerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/analyzer-service")
@RequiredArgsConstructor
public class AnalyzerController {
    private final AnalyzerService analyzerService;
    @PostMapping("/image/pixel/json")
    public ResponseEntity<String> generateJsonImagePixelsData(@RequestBody FilePathDTO filePathDTO){
        analyzerService.generatePixelsDataAsJson(filePathDTO.pathToFile);
        return ResponseEntity.ok().build();
    }
}

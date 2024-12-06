package com.example.analyzerDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class ImageDataDTO {
    public String concentration;
    public List<PointDTO> pointDtoList;
}

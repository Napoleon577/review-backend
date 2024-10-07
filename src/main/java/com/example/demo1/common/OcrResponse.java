package com.example.demo1.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OcrResponse {
    private String type;
    private Object data;

}
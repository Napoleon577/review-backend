package com.example.demo1.common;

public class OcrResponseTwo {
    private OcrResponse result1;
    private OcrResponse result2;

    public OcrResponseTwo(OcrResponse result1, OcrResponse result2) {
        this.result1 = result1;
        this.result2 = result2;
    }

    public OcrResponse getResult1() {
        return result1;
    }

    public void setResult1(OcrResponse result1) {
        this.result1 = result1;
    }

    public OcrResponse getResult2() {
        return result2;
    }

    public void setResult2(OcrResponse result2) {
        this.result2 = result2;
    }
}

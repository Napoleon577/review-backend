package com.example.demo1.controller;

import com.example.demo1.common.OcrResponse;
import com.example.demo1.common.OcrResponseTwo;
import com.example.demo1.service.OcrClient;
import com.example.demo1.service.ocrModel.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class OcrController {

    @Autowired
    private OcrClient ocrClient;

    @RequestMapping("/ocr")
    public ResponseEntity<?> ocr(@RequestBody Map<String, String> request) throws Exception {
        // 从请求体中获取URL
        String imageUrl = request.get("url");
        if (imageUrl == null || imageUrl.isEmpty()) {
            throw new IllegalArgumentException("URL 参数不能为空");
        }
        // 调用通用识别API
        String result = ocrClient.recognizeGeneral(imageUrl);
        // 解析JSON数据
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(result);
        String text = jsonNode.get("content").asText();
        if (text.contains("申请书")&&text.contains("公司登记")) {
            //自定义模板1
            FormOne formOne = new FormOne();
            //返回识别的json数据，给前端处理
            return  ResponseEntity.ok(new OcrResponse("/reviewOne",formOne.formOneOcr(imageUrl)));
        }
        if (text.contains("指定代表/委托代理人") || text.contains("申请人签署")) {
            //自定义模板2
            FormTwo formTwo = new FormTwo();
            IdCard idCard = new IdCard();
            OcrResponse idResult = new OcrResponse("/idCard", idCard.IdCardOcr(imageUrl));
            OcrResponse reviewTwo = new OcrResponse("/reviewTwo", formTwo.formTwoOcr(imageUrl));
            return  ResponseEntity.ok(new OcrResponseTwo(idResult,reviewTwo));
        }
        if (text.contains("附表1")) {
            //自定义表单4
            FormThree formThree = new FormThree();
            IdCard idCard = new IdCard();
            OcrResponse idResult = new OcrResponse("/idCard", idCard.IdCardOcr(imageUrl));
            OcrResponse reviewThree = new OcrResponse("/reviewThree", formThree.formThreeOcr(imageUrl));
            return  ResponseEntity.ok(new OcrResponseTwo(idResult,reviewThree));
        }
        if (text.contains("附表4")) {
            //自定义表单5
            FormFour formFour = new FormFour();
            IdCard idCard = new IdCard();
            OcrResponse idResult = new OcrResponse("/idCard", idCard.IdCardOcr(imageUrl));
            OcrResponse reviewFour = new OcrResponse("/reviewFour", formFour.formThreeOcr(imageUrl));
            return  ResponseEntity.ok(new OcrResponseTwo(idResult,reviewFour));
        }
        return ResponseEntity.ok(new OcrResponse("unknown", "未识别到对应的模板"));
    }
}


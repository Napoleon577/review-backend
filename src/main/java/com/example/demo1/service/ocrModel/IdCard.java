package com.example.demo1.service.ocrModel;

import com.aliyun.ocr_api20210707.models.RecognizeIdcardResponse;
import com.aliyun.ocr_api20210707.models.RecognizeIdcardResponseBody;
import com.aliyun.tea.TeaException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class IdCard {

    public static com.aliyun.ocr_api20210707.Client createClient() throws Exception {
        //韦宁key
        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config()
                .setAccessKeyId("")
                .setAccessKeySecret("");
        config.endpoint = "ocr-api.cn-hangzhou.aliyuncs.com";
        return new com.aliyun.ocr_api20210707.Client(config);
    }

    public String IdCardOcr(String imageUrl) throws Exception {
        com.aliyun.ocr_api20210707.Client client = IdCard.createClient();
        com.aliyun.ocr_api20210707.models.RecognizeIdcardRequest recognizeIdcardRequest = new com.aliyun.ocr_api20210707.models.RecognizeIdcardRequest()
                .setUrl(imageUrl);
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        try {
            // 复制代码运行请自行打印 API 的返回值
            RecognizeIdcardResponse recognizeIdcardResponse = client.recognizeIdcardWithOptions(recognizeIdcardRequest, runtime);
            RecognizeIdcardResponseBody body = recognizeIdcardResponse.getBody();
            // 将响应体转换为JSON字符串
            ObjectMapper objectMapper = new ObjectMapper();
            // 返回包含JSON数据的响应体
            return objectMapper.writeValueAsString(body);
        } catch (TeaException error) {
            // 此处仅做打印展示，请谨慎对待异常处理，在工程项目中切勿直接忽略异常。
            // 错误 message
            System.out.println(error.getMessage());
            // 诊断地址
            System.out.println(error.getData().get("Recommend"));
            com.aliyun.teautil.Common.assertAsString(error.message);
        } catch (Exception _error) {
            TeaException error = new TeaException(_error.getMessage(), _error);
            // 此处仅做打印展示，请谨慎对待异常处理，在工程项目中切勿直接忽略异常。
            // 错误 message
            System.out.println(error.getMessage());
            // 诊断地址
            System.out.println(error.getData().get("Recommend"));
            com.aliyun.teautil.Common.assertAsString(error.message);
        }
        return null;
    }
}

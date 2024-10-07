package com.example.demo1.service;

import com.aliyun.ocr_api20210707.models.RecognizeGeneralResponse;
import com.aliyun.ocr_api20210707.models.RecognizeGeneralResponseBody;
import com.aliyun.tea.TeaException;
import org.springframework.stereotype.Service;

/*
    通用识别接口
 */
@Service
public class OcrClient {
    public static com.aliyun.ocr_api20210707.Client createClient() throws Exception {
        //韦宁key
        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config()
                .setAccessKeyId("")
                .setAccessKeySecret("");
        config.endpoint = "ocr-api.cn-hangzhou.aliyuncs.com";
        return new com.aliyun.ocr_api20210707.Client(config);
    }
    public String recognizeGeneral(String imageUrl) throws Exception {

        com.aliyun.ocr_api20210707.Client client = OcrClient.createClient();
        com.aliyun.ocr_api20210707.models.RecognizeGeneralRequest recognizeGeneralRequest = new com.aliyun.ocr_api20210707.models.RecognizeGeneralRequest()
                .setUrl(imageUrl);
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        try {
            // 复制代码运行请自行打印 API 的返回值
            RecognizeGeneralResponse recognizeGeneralResponse = client.recognizeGeneralWithOptions(recognizeGeneralRequest, runtime);
            RecognizeGeneralResponseBody body = recognizeGeneralResponse.getBody();
            return body.getData();
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

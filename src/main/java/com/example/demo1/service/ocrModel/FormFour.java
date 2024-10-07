package com.example.demo1.service.ocrModel;

import com.aliyun.documentautoml20221229.models.PredictTemplateModelResponse;
import com.aliyun.documentautoml20221229.models.PredictTemplateModelResponseBody;
import com.aliyun.tea.*;
import com.fasterxml.jackson.databind.ObjectMapper;
/*
    自定义表格2
 */
public class FormFour {

    public static com.aliyun.documentautoml20221229.Client createClient() throws Exception {
        // 工程代码泄露可能会导致 AccessKey 泄露，并威胁账号下所有资源的安全性。以下代码示例仅供参考。
        // 建议使用更安全的 STS 方式，更多鉴权访问方式请参见：https://help.aliyun.com/document_detail/378657.html。
        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config()
                .setAccessKeyId("")
                .setAccessKeySecret("");
        // Endpoint 请参考 https://api.aliyun.com/product/documentAutoml
        config.endpoint = "documentautoml.cn-beijing.aliyuncs.com";
        return new com.aliyun.documentautoml20221229.Client(config);
    }
    //自定义表单3
    public String formThreeOcr(String imageUrl) throws Exception {
        com.aliyun.documentautoml20221229.Client client = FormTwo.createClient();
        com.aliyun.documentautoml20221229.models.PredictTemplateModelRequest predictTemplateModelRequest = new com.aliyun.documentautoml20221229.models.PredictTemplateModelRequest()
                .setTaskId(35671L)
                .setContent(imageUrl);
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        try {
            // 复制代码运行请自行打印 API 的返回值
            PredictTemplateModelResponse predictTemplateModelResponse = client.predictTemplateModelWithOptions(predictTemplateModelRequest, runtime);
            PredictTemplateModelResponseBody body = predictTemplateModelResponse.getBody();
            ObjectMapper objectMapper = new ObjectMapper();
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



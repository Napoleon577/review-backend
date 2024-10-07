package com.example.demo1.service.ocrModel;

import com.aliyun.documentautoml20221229.Client;
import com.aliyun.documentautoml20221229.models.PredictTemplateModelRequest;
import com.aliyun.documentautoml20221229.models.PredictTemplateModelResponse;
import com.aliyun.documentautoml20221229.models.PredictTemplateModelResponseBody;
import com.aliyun.tea.TeaException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class FormOne {
    public static com.aliyun.documentautoml20221229.Client createClient() throws Exception {
       //自定义模板key
        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config()
                .setAccessKeyId("")
                .setAccessKeySecret("");
        config.endpoint = "documentautoml.cn-beijing.aliyuncs.com";
        return new com.aliyun.documentautoml20221229.Client(config);
    }
    //自定义表单1
    public String formOneOcr(String imageUrl) throws Exception {
        Client client = FormOne.createClient();
        PredictTemplateModelRequest predictTemplateModelRequest = new PredictTemplateModelRequest()
                .setTaskId(35359L)
                .setContent(imageUrl);
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        try {
            // 复制代码运行请自行打印 API 的返回值
            PredictTemplateModelResponse predictTemplateModelResponse = client.predictTemplateModelWithOptions(predictTemplateModelRequest, runtime);
            PredictTemplateModelResponseBody body = predictTemplateModelResponse.getBody();
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
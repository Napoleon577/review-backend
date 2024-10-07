package com.example.demo1.service;

import com.example.demo1.DTO.AuditResult;
import com.example.demo1.entity.FormData1;
import com.example.demo1.entity.FormData2;
import com.example.demo1.entity.FormData3;
import com.example.demo1.entity.FormData4;

import java.util.Map;

public interface FormDataService {

    Map<String, AuditResult> auditFormData1(FormData1 formData1);
    Map<String, AuditResult> auditFormData2(FormData2 formData2);
    Map<String, AuditResult> auditFormData3(FormData3 formData3);
    Map<String, AuditResult> auditFormData4(FormData4 formData4);

}

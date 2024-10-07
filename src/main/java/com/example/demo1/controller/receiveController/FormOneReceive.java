package com.example.demo1.controller.receiveController;

import com.example.demo1.DTO.AuditResult;
import com.example.demo1.entity.FormData1;
import com.example.demo1.service.FormDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class FormOneReceive {
    private final FormDataService formDataService;

    public FormOneReceive(FormDataService formDataService) {
        this.formDataService = formDataService;
    }

    @PostMapping("/reviewOne")
    public ResponseEntity<Map<String, AuditResult>> receiveOne(@RequestBody FormData1 formData1) {
        Map<String, AuditResult> auditResults = formDataService.auditFormData1(formData1);
        System.out.println("Audit Results" + auditResults);

        // 返回审核结果
        return ResponseEntity.ok(auditResults);
    }
}



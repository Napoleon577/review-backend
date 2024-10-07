package com.example.demo1.controller.receiveController;

import com.example.demo1.DTO.AuditResult;
import com.example.demo1.entity.FormData2;
import com.example.demo1.service.FormDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class FormTwoReceive {
    private final FormDataService formDataService;

    public FormTwoReceive(FormDataService formDataService) {
        this.formDataService = formDataService;
    }

    @PostMapping("/reviewTwo")
    public ResponseEntity<Map<String, AuditResult>> receiveTwo(@RequestBody FormData2 formData2) {
        Map<String, AuditResult> auditResults = formDataService.auditFormData2(formData2);
        System.out.println("Audit Results" + auditResults);
        // 返回审核结果
        return ResponseEntity.ok(auditResults);
    }
}

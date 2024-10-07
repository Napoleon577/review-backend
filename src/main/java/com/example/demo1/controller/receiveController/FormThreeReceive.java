package com.example.demo1.controller.receiveController;

import com.example.demo1.DTO.AuditResult;
import com.example.demo1.entity.FormData3;
import com.example.demo1.service.FormDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RestController
public class FormThreeReceive {
    private final FormDataService formDataService;

    public FormThreeReceive(FormDataService formDataService) {
        this.formDataService = formDataService;
    }

    @PostMapping("/reviewThree")
    public ResponseEntity<Map<String, AuditResult>> receiveThree(@RequestBody FormData3 formData3) {
        Map<String, AuditResult> auditResults = formDataService.auditFormData3(formData3);
        System.out.println("Audit Results" + auditResults);
        // 返回审核结果
        return ResponseEntity.ok(auditResults);
    }
}

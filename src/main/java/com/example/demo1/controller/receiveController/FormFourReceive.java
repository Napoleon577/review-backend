package com.example.demo1.controller.receiveController;

import com.example.demo1.DTO.AuditResult;
import com.example.demo1.entity.FormData4;
import com.example.demo1.service.FormDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RestController
public class FormFourReceive {
    private final FormDataService formDataService;

    public FormFourReceive(FormDataService formDataService) {
        this.formDataService = formDataService;
    }

    @PostMapping("/reviewFour")
    public ResponseEntity<Map<String, AuditResult>> receiveFour(@RequestBody FormData4 formData4) {
        Map<String, AuditResult> auditResults = formDataService.auditFormData4(formData4);
        System.out.println("Audit Results" + auditResults);
        // 返回审核结果
        return ResponseEntity.ok(auditResults);
    }
}

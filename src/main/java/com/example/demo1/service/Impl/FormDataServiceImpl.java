package com.example.demo1.service.Impl;

import com.example.demo1.DTO.AuditResult;
import com.example.demo1.entity.FormData1;
import com.example.demo1.entity.FormData2;
import com.example.demo1.entity.FormData3;
import com.example.demo1.entity.FormData4;
import com.example.demo1.service.FormDataService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class FormDataServiceImpl implements FormDataService {

    @Override
    public Map<String, AuditResult> auditFormData1(FormData1 formData1) {
        Map<String, AuditResult> auditResults = new HashMap<>();
        String companyName = formData1.getCompanyName();
        String socialCode = formData1.getSocialCode();
        String residence = formData1.getResidence();
        String contactNumber = formData1.getContactNumber();
        int postalCode = formData1.getPostalCode();
        String nameOfLegalRepresentative = formData1.getNameOfLegalRepresentative();

        // 审核 companyName 字段
        if (companyName == null || companyName.trim().isEmpty()) {
            auditResults.put("companyName", new AuditResult(false, "公司名称不能为空"));
        } else if (companyName.length() < 2 || companyName.length() > 100) {
            auditResults.put("companyName", new AuditResult(false, "公司名称长度必须为2到100字符"));
        } else {
            auditResults.put("companyName", new AuditResult(true, null));
        }

        // 审核 socialCode 字段
        String socialCodePattern = "^[0-9A-Z]{18}$";
        if (socialCode == null || socialCode.trim().isEmpty()) {
            auditResults.put("socialCode", new AuditResult(false, "统一社会信用代码不能为空"));
        } else if (!socialCode.matches(socialCodePattern)) {
            auditResults.put("socialCode", new AuditResult(false, "统一社会信用代码必须为18位数字"));
        } else {
            auditResults.put("socialCode", new AuditResult(true, null));
        }


        // 审核 residence 字段
        if (residence == null || residence.trim().isEmpty()) {
            auditResults.put("residence", new AuditResult(false, "住所不能为空"));
        } else {
            auditResults.put("residence", new AuditResult(true, null));
        }


        // 审核 contactNumber 字段
        String phonePattern = "^[+]?[0-9-]{7,15}$";
        if (contactNumber == null || contactNumber.trim().isEmpty()) {
            auditResults.put("contactNumber", new AuditResult(false, "联系电话不能为空"));
        } else if (!contactNumber.matches(phonePattern)) {
            auditResults.put("contactNumber", new AuditResult(false, "联系电话格式无效"));
        } else {
            auditResults.put("contactNumber", new AuditResult(true, null));
        }


        // 审核 postalCode 字段
        String postalCodePattern = "^[0-9]{5,6}$";
        if (postalCode == 0) {
            auditResults.put("postalCode", new AuditResult(false, "邮政编码不能为空"));
        } else if (!String.valueOf(postalCode).matches(postalCodePattern)) {
            auditResults.put("postalCode", new AuditResult(false, "邮政编码必须是5~6位数字"));
        } else {
            auditResults.put("postalCode", new AuditResult(true, null));
        }


        // 审核 nameOfLegalRepresentative 字段
        if (nameOfLegalRepresentative == null || nameOfLegalRepresentative.trim().isEmpty()) {
            auditResults.put("nameOfLegalRepresentative", new AuditResult(false, "法定代表人姓名不能为空"));
        } else if (nameOfLegalRepresentative.length() < 2 || nameOfLegalRepresentative.length() > 50) {
            auditResults.put("nameOfLegalRepresentative", new AuditResult(false, "法定代表人姓名长度必须大于2，小于50"));
        } else {
            auditResults.put("nameOfLegalRepresentative", new AuditResult(true, null));
        }

        return auditResults;
    }

    //表格2审核
    @Override
    public Map<String, AuditResult> auditFormData2(FormData2 formData2) {
        Map<String, AuditResult> auditResults = new HashMap<>();

        // 审核身份证信息字段
        String idNumberPattern = "^[1-9]\\d{5}(18|19|20)?\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])\\d{3}(\\d|X)$";
        if (formData2.getIdNumber() == null || formData2.getIdNumber().trim().isEmpty()) {
            auditResults.put("idNumber", new AuditResult(false, "身份证号码不能为空"));
        } else if (!formData2.getIdNumber().matches(idNumberPattern)) {
            auditResults.put("idNumber", new AuditResult(false, "身份证号码格式不正确"));
        } else {
            auditResults.put("idNumber", new AuditResult(true, null));
        }

        // 审核姓名字段
        if (formData2.getName() == null || formData2.getName().trim().isEmpty()) {
            auditResults.put("name", new AuditResult(false, "姓名不能为空"));
        } else if (formData2.getName().length() < 2 || formData2.getName().length() > 10) {
            auditResults.put("name", new AuditResult(false, "姓名长度必须在2到10个字符之间"));
        } else {
            auditResults.put("name", new AuditResult(true, null));
        }

        // 审核性别字段
        if (formData2.getSex() == null || formData2.getSex().trim().isEmpty()) {
            auditResults.put("sex", new AuditResult(false, "性别不能为空"));
        } else if (!formData2.getSex().matches("^[男|女]{1}$")) {
            auditResults.put("sex", new AuditResult(false, "性别格式不正确"));
        } else {
            auditResults.put("sex", new AuditResult(true, null));
        }

        // 审核出生日期字段
        if (formData2.getBirthDate() == null || formData2.getBirthDate().trim().isEmpty()) {
            auditResults.put("birthDate", new AuditResult(false, "出生日期不能为空"));
        } else {
            // 这里可以添加更详细的日期格式验证
            auditResults.put("birthDate", new AuditResult(true, null));
        }

        // 审核地址字段
        if (formData2.getAddress() == null || formData2.getAddress().trim().isEmpty()) {
            auditResults.put("address", new AuditResult(false, "地址不能为空"));
        } else {
            auditResults.put("address", new AuditResult(true, null));
        }

        // 审核办理地址字段
        if (formData2.getIssueAuthority() == null || formData2.getIssueAuthority().trim().isEmpty()) {
            auditResults.put("issueAuthority", new AuditResult(false, "办理地址不能为空"));
        } else {
            auditResults.put("issueAuthority", new AuditResult(true, null));
        }

        // 审核生效-到期字段
        if (formData2.getValidPeriod() == null || formData2.getValidPeriod().trim().isEmpty()) {
            auditResults.put("validPeriod", new AuditResult(false, "身份证有效日期不能为空"));
        } else {
            auditResults.put("issueAuthority", new AuditResult(true, null));
        }

        // 审核固定电话字段
        if (formData2.getLandlineTelephone() == null || formData2.getLandlineTelephone().isEmpty()) {
            auditResults.put("landlineTelephone", new AuditResult(false, "固定电话不能为空"));
        } else {
            auditResults.put("landlineTelephone", new AuditResult(true, null));
        }

// 审核移动电话字段
        String mobilePhonePattern = "^[1]([3-9])[0-9]{9}$";
        if (formData2.getMobilePhone() == null || formData2.getMobilePhone().isEmpty()) {
            auditResults.put("mobilePhone", new AuditResult(false, "移动电话不能为空"));
        } else if (!formData2.getMobilePhone().matches(mobilePhonePattern)) {
            auditResults.put("mobilePhone", new AuditResult(false, "移动电话号码格式不正确"));
        } else {
            auditResults.put("mobilePhone", new AuditResult(true, null));
        }

        // 审核指定人签名字段
        if (formData2.getSignatureOfDesignated() == null || formData2.getSignatureOfDesignated().trim().isEmpty()) {
            auditResults.put("signatureOfDesignated", new AuditResult(false, "指定人签名不能为空"));
        } else {
            auditResults.put("signatureOfDesignated", new AuditResult(true, null));
        }

        // 审核法定代表人签名字段
        if (formData2.getSignatureOfLegalRepresentative() == null || formData2.getSignatureOfLegalRepresentative().trim().isEmpty()) {
            auditResults.put("signatureOfLegalRepresentative", new AuditResult(false, "法定代表人签名不能为空"));
        } else {
            auditResults.put("signatureOfLegalRepresentative", new AuditResult(true, null));
        }

        // 审核签名日期字段
        if (formData2.getSignatureDate() == null || formData2.getSignatureDate().trim().isEmpty()) {
            auditResults.put("signatureDate", new AuditResult(false, "签名日期不能为空"));
        } else {
            // 这里可以添加更详细的日期验证
            auditResults.put("signatureDate", new AuditResult(true, null));
        }

        return auditResults;
    }

    //表格3审核
    @Override
    public Map<String, AuditResult> auditFormData3(FormData3 formData3) {
        Map<String, AuditResult> auditResults = new HashMap<>();

        // 审核 name 字段
        String name = formData3.getName();
        if (name == null || name.trim().isEmpty()) {
            auditResults.put("name", new AuditResult(false, "身份证姓名不能为空"));
        } else {
            auditResults.put("name", new AuditResult(true, null));
        }
        //审核表格name与身份证name
        // 审核 formName 字段
        String formName = formData3.getFormName();
        if (formName == null || formName.trim().isEmpty()) {
            auditResults.put("formName", new AuditResult(false, "表格名称不能为空"));
        }
        if (!formName.equals(name)) {
            auditResults.put("formName", new AuditResult(false, "表格名称与身份证名字不一致"));
        } else {
            auditResults.put("formName", new AuditResult(true, null));
        }
        // 审核生效-到期字段
        if (formData3.getValidPeriod() == null || formData3.getValidPeriod().trim().isEmpty()) {
            auditResults.put("validPeriod", new AuditResult(false, "身份证有效日期不能为空"));
        } else {
            auditResults.put("validPeriod", new AuditResult(true, null));
        }

        // 审核 country 字段
        String country = formData3.getCountry();
        if (country == null || country.trim().

                isEmpty()) {
            auditResults.put("country", new AuditResult(false, "国家不能为空"));
        } else {
            auditResults.put("country", new AuditResult(true, null));
        }

        // 审核 productionMode 字段
        String productionMode = formData3.getProductionMode();
        if (productionMode == null || productionMode.trim().

                isEmpty()) {
            auditResults.put("productionMode", new AuditResult(false, "生产模式不能为空"));
        } else {
            auditResults.put("productionMode", new AuditResult(true, null));
        }

        // 审核 typeOfIdentityDocument 字段
        String typeOfIdentityDocument = formData3.getTypeOfIdentityDocument();
        if (typeOfIdentityDocument == null || typeOfIdentityDocument.trim().

                isEmpty()) {
            auditResults.put("typeOfIdentityDocument", new AuditResult(false, "身份证明类型不能为空"));
        } else {
            auditResults.put("typeOfIdentityDocument", new AuditResult(true, null));
        }

        // 审核 idNumber 字段
        String idNumber = formData3.getIdNumber();
        if (idNumber == null || idNumber.trim().

                isEmpty()) {
            auditResults.put("idNumber", new AuditResult(false, "身份证号码不能为空"));
        }

        //审核idNumber和formIdNumber
        String formIdNumber = formData3.getFormIdNumber();
        if (!formIdNumber.equals(idNumber)) {
            auditResults.put("formIdNumber", new AuditResult(false, "表格身份证号码与身份证号码不一致"));
        } else {
            auditResults.put("formIdNumber", new AuditResult(true, null));
        }

        // 审核 landlineTelephone 字段
        String landlineTelephone = formData3.getLandlineTelephone();
        // 审核固定电话字段
        if (landlineTelephone == null || landlineTelephone.isEmpty()) {
            auditResults.put("landlineTelephone", new AuditResult(false, "固定电话不能为空"));
        } else {
            auditResults.put("landlineTelephone", new AuditResult(true, null));
        }

        // 审核 mobilePhone 字段
        String mobilePhone = formData3.getMobilePhone();
        String mobilePhonePattern = "^[1]([3-9])[0-9]{9}$"; // 假设手机号码符合中国大陆的格式
        if (mobilePhone == null || mobilePhone.trim().

                isEmpty()) {
            auditResults.put("mobilePhone", new AuditResult(false, "手机号码不能为空"));
        } else if (!mobilePhone.matches(mobilePhonePattern)) {
            auditResults.put("mobilePhone", new AuditResult(false, "手机号码格式不正确"));
        } else {
            auditResults.put("mobilePhone", new AuditResult(true, null));
        }

        // 审核 residence 字段
        String residence = formData3.getResidence();
        if (residence == null || residence.trim().

                isEmpty()) {
            auditResults.put("residence", new AuditResult(false, "居住地址不能为空"));
        } else {
            auditResults.put("residence", new AuditResult(true, null));
        }

        // 审核 emailAddress 字段
        String emailAddress = formData3.getEmailAddress();
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (emailAddress == null || emailAddress.trim().

                isEmpty()) {
            auditResults.put("emailAddress", new AuditResult(false, "电子邮件地址不能为空"));
        } else if (!emailAddress.matches(emailPattern)) {
            auditResults.put("emailAddress", new AuditResult(false, "电子邮件地址格式不正确"));
        } else {
            auditResults.put("emailAddress", new AuditResult(true, null));
        }

        // 审核 signatureOfTheProposedLegalRepresentative 字段
        String signatureOfTheProposedLegalRepresentative = formData3.getSignatureOfTheProposedLegalRepresentative();
        if (signatureOfTheProposedLegalRepresentative == null || signatureOfTheProposedLegalRepresentative.trim().

                isEmpty()) {
            auditResults.put("signatureOfTheProposedLegalRepresentative", new AuditResult(false, "法定代表人签名不能为空"));
        } else {
            auditResults.put("signatureOfTheProposedLegalRepresentative", new AuditResult(true, null));
        }

        // 审核 signatureDate 字段

        String signatureDate = formData3.getSignatureDate();
        if (signatureDate == null || signatureDate.trim().
                isEmpty()) {
            auditResults.put("signatureDate", new AuditResult(false, "签名日期不能为空"));
        }else {
            auditResults.put("signatureDate", new AuditResult(true, "null"));
        }


        return auditResults;
    }

    //表单5审核
    @Override
    public Map<String, AuditResult> auditFormData4(FormData4 formData4) {

        Map<String, AuditResult> auditResults = new HashMap<>();

        // 审核 name 字段
        String name = formData4.getName();
        if (name == null || name.trim().isEmpty()) {
            auditResults.put("name", new AuditResult(false, "姓名不能为空"));
        } else {
            auditResults.put("name", new AuditResult(true, null));
        }

        // 审核 sex 字段
        String sex = formData4.getSex();
        if (sex == null || sex.trim().isEmpty()) {
            auditResults.put("sex", new AuditResult(false, "性别不能为空"));
        } else {
            auditResults.put("sex", new AuditResult(true, null));
        }

        // 审核 birthDate 字段
        String birthDate = formData4.getBirthDate();
        String birthDatePattern = "^[0-9]{4}年(0[1-9]|1[0-2])月(0[1-9]|[12][0-9]|3[01])日$";
        if (birthDate == null || birthDate.trim().isEmpty()) {
            auditResults.put("birthDate", new AuditResult(false, "出生日期不能为空"));
        } else if (!birthDate.matches(birthDatePattern)) {
            auditResults.put("birthDate", new AuditResult(false, "出生日期格式不正确"));
        } else {
            auditResults.put("birthDate", new AuditResult(true, null));
        }

        // 审核 address 字段
        String address = formData4.getAddress();
        if (address == null || address.trim().isEmpty()) {
            auditResults.put("address", new AuditResult(false, "地址不能为空"));
        } else {
            auditResults.put("address", new AuditResult(true, null));
        }

        // 审核 idNumber 字段
        String idNumber = formData4.getIdNumber();
        String idNumberPattern = "^[1-9]\\d{5}(18|19|20)?\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])\\d{3}([0-9Xx])$";
        if (idNumber == null || idNumber.trim().isEmpty()) {
            auditResults.put("idNumber", new AuditResult(false, "身份证号码不能为空"));
        } else if (!idNumber.matches(idNumberPattern)) {
            auditResults.put("idNumber", new AuditResult(false, "身份证号码格式不正确"));
        } else {
            auditResults.put("idNumber", new AuditResult(true, null));
        }

        // 审核 issueAuthority 字段
        String issueAuthority = formData4.getIssueAuthority();
        if (issueAuthority == null || issueAuthority.trim().isEmpty()) {
            auditResults.put("issueAuthority", new AuditResult(false, "发证机关不能为空"));
        } else {
            auditResults.put("issueAuthority", new AuditResult(true, null));
        }

        // 审核 validPeriod 字段
        String validPeriod = formData4.getValidPeriod();
        if (validPeriod == null || validPeriod.trim().isEmpty()) {
            auditResults.put("validPeriod", new AuditResult(false, "有效期限不能为空"));
        } else {
            auditResults.put("validPeriod", new AuditResult(true, null));
        }

        // 审核 formName 字段
        String formName = formData4.getFormName();
        if (formName == null || formName.trim().isEmpty()) {
            auditResults.put("formName", new AuditResult(false, "表格名称不能为空"));
        }
        if (!formName.equals(name)) {
            auditResults.put("formName", new AuditResult(false, "表格名称与身份证名字不一致"));
        } else {
            auditResults.put("formName", new AuditResult(true, null));
        }
        // 审核 mobilePhone 字段
        String mobilePhone = formData4.getMobilePhone();
        String mobilePhonePattern = "^[1]([3-9])[0-9]{9}$";
        if (mobilePhone == null || mobilePhone.trim().isEmpty()) {
            auditResults.put("mobilePhone", new AuditResult(false, "手机号码不能为空"));
        } else if (!mobilePhone.matches(mobilePhonePattern)) {
            auditResults.put("mobilePhone", new AuditResult(false, "手机号码格式不正确"));
        } else {
            auditResults.put("mobilePhone", new AuditResult(true, null));
        }

        // 审核 typeOfIdentityDocument 字段
        String typeOfIdentityDocument = formData4.getTypeOfIdentityDocument();
        if (typeOfIdentityDocument == null || typeOfIdentityDocument.trim().isEmpty()) {
            auditResults.put("typeOfIdentityDocument", new AuditResult(false, "身份证明类型不能为空"));
        } else {
            auditResults.put("typeOfIdentityDocument", new AuditResult(true, null));
        }

        // 审核 formIdNumber 字段
        String formIdNumber = formData4.getFormIdNumber();
        if (formIdNumber == null || formIdNumber.trim().isEmpty()) {
            auditResults.put("formIdNumber", new AuditResult(false, "表格身份证号码不能为空"));
        }
        if (!formIdNumber.equals(idNumber)) {
            auditResults.put("formIdNumber", new AuditResult(false, "表格身份证号码与身份证号码不一致"));
        } else {
            auditResults.put("formIdNumber", new AuditResult(true, null));
        }

        // 审核 emailAddress 字段
        String emailAddress = formData4.getEmailAddress();
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (emailAddress == null || emailAddress.trim().isEmpty()) {
            auditResults.put("emailAddress", new AuditResult(false, "电子邮件地址不能为空"));
        } else if (!emailAddress.matches(emailPattern)) {
            auditResults.put("emailAddress", new AuditResult(false, "电子邮件地址格式不正确"));
        } else {
            auditResults.put("emailAddress", new AuditResult(true, null));
        }

        // 审核 landlineTelephone 字段
        String landlineTelephone = formData4.getLandlineTelephone();
        // 审核固定电话字段
        if (landlineTelephone == null || landlineTelephone.isEmpty()) {
            auditResults.put("landlineTelephone", new AuditResult(false, "固定电话不能为空"));
        } else {
            auditResults.put("landlineTelephone", new AuditResult(true, null));
        }

        return auditResults;
    }
}




package com.example.demo1.entity;

import lombok.Data;

import java.util.Map;
/*
    变更表单
 */
@Data
public class FormData3 {
    //身份证信息
    private String name;
    private String sex;
    private String birthDate;
    private String address;
    private String idNumber;
    /**
     * 办理地址
     */
    private String issueAuthority;

    /**
     * 生效-到期
     */
    private String validPeriod;
    //表格信息
    private String formName;
    private String country;
    private String productionMode;
    private String typeOfIdentityDocument;
    private String formIdNumber;
    private String landlineTelephone;
    private String mobilePhone;
    private String residence;
    private String emailAddress;
    private String signatureOfTheProposedLegalRepresentative;
    private String signatureDate;


}



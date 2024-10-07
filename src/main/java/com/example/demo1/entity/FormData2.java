package com.example.demo1.entity;

import lombok.Data;

@Data
public class FormData2 {
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


    private String landlineTelephone;
    private String mobilePhone;
    private String signatureOfDesignated;
    private String signatureOfLegalRepresentative;
    private String signatureDate;
}

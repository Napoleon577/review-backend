package com.example.demo1.entity;

import lombok.Data;
/*
    表单5
 */
@Data
public class FormData4 {
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
    private String mobilePhone;
    private String typeOfIdentityDocument;
    private String formIdNumber;
    private String emailAddress;
    private String landlineTelephone;
}

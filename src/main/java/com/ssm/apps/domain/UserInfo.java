package com.ssm.apps.domain;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfo {

    private String id;
    private String name;
    private String username;
    private String password;
    private Integer age;
    private String sex;
    private String address;
    private Date createTime;
    private Date updateTime;
}

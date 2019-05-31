package com.bl.myproject.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author bl
 * @date 2019-5-24
 */
@Data
public class BlUser implements Serializable {
    private Integer id;

    private String name;

    private String sex;

    private Integer age;

    private Integer del;

    private String pwd;

    public BlUser(String name,Integer age){
        this.name = name;
        this.age = age;
    }

}
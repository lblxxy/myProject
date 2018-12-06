package com.meiman.meimanwallet.entity;

/**
 * @author zeng_
 */
public class MmUser {
    private Integer id;

    private String name;

    private String pass;

    private Integer role;

    private Integer rank;

    private Integer stu;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass == null ? null : pass.trim();
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getStu() {
        return stu;
    }

    public void setStu(Integer stu) {
        this.stu = stu;
    }
}
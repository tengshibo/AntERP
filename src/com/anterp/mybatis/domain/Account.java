package com.anterp.mybatis.domain;

import java.io.Serializable;
import java.util.Date;

public class Account implements Serializable {
    private Integer accid;

    private String empname;

    private String accname;

    private String accpwd;

    private Integer status;

    private Integer age;

    private Short gender;

    private String phoneno;

    private String urgentphone;

    private String address;

    private Date createtime;

    private Date lastmodifytime;

    private static final long serialVersionUID = 1L;

    public Integer getAccid() {
        return accid;
    }

    public void setAccid(Integer accid) {
        this.accid = accid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getAccname() {
        return accname;
    }

    public void setAccname(String accname) {
        this.accname = accname;
    }

    public String getAccpwd() {
        return accpwd;
    }

    public void setAccpwd(String accpwd) {
        this.accpwd = accpwd;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getUrgentphone() {
        return urgentphone;
    }

    public void setUrgentphone(String urgentphone) {
        this.urgentphone = urgentphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getLastmodifytime() {
        return lastmodifytime;
    }

    public void setLastmodifytime(Date lastmodifytime) {
        this.lastmodifytime = lastmodifytime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Account other = (Account) that;
        return (this.getAccid() == null ? other.getAccid() == null : this.getAccid().equals(other.getAccid()))
            && (this.getEmpname() == null ? other.getEmpname() == null : this.getEmpname().equals(other.getEmpname()))
            && (this.getAccname() == null ? other.getAccname() == null : this.getAccname().equals(other.getAccname()))
            && (this.getAccpwd() == null ? other.getAccpwd() == null : this.getAccpwd().equals(other.getAccpwd()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getPhoneno() == null ? other.getPhoneno() == null : this.getPhoneno().equals(other.getPhoneno()))
            && (this.getUrgentphone() == null ? other.getUrgentphone() == null : this.getUrgentphone().equals(other.getUrgentphone()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getLastmodifytime() == null ? other.getLastmodifytime() == null : this.getLastmodifytime().equals(other.getLastmodifytime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAccid() == null) ? 0 : getAccid().hashCode());
        result = prime * result + ((getEmpname() == null) ? 0 : getEmpname().hashCode());
        result = prime * result + ((getAccname() == null) ? 0 : getAccname().hashCode());
        result = prime * result + ((getAccpwd() == null) ? 0 : getAccpwd().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getPhoneno() == null) ? 0 : getPhoneno().hashCode());
        result = prime * result + ((getUrgentphone() == null) ? 0 : getUrgentphone().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getLastmodifytime() == null) ? 0 : getLastmodifytime().hashCode());
        return result;
    }
}
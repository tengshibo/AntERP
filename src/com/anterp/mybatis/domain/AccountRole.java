package com.anterp.mybatis.domain;

import java.io.Serializable;

public class AccountRole implements Serializable {
    private Integer accid;

    private Integer roleid;

    private static final long serialVersionUID = 1L;

    public Integer getAccid() {
        return accid;
    }

    public void setAccid(Integer accid) {
        this.accid = accid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
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
        AccountRole other = (AccountRole) that;
        return (this.getAccid() == null ? other.getAccid() == null : this.getAccid().equals(other.getAccid()))
            && (this.getRoleid() == null ? other.getRoleid() == null : this.getRoleid().equals(other.getRoleid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAccid() == null) ? 0 : getAccid().hashCode());
        result = prime * result + ((getRoleid() == null) ? 0 : getRoleid().hashCode());
        return result;
    }
}
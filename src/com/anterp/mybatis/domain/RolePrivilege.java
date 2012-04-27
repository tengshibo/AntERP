package com.anterp.mybatis.domain;

import java.io.Serializable;

public class RolePrivilege implements Serializable {
    private Integer roleid;

    private String pvgid;

    private static final long serialVersionUID = 1L;

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getPvgid() {
        return pvgid;
    }

    public void setPvgid(String pvgid) {
        this.pvgid = pvgid;
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
        RolePrivilege other = (RolePrivilege) that;
        return (this.getRoleid() == null ? other.getRoleid() == null : this.getRoleid().equals(other.getRoleid()))
            && (this.getPvgid() == null ? other.getPvgid() == null : this.getPvgid().equals(other.getPvgid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRoleid() == null) ? 0 : getRoleid().hashCode());
        result = prime * result + ((getPvgid() == null) ? 0 : getPvgid().hashCode());
        return result;
    }
}
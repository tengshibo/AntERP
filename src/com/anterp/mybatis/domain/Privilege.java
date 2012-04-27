package com.anterp.mybatis.domain;

import java.io.Serializable;

public class Privilege implements Serializable {
    private Integer pvgid;

    private String functioncode;

    private static final long serialVersionUID = 1L;

    public Integer getPvgid() {
        return pvgid;
    }

    public void setPvgid(Integer pvgid) {
        this.pvgid = pvgid;
    }

    public String getFunctioncode() {
        return functioncode;
    }

    public void setFunctioncode(String functioncode) {
        this.functioncode = functioncode;
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
        Privilege other = (Privilege) that;
        return (this.getPvgid() == null ? other.getPvgid() == null : this.getPvgid().equals(other.getPvgid()))
            && (this.getFunctioncode() == null ? other.getFunctioncode() == null : this.getFunctioncode().equals(other.getFunctioncode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPvgid() == null) ? 0 : getPvgid().hashCode());
        result = prime * result + ((getFunctioncode() == null) ? 0 : getFunctioncode().hashCode());
        return result;
    }
}
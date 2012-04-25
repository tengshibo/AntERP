package com.anterp.mybatis.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AccountExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andAccidIsNull() {
            addCriterion("accId is null");
            return (Criteria) this;
        }

        public Criteria andAccidIsNotNull() {
            addCriterion("accId is not null");
            return (Criteria) this;
        }

        public Criteria andAccidEqualTo(Integer value) {
            addCriterion("accId =", value, "accid");
            return (Criteria) this;
        }

        public Criteria andAccidNotEqualTo(Integer value) {
            addCriterion("accId <>", value, "accid");
            return (Criteria) this;
        }

        public Criteria andAccidGreaterThan(Integer value) {
            addCriterion("accId >", value, "accid");
            return (Criteria) this;
        }

        public Criteria andAccidGreaterThanOrEqualTo(Integer value) {
            addCriterion("accId >=", value, "accid");
            return (Criteria) this;
        }

        public Criteria andAccidLessThan(Integer value) {
            addCriterion("accId <", value, "accid");
            return (Criteria) this;
        }

        public Criteria andAccidLessThanOrEqualTo(Integer value) {
            addCriterion("accId <=", value, "accid");
            return (Criteria) this;
        }

        public Criteria andAccidIn(List<Integer> values) {
            addCriterion("accId in", values, "accid");
            return (Criteria) this;
        }

        public Criteria andAccidNotIn(List<Integer> values) {
            addCriterion("accId not in", values, "accid");
            return (Criteria) this;
        }

        public Criteria andAccidBetween(Integer value1, Integer value2) {
            addCriterion("accId between", value1, value2, "accid");
            return (Criteria) this;
        }

        public Criteria andAccidNotBetween(Integer value1, Integer value2) {
            addCriterion("accId not between", value1, value2, "accid");
            return (Criteria) this;
        }

        public Criteria andEmpnameIsNull() {
            addCriterion("empName is null");
            return (Criteria) this;
        }

        public Criteria andEmpnameIsNotNull() {
            addCriterion("empName is not null");
            return (Criteria) this;
        }

        public Criteria andEmpnameEqualTo(String value) {
            addCriterion("empName =", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameNotEqualTo(String value) {
            addCriterion("empName <>", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameGreaterThan(String value) {
            addCriterion("empName >", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameGreaterThanOrEqualTo(String value) {
            addCriterion("empName >=", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameLessThan(String value) {
            addCriterion("empName <", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameLessThanOrEqualTo(String value) {
            addCriterion("empName <=", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameLike(String value) {
            addCriterion("empName like", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameNotLike(String value) {
            addCriterion("empName not like", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameIn(List<String> values) {
            addCriterion("empName in", values, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameNotIn(List<String> values) {
            addCriterion("empName not in", values, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameBetween(String value1, String value2) {
            addCriterion("empName between", value1, value2, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameNotBetween(String value1, String value2) {
            addCriterion("empName not between", value1, value2, "empname");
            return (Criteria) this;
        }

        public Criteria andAccnameIsNull() {
            addCriterion("accName is null");
            return (Criteria) this;
        }

        public Criteria andAccnameIsNotNull() {
            addCriterion("accName is not null");
            return (Criteria) this;
        }

        public Criteria andAccnameEqualTo(String value) {
            addCriterion("accName =", value, "accname");
            return (Criteria) this;
        }

        public Criteria andAccnameNotEqualTo(String value) {
            addCriterion("accName <>", value, "accname");
            return (Criteria) this;
        }

        public Criteria andAccnameGreaterThan(String value) {
            addCriterion("accName >", value, "accname");
            return (Criteria) this;
        }

        public Criteria andAccnameGreaterThanOrEqualTo(String value) {
            addCriterion("accName >=", value, "accname");
            return (Criteria) this;
        }

        public Criteria andAccnameLessThan(String value) {
            addCriterion("accName <", value, "accname");
            return (Criteria) this;
        }

        public Criteria andAccnameLessThanOrEqualTo(String value) {
            addCriterion("accName <=", value, "accname");
            return (Criteria) this;
        }

        public Criteria andAccnameLike(String value) {
            addCriterion("accName like", value, "accname");
            return (Criteria) this;
        }

        public Criteria andAccnameNotLike(String value) {
            addCriterion("accName not like", value, "accname");
            return (Criteria) this;
        }

        public Criteria andAccnameIn(List<String> values) {
            addCriterion("accName in", values, "accname");
            return (Criteria) this;
        }

        public Criteria andAccnameNotIn(List<String> values) {
            addCriterion("accName not in", values, "accname");
            return (Criteria) this;
        }

        public Criteria andAccnameBetween(String value1, String value2) {
            addCriterion("accName between", value1, value2, "accname");
            return (Criteria) this;
        }

        public Criteria andAccnameNotBetween(String value1, String value2) {
            addCriterion("accName not between", value1, value2, "accname");
            return (Criteria) this;
        }

        public Criteria andAccpwdIsNull() {
            addCriterion("accPwd is null");
            return (Criteria) this;
        }

        public Criteria andAccpwdIsNotNull() {
            addCriterion("accPwd is not null");
            return (Criteria) this;
        }

        public Criteria andAccpwdEqualTo(String value) {
            addCriterion("accPwd =", value, "accpwd");
            return (Criteria) this;
        }

        public Criteria andAccpwdNotEqualTo(String value) {
            addCriterion("accPwd <>", value, "accpwd");
            return (Criteria) this;
        }

        public Criteria andAccpwdGreaterThan(String value) {
            addCriterion("accPwd >", value, "accpwd");
            return (Criteria) this;
        }

        public Criteria andAccpwdGreaterThanOrEqualTo(String value) {
            addCriterion("accPwd >=", value, "accpwd");
            return (Criteria) this;
        }

        public Criteria andAccpwdLessThan(String value) {
            addCriterion("accPwd <", value, "accpwd");
            return (Criteria) this;
        }

        public Criteria andAccpwdLessThanOrEqualTo(String value) {
            addCriterion("accPwd <=", value, "accpwd");
            return (Criteria) this;
        }

        public Criteria andAccpwdLike(String value) {
            addCriterion("accPwd like", value, "accpwd");
            return (Criteria) this;
        }

        public Criteria andAccpwdNotLike(String value) {
            addCriterion("accPwd not like", value, "accpwd");
            return (Criteria) this;
        }

        public Criteria andAccpwdIn(List<String> values) {
            addCriterion("accPwd in", values, "accpwd");
            return (Criteria) this;
        }

        public Criteria andAccpwdNotIn(List<String> values) {
            addCriterion("accPwd not in", values, "accpwd");
            return (Criteria) this;
        }

        public Criteria andAccpwdBetween(String value1, String value2) {
            addCriterion("accPwd between", value1, value2, "accpwd");
            return (Criteria) this;
        }

        public Criteria andAccpwdNotBetween(String value1, String value2) {
            addCriterion("accPwd not between", value1, value2, "accpwd");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(Integer value) {
            addCriterion("age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(Integer value) {
            addCriterion("age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(Integer value) {
            addCriterion("age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(Integer value) {
            addCriterion("age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(Integer value) {
            addCriterion("age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<Integer> values) {
            addCriterion("age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<Integer> values) {
            addCriterion("age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(Integer value1, Integer value2) {
            addCriterion("age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("age not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(Short value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(Short value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(Short value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(Short value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(Short value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(Short value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<Short> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<Short> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(Short value1, Short value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(Short value1, Short value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andPhonenoIsNull() {
            addCriterion("phoneNo is null");
            return (Criteria) this;
        }

        public Criteria andPhonenoIsNotNull() {
            addCriterion("phoneNo is not null");
            return (Criteria) this;
        }

        public Criteria andPhonenoEqualTo(String value) {
            addCriterion("phoneNo =", value, "phoneno");
            return (Criteria) this;
        }

        public Criteria andPhonenoNotEqualTo(String value) {
            addCriterion("phoneNo <>", value, "phoneno");
            return (Criteria) this;
        }

        public Criteria andPhonenoGreaterThan(String value) {
            addCriterion("phoneNo >", value, "phoneno");
            return (Criteria) this;
        }

        public Criteria andPhonenoGreaterThanOrEqualTo(String value) {
            addCriterion("phoneNo >=", value, "phoneno");
            return (Criteria) this;
        }

        public Criteria andPhonenoLessThan(String value) {
            addCriterion("phoneNo <", value, "phoneno");
            return (Criteria) this;
        }

        public Criteria andPhonenoLessThanOrEqualTo(String value) {
            addCriterion("phoneNo <=", value, "phoneno");
            return (Criteria) this;
        }

        public Criteria andPhonenoLike(String value) {
            addCriterion("phoneNo like", value, "phoneno");
            return (Criteria) this;
        }

        public Criteria andPhonenoNotLike(String value) {
            addCriterion("phoneNo not like", value, "phoneno");
            return (Criteria) this;
        }

        public Criteria andPhonenoIn(List<String> values) {
            addCriterion("phoneNo in", values, "phoneno");
            return (Criteria) this;
        }

        public Criteria andPhonenoNotIn(List<String> values) {
            addCriterion("phoneNo not in", values, "phoneno");
            return (Criteria) this;
        }

        public Criteria andPhonenoBetween(String value1, String value2) {
            addCriterion("phoneNo between", value1, value2, "phoneno");
            return (Criteria) this;
        }

        public Criteria andPhonenoNotBetween(String value1, String value2) {
            addCriterion("phoneNo not between", value1, value2, "phoneno");
            return (Criteria) this;
        }

        public Criteria andUrgentphoneIsNull() {
            addCriterion("urgentPhone is null");
            return (Criteria) this;
        }

        public Criteria andUrgentphoneIsNotNull() {
            addCriterion("urgentPhone is not null");
            return (Criteria) this;
        }

        public Criteria andUrgentphoneEqualTo(String value) {
            addCriterion("urgentPhone =", value, "urgentphone");
            return (Criteria) this;
        }

        public Criteria andUrgentphoneNotEqualTo(String value) {
            addCriterion("urgentPhone <>", value, "urgentphone");
            return (Criteria) this;
        }

        public Criteria andUrgentphoneGreaterThan(String value) {
            addCriterion("urgentPhone >", value, "urgentphone");
            return (Criteria) this;
        }

        public Criteria andUrgentphoneGreaterThanOrEqualTo(String value) {
            addCriterion("urgentPhone >=", value, "urgentphone");
            return (Criteria) this;
        }

        public Criteria andUrgentphoneLessThan(String value) {
            addCriterion("urgentPhone <", value, "urgentphone");
            return (Criteria) this;
        }

        public Criteria andUrgentphoneLessThanOrEqualTo(String value) {
            addCriterion("urgentPhone <=", value, "urgentphone");
            return (Criteria) this;
        }

        public Criteria andUrgentphoneLike(String value) {
            addCriterion("urgentPhone like", value, "urgentphone");
            return (Criteria) this;
        }

        public Criteria andUrgentphoneNotLike(String value) {
            addCriterion("urgentPhone not like", value, "urgentphone");
            return (Criteria) this;
        }

        public Criteria andUrgentphoneIn(List<String> values) {
            addCriterion("urgentPhone in", values, "urgentphone");
            return (Criteria) this;
        }

        public Criteria andUrgentphoneNotIn(List<String> values) {
            addCriterion("urgentPhone not in", values, "urgentphone");
            return (Criteria) this;
        }

        public Criteria andUrgentphoneBetween(String value1, String value2) {
            addCriterion("urgentPhone between", value1, value2, "urgentphone");
            return (Criteria) this;
        }

        public Criteria andUrgentphoneNotBetween(String value1, String value2) {
            addCriterion("urgentPhone not between", value1, value2, "urgentphone");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeIsNull() {
            addCriterion("lastModifyTime is null");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeIsNotNull() {
            addCriterion("lastModifyTime is not null");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeEqualTo(Date value) {
            addCriterion("lastModifyTime =", value, "lastmodifytime");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeNotEqualTo(Date value) {
            addCriterion("lastModifyTime <>", value, "lastmodifytime");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeGreaterThan(Date value) {
            addCriterion("lastModifyTime >", value, "lastmodifytime");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lastModifyTime >=", value, "lastmodifytime");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeLessThan(Date value) {
            addCriterion("lastModifyTime <", value, "lastmodifytime");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeLessThanOrEqualTo(Date value) {
            addCriterion("lastModifyTime <=", value, "lastmodifytime");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeIn(List<Date> values) {
            addCriterion("lastModifyTime in", values, "lastmodifytime");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeNotIn(List<Date> values) {
            addCriterion("lastModifyTime not in", values, "lastmodifytime");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeBetween(Date value1, Date value2) {
            addCriterion("lastModifyTime between", value1, value2, "lastmodifytime");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeNotBetween(Date value1, Date value2) {
            addCriterion("lastModifyTime not between", value1, value2, "lastmodifytime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andEmpnameLikeInsensitive(String value) {
            addCriterion("upper(empName) like", value.toUpperCase(), "empname");
            return this;
        }

        public Criteria andAccnameLikeInsensitive(String value) {
            addCriterion("upper(accName) like", value.toUpperCase(), "accname");
            return this;
        }

        public Criteria andAccpwdLikeInsensitive(String value) {
            addCriterion("upper(accPwd) like", value.toUpperCase(), "accpwd");
            return this;
        }

        public Criteria andPhonenoLikeInsensitive(String value) {
            addCriterion("upper(phoneNo) like", value.toUpperCase(), "phoneno");
            return this;
        }

        public Criteria andUrgentphoneLikeInsensitive(String value) {
            addCriterion("upper(urgentPhone) like", value.toUpperCase(), "urgentphone");
            return this;
        }

        public Criteria andAddressLikeInsensitive(String value) {
            addCriterion("upper(address) like", value.toUpperCase(), "address");
            return this;
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
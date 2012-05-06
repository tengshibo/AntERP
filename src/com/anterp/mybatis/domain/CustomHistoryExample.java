package com.anterp.mybatis.domain;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CustomHistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustomHistoryExample() {
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

        public Criteria andCustidIsNull() {
            addCriterion("custId is null");
            return (Criteria) this;
        }

        public Criteria andCustidIsNotNull() {
            addCriterion("custId is not null");
            return (Criteria) this;
        }

        public Criteria andCustidEqualTo(Integer value) {
            addCriterion("custId =", value, "custid");
            return (Criteria) this;
        }

        public Criteria andCustidNotEqualTo(Integer value) {
            addCriterion("custId <>", value, "custid");
            return (Criteria) this;
        }

        public Criteria andCustidGreaterThan(Integer value) {
            addCriterion("custId >", value, "custid");
            return (Criteria) this;
        }

        public Criteria andCustidGreaterThanOrEqualTo(Integer value) {
            addCriterion("custId >=", value, "custid");
            return (Criteria) this;
        }

        public Criteria andCustidLessThan(Integer value) {
            addCriterion("custId <", value, "custid");
            return (Criteria) this;
        }

        public Criteria andCustidLessThanOrEqualTo(Integer value) {
            addCriterion("custId <=", value, "custid");
            return (Criteria) this;
        }

        public Criteria andCustidIn(List<Integer> values) {
            addCriterion("custId in", values, "custid");
            return (Criteria) this;
        }

        public Criteria andCustidNotIn(List<Integer> values) {
            addCriterion("custId not in", values, "custid");
            return (Criteria) this;
        }

        public Criteria andCustidBetween(Integer value1, Integer value2) {
            addCriterion("custId between", value1, value2, "custid");
            return (Criteria) this;
        }

        public Criteria andCustidNotBetween(Integer value1, Integer value2) {
            addCriterion("custId not between", value1, value2, "custid");
            return (Criteria) this;
        }

        public Criteria andCustnameIsNull() {
            addCriterion("custName is null");
            return (Criteria) this;
        }

        public Criteria andCustnameIsNotNull() {
            addCriterion("custName is not null");
            return (Criteria) this;
        }

        public Criteria andCustnameEqualTo(String value) {
            addCriterion("custName =", value, "custname");
            return (Criteria) this;
        }

        public Criteria andCustnameNotEqualTo(String value) {
            addCriterion("custName <>", value, "custname");
            return (Criteria) this;
        }

        public Criteria andCustnameGreaterThan(String value) {
            addCriterion("custName >", value, "custname");
            return (Criteria) this;
        }

        public Criteria andCustnameGreaterThanOrEqualTo(String value) {
            addCriterion("custName >=", value, "custname");
            return (Criteria) this;
        }

        public Criteria andCustnameLessThan(String value) {
            addCriterion("custName <", value, "custname");
            return (Criteria) this;
        }

        public Criteria andCustnameLessThanOrEqualTo(String value) {
            addCriterion("custName <=", value, "custname");
            return (Criteria) this;
        }

        public Criteria andCustnameLike(String value) {
            addCriterion("custName like", value, "custname");
            return (Criteria) this;
        }

        public Criteria andCustnameNotLike(String value) {
            addCriterion("custName not like", value, "custname");
            return (Criteria) this;
        }

        public Criteria andCustnameIn(List<String> values) {
            addCriterion("custName in", values, "custname");
            return (Criteria) this;
        }

        public Criteria andCustnameNotIn(List<String> values) {
            addCriterion("custName not in", values, "custname");
            return (Criteria) this;
        }

        public Criteria andCustnameBetween(String value1, String value2) {
            addCriterion("custName between", value1, value2, "custname");
            return (Criteria) this;
        }

        public Criteria andCustnameNotBetween(String value1, String value2) {
            addCriterion("custName not between", value1, value2, "custname");
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

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterion("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterion("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterion("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterion("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterion("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterion("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterion("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterion("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterion("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterion("birthday not between", value1, value2, "birthday");
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

        public Criteria andFamilydescIsNull() {
            addCriterion("familyDesc is null");
            return (Criteria) this;
        }

        public Criteria andFamilydescIsNotNull() {
            addCriterion("familyDesc is not null");
            return (Criteria) this;
        }

        public Criteria andFamilydescEqualTo(String value) {
            addCriterion("familyDesc =", value, "familydesc");
            return (Criteria) this;
        }

        public Criteria andFamilydescNotEqualTo(String value) {
            addCriterion("familyDesc <>", value, "familydesc");
            return (Criteria) this;
        }

        public Criteria andFamilydescGreaterThan(String value) {
            addCriterion("familyDesc >", value, "familydesc");
            return (Criteria) this;
        }

        public Criteria andFamilydescGreaterThanOrEqualTo(String value) {
            addCriterion("familyDesc >=", value, "familydesc");
            return (Criteria) this;
        }

        public Criteria andFamilydescLessThan(String value) {
            addCriterion("familyDesc <", value, "familydesc");
            return (Criteria) this;
        }

        public Criteria andFamilydescLessThanOrEqualTo(String value) {
            addCriterion("familyDesc <=", value, "familydesc");
            return (Criteria) this;
        }

        public Criteria andFamilydescLike(String value) {
            addCriterion("familyDesc like", value, "familydesc");
            return (Criteria) this;
        }

        public Criteria andFamilydescNotLike(String value) {
            addCriterion("familyDesc not like", value, "familydesc");
            return (Criteria) this;
        }

        public Criteria andFamilydescIn(List<String> values) {
            addCriterion("familyDesc in", values, "familydesc");
            return (Criteria) this;
        }

        public Criteria andFamilydescNotIn(List<String> values) {
            addCriterion("familyDesc not in", values, "familydesc");
            return (Criteria) this;
        }

        public Criteria andFamilydescBetween(String value1, String value2) {
            addCriterion("familyDesc between", value1, value2, "familydesc");
            return (Criteria) this;
        }

        public Criteria andFamilydescNotBetween(String value1, String value2) {
            addCriterion("familyDesc not between", value1, value2, "familydesc");
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

        public Criteria andLastmodifytimeEqualTo(Timestamp value) {
            addCriterion("lastModifyTime =", value, "lastmodifytime");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeNotEqualTo(Timestamp value) {
            addCriterion("lastModifyTime <>", value, "lastmodifytime");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeGreaterThan(Timestamp value) {
            addCriterion("lastModifyTime >", value, "lastmodifytime");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("lastModifyTime >=", value, "lastmodifytime");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeLessThan(Timestamp value) {
            addCriterion("lastModifyTime <", value, "lastmodifytime");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("lastModifyTime <=", value, "lastmodifytime");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeIn(List<Timestamp> values) {
            addCriterion("lastModifyTime in", values, "lastmodifytime");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeNotIn(List<Timestamp> values) {
            addCriterion("lastModifyTime not in", values, "lastmodifytime");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("lastModifyTime between", value1, value2, "lastmodifytime");
            return (Criteria) this;
        }

        public Criteria andLastmodifytimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("lastModifyTime not between", value1, value2, "lastmodifytime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andCustnameLikeInsensitive(String value) {
            addCriterion("upper(custName) like", value.toUpperCase(), "custname");
            return this;
        }

        public Criteria andPhonenoLikeInsensitive(String value) {
            addCriterion("upper(phoneNo) like", value.toUpperCase(), "phoneno");
            return this;
        }

        public Criteria andAddressLikeInsensitive(String value) {
            addCriterion("upper(address) like", value.toUpperCase(), "address");
            return this;
        }

        public Criteria andFamilydescLikeInsensitive(String value) {
            addCriterion("upper(familyDesc) like", value.toUpperCase(), "familydesc");
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
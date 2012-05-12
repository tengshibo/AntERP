package com.anterp.modules.custom;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anterp.modules.utils.ThreadLocalUtils;
import com.anterp.mybatis.domain.Custom;
import com.anterp.mybatis.domain.CustomHistory;
import com.anterp.mybatis.mapper.CustomHistoryMapper;
import com.anterp.mybatis.mapper.CustomMapper;
import com.anterp.tool.DateUtil;

@Service
public class CustomService {

	@Autowired
	private CustomMapper customMapper;

	@Autowired
	private CustomHistoryMapper customHistoryMapper;

	@Transactional
	public void createCustom(Custom custom) {
		Timestamp now = DateUtil.getCurrentTime();
		custom.setCreatetime(now);
		custom.setLastmodifytime(now);
		this.customMapper.insert(custom);
		this.customHistoryMapper.insert(this.getCustomHistory_Update(custom));
	}

	@Transactional
	public void updateCustom(Custom custom) {
		custom.setLastmodifytime(DateUtil.getCurrentTime());
		// 更新客户信息
		this.customMapper.updateByPrimaryKey(custom);
		// 复制一份到客户历史信息表
		this.customHistoryMapper.insert(this.getCustomHistory_Update(custom));
	}

	@Transactional
	public void deleteCustom(int custId) {
		Custom custom = this.customMapper.selectByPrimaryKey(custId);
		this.customMapper.deleteByPrimaryKey(custId);
		this.customHistoryMapper.insert(this.getCustomHistory_Delete(custom));
	}

	private CustomHistory getCustomHistory_Update(Custom custom) {
		return this.getCustomHistory(custom, 0);
	}

	private CustomHistory getCustomHistory_Delete(Custom custom) {
		return this.getCustomHistory(custom, 1);
	}

	private CustomHistory getCustomHistory(Custom custom, int mode) {
		CustomHistory record = new CustomHistory();
		record.setAccid(ThreadLocalUtils.getAccInfo().getAccid());
		record.setStatus(mode);
		record.setAddress(custom.getAddress());
		record.setAge(custom.getAge());
		record.setBirthday(custom.getBirthday());
		record.setCustid(custom.getCustid());
		record.setCustname(custom.getCustname());
		record.setFamilydesc(custom.getFamilydesc());
		record.setGender(custom.getGender());
		record.setLastmodifytime(custom.getLastmodifytime());
		record.setPhoneno(custom.getPhoneno());
		return record;
	}
}

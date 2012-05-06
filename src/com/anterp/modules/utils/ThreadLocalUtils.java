package com.anterp.modules.utils;

import com.anterp.mybatis.domain.Account;

public class ThreadLocalUtils {

	private static final ThreadLocal<Account> accInfo = new ThreadLocal<Account>();

	public static final void setAccInfo(Account account) {
		accInfo.set(account);
	}

	public static Account getAccInfo() {
		return accInfo.get();
	}
}

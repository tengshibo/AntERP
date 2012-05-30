package com.anterp.modules.utils;

import com.anterp.mybatis.domain.Account;

public class ThreadLocalUtils {

	private static final ThreadLocal<Account> accInfo = new ThreadLocal<Account>();

	private static final ThreadLocal<Boolean> isAdmin = new ThreadLocal<Boolean>();

	public static final void setAccInfo(Account account) {
		accInfo.set(account);
	}

	public static Account getAccInfo() {
		return accInfo.get();
	}

	public static final void setIsAdmin(Boolean flag) {
		isAdmin.set(flag);
	}

	public static boolean getIsAdmin() {
		return isAdmin.get();
	}
}

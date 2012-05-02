package com.anterp.tool;

import java.sql.Timestamp;



public class DateUtil {

		
	/**
	 * @return 返回系统当前时间.
	 */
	
	public static Timestamp getCurrentTime(){
		
		return new Timestamp(System.currentTimeMillis());
		
	}
	
	
}

package com.bluesky.tools;

import java.util.Date;

public class TimeConvert {
	public static java.sql.Date ConvertToSqlDate(Date date){
		return new java.sql.Date(date.getTime());
	}
}

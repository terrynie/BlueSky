package com.bluesky.tools;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class GetFirstAndLastDayOfMon {

	public static Map<String, String> getFirstAndLastDayOfMonth(int year, int month) {
		Map<String, String> dayMap = new HashMap<String, String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();

		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.DAY_OF_MONTH, -1);

		String lastDay = sdf.format(cal.getTime());
		cal.set(Calendar.DAY_OF_MONTH, 1);
		String firstDay = sdf.format(cal.getTime());

		dayMap.put("firstDay", firstDay);
		dayMap.put("lastDay", lastDay);

		return dayMap;
	}

}

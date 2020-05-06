package com.rs.fer.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date getCurrentDate(String dateFormat) {
		Date curDate = new Date();

		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		String dateToStr = format.format(curDate);
		try {
			return format.parse(dateToStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}
}

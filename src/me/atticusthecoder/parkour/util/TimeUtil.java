package me.atticusthecoder.parkour.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeUtil {
	public static String milliToNormal(long time) {
		Date date = new Date(time);
		DateFormat formatter = new SimpleDateFormat("mm:ss.SSS");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		String dateFormatted = formatter.format(date);
		return dateFormatted;
	}
}

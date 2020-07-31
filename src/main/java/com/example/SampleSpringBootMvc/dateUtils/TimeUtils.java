package com.example.SampleSpringBootMvc.dateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

	private static SimpleDateFormat formatter = 
			new SimpleDateFormat("hh:mm:ss");
	public static Date parseDate(String str) throws ParseException
	{
		Date theDate = formatter.parse(str);
		return theDate;
	}
	public static String formatDate(Date theDate)
	{
		String date = null;
		if(theDate!=null)
		{
			date = formatter.format(theDate);
			
		}
		return date;
	}
}

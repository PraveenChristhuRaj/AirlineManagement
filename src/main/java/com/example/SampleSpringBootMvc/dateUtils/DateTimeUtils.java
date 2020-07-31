package com.example.SampleSpringBootMvc.dateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtils {

	private static SimpleDateFormat formatter = 
			new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	public static Date parseDate() throws ParseException
	{
		Date date = new Date();
		return date;
	}
	public static String formatDate(Date theDate) 
	{
		String result=null;
		if(theDate!=null)
		{
			result = formatter.format(theDate);
		}
		return result;
	}

}

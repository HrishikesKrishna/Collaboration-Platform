package com.hk.AirChatBackEnd.Util;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Date_Time {
	public String getDateTime()
	{
		DateFormat df=new SimpleDateFormat("dd-MMM-yyyy @ HH:mm");
		Date dateobj=new Date();
		String datetime=df.format(dateobj).toString();
		System.out.println("Date- "+datetime);
		return datetime;
	}
}

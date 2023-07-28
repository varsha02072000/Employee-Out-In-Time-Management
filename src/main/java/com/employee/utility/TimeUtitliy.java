package com.employee.utility;

import java.time.LocalTime;

public class TimeUtitliy 
{
	public static String getCurrentTime()
	{
		LocalTime tm=LocalTime.now();
		String time=tm.getHour()+":"+tm.getMinute()+":"+tm.getSecond();
		return time;
	}

	public static String getTotalTime(String intime, String outtime) 
	{
		int intotals=converTimeInSeconds(intime);
		int outtotals=converTimeInSeconds(outtime);
		int totals=intotals-outtotals;
		int s=totals%60;
		int m=totals/60;
		int h=0;
		String time=m+"min "+s+"sec";
		if(m>=60)
		{
			h=m/60;
			m=m%60;
			time=h+"hr "+m+"min "+s+"sec";
		}
		return time;
	}
	private static int converTimeInSeconds(String time)
	{
		String[] x=time.split(":");
		int total=Integer.parseInt(x[0])*60*60+Integer.parseInt(x[1])*60+Integer.parseInt(x[2]);
		return total;
	}
}

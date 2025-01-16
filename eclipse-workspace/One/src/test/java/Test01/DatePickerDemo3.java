package Test01;

import java.time.Month;
import java.util.HashMap;

public class DatePickerDemo3 {

	public static Month main(String[] args) {
		Month convertMonth(String Month)
		{
			HashMap<String, Month> monthMap=new HashMap<String, Month>();
			
			monthMap.put("January",Month.JANUARY);
			monthMap.put("February",Month.FEBRUARY);
			monthMap.put("March",Month.MARCH);
			monthMap.put("March",Month.APRIL);
			monthMap.put("March",Month.MAY);
			monthMap.put("March",Month.JUNE);
			monthMap.put("March",Month.JULY);
			monthMap.put("March",Month.AUGUST);
			monthMap.put("March",Month.SEPTEMBER);
			monthMap.put("March",Month.OCTOBER);
			monthMap.put("March",Month.NOVEMBER);
			monthMap.put("March",Month.DECEMBER);
			
			Month vmonth = monthMap.getMonth();
			
			if(vmonth==null)
			{
				System.out.println("Invalid Month.....");
			}
			return vmonth;
			
			
		}

	}

}

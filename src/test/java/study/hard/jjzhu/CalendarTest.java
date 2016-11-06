package study.hard.jjzhu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
	public static void main(String[] args) {
		String[] weeks = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};  
		Calendar c = Calendar.getInstance();
		String time = "2016-2-41";
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");  
		try {
			c.setTime(sdf1.parse(time));

			System.out.println(c.get(Calendar.DAY_OF_WEEK)-1);
			SimpleDateFormat sdf = new SimpleDateFormat("EEEE");  
			String week = sdf.format(sdf1.parse(time));  
			System.out.println(week);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

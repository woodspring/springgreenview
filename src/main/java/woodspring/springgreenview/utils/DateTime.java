package woodspring.springgreenview.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateTime {
	
	public static String getTimestamp() {
		//Document doc = collection.find().first();
		//Date date = doc.getDate("date");
		SimpleDateFormat formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		formattedDate.setTimeZone(TimeZone.getTimeZone("UTC"));
		String retStr = formattedDate.format(new Date());
		
		return retStr;
	}

}

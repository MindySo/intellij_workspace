import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NewYorkTime {
	public int getHour() {
		
		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		
		hour -= 13;
		
		if (hour < 0) {
			hour += 24;
		}
		
		return hour;
	}
}

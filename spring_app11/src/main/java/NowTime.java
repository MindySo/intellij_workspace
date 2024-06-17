import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NowTime {
	public int getHour() {
		
		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		
		return hour;
	}
}

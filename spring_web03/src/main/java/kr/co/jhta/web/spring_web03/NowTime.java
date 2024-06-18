package kr.co.jhta.web.spring_web03;

import java.util.Calendar;

public class NowTime {
    public int getHour() {
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        return hour;
    }
}

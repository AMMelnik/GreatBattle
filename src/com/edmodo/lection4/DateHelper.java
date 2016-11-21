package com.edmodo.lection4;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * Created by pc on 19.11.2016.
 */
public class DateHelper {

    Calendar battleBegin = new GregorianCalendar();//календарь на текущую дату
    Calendar battleSkip = new GregorianCalendar();//календарь на текущую дату

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("Год yyy, месяц MM, день dd. Время hh:mm");

    public String getFormattedStartDate() {
        battleBegin.add(Calendar.YEAR, -1500);
        battleSkip.add(Calendar.YEAR, -1500);
        return "TIME of BEGIN:" + simpleDateFormat.format(battleBegin.getTime());
    }

    public void skipTime() {
        battleSkip.add(Calendar.MINUTE, 20);
    }

   public String getFormattedDiff() {
       long begin = battleBegin.getTimeInMillis();
       long skip = battleSkip.getTimeInMillis();
       Calendar battleEnd = Calendar.getInstance(TimeZone.getTimeZone("GMT"));//календарь на текущую дату
       battleEnd.setTimeInMillis(skip - begin);
       return "TIME of BATTLE: " + (battleEnd.get(Calendar.DAY_OF_YEAR) - 1) + " дней "
               + battleEnd.get(Calendar.HOUR_OF_DAY) + " часов, "
               + battleEnd.get(Calendar.MINUTE) + " минут\n";
   }
}

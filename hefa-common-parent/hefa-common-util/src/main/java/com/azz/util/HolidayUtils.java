package com.azz.util;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Calendar;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄雄星（13077862552）  2014-10-16 下午2:05:36
 */
public class HolidayUtils {

    private static final String SOLAR[] = {"0101", "0404", "0501", "1001", "1002", "1003"};
    private static final String LUNAR[] = {"0101", "0102", "0103", "0505", "0815"};


    private final static NumberFormat NumFmt = NumberFormat.getInstance();

    static {
        NumFmt.setMaximumFractionDigits(0);
        NumFmt.setMinimumIntegerDigits(2);
    }

    public static Boolean isHoliday(Calendar cal) {
        long[] ds = LunarCalendar.get(cal);
        String nongli = NumFmt.format(ds[1]) + NumFmt.format(ds[2]);
        String yangli = NumFmt.format(cal.get(Calendar.MONTH) + 1) +
                NumFmt.format(cal.get(Calendar.DATE));
        Boolean holiday = false;
        //没有周节日放假，故而删除，2013年9月9日14:03:05
//        //周节日
//        String week = NumFmt.format(cal.get(Calendar.MONTH) + 1) +
//                cal.get(Calendar.DAY_OF_WEEK_IN_MONTH) +
//                (cal.get(Calendar.DAY_OF_WEEK) - 1);
//        holiday = iniFile.getItemValue("WEEK", week);
//        if (holiday != null)
//            return holiday;

        //阳历
        if (isInThoseDays(SOLAR, yangli)) {
            holiday = true;
        }


        //阴历
        if (isInThoseDays(LUNAR, nongli)) {
            holiday = true;
        }


        //双休
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            holiday = true;
        }

        return holiday;
    }

    private static boolean isInThoseDays(String[] holidays, String theDay) {
        boolean flag = false;
        for (String holiday : holidays) {
            if (holiday.equals(theDay)) {
                flag = true;
                return flag;
            }
        }
        return flag;
    }

    public static int numberOfWorkdays(Calendar startDate, Calendar endDate) {
        int numberOfWorkdays = 0;
        for (; startDate.before(endDate); startDate.add(Calendar.DAY_OF_YEAR, 1)){
          if (isHoliday(startDate)) {
              numberOfWorkdays++;
          }
        }
        return numberOfWorkdays;
    }

    public static void main(String[] args) throws IOException {

        Calendar startDate =  Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.DAY_OF_YEAR,20);
        int num = HolidayUtils.numberOfWorkdays(startDate,endDate);
        System.out.println(num);
    }

}


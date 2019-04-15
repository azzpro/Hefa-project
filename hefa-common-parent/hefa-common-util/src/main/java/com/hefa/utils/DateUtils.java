package com.hefa.utils;

import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import org.apache.commons.lang3.time.DateFormatUtils;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

/**
 * <P>日期处理的支持类</P>
 *
 * @author 黄雄星（13077862552） 2013-10-11 下午3:21:36
 * @version 1.0
 */
@Slf4j
@UtilityClass
public class DateUtils {


    /**
     * yyyyMMdd
     */
    private static final String FORMAT_YMD = "yyyyMMdd";
    /**
     * yyyyMMddHH:mm
     */
    private static final String FORMAT_YMDMS = "yyyyMMddHH:mm";
    //private static final String FORMAT_HMS = "HHmmss";
    /**
     * HH:mm
     */
    private static final String FORMAT_HM = "HH:mm";
    /**
     * yyyyMMddHHmmss
     */
    private static final String FORMAT_YMDHMS = "yyyyMMddHHmmss";

    /**
     * yyyyMMddHHmm
     */
    public static final String FORMAT_YMDHM = "yyyyMMddHHmm";
    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static final String FORMAT_YMDHMS_FRONT = "yyyy-MM-dd HH:mm:ss";
    /**
     * yyyy-MM-dd HH:mm
     */
    public static final String FORMAT_YMDHM_FRONT = "yyyy-MM-dd HH:mm";
    /**
     * yyyyMM
     */
    public static final String YM = "yyyyMM";
    /**
     * yyyy-MM-dd
     */
    public static final String YMD = "yyyy-MM-dd";
    /**
     * HHmmss
     */
    public static final String HMS = "HHmmss";
    /**
     * MMdd
     */
    public static final String MMDD = "MMdd";
    /**
     * yyyy-MM-dd HH:mm:ss.SSS
     */
    public static final String TIMESTAMP_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";

    public static final String TIME_ZONE_GMT8 = "GMT+8";
 

    
    /**********************************获取当前日期begin*******************************************/
    
    
    /**
     * <p>获取当前年月日字符串yyyyMMdd</p>
     *
     * @return
     * @author 黄雄星（13077862552） 2013-10-11 下午3:21:36
     */
    public static String getCurrentYMD() {
        return DateFormatUtils.format(new Date(), FORMAT_YMD);
    }

    /**
     * <p>获取当前时间:yyyy-MM-dd HH:mm:ss</p>
     *
     * @return
     * @author 黄雄星（13077862552） 2013-11-1 上午9:53:40
     */
    public static String getCurrentDateTime() {
        return DateFormatUtils.format(new Date(), FORMAT_YMDHMS_FRONT);
    }

    /**
     * <p>获取当前时间:yyyyMMddHHmmss</p>
     *
     * @return
     * @author 黄雄星（13077862552） 2013-11-1 上午10:12:42
     */
    @Deprecated
    public static String getCurrentYMDHMS() {
        return DateFormatUtils.format(new Date(), FORMAT_YMDHMS);
    }
    /**
     * <p>获取当前日期YMD字符串，格式为yyyyMMdd</p>
     *
     * @return SimpleDateFormat格式化为yyyyMMdd的字符串
     * @author 黄雄星（13077862552） 2013-10-11 下午3:21:36
     */
    @Deprecated
    public static String getYMDDate(final Date date) {
        return DateFormatUtils.format(date, FORMAT_YMD);
    }

    /**
     * <p>获取当前日期YMD字符串，格式为yyyy-MM-dd</p>
     *
     * @param date
     * @return
     * @version V1.0
     * @author 林仙龙
     * @date 2014-9-3下午5:08:07
     */
    public static String getDateYMD(final Date date) {
        return DateFormatUtils.format(date, YMD);
    }

    /**
     * <p>获取当前日期YM字符串，格式为yyyyMM</p>
     *
     * @return SimpleDateFormat格式化为yyyyMM的字符串
     * @author 黄雄星（13077862552） 2013-10-11 下午3:21:36
     */
    public static String getYMDate(final Date date) {
        return DateFormatUtils.format(date, YM);
    }

    /**********************************获取当前日期end*********************************************/
    
    
    
    
    
    
    
    /**********************************日期字符串转换begin*****************************************/
    
    /**
     * <p>获取对应的Date的格式yyyyMMddHHmmss</p>
     *
     * @param date 传入的日期
     * @return SimpleDateFormat格式化为yyyyMMddHHmmss的字符串
     * @author 黄雄星（13077862552） 2013-10-11 下午3:21:36
     */
    public static String getDateTime(final Date date) {
        if (date == null) {
            return null;
        }
        return DateFormatUtils.format(date, FORMAT_YMDHMS);
    }

    /**
     * <p>获取对应的Date的格式yyyy-MM-dd HH:mm:ss</p>
     *
     * @param date 传入的日期
     * @return SimpleDateFormat格式化为yyyy-MM-dd HH:mm:ss的字符串
     * @author 黄雄星（13077862552） 2013-10-11 下午3:21:36
     */
    public static String getYMDHMSDateTime(final Date date) {
        if (date == null) {
            return null;
        }
        return DateFormatUtils.format(date, FORMAT_YMDHMS_FRONT);
    }

    /**
     * <p>将字符串时间格式转成成Date</p><p>支持的格式有：<br/>
     * yyyyMMddHH:mm<br/>
     * HH:mm<br/>
     * yyyyMMddHHmmss<br/>
     * yyyyMMdd<br/>
     * yyyy-MM-dd HH:mm:ss<br/>
     * yyyy-MM-dd
     * </p>
     *
     * @param time
     * @return
     * @throws ParseException
     * @author 黄雄星（13077862552） 2013-11-1 上午9:36:26
     */
    public static Date getDateFromString(final String time){
        try {
            return org.apache.commons.lang3.time.DateUtils.parseDate(time, FORMAT_YMDMS, FORMAT_HM,
                    FORMAT_YMDHMS, FORMAT_YMD, FORMAT_YMDHMS_FRONT, YMD);
        } catch (ParseException e) {
            log.error("日期[{}]转换失败",time);
        }
        return null;
    }
    
    
    /**
     * <p>日期转换，默认格式为yyyy-MM-dd</p>
     *
     * @param dateString
     * @return
     * @author 王好（18675539583）  2017年11月2日 下午3:29:12
     */
    public static Date parseDateTime(String dateString){
        return parseDateTime(dateString, null);
    }

    /**
     * <p>日期转换,转换失败返回null</p>
     *
     * @param dateString
     * @param pattern    传空则默认为yyyy-MM-dd
     * @return
     * @author 王好（18675539583）  2017年11月2日 下午3:29:12
     */
    public static Date parseDateTime(String dateString, String pattern) {
        if (pattern == null) {
            pattern = YMD;
        }
        try {
            return org.apache.commons.lang3.time.DateUtils.parseDate(dateString, pattern);
        } catch (ParseException e) {
            log.error("日期[{}]转换失败",dateString);
        }
        return null;
       
    }
    /**
     * 
     * <p>字符串转日期,Java8版</p>
     * @param dateString
     * @param pattern 传空则默认为yyyy-MM-dd
     * @return
     * @author 王好（18675539583）  2017年11月2日 下午3:29:12
     */
    public static Date parseDateTimeJava8(String dateString, String pattern) {
        if (pattern == null) {
            pattern = YMD;
        }
        TemporalAccessor ta = DateTimeFormatter.ofPattern(pattern).parse(dateString);
        //根据是否有时间字段判断是否是时间类型
        boolean isTime =  ta.isSupported(ChronoField.HOUR_OF_DAY);
        Instant instant;
        if (isTime) {
             instant = LocalDateTime.from(ta).atZone(ZoneId.systemDefault()).toInstant();
        }else {
             instant = LocalDate.from(ta).atStartOfDay(ZoneId.systemDefault()).toInstant();
        }
        return  Date.from(Instant.from(instant));
    }
    
    
    
    
    
    
    
    
    
    
    
    /**********************************日期字符串转换end*************************************************/
    
    
    
    
    /**********************************日期加减begin*************************************************/
    /**
     * <p>用于某日期加几天</p>
     *
     * @param orgCutDayTime 当前时间
     * @return 第N天
     * @author 王好（18675539583） 2017-10-24 11:54:40
     */
    public static Date calculateNextNDay(final Date orgCutDayTime, long nextDay) {
        return Date.from(orgCutDayTime.toInstant().plus(nextDay, ChronoUnit.DAYS));
    }
    
    /**
     * <p>获取某个月的第一天</p>
     *
     * @param plus 月份跟当前月相差的月份
     * @return
     * @author 王好（17720589316）  2016年11月17日 下午7:46:12
     */
    public static Date getMonFirstDay(long plus) {
        LocalDateTime ldt = LocalDateTime.now().plusMonths(plus)
                .withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0);
        return Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * <p>前一个月的第一天</p>
     *
     * @return yyyyMMdd
     * @author 黄雄星（13077862552） 2013-11-1 上午10:47:42
     */
    public static Date getPreMonFirstDay() {
        return getMonFirstDay(-1);
    }
    /**
     * <p>今天零点</p>
     *
     * @return yyyy-MM-dd HH:mm:ss
     * @author 王好(18675539583) 2017-10-26 15:18:18
     */
    public static String getTodayZero() {
        LocalDateTime startOfDay = LocalDate.now().atStartOfDay();
        return DateTimeFormatter.ofPattern(FORMAT_YMDHMS_FRONT).format(startOfDay);
    }
    /**
     * <p>当前的时间 + 年数</p>
     *
     * @param date  当前时间
     * @param years 年数
     * @return
     * @version V1.0
     * @author 王好(18675539583) 2017-10-26 15:18:18
     */
    public static final Date addYears(Date date, long years) {
        if (date == null) {
            return null;
        }
        Instant instant = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault())
                .plusYears(years).atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    /**
     * <p>当前的时间 + 分钟</p>
     *
     * @param date      当前时间
     * @param addMinute 分钟
     * @return
     * @author 王好(18675539583) 2017-10-26 15:18:18
     */
    public static final Date addMinute(Date date, long addMinute) {
        if (date == null) {
            return null;
        }
        Instant instant = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault())
                .plusMinutes(addMinute).atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }
    
    /**
     * <p>当前的时间 + 小时</p>
     *
     * @param date      当前时间
     * @param addDay 天
     * @return
     * @author 王好(18675539583) 2017-10-26 15:18:18
     */
    public static final Date addHour(Date date, long addHour) {
        if (date == null) {
            return null;
        }
        Instant instant = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault())
        		.plusHours(addHour).atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }
    
    /**
     * <p>当前的时间 + 天</p>
     *
     * @param date      当前时间
     * @param addDay 天
     * @return
     * @author 王好(18675539583) 2017-10-26 15:18:18
     */
    public static final Date addDay(Date date, long addDay) {
        if (date == null) {
            return null;
        }
        Instant instant = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault())
        		.plusDays(addDay).atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }
    
    /**********************************日期加减end*************************************************/
    
    
    /**********************************日期比较判断begin*******************************************/
    /**
     * <p>获取与当前时间相差的秒数</p>
     *
     * @param dateStart 时间
     * @return
     * @author 王好(18675539583) 2017-11-2 16:26:35
     */
    public static long timeDiff(Date dateStart){
        LocalDateTime now  = LocalDateTime.now();
        LocalDateTime strat = LocalDateTime.ofInstant(dateStart.toInstant(), ZoneId.systemDefault());
        return Duration.between(strat, now).get(ChronoUnit.SECONDS);
    }

    /**
     * <p>获取与当前时间相差的分钟</p>
     *
     * @param startDate 时间
     * @return
     * @author 王好(18675539583) 2017-10-26 10:47:48
     */
    public static long timeDiffMin(Date startDate){
        return  timeDiffMin(startDate,new Date());
    }

    /**
     * <p>获取与当前时间相差的分钟</p>
     *
     * @param startDate 时间
     * @return
     * @author 王好(18675539583) 2017-10-26 10:47:48
     */
    public static long timeDiffMin(Date startDate, Date endDate){
        LocalDateTime start = LocalDateTime.ofInstant(startDate.toInstant(), ZoneId.systemDefault());
        LocalDateTime end = LocalDateTime.ofInstant(endDate.toInstant(), ZoneId.systemDefault());
        return ChronoUnit.MINUTES.between(start, end);
    }

    /**
     * <P>计算日期相差天数</P>
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return
     * @version 1.0
     * @author 王好（17720589316） 2016/12/21 17:00
     */
    public static long timeDiffDay(Date startDate, Date endDate) {
        LocalDateTime start = LocalDateTime.ofInstant(startDate.toInstant(), ZoneId.systemDefault());
        LocalDateTime end = LocalDateTime.ofInstant(endDate.toInstant(), ZoneId.systemDefault());
        return ChronoUnit.DAYS.between(start, end);
    }

    /**
     *  <p>获取对应日期是星期几</p>
     *
     * @return int
     * @author 王好(18675539583) 2017-10-24 14:46:40
     */
    public static int getWeekDay(Date date) {
        return DayOfWeek.from(date.toInstant()).getValue();
    }

    /**
     * <p>判断当前时间是否在给定的日期之内</p>
     *
     * @param startDate
     * @param endDate
     * @return
     * @author 王好(18675539583) 2017-10-24 14:35:50
     */
    public static boolean nowBetween(Date startDate, Date endDate) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime start = LocalDateTime.ofInstant(startDate.toInstant(), ZoneId.systemDefault());
        LocalDateTime end = LocalDateTime.ofInstant(endDate.toInstant(), ZoneId.systemDefault());
        return now.isAfter(start) && now.isBefore(end);
    }


    /**
     * 验证时间字符串格式输入是否为yyyy-MM-dd格式
     *
     * @param timeStr 时间字符串
     * @return
     */
    public static boolean valiDateTimeWithYYYYMMDDFormat(String timeStr) {
        LocalDate localDate = null;
        try {
            localDate =  LocalDate.parse(timeStr,DateTimeFormatter.ISO_DATE);
        } catch (Exception e) {
            log.warn("日期[{}]不是yyyy-MM-dd格式",timeStr);
        }
        
        return Objects.nonNull(localDate);
    }
    /**********************************日期比较判断end*********************************************/
    
    
    /**
     *  获取两个日期相差的月数
     * @param d1    较大的日期
     * @param d2    较小的日期
     * @return  如果d1>d2返回 月数差 否则返回0
     */
    public static int getMonthDiff(Date d1, Date d2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);
        if(c1.getTimeInMillis() < c2.getTimeInMillis()) return 0;
        int year1 = c1.get(Calendar.YEAR);
        int year2 = c2.get(Calendar.YEAR);
        int month1 = c1.get(Calendar.MONTH);
        int month2 = c2.get(Calendar.MONTH);
        int day1 = c1.get(Calendar.DAY_OF_MONTH);
        int day2 = c2.get(Calendar.DAY_OF_MONTH);
        // 获取年的差值 假设 d1 = 2015-8-16  d2 = 2011-9-30
        int yearInterval = year1 - year2;
        // 如果 d1的 月-日 小于 d2的 月-日 那么 yearInterval-- 这样就得到了相差的年数
        if(month1 < month2 || month1 == month2 && day1 < day2) yearInterval --;
        // 获取月数差值
        int monthInterval =  (month1 + 12) - month2  ;
        if(day1 < day2) monthInterval --;
        monthInterval %= 12;
        return yearInterval * 12 + monthInterval;
    }
}
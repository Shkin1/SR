package com.job.service.common.util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author pushkin
 * @version v1.0.0
 * @date 2020/6/2 14:10
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */

public class DateUtil {

    /**
     * YYYYMMDDHHMMSS <br>
     */
    public static final String  YYYY_MM_DD_HH_MM_SS= "yyyy-MM-dd HH:mm:ss";
    /**
     * YYYYMMDDHHMM <br>
     */
    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";

    /**
     * YYYYMMDD <br>
     */
    public static final String YYYY_MM_DD = "yyyyMMdd";



    /**
     * YYYYMM <br>
     */
    public static final String YYYY_MM = "yyyy-MM";
    /**
     * MMDD
     */
    public static final String MM_DD = "MM-dd";

    /**
     * HHMMSS <br>
     */
    public static final String HH_MM_SS = "HH:mm:ss";

    public static final String YYYY = "yyyy";

    /**
     * DD <br>
     */
    public static final String DD = "dd";

    /**
     * HH <br>
     */
    public static final String HH = "HH";

    /**
     * MM min<br>
     */
    public static final String MMMIN = "mm";

    /**
     * yyyy-MM-dd HH:mm:ss 转 yyyyMMddHHmmss
     */
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    /**
     * yyyy-MM-dd 转 yyyyMMdd
     */
    public static final String YYYYMMDD = "yyyyMMdd";


    /**
     * Description: 字符串转换成日期<br>
     *
     * @author ZhuRui<br>
     * @taskId <br>
     * @param str
     * @param pattern
     * @return <br>
     */
    public static Date strToDate(String str, String pattern)
    {

        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date date = null;
        try
        {
            date = format.parse(str);
        }
        catch (ParseException e)
        {

        }
        return date;
    }

    /**
     * Description: 日期转换成字符串<br>
     *
     * @author ZhuRui<br>
     * @taskId <br>
     * @param date
     * @param pattern
     * @return <br>
     */
    public static String dateToStr(Date date, String pattern)
    {

        SimpleDateFormat format = new SimpleDateFormat(pattern);
        String str = format.format(date);
        return str;
    }

    /**
     * Description: <br>
     *
     * @author ZhuRui<br>
     * @taskId <br>
     * @param str
     * @param pattern
     * @return <br>
     */
    public static String getDateStr(String str, String pattern)
    {
        return dateToStr(strToDate(str, pattern), pattern);
    }

    /**
     * Description: 一天的时间划分为5分钟一段，返回时间输入第几段
     *
     * @author ding.hailong
     * @taskId
     * @param dateTime
     * @return
     * @exception:
     */
    public static int DivideTime(Date dateTime)
    {

        int i = 0;

        SimpleDateFormat fmtH = new SimpleDateFormat("HH");
        SimpleDateFormat fmtM = new SimpleDateFormat("mm");

        int hour = Integer.parseInt(fmtH.format(dateTime));
        int min = Integer.parseInt(fmtM.format(dateTime));

        // 00:00~04:59 算第一个5分钟 以此类推
        i = hour * 12 + min / 5 + 1;

        return i;
    }

    /**
     * Description: 比较两个时间相差的秒数(第一个时间-第二个时间)
     *
     * @author ding.hailong
     * @taskId
     * @param firstTime
     * @param secondTime
     * @return
     * @exception:
     */
    public static long compareTime(Date firstTime, Date secondTime)
    {
        long i;
        i = (firstTime.getTime() - secondTime.getTime()) / 1000;

        return i;

    }

    /**
     * Description: 根据日期，返回星期几
     *
     * @author ding.hailong
     * @taskId
     * @param date
     * @return
     * @exception:
     */
    public static String getWeekDay(Date date)
    {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        int i = ca.get(Calendar.DAY_OF_WEEK) -1;//一周的第几天
        switch (i)
        {
            case 1:
                return "星期一";
            case 2:
                return "星期二";
            case 3:
                return "星期三";
            case 4:
                return "星期四";
            case 5:
                return "星期五";
            case 6:
                return "星期六";
            default:
                return "星期日";
        }
    }
    /**
     *  获取时间段内的每一天
     * @Title: getBetweenDaysList
     * @Description: TODO
     * @param @param begintTime
     * @param @param endTime
     * @param @param type
     * @param @return
     * @return List<String>
     * @author: jiang.lili
     * @throws
     */
    public static List<String> getBetweenDaysList(String beginTime, String endTime,String type)
    {
        Date  dBegin =  DateUtil.strToDate(beginTime, type);
        Date   dEnd =  DateUtil.strToDate(endTime, type);
        List<String> daysStrList = new ArrayList<String>();
        daysStrList.add(DateUtil.dateToStr(dBegin, type));
        Calendar calBegin = Calendar.getInstance();
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(dEnd);
        while (dEnd.after(calBegin.getTime())) {
            if(type.equals(DateUtil.YYYY)) {
                calBegin.add(Calendar.YEAR, 1);
            }else if(type.equals(DateUtil.YYYY_MM)) {
                calBegin.add(Calendar.MONTH, 1);
            }else if(type.equals(DateUtil.YYYY_MM_DD)) {
                calBegin.add(Calendar.DAY_OF_MONTH, 1);
            }else if(type.equals(DateUtil.HH)) {
                calBegin.add(Calendar.HOUR, 1);
            }
            String dayStr =DateUtil.dateToStr(calBegin.getTime(),type);
            daysStrList.add(dayStr);
        }
        return daysStrList;
    }
    /**
     * @Title: getDays
     * @Description: TODO
     * @param @param year
     * @param @param month
     * @param @param type 0某个月的每一天，1是某个月的工作日，2是某个月的非工作日
     * @param @return
     * @return List<Date>
     * @author: jiang.lili
     * @throws
     */
    public static List<Date> getDays(String timeStr,int type){
        List<Date> dates = new ArrayList<Date>();
        Calendar ca = Calendar.getInstance();
        ca.setTime(DateUtil.strToDate(timeStr, DateUtil.YYYY_MM_DD));
        int year = ca.get(Calendar.YEAR);//年份数值
        int month = ca.get(Calendar.MONTH) +1;//第几个月
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH,  month -1);
        cal.set(Calendar.DATE, 1);


        while(cal.get(Calendar.YEAR) == year &&
                cal.get(Calendar.MONTH) < month){
            int day = cal.get(Calendar.DAY_OF_WEEK);
            if(type == 0) {
                dates.add((Date)cal.getTime().clone());
            }else if(type == 1) {
                if(!(day == Calendar.SUNDAY || day == Calendar.SATURDAY)){
                    dates.add((Date)cal.getTime().clone());
                }
            }else if(type == 2) {
                if(day == Calendar.SUNDAY || day == Calendar.SATURDAY){
                    dates.add((Date)cal.getTime().clone());
                }
            }

            cal.add(Calendar.DATE, 1);
        }
        return dates;
    }
    /**
     * 输入年月日判断是否是周末
     * 为真是周末反之不是
     * @Title: checkWeek
     * @Description: TODO
     * @param @param year
     * @param @param mon
     * @param @param day
     * @param @return
     * @return boolean
     * @author: jiang.lili
     * @throws
     */
    public static boolean checkWeek(String year,String mon,String day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, Integer.valueOf(year));
        calendar.set(Calendar.MONTH, Integer.valueOf(mon)-1);//月份比正常小1,0代表一月
        calendar.set(Calendar.DAY_OF_MONTH, Integer.valueOf(day));
        //判断日期是否是周六周日
        if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ||
                calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
            return true;
        }
        return false;
    }
}

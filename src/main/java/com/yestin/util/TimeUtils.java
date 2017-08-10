package com.yestin.util;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimeUtils {

    /**
     * 转换成Date形式
     *
     * @param Time
     * @return
     */

    public static Date getTime(String Time) {

        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        Date date = null;
        try {
            String time = Time.replaceAll("/", "-");
            date = sdf.parse(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }


    /**
     * 转换成datetime形式
     *
     * @param operatingTime
     * @return
     */
    public static Timestamp getOperateTime(String operatingTime) {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        try {
            ts = Timestamp.valueOf(operatingTime);
            System.out.println(ts);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ts;
    }

	/*
     * public static void main(String[] args) throws ParseException {
	 * System.out.println(TimestampStr("2015-04-30  15:15:38").toString());; }
	 */

    public static Timestamp TimestampStr(String str_time) throws ParseException {

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp ts = new Timestamp(format.parse(str_time).getTime());
        System.out.println(ts.toString());
        return ts;
    }


    // datetime转换成string形式

    public static String getDateTime(Timestamp operatingTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = "";
        try {
            // 方法一
            time = sdf.format(operatingTime);
            System.out.println(time);
            /*
             * //方法二 time = ts.toString(); System.out.println(time);
			 */
        } catch (Exception e) {
            e.printStackTrace();
        }
        return time;
    }

    /**
     * datetime转换成string形式 格式为yyyy-MM-dd
     *
     * @param operatingTime
     * @return
     */

    public static String getDate(Timestamp operatingTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time = "";
        try {
            // 方法一
            time = sdf.format(operatingTime);
            System.out.println(time);
            /*
             * //方法二 time = ts.toString(); System.out.println(time);
			 */
        } catch (Exception e) {
            e.printStackTrace();
        }
        return time;
    }

    /**
     * 获取系统时间转换成datetime类型
     *
     * @return
     */
    public static Timestamp getSysTime() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        String currTime = dateFormat.format(date);
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        try {
            ts = Timestamp.valueOf(currTime);
            System.out.println(ts);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ts;
    }

    /**
     * 获取系统时间转换成datetime类型
     *
     * @return
     */
    public static Time getSysTimes() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String currTime = dateFormat.format(date);
        Time ts = new Time(System.currentTimeMillis());
        try {
            ts = Time.valueOf(currTime);
            System.out.println(ts);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ts;
    }

    /**
     * 获取系统时间转换成date类型
     *
     * @return
     */
    public static Date getSysDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currTime = sdf.format(date);
        try {
            date = sdf.parse(currTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }


    /**
     * 获取现在时间
     *
     * @return返回短时间格式 yyyy-MM-dd
     */
    public static Date getNowDateShort() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        ParsePosition pos = new ParsePosition(8);
        Date currentTime_2 = formatter.parse(dateString, pos);
        return currentTime_2;
    }

/*	public static void main(String[] args) {
        System.out.println(getNowDateShort());
	}*/

    public static String getTime() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy/MM/dd HH:mm:ss");
        String currTime = dateFormat.format(date);
        return currTime;
    }

    public static String getYear() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        String currTime = dateFormat.format(date);
        return currTime;
    }

    public static String getOrderTime() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        String currTime = dateFormat.format(date);
        return currTime;
    }

    public static String getPayTime() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        String currTime = dateFormat.format(date);
        return currTime;
    }

    public static String getPayTime2() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String currTime = dateFormat.format(date);
        return currTime;
    }

    public static String getTimes(Date time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currTime = dateFormat.format(time);
        return currTime;
    }

    public static String getDateTimes(Date time) {

        if (time == null) {
            return null;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currTime = dateFormat.format(time);
        return currTime;
    }


    public static String getDateTimes2(Date time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        String currTime = dateFormat.format(time);
        return currTime;
    }

    public static String getImagesTime() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String currTime = dateFormat.format(date);
        return currTime;
    }

    public static String getWeixinTime() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM月dd日");
        String currTime = dateFormat.format(date);
        return currTime;
    }

    public static String getDay() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
        String currTime = dateFormat.format(date);
        return currTime;
    }

    public static Date StringToDate(String strdate) {
        Date date = null;
        try {
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            date = dateformat.parse(strdate);


        } catch (Exception e) {
        }
        return date;
    }

    //根据当前时间去+数字
    public static Date dateAddDay(Integer dayTime) {

        Calendar calendar = new GregorianCalendar();

        calendar.add(calendar.DATE, dayTime);//把日期往后增加180天.整数往后推,负数往前移动

        Date invaliddt = calendar.getTime();

        String dateAddDay = TimeUtils.getDateTimes2(invaliddt);

        return invaliddt;
    }

    /**
     * 爱流量企业版流量 计算赠送活动开始时间方法
     *
     * @return
     */
    public static Date addDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar rightNow = Calendar.getInstance();
        Date invaliddt = new Date();
        rightNow.setTime(invaliddt);
        rightNow.add(Calendar.DATE, 3);
        Date activityStarttime = rightNow.getTime();

        String activityStarttime2 = sdf.format(activityStarttime);

        return TimeUtils.getTime(activityStarttime2);
    }


    public static void main(String[] args) {
        System.out.println(TimeUtils.getDateTimes(addDate()));
    }

}

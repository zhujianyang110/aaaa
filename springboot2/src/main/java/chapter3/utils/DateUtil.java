package com.marknum.utils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.marknum.utils.Tools;


public class DateUtil {
	public 	static final Logger logger = LoggerFactory.getLogger(DateUtil.class);
	private static final String UNEXPECTEDERROR = "意料之外错误！！！";	
	private static final String DATAFORMAT = "yyyy-MM-dd HH:mm:ss";
	private static final String DATAFORMAT2 =  "yyyyMMddHHmmss";
	private static final String DATAFORMAT3 = "yyyy/MM/dd HH:mm:ss";
	private static final String EL = "^[1-2]\\d{13}$";
	
	private DateUtil(){}
	
	/**
	 * 根据时间戳参数的值，获取时间戳当天零点的时间戳
	 * @param timestamp
	 * @return
	 */
	public static int getDayOfZeroHourTimestamp(int timestamp){
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(timestamp * 1000l);
		calendar.set(Calendar.HOUR_OF_DAY, 0);// 小时设置为0点
		calendar.set(Calendar.SECOND, 0);// 秒设置为0秒
		calendar.set(Calendar.MINUTE, 0);// 分钟设置为0分
		calendar.set(Calendar.MILLISECOND, 0);// 毫秒设置为0毫秒
		return (int)(calendar.getTimeInMillis()/1000);
	}
	
	/***
	 * 
	 * @param endDate
	 * @param format
	 * @return
	 */
	public static int getState(String endDate, String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		try {
			return new Date().getTime() - df.parse(endDate).getTime() > 60 * 60 * 1000 ? 2
					: 1;
		} catch (ParseException e) {
			logger.error(UNEXPECTEDERROR, e);
		}
		return 2;
	}
	
	public static String longToDate(String dateLong){
		Date d=new Date(Long.parseLong(dateLong+"000"));
		SimpleDateFormat sdf=new SimpleDateFormat(DATAFORMAT);
		return sdf.format(d);
		
	}
	public static long timeRange(String startTime){
		try {
			SimpleDateFormat df = new SimpleDateFormat(DATAFORMAT2);
			String eL = EL;
			Pattern p = Pattern.compile(eL);
			Matcher m = p.matcher(startTime);
			if (!m.matches()) {
				return (new Date().getTime() - df.parse("19700101080000").getTime())/1000;
			}
			return (df.parse(startTime).getTime() - df.parse("19700101080000").getTime())/1000;
		} catch (ParseException e) {
			logger.error(UNEXPECTEDERROR, e);
		}
		return 0;
	}
	/**
	 * 将当前格式为yyyyMMddhhmmss的时间转化成毫秒数
	 * @param dateStr
	 * @return
	 */
	public static long dateToLong(String dateStr){
		String eL = EL;
		Pattern p = Pattern.compile(eL);
		Matcher m = p.matcher(dateStr);
		if (!m.matches()) {
			return 0;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(DATAFORMAT2);
		try {
			return sdf.parse(dateStr).getTime();
		} catch (ParseException e) {
			logger.error(UNEXPECTEDERROR, e);
		}
		return 0;
	}
	/**
	 * 将当前格式为yyyyMMddhhmmss的时间转化成秒数
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static long dateToLong(String dateStr,String format){
		String eL = EL;
		Pattern p = Pattern.compile(eL);
		Matcher m = p.matcher(dateStr);
		if (!m.matches()) {
			return 0;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(dateStr).getTime()/1000;
		} catch (ParseException e) {
			logger.error(UNEXPECTEDERROR, e);
		}
		return 0;
	}
	public static String strToStr(String dateStr) {
		if(dateStr==null || "".equals(dateStr))
			return "0";
		SimpleDateFormat sdf = new SimpleDateFormat(DATAFORMAT);
		SimpleDateFormat sdf1 = new SimpleDateFormat(DATAFORMAT2);
		Date date = null;
		try {
			date = sdf1.parse(dateStr);
		} catch (ParseException e) {
			logger.error(UNEXPECTEDERROR, e);
			return "";
		}
		return sdf.format(date);
	}
	public static String dateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATAFORMAT);
		sdf.applyPattern("yyyy年MM月dd日 HH时mm分ss秒");
		return sdf.format(date);
	}
	
	public static String strToStr(String dateStr, String format) {
		if(dateStr==null || "".equals(dateStr) || format == null || "".equals(format))
			return "0";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			logger.error(UNEXPECTEDERROR, e);
		}
		return sdf.format(date);
	}
	/**
	 * dateStr 格式 yyyyMMddHHmmss，目标格式format
	 * @param datestr
	 * @param format
	 * @return
	 */
	public static String str2str(String datestr,String format){
		if(datestr==null || "".equals(datestr) || format == null || "".equals(format))
			return "";
		SimpleDateFormat sdfD=new SimpleDateFormat(format);
		SimpleDateFormat sdfS=new SimpleDateFormat(DATAFORMAT2);
		Date date=null;
		String rsltStr=null;
		try {
			date=sdfS.parse(datestr);
			rsltStr=sdfD.format(date);
		} catch (ParseException e) {
			logger.error(UNEXPECTEDERROR, e);
		}
		return rsltStr;
	}
	public static String str2strCN(String datestr,String format){
		if(datestr==null || "".equals(datestr) || format == null || "".equals(format))
			return "";
		SimpleDateFormat sdfD=new SimpleDateFormat(format);
		SimpleDateFormat sdfS=new SimpleDateFormat(DATAFORMAT);
		Date date=null;
		String rsltStr=null;
		try {
			date=sdfS.parse(datestr);
			rsltStr=sdfD.format(date);
		} catch (ParseException e) {
			logger.error(UNEXPECTEDERROR, e);
		}
		return rsltStr;
	}
	public static Date strToDate(String dateStr, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			logger.error(UNEXPECTEDERROR, e);
		}
		return date;
	}
	
	public static String dateToStr(Date date, String format) {
		return new SimpleDateFormat(format).format(date);
	}

	public static Date strToDate(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			logger.error(UNEXPECTEDERROR, e);
		}
		return date;
	}

	public static String dateToString2(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		return sdf.format(date);
	}

	public static Date getDateBySecond(long s) {
		Date date = new Date();
		date.setTime(s * 1000);
		return date;
	}
	/**
	 * 将当前时间转化成秒
	 * @param date
	 * @return
	 */
	public static long dateToseconds(Date date){
		long seconds=0;	
		seconds=date.getTime()/1000;
		return seconds;
	}
	/**
	 * int转时间
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static String date(String dateStr,String format){
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		long ds = Integer.parseInt(dateStr);
		long aa = ds * 1000;
		return sdf.format(new Date(aa));
	}
	/**
	 * string转时间
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static long date2seconds(String dateStr,String format){
			SimpleDateFormat sdf=new SimpleDateFormat(format);
			long seconds=0;	
			try {
				Date  date =sdf.parse(dateStr);
				seconds=date.getTime()/1000;
			} catch (ParseException e) {
				logger.error(UNEXPECTEDERROR, e);
			}
			return seconds;
	}
	public static String getCurrentTimeString() {
		StringBuilder sf = new StringBuilder();
		long now = System.currentTimeMillis(); 
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(now);
		int month = 0;
		int day = 0;
		int hour = 0;
		int fen = c.get(Calendar.MINUTE);
		int second = 0;
		month = (c.get(Calendar.MONTH) + 1);
		day = c.get(Calendar.DATE);
		hour = c.get(Calendar.HOUR);
		second = c.get(Calendar.SECOND);

		sf.append(String.valueOf(c.get(Calendar.YEAR)));
		if (month < 10) {
			sf.append("0" + month);
		} else {
			sf.append(String.valueOf(month));
		}
		if (day < 10) {
			sf.append("0" + day);
		} else {
			sf.append(String.valueOf(day));
		}
		if (hour < 10) {
			sf.append("0" + hour);
		} else {
			sf.append(String.valueOf(hour));
		}
		if (fen < 10) {
			sf.append("0" + fen);
		} else {
			sf.append(String.valueOf(fen));
		}
		if (second < 10) {
			sf.append("0" + second);
		} else {
			sf.append(String.valueOf(second));
		}
		return sf.toString();
	}
	/**
	 * 获取去前一天日期
	 * @return  2017-06-05
	 */
	public static String yesterday(){
		Calendar   cal   =   Calendar.getInstance();
		  cal.add(Calendar.DATE,   -1);
		  return new SimpleDateFormat( "yyyy-MM-dd ").format(cal.getTime());
	}

	
	/**
	 * 获取当前日期
	 */
	public static String today(){
		Calendar   cal   =   Calendar.getInstance();
		  cal.add(Calendar.DATE,0);
		  return new SimpleDateFormat( "yyyy-MM-dd ").format(cal.getTime());
	}

	  /* 
     * 将时间转换为时间戳
     */    
    public static String dateToStamp(String s) throws ParseException{
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATAFORMAT);
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime()/1000;
        res = String.valueOf(ts);
        return res;
    }

	/**
	 * 获取YYYYMMDD格式
	 * @return
	 */
	public static String getDays(){
		SimpleDateFormat sdfDays = new SimpleDateFormat("yyyyMMdd");		
		return sdfDays.format(new Date());
	}
	
	/**
	 * 获取YYYY-MM-DD HH:mm:ss格式
	 * @return
	 */
	public static String getTime() {
		SimpleDateFormat sdfTime = new SimpleDateFormat(DATAFORMAT);		
		return sdfTime.format(new Date());
	} 
	
	/**
	 * 获取YYYY格式
	 * @return
	 */
	public static String getSdfTimes() {
		SimpleDateFormat sdfTimes = new SimpleDateFormat(DATAFORMAT2);		
		return sdfTimes.format(new Date());
	}
	
	public static String timeStamp2Date(String timestampString, String formats) {
		if (Tools.isEmpty(formats)){
			formats = DATAFORMAT;
		}	
		Long timestamp = Long.parseLong(timestampString) * 1000;
		return new SimpleDateFormat(formats, Locale.CHINA).format(new Date(timestamp));			
	}
	
	public static String timeStamp2DateMs(String timestampString, String formats) {
		if (Tools.isEmpty(formats)){
			formats = DATAFORMAT;
		}	
		Long timestamp = Long.parseLong(timestampString);
		return new SimpleDateFormat(formats, Locale.CHINA).format(new Date(timestamp));			
		

	}	
	
    public static long gettimestampSub(String beginDateStr,String endDateStr){
        long day=0;
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat(DATAFORMAT);
        java.util.Date beginDate = null;
        java.util.Date endDate = null;
        
            try {
				beginDate = format.parse(beginDateStr);
				endDate= format.parse(endDateStr);
			} catch (ParseException e) {
				logger.error(UNEXPECTEDERROR, e);
			}
            if(null != endDate && null != beginDate){
                day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000);           	
            }
      
        return day;
    }
    
    /**
     * 日期格式字符串转换成时间戳
     *
     * @param dateStr 字符串日期
     * @param format   如：yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String date2TimeStamp(String dateStr, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return String.valueOf(sdf.parse(dateStr).getTime() / 1000);
        } catch (Exception e) {
        	logger.error(UNEXPECTEDERROR, e);
        }
        return "";
    }  
    
    public static List<String> findDates(Date dBegin, Date dEnd){
        List<String> lDate = new ArrayList<>();
        SimpleDateFormat sd = new SimpleDateFormat("yyyyMMddHH");
        lDate.add(sd.format(dBegin));
        Calendar calBegin = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calEnd.setTime(dEnd);
        // 测试此日期是否在指定日期之后
        while (dEnd.after(calBegin.getTime()))
        {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(Calendar.HOUR_OF_DAY, 1);
            lDate.add(sd.format(calBegin.getTime()));
        }
        return lDate;
    }
    
    /* 
     * 将时间戳转换为时间
     */
    public static Date stampToDate(String s){
        long lt = new Long(s);
        Date date = new Date(lt*1000);
        return date;
    }    
    
    public static void main(String[] args) throws ParseException {
    	System.out.println(timeStamp2Date("1551442080",""));
	}

    	/**
    	 * 获取当前时间戳（秒级）
    	 * 
    	 * @return 整型当前时间的时间戳
    	 */
    	public static int getCurrTimestamp() {
    		return ((Long) (new Date().getTime() / 1000)).intValue();
    	}
    	
    	/**
    	 * 获取YYYYMMDD格式
    	 * @return
    	 */
    	public static String getTimes(){
    		SimpleDateFormat sdfDays = new SimpleDateFormat("HH:mm:ss");		
    		return sdfDays.format(new Date());
    	}  
    	
        /**
         * 获取给定的时间,延时n小时的时间
         * @param data 给定时间
         * @param hours 延时几小时
         * @return
         * @throws ParseException 
         */
        public static String getDelayedTime(String data, int hours) {
        	Calendar cal = Calendar.getInstance();
        	SimpleDateFormat sdf = new SimpleDateFormat(DATAFORMAT);
        	try {
    			cal.setTime(sdf.parse(data));
    		} catch (ParseException e) {
    			logger.error("{}",e);
    		} 
        	cal.add(Calendar.HOUR, hours);
        	Date time = cal.getTime();
    		return sdf.format(time);
        }
        
        /**
         * 
         * @Title: getNowTime
         * @Description: 获取yyyy/MM/dd HH:mm:ss格式
         * @author: 朱建阳
         * @date: 2019年7月9日 下午4:03:34
         * @return
         * @return: String
         * @since: 版本v3.1
         */
    	public static String getNowTime() {
    		SimpleDateFormat sdfTime = new SimpleDateFormat(DATAFORMAT);		
    		return sdfTime.format(new Date());
    	}         
    	
}


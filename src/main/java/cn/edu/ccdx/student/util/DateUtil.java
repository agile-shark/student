package cn.edu.ccdx.student.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

	/**
	 * @param source 传入的初始化日期时间
	 * @see 日期格式转换，即可以讲系统时间转换成自己想要的格式
	 * @return String
	 *//*
	public static String dateTimeChange(Date source) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String changeTime = format.format(source);
		return changeTime;
	}

	*//**
	 * @param aDate 传入的初始化日期时间
	 * @see 将日期转换成：月/日/年 的形式
	 * @return String
	 *//*
	public static String shortDate(Date aDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		return formatter.format(aDate);
	}

	*//**
	 * @see:得到当前时间，并且将其转换成：年/月/日 的标准格式
	 * @return String
	 *//*
	public static String nowDate() {
		String iDate="";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String str= formatter.format(new Date());
		String[] date = str.split("-");
		if (date.length >= 3) {
			iDate = date[0] + "/" + date[1] + "/" + date[2]+"";
		} else {
			iDate = str;
		}
		return iDate;
	}
	
	*//**
	 * @see:得到当前时间，并且将其转换成：年-月-日 的标准格式
	 * @return String
	 *//*
	public static String nowDates() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String str= formatter.format(new Date());
		return str;
	}


	*//**
	 * @param aDate : 传入的初始化时间
	 * @see 将时间转换成快递号形式的字符串（即可以用来当订单号使用）
	 * @return ： String
	 *//*
	public static String mailDate(Date aDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return formatter.format(aDate);
	}
	
	*//**
	 * @param aDate : 传入的要格式化的时间
	 * @see 将传入的时间格式化为：年-月-日
	 * @return String
	 *//*
	public static String dateParser(Date aDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(aDate);
	}

	*//**
	 * @param strDate 传入用户想要的时间字符串
	 * @see 将字符串日期转换成Date类型
	 * @return Date
	 *//*
	public static Date parser(String strDate) {
		//replace(char oldChar, char newChar)返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。
		strDate = strDate.replace("/", "-");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(strDate);
		} catch (Exception e) {
			return null;
		}
	}

	*//**
	 * @param strDate 要转换的时间字符串
	 * @param formatter 要转换的格式,例如：yyyy-MM-dd
	 * 注意：输入的时间格式要和转换的格式一致才能进行转换，否则会报空指针
	 * @return Date
	 *//*
	public static Date parser(String strDate, String formatter) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatter);
		try {
			return sdf.parse(strDate);
			
		} catch (Exception e) {
			return null;
		}
	}

	*//**
	 * @param myDate
	 * @param amount
	 * @return？？？？？？？？？？？？？
	 *//*
	public static Date addMonth(Date myDate, int amount) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(myDate);
		boolean isEndDayOfMonth_old = cal
				.getActualMaximum(GregorianCalendar.DAY_OF_MONTH) == cal
				.get(GregorianCalendar.DAY_OF_MONTH);
		cal.add(GregorianCalendar.MONTH, amount);
		boolean isEndDayOfMonth_new = cal
				.getActualMaximum(GregorianCalendar.DAY_OF_MONTH) == cal
				.get(GregorianCalendar.DAY_OF_MONTH);
		if (isEndDayOfMonth_old && !isEndDayOfMonth_new) {
			cal.set(GregorianCalendar.DATE, cal
					.getActualMaximum(GregorianCalendar.DAY_OF_MONTH));
		}
		return cal.getTime();
	}

	*//**
	 * 
	 * @param myDate 用户自己给定的日期
	 * @param amount 要增加的天数
	 * @return Date
	 *//*
	public static Date addDay(Date myDate, int amount) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(myDate);
		cal.add(Calendar.DAY_OF_MONTH, amount);
		return cal.getTime();
	}

	*//**
	 * @param myDate 用户给定的日期
	 * @param amount 要增加的分钟数
	 * @return Date
	 *//*
	public static Date addMinute(Date myDate, int amount) {
		//要明白在Calendar中的add方法，是给定的时间的某个字段和后面的参数进行相减得到的
		Calendar cal = Calendar.getInstance();
		cal.setTime(myDate);
		int minute = 0;
		amount = -(amount);

		if (amount > 60) {

			int hour = (int) amount / 60;

			if (hour * 60 > amount) {
				minute = hour * 60 - amount;

				cal.add(Calendar.HOUR_OF_DAY, -hour);
				cal.add(Calendar.MINUTE, minute);

			} else if (hour * 60 < amount) {

				minute = amount - hour * 60;
				cal.add(Calendar.HOUR_OF_DAY, -hour);
				cal.add(Calendar.MINUTE, -minute);

			} else {
				cal.add(Calendar.HOUR_OF_DAY, -hour);
			}

		} else {

			cal.add(Calendar.MINUTE, -amount);
		}
		return cal.getTime();
	}
	
	*//**
	 * @param myDate 用户给定的日期
	 * @param amount 要增加的年数
	 * @return Date?????????????????
	 *//*
	public static Date addYear(Date myDate, int amount) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(myDate);
		boolean isEndDayOfMonth_old = cal
				.getActualMaximum(GregorianCalendar.DAY_OF_MONTH) == cal
				.get(GregorianCalendar.DAY_OF_MONTH);
		cal.add(GregorianCalendar.YEAR, amount);
		boolean isEndDayOfMonth_new = cal
				.getActualMaximum(GregorianCalendar.DAY_OF_MONTH) == cal
				.get(GregorianCalendar.DAY_OF_MONTH);
		if (isEndDayOfMonth_old && !isEndDayOfMonth_new) {
			cal.set(GregorianCalendar.DATE, cal
					.getActualMaximum(GregorianCalendar.DAY_OF_MONTH));
		}
		return cal.getTime();
	}

	*//**
	 * @param myDate 用户给定的日期
	 * @see 得到一个星期的第一天。如果今天为周一，则返回2，是因为周日为第一天
	 * @return int
	 *//*
	public static int getWeekDay(Date myDate) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(myDate);
		return cal.get(GregorianCalendar.DAY_OF_WEEK);
	}

	*//**
	 * @param myDate 用户给定的日期
	 * @see 按照标准方式将日期改为中国符合的日期
	 * @return int
	 *//*
	public static int getConvertWeekDay(Date myDate) {
		int day = getWeekDay(myDate);
		int result = day - 1;
		if (result == 0)
			result = 7;
		return result;
	}

	*//**
	 * @param myDate 用户指定的日期
	 * @see 将小时、分钟和秒转换成整型变量
	 * @return int
	 *//*
	public static int getTimeFromDate(Date myDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("hhmmss");
		int result = Integer.parseInt(sdf.format(myDate));
		return result;
	}

	*//**
	 * @param startDate 开始的日期
	 * @param endDate 结束的日期
	 * @see 计算用户给定日期到结束日期所
	 * 86400000=1000毫秒 * 60秒 * 60分 * 24时
	 * @return
	 *//*
	public static long getDaysBetweenDate(Date startDate, Date endDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		startDate = cal.getTime();
		cal.setTime(endDate);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return (cal.getTime().getTime() - startDate.getTime()) / 86400000;

	}

	*//**
	 * @param str 用户给定的时间字符串
	 * @see 将格式为2012-7-9 转换为2012.7.9
	 * @return String
	 *//*
	public static String strDateTime(String str) {
		String idate = "";
		if (str != null) {
			String[] date = str.split("-");
			if (date.length >= 3) {
				idate = date[0] + "." + date[1] + "." + date[2];
			} else {
				idate = str;
			}
		}
		return idate;
	}

	*//**
	 * @param str 用户给定的日期字符串
	 * @see 将2012-7-9这种格式的日期字符串转换为12.7.9的形式
	 * @return String
	 *//*
	public static String strDotDateTime(String str) {
		String idate = "";
		if (str != null) {
			String data0 = null;
			String[] date = str.split("-");
			if (date.length >= 3) {
				if (date[0] != null) {
					data0 = date[0].substring(2, 4);
				}
				idate = data0 + "." + date[1] + "." + date[2];
			} else {
				idate = str;
			}
		}
		return idate;
	}

	*//**
	 * @param str用户指定的日期字符串
	 * @see 将2012.07.09 16:25:36 转换为 2012-07-09 16:25:36
	 * @return String
	 *//*
	public static String bakDateTime(String str) {
		String idate = "";
		if (str != null) {
			int l1 = str.indexOf(".");
			String d1 = str.substring(0, l1);
			String s1 = str.substring(l1 + 1);
			int l2 = s1.indexOf(".");
			String d2 = s1.substring(0, l2);
			String d3 = s1.substring(l2 + 1);
			idate = d1 + "-" + d2 + "-" + d3;
		}
		return idate;
	}

	*//**
	 * @param str 用户传入的日期字符串
	 * @see 不管传入的字符串有多长，都会转成年.月.日
	 * @return
	 *//*
	public static String strShortDateTime(String str) {
		String idate = "";
		if (str != null) {
			String[] date = str.split("-");
			if (date.length >= 3) {
				idate = date[0] + "." + date[1] + "." + date[2];
			} else {
				idate = str;
			}
			if (idate != null && idate.length() > 9) {
				idate = idate.substring(0, 10);

			}
		}
		return idate;
	}
	
	*//**
	 * @param dateA 起始计算日期
	 * @param dateB 结束计算日期
	 * @see 计算这两个日期之间相隔的天数
	 * @return int
	 *//*
	public static int getBetweenDayNumber(String dateA, String dateB) {
	      long dayNumber = 0;
	      long DAY = 24L * 60L * 60L * 1000L;
	      SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	      try {
	       java.util.Date d1 = df.parse(dateA);
	       java.util.Date d2 = df.parse(dateB);
	       dayNumber = (d2.getTime() - d1.getTime()) / DAY;
	      } catch (Exception e) {
	       e.printStackTrace();
	      }
	      return (int) dayNumber;
	}
	
	*//**
	 * @param str 用户传入的日期字符串，推荐使用：2012-7-9
	 * @see 将字符串转换为带有中文格式的字符串
	 * @return String 
	 *//*
	public static String getDateKor(String str){
		String idate = "";
		if (str != null) {
			String[] date = str.split("-");
			if (date.length >= 3) {
				idate = date[0] + "年" + date[1] + "月" + date[2] + "日";
			} else {
				idate = str;
			}
			if (idate != null && idate.length() > 9) {
				idate = idate.substring(0, 11);

			}
		}
		return idate;
	}
*/
	public static void main(String[] args) {
		//System.out.println(nowDate());
	}
}

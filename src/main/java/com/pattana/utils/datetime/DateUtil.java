package com.pattana.utils.datetime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.pattana.utils.ThaiUtilities;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author
 * @version 1.0
 */
public class DateUtil {
	public static final int DATE = 1;
	public static final int WEEK = 2;
	public static final int MONTH = 3;
	public static final int YEAR = 4;
	public static int DATEDIFF = 0;
	public static int MONTHDIFF = 0;
	public static int YEARDIFF = 0;
	public static final String[] LONG_MONTHNAMES_EN = { "January", "February", "March", "Apil", "May", "June", "July",
			"August", "September", "October", "November", "December" };
	public static final String[] LONG_MONTHNAMES_TH = { "มกราคม", "กุมภาพันธ์", "มีนาคม", "เมษายน", "พฤษภาคม",
			"มิถุนายน", "กรกฏาคม", "สิงหาคม", "กันยายน", "ตุลาคม", "พฤศจิกายน¹", "ธันวาคม" };

	/**
	 * @return String of Current Date in format dd
	 */
	public static String getDay() throws Exception {
		return getDay(new java.util.Date(), Locale.ENGLISH);
	}

	/**
	 * @return String of Current Date in format MM
	 */
	public static String getMonth() throws Exception {
		return getMonth(new java.util.Date(), Locale.ENGLISH);
	}

	/**
	 * @return String of Current Date in format yyyy-MM-dd
	 */
	public static String getStrDate() throws Exception {
		return getStrDate(new java.util.Date());
	}

	/**
	 * @return String of Current Date in format yyyy-MM-dd HH:mm:ss
	 */
	public static String getStrDateTime(){
		String strDateTime="";
		try {
			strDateTime=getStrDateTime(new java.util.Date());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return strDateTime;
	}

	/**
	 * @param date a java.util.Date
	 * @return String of Date in format yyyy-MM-dd
	 */
	public static String getStrDate(Date date) throws Exception {
		SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		return simpledateformat.format(date);
	}

	/**
	 * @param date a java.util.Date
	 * @return String of Date in format yyyy-MM-dd
	 */
	public static String getStrDateTime(Date date) throws Exception {
		SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
		return simpledateformat.format(date);
	}

	/**
	 * @return String of Current Date in format dd/MM/yyyy (Thai Year)
	 */
	public static String getStrThaiDate() throws Exception {
		return getStrThaiDate(new java.util.Date());
	}

	/**
	 * @param date a java.util.Date
	 * @return String of Date in format dd/MM/yyyy (Thai Year)
	 */
	public static String getStrThaiDate(Date date) throws Exception {
		SimpleDateFormat simpledateformat = new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));
		return simpledateformat.format(date);
	}

	/**
	 * @param strEngDate in format of MS SQL Server
	 * @return String of Date in format dd/MM/yyyy (Thai Year)
	 */
	public static String getStrThaiDate(String strEngDate) throws Exception {
		return ThaiDate.getDate(strEngDate);
	}

	/**
	 * @param strEngDateTime in format of MS SQL Server
	 * @return String of Date in format dd/MM/yyyy, HH:mm:ss (Thai Year)
	 */
	public static String getStrThaiDateTime(String strEngDateTime) throws Exception {
		return ThaiDate.getDateTime(strEngDateTime);
	}

	/**
	 * @return String of Current Date in format MM
	 */
	public static String getMonthNameTH(int nMonth) throws Exception {
		if ((nMonth >= 0) && (nMonth <= 12))
			return ThaiUtilities.ASCII2Unicode(LONG_MONTHNAMES_TH[nMonth - 1]);
		else
			return "";
	}

	/**
	 * @return String of Current Date in format yyyy (ENG)
	 */
	public static String getYear() throws Exception {
		return getYear(new java.util.Date(), Locale.ENGLISH);
	}

	/**
	 * @return String of Current Date in format yyyy (Thai)
	 */
	public static String getYearTH() throws Exception {
		return getYear(new java.util.Date(), new Locale("th", "TH"));
	}

	public static String getDay(Date date, Locale locale) throws Exception {
		SimpleDateFormat simpledateformat = new SimpleDateFormat("dd", locale);
		return simpledateformat.format(date);
	}

	public static String getMonth(Date date, Locale locale) throws Exception {
		SimpleDateFormat simpledateformat = new SimpleDateFormat("MM", locale);
		return simpledateformat.format(date);
	}

	public static String getYear(Date date, Locale locale) throws Exception {
		SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy", locale);
		return simpledateformat.format(date);
	}

	public static Date getStringToDate(String strDate) {
		Date brithDate = null;
		String dateFormat = "dd/MM/yyyy";
		if (strDate != null) {
			try {
				brithDate = new SimpleDateFormat(dateFormat).parse(strDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(strDate + "\t" + brithDate);

		}
		return brithDate;
	}

	/**
	 * @param strDate      in format dd/mm/yyyy (Thai Year) or yyyy/mm/dd (Eng Year)
	 * @param strFromLang  - Language of strDate (�� TH ���� EN)
	 * @param strToLang    - Transform to Language (�� TH ���� EN)
	 * @param strDelimeter - ��Ǥ�� (�� /) ����Ѻ strDate
	 * @return String of ThaiDate that added (numDays, numMonths, numYears)
	 */
	public static String getYear(String strDate, String strFromLang, String strToLang, String strDelimeter)
			throws Exception {
		String strReturn = "";
		if (strDate != null && strDate.length() > 0) {
			String[] strs = strDate.split(strDelimeter);
			if (strFromLang.equalsIgnoreCase("TH")) {
				strReturn = strs[2];
				if (strToLang.equalsIgnoreCase("EN"))
					strReturn = (Integer.parseInt(strReturn) - 543) + "";
			} // if
			if (strFromLang.equalsIgnoreCase("EN")) {
				strReturn = strs[0];
				if (strToLang.equalsIgnoreCase("TH"))
					strReturn = (Integer.parseInt(strReturn) + 543) + "";
			} // if
		} // if
		return strReturn;
	}

	public static String getOptionMonthEN(String strSelectedData) {
		return getOptionMonth(strSelectedData, "EN");
	}// fn

	public static String getOptionMonthTH(String strSelectedData) {
		return com.pattana.utils.ThaiUtilities.ASCII2Unicode(getOptionMonth(strSelectedData, "TH"));
	}// fn

	public static String getOptionMonth(String strSelectedData, String strLANG) {
		StringBuffer temp = new StringBuffer();
		int nSelectedData = 0;
		if (strSelectedData != null && strSelectedData.length() > 0)
			nSelectedData = Integer.parseInt(strSelectedData);
		if (strLANG.equals("TH")) {
			for (int i = 0; i < LONG_MONTHNAMES_TH.length; i++) {
				temp.append("<option value=\"" + (i + 1) + "\"" + ((nSelectedData == i + 1) ? " selected" : "") + ">"
						+ LONG_MONTHNAMES_TH[i] + "</option>");
			} // for
		} // if
		if (strLANG.equals("EN")) {
			for (int i = 0; i < LONG_MONTHNAMES_EN.length; i++) {
				temp.append("<option value=\"" + (i + 1) + "\"" + ((nSelectedData == i + 1) ? " selected" : "") + ">"
						+ LONG_MONTHNAMES_EN[i] + "</option>");
			} // for
		} // if
		return temp.toString();
	}// fn

	/**
	 * @param strThaiDate in format dd/mm/yyyy (Thai Year)
	 * @param numDays     a number of Day
	 * @param numMonths   a number of Month
	 * @param numYears    a number of Year
	 * @return String of ThaiDate that added (numDays, numMonths, numYears)
	 */
	public static String ThaiDateAdd(String strThaiDate, int numDays, int numMonths, int numYears) {
		String[] strs = strThaiDate.split("/");
		Calendar cal = new GregorianCalendar(Integer.parseInt(strs[2]) - 543, Integer.parseInt(strs[1]) - 1,
				Integer.parseInt(strs[0]));
		cal.add(Calendar.DATE, numDays);
		cal.add(Calendar.MONTH, numMonths);
		cal.add(Calendar.YEAR, numYears);
		return (cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + (cal.get(Calendar.YEAR) + 543));
	}// fn

	/**
	 * @param strEngDate in format yyyy-mm-dd (End Year)
	 * @param numDays    a number of Day
	 * @param numMonths  a number of Month
	 * @param numYears   a number of Year
	 * @return String of EndDate that added (numDays, numMonths, numYears)
	 */
	public static String EngDateAdd(String strEngDate, int numDays, int numMonths, int numYears) {
		String[] strs = strEngDate.split("-");
		Calendar cal = new GregorianCalendar(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]) - 1,
				Integer.parseInt(strs[2]));
		cal.add(Calendar.DATE, numDays);
		cal.add(Calendar.MONTH, numMonths);
		cal.add(Calendar.YEAR, numYears);
		return (cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DATE));
	}// fn

	/**
	 * get result from static int DATEDIFF, MONTHDIFF, YEARDIFF
	 * 
	 * @param strEngDate1 in format yyyy-MM-dd (Eng Year)
	 * @param strEngDate2 in format yyyy-MM-dd (Eng Year)
	 */
	public static void doEngDateDiff(String strEngDate1, String strEngDate2) throws Exception {
		if (strEngDate1 == null || strEngDate2 == null || strEngDate1.length() == 0 || strEngDate2.length() == 0) {
			DATEDIFF = 0;
			MONTHDIFF = 0;
			YEARDIFF = 0;
			return;
		} // if

		int dfy = 0, dfm = 0, dfd = 0;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
		SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
		strEngDate1 = simpledateformat.format(df.parse(strEngDate1));
		strEngDate2 = simpledateformat.format(df.parse(strEngDate2));

		dfm = EngDateDiff(strEngDate1, strEngDate2, MONTH);
		if (dfm > 0) {
			dfd = EngDateDiff(EngDateAdd(strEngDate1, 0, dfm, 0), strEngDate2, DATE);
			if (dfd < 0 && dfm > 1) {
				dfm = dfm - 1;
				dfd = EngDateDiff(EngDateAdd(strEngDate1, 0, dfm, 0), strEngDate2, DATE);
			} // if
			if (dfd < 0 && dfm == 1) {
				dfd = EngDateDiff(strEngDate1, strEngDate2, DATE);
				dfm = 0;
			} // if
		} else {
			dfd = EngDateDiff(strEngDate1, strEngDate2, DATE);
		}

		if (dfm >= 12) {
			dfy = dfm / 12;
			dfm = dfm % 12;
		} // if

		DATEDIFF = dfd;
		MONTHDIFF = dfm;
		YEARDIFF = dfy;
		return;
	}// fn

	/**
	 * get result from static int DATEDIFF, MONTHDIFF, YEARDIFF
	 * 
	 * @param strThaiDate1 in format dd/mm/yyyy (Thai Year)
	 * @param strThaiDate2 in format dd/mm/yyyy (Thai Year)
	 */
	public static void doThaiDateDiff(String strThaiDate1, String strThaiDate2) throws Exception {
		doEngDateDiff(getStrEngDate(strThaiDate1), getStrEngDate(strThaiDate2));
	}// fn

	/**
	 * @param strEngDate1 in format yyyy-MM-dd (Eng Year)
	 * @param strEngDate2 in format yyyy-MM-dd (Eng Year)
	 * @return String number of difference of year, month, year (1 �� 2 ��͹ 3 �ѹ)
	 */
	public static String EngDateDiff(String strEngDate1, String strEngDate2) throws Exception {
		String strTmp = "";
		int dfy = 0, dfm = 0, dfd = 0;
		dfm = EngDateDiff(strEngDate1, strEngDate2, MONTH);
		if (dfm > 0) {
			dfd = EngDateDiff(EngDateAdd(strEngDate1, 0, dfm, 0), strEngDate2, DATE);
			if (dfd < 0 && dfm > 1) {
				dfm = dfm - 1;
				dfd = EngDateDiff(EngDateAdd(strEngDate1, 0, dfm, 0), strEngDate2, DATE);
			} // if
			if (dfd < 0 && dfm == 1) {
				dfd = EngDateDiff(strEngDate1, strEngDate2, DATE);
				dfm = 0;
			} // if
		} else {
			dfd = EngDateDiff(strEngDate1, strEngDate2, DATE);
		}
		if (dfm >= 12) {
			dfy = dfm / 12;
			dfm = dfm % 12;
			strTmp = Integer.toString(dfy) + " �� ";
		} // if
		if (dfm > 0)
			strTmp += Integer.toString(dfm) + " ��͹ ";
		if (dfd > 0)
			strTmp += Integer.toString(dfd) + " �ѹ ";

		return ThaiUtilities.ASCII2Unicode(strTmp);
	}// fn

	/**
	 * @param strThaiDate1 in format dd/mm/yyyy (Thai Year)
	 * @param strThaiDate2 in format dd/mm/yyyy (Thai Year)
	 * @return String number of difference of year, month, year (1 �� 2 ��͹ 3 �ѹ)
	 */
	public static String ThaiDateDiff(String strThaiDate1, String strThaiDate2) throws Exception {
		return EngDateDiff(getStrEngDate(strThaiDate1), getStrEngDate(strThaiDate2));
	}// fn

	/**
	 * @param strThaiDate1 in format dd/mm/yyyy (Thai Year)
	 * @param strThaiDate2 in format dd/mm/yyyy (Thai Year)
	 * @return int of differenct date
	 */
	public static int ThaiDateDiff(String strThaiDate1, String strThaiDate2, int timefield) throws Exception {
		String[] strs = strThaiDate1.split("/");
		strThaiDate1 = (Integer.parseInt(strs[2]) - 543) + "-" + (Integer.parseInt(strs[1]) - 1) + "-" + strs[0];
		strs = strThaiDate2.split("/");
		strThaiDate2 = (Integer.parseInt(strs[2]) - 543) + "-" + (Integer.parseInt(strs[1]) - 1) + "-" + strs[0];
		return getDateDiff(strThaiDate1, strThaiDate2, timefield);
	}// fn

	/**
	 * @param strEngDate1 in format yyyy-MM-dd (Eng Year)
	 * @param strEngDate2 in format yyyy-MM-dd (Eng Year)
	 * @return int number of difference of date
	 */
	public static int EngDateDiff(String strEngDate1, String strEngDate2, int timefield) throws Exception {
		return getDateDiff(strEngDate1, strEngDate2, timefield);
	}// fn

	/*
	 * @param String strDate1 format 2002-10-25
	 * 
	 * @param String strDate2 format 2002-10-25
	 * 
	 * @return int number of difference of date
	 */
	public static int getDateDiff(String strDate1, String strDate2, int timefield) throws Exception {
		if (strDate1 == null || strDate1.equals("") || strDate2 == null || strDate2.equals(""))
			return 0;

		int nDiff = 0;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
		Date date1 = df.parse(strDate1);
		Date date2 = df.parse(strDate2);
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();

		// different date might have different offset
		cal1.setTime(date1);
		long ldate1 = date1.getTime() + cal1.get(Calendar.ZONE_OFFSET) + cal1.get(Calendar.DST_OFFSET);
		cal2.setTime(date2);
		long ldate2 = date2.getTime() + cal2.get(Calendar.ZONE_OFFSET) + cal2.get(Calendar.DST_OFFSET);
		// Use integer calculation, truncate the decimals
		int hr1 = (int) (ldate1 / 3600000); // 60*60*1000
		int hr2 = (int) (ldate2 / 3600000);
		int days1 = (int) hr1 / 24;
		int days2 = (int) hr2 / 24;
		int dateDiff = days2 - days1;
		int weekOffset = (cal2.get(Calendar.DAY_OF_WEEK) - cal1.get(Calendar.DAY_OF_WEEK)) < 0 ? 1 : 0;
		int weekDiff = dateDiff / 7 + weekOffset;
		int yearDiff = cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR);
		int monthDiff = yearDiff * 12 + cal2.get(Calendar.MONTH) - cal1.get(Calendar.MONTH);
		switch (timefield) {
		case DATE:
			nDiff = dateDiff;
			break;
		case WEEK:
			nDiff = weekDiff;
			break;
		case MONTH:
			nDiff = monthDiff;
			break;
		case YEAR:
			nDiff = yearDiff;
			break;
		}// switch
		return nDiff;
	}// getDateDiff

	/**
	 * @param strThaiDate in format dd/MM/yyyy (Thai Year)
	 * @return String of Date in format yyyy-MM-dd (Eng Year)
	 */
	public static String getStrEngDate(String strThaiDate) throws Exception {
		if (strThaiDate == null)
			return strThaiDate;
		if (strThaiDate.length() == 0)
			return "";
		String[] strAD = strThaiDate.split("/");
		return ((Integer.parseInt(strAD[2]) - 543) + "-" + strAD[1] + "-" + strAD[0]);
	}//

	/**
	 * @param strEngDate in format yyyy-MM-dd (Eng Year)
	 * @return String of Date in format yyyy-MM-dd (Eng Year)
	 */
	public static String getLastDayOfMonth(String strEngDate) {
		if (strEngDate == null || strEngDate.length() == 0)
			return "";
		String[] strAD = strEngDate.split("-");
		String strT = Integer.toString(getNumOfDaysInMonth(Integer.parseInt(strAD[1]), Integer.parseInt(strAD[0])));
		if (strT.length() == 1)
			strT = "0" + strT;
		return (strAD[0] + "-" + strAD[1] + "-" + strT);
	}// fn

	/**
	 * @param strEngDate in format yyyy-MM-dd (Eng Year)
	 * @return String of Date in format yyyy-MM-dd (Eng Year)
	 */
	public static String getFirstDayOfMonth(String strEngDate) {
		if (strEngDate == null || strEngDate.length() == 0)
			return "";
		String[] strAD = strEngDate.split("-");
		return (strAD[0] + "-" + strAD[1] + "-01");
	}// fn

	/**
	 * @param nDay
	 * @param nMonth
	 * @param nYear
	 * @return int of DAY_OF_WEEK (SUNDAY=1, SATURDAY=7)
	 */
	public static int getDayOfWeek(int nDay, int nMonth, int nYear) {
		Calendar cal = new GregorianCalendar(nYear, nMonth - 1, nDay);
		return cal.get(Calendar.DAY_OF_WEEK);
	}// fn

	/**
	 * get number of day in month
	 * 
	 * @param nMonth
	 * @param nYear
	 * @return int of Number of Day in month
	 */
	public static int getNumOfDaysInMonth(int nMonth, int nYear) {
		int nRetVal = 0;
		if (nMonth == 1 || nMonth == 3 || nMonth == 5 || nMonth == 7 || nMonth == 8 || nMonth == 10 || nMonth == 12)
			nRetVal = 31;
		if (nMonth == 4 || nMonth == 6 || nMonth == 9 || nMonth == 11)
			nRetVal = 30;
		if (nMonth == 2)
			if (isLeapYear(nYear))
				nRetVal = 29;
			else
				nRetVal = 28;
		return nRetVal;
	}//

	/**
	 * @param nYear
	 * @return boolean if isLeapYear return true
	 */
	public static boolean isLeapYear(int nYear) {
		if ((nYear % 400 == 0) || ((nYear % 4 == 0) && (nYear % 100 != 0)))
			return true;
		return false;
	}// fn

}//

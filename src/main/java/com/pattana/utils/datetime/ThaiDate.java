package com.pattana.utils.datetime;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * ThaiDate(Thai Year)
 * <pre>Change Format
 *  yyyy-MM-dd   -->   dd/MM/yyy
 *  yyyy-MM-dd HH:mm:ss   -->   dd/MM/yyyy, HH:mm:ss</pre>
 * @author Maitree Sanpakitwattana
 * @version 1.0
 */
public class ThaiDate {
        public static final String THAISHORT="dd/MM/yyyy";
        public static final String THAISHORT_TIME="dd/MM/yyyy, HH:mm:ss";

        
        /**
         * @param date a java.util.Date
         * @return String of Date in format dd/MM/yyyy (Thai Year)
         */
    public static String getStrThaiDate(Date date) throws Exception {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));
        return simpledateformat.format(date);
    }
    
        /**
         * @return String of Current Date in format dd/MM/yyyy (Thai Year)
         */
        public static String getStrThaiDate() throws Exception {
                return getStrThaiDate(new java.util.Date());
        }
        
        /**
         * @return String of Current Date in format yyyy-MM-dd
         */
        public static String getStrDate() {
        	String strDate=null;
        	try{
        		strDate= getStrDate(new java.util.Date());
        	}catch(Exception e){
        		e.printStackTrace(System.out);
        	}
        	return strDate;
        }

        /**
         * @return String of Current Date in format yyyy-MM-dd HH:mm:ss
         */
        public static String getStrDateTime() throws Exception {
                return getStrDateTime(new java.util.Date());
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
        public static String getDateTime(String strDateTime, String strFormat) throws Exception {
                String strReturn="";
                if(strDateTime!=null && !strDateTime.equals("")){
                        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                        SimpleDateFormat simpledateformat = new SimpleDateFormat(strFormat, new Locale("th", "TH"));
                strReturn = simpledateformat.format(df.parse(strDateTime));
                }else{
                        strReturn = strDateTime;
                }
                return strReturn;
    }//end method getDateTime()

        public static String getDateTime(String strDateTime) throws Exception{
                return getDateTime(strDateTime,THAISHORT_TIME);
        }

        public static String getDate(String strDateTime, String strFormat) throws Exception {
                String strReturn="";
                if(strDateTime!=null && !strDateTime.equals("")){
                        DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                        SimpleDateFormat simpledateformat = new SimpleDateFormat(strFormat, new Locale("th", "TH"));
                strReturn = simpledateformat.format(df.parse(strDateTime));
                }else{
                        strReturn = strDateTime;
                }
                return strReturn;
    }//end method getDate

        public static String getDate(String strDateTime){
        	String strValueDate=null;
        	try{
        		strValueDate= getDate(strDateTime,THAISHORT);
                
        	}catch(Exception e){
        		e.printStackTrace(System.out);
        	}
        	return strValueDate;
        }


        /*Thai Date Difference
         *Author by Maitree
         *Create at 11/4/2002
         *Parameter String strStartDate format 2002-10-25
         *Parameter String strFinishDate format 2002-10-25
         *Return as Integer in number of difference of date
         */
        public static int getDateDiff(String strStartDate, String strFinishDate) throws Exception {
                if(strStartDate==null || strStartDate.equals("") || strFinishDate==null || strFinishDate.equals("")){
                        return 0;
                }//
                int nDiff=0;
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                Date dStart = df.parse(strStartDate);
                Date dFinish = df.parse(strFinishDate);
                //long nlDiff = ;
                nDiff = (int)((dFinish.getTime() - dStart.getTime())/(1000*60*60*24));

                return nDiff;
    }//end method getDate


}//end class

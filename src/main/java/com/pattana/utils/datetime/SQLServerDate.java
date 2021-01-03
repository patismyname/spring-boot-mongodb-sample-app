package com.pattana.utils.datetime;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * <pre>
 * SQLServerDate - Get Date, DateTime in format for SQL Server
 * DateTime = yyyy-MM-dd HH:mm:ss
 * Date = yyyy-MM-dd
 * <b>Example for use : </b>
 *	SQLServerDate.getStrDate();
 *	SQLServerDate.getStrDateTime();
 * </pre>
 * @author Maitree Sanpakitwattana
 * @version 1.0
 */
public class SQLServerDate {

        /**
         * @return String of Current Date in format yyyy-MM-dd
         */
        public static String getStrDate() throws Exception {
                return getStrDate(new java.util.Date());
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

        /**
         * @param strThaiDate in format dd/MM/yyyy (Thai Year)
         * @return String of Date in format yyyy-MM-dd (Eng Year)
         * 
         */
    public static String getStrDate(String strThaiDate) throws Exception {
                if(strThaiDate == null)
                        return strThaiDate;
                if(strThaiDate.length() == 0)
                        return "";
        /*String[] strAD = strThaiDate.split("/");
        return ((Integer.parseInt(strAD[2])-543)+"-"+strAD[1]+"-"+strAD[0]);
                */
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));
                SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                return simpledateformat.format(df.parse(strThaiDate));
    }

        /**
         * @param strThaiDateTime in format dd/MM/yyyy HH:mm:ss (Thai) or yyyy-MM-dd HH:mm:ss (Eng)
         * @return String of Time in format HH:mm
         */
        public static String getStrTime(String strThaiDateTime) throws Exception {
                String strReturn="";
                if(strThaiDateTime.indexOf("/") != -1){	// delimeter is /
                        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", new Locale("th", "TH"));
                        SimpleDateFormat simpledateformat = new SimpleDateFormat("HH:mm", Locale.ENGLISH);
                strReturn = simpledateformat.format(df.parse(strThaiDateTime));
                }//if
                if(strThaiDateTime.indexOf("-") != -1){	// delimeter is -
                        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
                        SimpleDateFormat simpledateformat = new SimpleDateFormat("HH:mm", Locale.ENGLISH);
                strReturn = simpledateformat.format(df.parse(strThaiDateTime));
                }//if
                return strReturn;
    }

        /**
         * @param strThaiDateTime in format dd/MM/yyyy HH:mm:ss (Thai Year)
         * @return String of Date in format yyyy-MM-dd HH:mm:ss (Eng Year)
         */
        public static String getStrDateTime(String strThaiDateTime) throws Exception {
                String strReturn="";
                if(strThaiDateTime!=null && !strThaiDateTime.equals("")){
                        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", new Locale("th", "TH"));
                        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
                strReturn = simpledateformat.format(df.parse(strThaiDateTime));
                }else{
                        strReturn = strThaiDateTime;
                }
                return strReturn;
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
         * @return String of Date in format  dd/MM/yyyy (Thai Year)
         */
        public static String getStrThaiDate(String strEngDate) throws Exception{
                return ThaiDate.getDate(strEngDate);
        }

        /**
         * @param strEngDateTime in format of MS SQL Server
         * @return String of Date in format  dd/MM/yyyy, HH:mm:ss (Thai Year)
         */
        public static String getStrThaiDateTime(String strEngDateTime) throws Exception{
                return ThaiDate.getDateTime(strEngDateTime);
        }
}

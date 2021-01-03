/**
 * 
 */
package com.pattana.utils.datetime;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MySQLdateEN {

    public static String getStrDateTime(Date date) throws Exception {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        return simpledateformat.format(date);
    }
    public static String getStrDateTime()throws Exception {    	
        	 return getStrDateTime(new Date());
    }
    public static String getStrDate(Date date) throws Exception {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        return simpledateformat.format(date);
    }
    public static String getStrDate() throws Exception {
    	return getStrDate(new Date());
    }
    
    /**
     * @param strEngDateTime in format of MS SQL Server
     * @return String of Date in format  dd/MM/yyyy, HH:mm:ss (Thai Year)
     */
    public static String getStrThaiDateTime(String strEngDateTime) throws Exception{
            return ThaiDate.getDateTime(strEngDateTime);
    }
    
    public static String getStrDate(String strThaiDate) {
        if(strThaiDate == null)
                return strThaiDate;
        if(strThaiDate.length() == 0)
                return "";        
        String[] strThaiDates = sPlitString(strThaiDate,"/");        
        strThaiDate=(Integer.parseInt(strThaiDates[2])-543)+"-"+strThaiDates[1]+"-"+strThaiDates[0];
        return strThaiDate;
}

    
	public static String[] sPlitString (String str, String dim) 
	{	
		int arrlength = 0;
		int start = 0, end = 0;
		int i=0;

		for( i=0; i< str.length(); i++){
			if(i+dim.length() > str.length()) 	
					end = str.length();
			else	
					end = i+dim.length();
			if(str.substring(i, end).equals(dim)){
				arrlength++;
				i = end -1 ;
			}
		}

		String [] toks = new String[arrlength+1];
		arrlength = 0;
		for(i=0; i< str.length(); i++){
			if(i+dim.length() > str.length()) 	
					end = str.length();
			else	
					end = i+dim.length();
			if(str.substring(i, end).equals(dim)){
				toks[arrlength++] = str.substring(start, end - dim.length());
				start = i + dim.length() ;
				i = end -1 ;
			}
		}
		toks[arrlength++] = str.substring(start, str.length());							
//		for(i=0; i< toks.length; i++)
//			out.print(toks[i] + "<br>");
		return toks;
		}		
    
    
    public static void main(String args[]){
    	try{
    		//getStrDateTime()==>2011-02-17 16:15:18
    	System.out.println("getStrDateTime()==>"+getStrDateTime());
    	}catch(Exception e){
    		
    	}
    }
}

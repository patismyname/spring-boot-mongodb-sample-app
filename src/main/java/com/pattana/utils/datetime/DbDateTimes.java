/**
 * 
 */
package com.pattana.utils.datetime;



/**
 * @author Administrator
 *
 */
public class DbDateTimes {

	public static String strDbType="sqlserver";
	
	/**
	 * 
	 */
	public DbDateTimes() {
		// TODO Auto-generated constructor stub
		//strDbType="";
	}
	 /**
	 * @return the strDbType
	 */
	public static String getStrDbType() {
		return strDbType;
	}
	/**
	 * @param strDbType the strDbType to set
	 */
	public static void setStrDbType(String strDbType) {
		DbDateTimes.strDbType = strDbType;
	}
	public static String getStrDateTime() throws Exception {
		 String strDateTime=null;
		 System.out.println("DbDateTimes.java getStrDateTime()#strDbType=>"+strDbType);
		 if(strDbType.equalsIgnoreCase("sqlserver")){
			 strDateTime= SQLServerDate.getStrDateTime();
		 }
		 if(strDbType.equalsIgnoreCase("mysql")){
			 strDateTime=MySQLdateEN.getStrDateTime();
		 }
		  
		 return strDateTime;
	 }
	


    /**
     * @param strEngDateTime in format of MS SQL Server
     * @return String of Date in format  dd/MM/yyyy, HH:mm:ss (Thai Year)
     */
    public static String getStrThaiDateTime(String strEngDateTime) throws Exception{
    	 String strThaiDateTime=null;
		 if(strDbType.equalsIgnoreCase("sqlserver")){
			 strThaiDateTime= SQLServerDate.getStrThaiDateTime(strEngDateTime);
		 }
		 if(strDbType.equalsIgnoreCase("mysql")){
			 strThaiDateTime=MySQLdateEN.getStrThaiDateTime(strEngDateTime);
		 }
		  
		 return strThaiDateTime;
            
    }
	
}

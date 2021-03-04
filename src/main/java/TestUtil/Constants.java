package TestUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Constants {

//	public static final String BASEURL = "http://213.133.139.190/BNS-SOP/";
//	public static final String BASEURL = "http://172.16.2.71:9194/#/";
	public static final String BASEURL = "http://10.0.0.44:9192/#/"; //version 2.0

	public static final String CustomerName ="Tushar Patel";
	public static final String CustomerAddress="kunj vila society laxmipura ,Baroda";
	public static final String County="India";
	public static final String CustomerAccountNumber="Test_reg-2021";
	public static final String City="Vadodara";
	public static final String PostCode="388350";
	public static final String ContactPersonName="Depika Parekh";
	public static final String ContactPersonNumber="8989898989";
	public static final String FaxNumber="363636";
	public static final String Email="Tusharpatel@luxshtech.com";


	public static final String USERNAME = "E123456";
	public static final String PASSWORD = "112245998";

	public static final String ADMINUSERNAME = "Emp10"; //"Emp39"; //Emp188
	public static final String AGENTUSERNAME = "Emp11"; //"Emp41"; //Emp190
	public static final String MANAGERUSERNAME = "Emp13"; //"Emp40"; //Emp189
	public static final String DEPARTMENTALUSERNAME = "Emp18"; //"Emp42";
	public static final String VALIDPASSWORD = "123456";

	public static final String INVALIDUSERNAME = "!@$~&";
	public static final String INVALIDPASSWORD = "!@$~&";

	public static final String EMPTYDATA = "";

	public static final String PROJECTPATH = "D:\\A_Parth\\Automation Practice\\HPAT\\CxHelpDesk";

	public static final String FILEUPLOADPATH = PROJECTPATH + "\\src\\main\\java\\helper\\testingPurpose\\Test PNG-1.png";
	public static final String UPDATEDFILEUPLOADPATH = PROJECTPATH + "\\src\\main\\java\\helper\\testingPurpose\\images.png";
	
	public static final Date date = new Date();

	public static SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
	public static String strDate = formatter.format(date);
	
//	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
//	String strDate = formatter.format(date);  
//	System.out.println("Date Format with MM/dd/yyyy : "+strDate);  

//	formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
//	strDate = formatter.format(date);
//	System.out.println("Date Format with dd-M-yyyy hh:mm:ss : "+strDate);

//	formatter = new SimpleDateFormat("dd MMMM yyyy");  
//	strDate = formatter.format(date);  
//	System.out.println("Date Format with dd MMMM yyyy : "+strDate);  
//
//	formatter = new SimpleDateFormat("dd MMMM yyyy zzzz");  
//	strDate = formatter.format(date);  
//	System.out.println("Date Format with dd MMMM yyyy zzzz : "+strDate);  
//
//	formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");  
//	strDate = formatter.format(date);  
//	System.out.println("Date Format with E, dd MMM yyyy HH:mm:ss z : "+strDate);  

}

package com.inetbanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
  Properties pro;
  
  public ReadConfig()
  {
  File src=new File("./Configuration/config.properties");
  try
   {
	  FileInputStream fs= new FileInputStream(src); 
	   
	   pro=new Properties();
	   pro.load(fs);
   }
  catch (Exception e)
   {
	   System.out.println("The Error is "+e.getMessage());
   }
   
  }

   public String getUrl()
   {
	   String url=pro.getProperty("url");
	   return url;
   }
   
   public String getUserId()
   {
	 String UserId=pro.getProperty("UserId");
     return UserId;
   }
   
   public String getPassword()
   {
	 String Password=pro.getProperty("Password");
	 return Password;
   }
   
   public String setChromepath()
   {
	   String Chromepath=pro.getProperty("Chromepath");
	   return Chromepath;
	   
   }
   
   public String setEdgepath()
   {
	  String Edgepath=pro.getProperty("Edgepath");
	  return Edgepath;
   }
}

package com.utils;

import java.io.FileOutputStream;
import java.util.Properties;

public class WritePropertiesFiles {

	Properties prop=new Properties();
	
	 public WritePropertiesFiles(String key,String value, String path)
	 {
	 
	 try
	 {
	 prop.setProperty(key, value);
	 
	 prop.store(new FileOutputStream(path), "Writing to Property File");
	 System.out.println("File created");
	 }
	 
	 catch(Exception e)
	 {
	 e.getMessage();
	 }
	 }
	
	 
	 

}

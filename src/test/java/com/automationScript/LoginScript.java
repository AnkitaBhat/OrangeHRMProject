package com.automationScript;


import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.ExcelUtility;



public class LoginScript extends BaseClass{
	
	@DataProvider(name="testdata") 
	public Object[][] TestDataFeed(){
		final  String pathSeparator = File.separator;

		final  String filename="Test2.xls";
		final  String path=System.getProperty("user.dir")+pathSeparator+"src"+pathSeparator+"main"+pathSeparator+"resources"+pathSeparator+filename;
		 ExcelUtility reader = new ExcelUtility(path);
		final String USERNAME1 = reader.getCellData("AdminSheet", "Username", 2);
		final String PASSWORD1 = reader.getCellData("AdminSheet", "Password", 2);
		final String USERNAME2 = reader.getCellData("AdminSheet", "Username", 3);
		final String PASSWORD2 = reader.getCellData("AdminSheet", "Password", 3);
	
  // Create object array with 2 rows and 2 column- first parameter is row and
  //second is 
 //column 
 Object [][] twitterdata=new Object[2][2];


  // Enter data to row 0 column 0 
	twitterdata[0][0]=USERNAME1; //Enter data to row 0 column 1
   twitterdata[0][1]=PASSWORD1; // Enter data to row 1 column 0
   twitterdata[1][0]=USERNAME2; // Enter data to row 1 column 0
   twitterdata[1][1]=PASSWORD2; // return arrayobject to testscript
  return twitterdata; }
	
	
	@Test(dataProvider = "testdata")
	public void loginTest(String username,String password) {
		userableToLogin(username,password);
	}
	
	

}

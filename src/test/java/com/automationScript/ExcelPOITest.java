package com.automationScript;

import java.io.File;

import com.utils.ExcelUtility;

public class ExcelPOITest {
	final static String pathSeparator = File.separator;

	final static String filename="Test2.xls";
	final static String path=System.getProperty("user.dir")+pathSeparator+"src"+pathSeparator+"main"+pathSeparator+"resources"+pathSeparator+filename;
	

		public static void main(String[] args) {
			ExcelUtility reader = new ExcelUtility(path);
			
			String cell = reader.getCellData("AdminSheet", "Username", 2);
			System.out.println(cell);

		
	}

}

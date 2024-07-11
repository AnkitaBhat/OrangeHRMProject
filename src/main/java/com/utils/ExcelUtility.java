 package com.utils;


 import java.io.File;
 import java.io.FileInputStream;


 import java.util.Iterator;

 import org.apache.poi.hssf.usermodel.HSSFSheet; 
 import org.apache.poi.hssf.usermodel.HSSFWorkbook; 
 import org.apache.poi.ss.usermodel.Cell; 
 import org.apache.poi.ss.usermodel.Row; 

 public class ExcelUtility {

 	public static void main(String[] args) {
 		try { 

 			String path="C:\\Users\\48739\\PageObjectModel\\POM\\AdminProject\\src\\main\\resources\\Test2.xls";
 			 // Reading file from local directory 
 			 FileInputStream file = new FileInputStream( 
 			 new File(path)); 

 			 // Create Workbook instance holding reference to 
 			 // .xlsx file 
 			 HSSFWorkbook wb=new HSSFWorkbook(file);   
 			//creating a Sheet object to retrieve the object  
 			HSSFSheet sheet=wb.getSheetAt(0);

 			 // Iterate through each rows one by one 
 			 Iterator<Row> rowIterator = sheet.iterator(); 

 			 // Till there is an element condition holds true 
 			 while (rowIterator.hasNext()) { 

 			 Row row = rowIterator.next(); 

 			 // For each row, iterate through all the 
 			 // columns 
 			 Iterator<Cell> cellIterator 
 			 = row.cellIterator(); 

 			 while (cellIterator.hasNext()) { 

 			 Cell cell = cellIterator.next(); 

 			 // Checking the cell type and format 
 			 // accordingly 
 			 switch (cell.getCellType()) {

 			 // Case 1 
 			 case Cell.CELL_TYPE_NUMERIC: 
 			 System.out.print( 
 			 cell.getNumericCellValue() 
 			 + "t"); 
 			 break; 

 			 // Case 2 
 			 case Cell.CELL_TYPE_STRING: 
 			 System.out.print( 
 			 cell.getStringCellValue() 
 			 + "t"); 
 			 break; 
 			 } 
 			 
 			 } 

 			 System.out.println(""); 
 			 } 
 		

 			 // Closing file output streams 
 			 file.close(); 
 			 } 

 			 // Catch block to handle exceptions 
 			 catch (Exception e) { 

 			 // Display the exception along with line number 
 			 // using printStackTrace() method 
 			 e.printStackTrace(); 
 			 } 
 			 } 
 			


 	
 }

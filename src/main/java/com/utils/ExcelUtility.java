 package com.utils;


 import java.io.FileInputStream;
 import java.io.FileOutputStream;
 import java.util.Calendar;

 import org.apache.poi.hssf.usermodel.HSSFCell;
 import org.apache.poi.hssf.usermodel.HSSFRow;
 import org.apache.poi.hssf.usermodel.HSSFSheet;
 import org.apache.poi.hssf.usermodel.HSSFWorkbook;
 import org.apache.poi.ss.usermodel.CellType;
 import org.apache.poi.ss.usermodel.DateUtil;

 public class ExcelUtility {
 	public String path;
 	public FileInputStream fis = null;
 	public FileOutputStream fileOut = null;
 	private HSSFWorkbook workbook = null;
 	private HSSFSheet sheet = null;
 	private HSSFRow row = null;
 	private HSSFCell cell = null;

 	public ExcelUtility(String path) {

 		this.path = path;
 		try {

 			fis = new FileInputStream(path);
 			workbook = new HSSFWorkbook(fis);
 			sheet = workbook.getSheetAt(0);
 			fis.close();
 		} catch (Exception e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 	}
 	
 	
 	public String getCellData(String sheetName, String colName, int rowNum) {
 		try {
 			if (rowNum <= 0)
 				return "";

 			int index = workbook.getSheetIndex(sheetName);
 			int col_Num = -1;
 			if (index == -1)
 				return "";

 			sheet = workbook.getSheetAt(index);
 			row = sheet.getRow(0);
 			for (int i = 0; i < row.getLastCellNum(); i++) {
 				// System.out.println(row.getCell(i).getStringCellValue().trim());
 				if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
 					col_Num = i;
 			}
 			if (col_Num == -1)
 				return "";

 			sheet = workbook.getSheetAt(index);
 			row = sheet.getRow(rowNum - 1);
 			if (row == null)
 				return "";
 			cell = row.getCell(col_Num);

 			if (cell == null)
 				return "";
 			// System.out.println(cell.getCellType());
 			if (cell.getCellType() == CellType.STRING)
 				return cell.getStringCellValue();
 			else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {

 				String cellText = String.valueOf(cell.getNumericCellValue());
 				if (DateUtil.isCellDateFormatted(cell)) {

 					// format in form of M/D/YY
 					double d = cell.getNumericCellValue();

 					Calendar cal = Calendar.getInstance();
 					cal.setTime(DateUtil.getJavaDate(d));
 					cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
 					cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + 1 + "/" + cellText;

 					// System.out.println(cellText);

 				}

 				return cellText;
 			} else if (cell.getCellType() == CellType.BLANK)
 				return "";
 			else
 				return String.valueOf(cell.getBooleanCellValue());

 		} catch (Exception e) {

 			e.printStackTrace();
 			return "row " + rowNum + " or column " + colName + " does not exist in xls";
 		}
 	}
 }


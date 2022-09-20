package CRM.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This method is used to fetch the data from excel This class is consisting all
 * common action on excel
 * 
 * @param excelpatha
 * @param sheetname
 * @param rownumber
 * @param cellnumber
 * @author BHARDWAJ
 *
 */

public class Excelutility {
	Workbook wb;

	

	public void intilaizeExcel(String excelPath) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream(excelPath);
		 wb = WorkbookFactory.create(file);
	}

	public String getDataFromExcel(String excelPath,String sheetName, int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream(excelPath);
		Workbook wb = WorkbookFactory.create(file);
		Sheet sheet = wb.getSheet(sheetName);
		String data = new DataFormatter().formatCellValue(sheet.getRow(row).getCell(cell));
		return data;
	}
	public String getDataFromExcel(String sheetName, String requiredKey) {
		Sheet sheet = wb.getSheet(sheetName);
		String value=null;
		for(int i=0; i<=sheet.getLastRowNum();i++) {
			String actualkey= sheet.getRow(i).getCell(0).getStringCellValue();
			if(actualkey.equalsIgnoreCase(requiredKey)) {
				value= sheet.getRow(i).getCell(1).getStringCellValue();
				break;
			}
		}
		return value;
		
	}
	public Map<String, String> getDataFromExcelInMap(String sheetName){
		Sheet sheet= wb.getSheet(sheetName);
		
		Map<String, String> map= new HashMap<>();
		DataFormatter df= new DataFormatter();
		for(int i=0;i<=sheet.getLastRowNum();i++) {
			map.put(df.formatCellValue(sheet.getRow(i).getCell(0)), df.formatCellValue(sheet.getRow(i).getCell(1)));
			
		}
		return map;
		
	}
	public List<Map<String, String>> getDataFromExcelInList(String sheetName) {
		Sheet sheet= wb.getSheet(sheetName);
		List<Map<String, String>> list= new ArrayList<>();
		DataFormatter df= new DataFormatter();
		for(int k=1; k<sheet.getRow(0).getLastCellNum();k++) {
			Map<String, String> map= new HashMap<>();
			for(int i=0;i<=sheet.getLastRowNum();i++) {
				map.put(df.formatCellValue(sheet.getRow(i).getCell(0)), df.formatCellValue(sheet.getRow(i).getCell(k)));
				
			}
			list.add(map);
		}
		return list;
		
	}
	public String getDataFromExcel(String sheetNmae,String requiredKey, String testCaseName) {
		Sheet sheet= wb.getSheet(sheetNmae);
		String value=null;
		
		for(int i=0;i<=sheet.getLastRowNum();i++) {
			String actualTestCaseName = sheet.getRow(i).getCell(0).getStringCellValue();
			if(actualTestCaseName.equalsIgnoreCase(testCaseName)) {
				for(int j=1;j<=sheet.getRow(i).getLastCellNum();j++) {
					String actualKey= sheet.getRow(i).getCell(j).getStringCellValue();
					if(actualKey.equalsIgnoreCase(actualKey)) {
						value= sheet.getRow(i+1).getCell(j).getStringCellValue();
						break;
					}
					break;
				}
				
			}
		}
		return value;
	}

	public void closeExcel() throws IOException {
		wb.close();
	}

	public void setDataInExcel(String sheetName, int row, int cell, String text) {
	Sheet sheet = wb.getSheet(sheetName);
	sheet.getRow(row).createCell(cell).setCellValue(text);
	}

	public void saveDataInToExcel(String outputPath) throws FileNotFoundException, IOException {
		wb.write(new FileOutputStream(outputPath));

}
	
	
	
	
}

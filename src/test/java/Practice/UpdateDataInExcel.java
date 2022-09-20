package Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class UpdateDataInExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream("src/test/resources/testdata.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sheet= wb.getSheet("COMMONDATA");
		Row row= sheet.createRow(2);
		Cell cell= row.createCell(3);
		cell.setCellValue("shubham");
		FileOutputStream fos= new FileOutputStream("src/test/resources/testdata.xlsx");
		wb.write(fos);
		System.out.println("Data updated");
		wb.close();	}

}

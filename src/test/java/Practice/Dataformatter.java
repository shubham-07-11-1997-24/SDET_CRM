package Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Dataformatter {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fisexcxel= new FileInputStream("src/test/resources/testdata.xlsx");
		Workbook wb=WorkbookFactory.create(fisexcxel);
		DataFormatter df= new DataFormatter();
		try {
			Sheet sheet= wb.getSheet("Sheet1");
			Cell cell= sheet.getRow(0).getCell(0);
			String data = df.formatCellValue(cell);
			System.out.println(data);
			
			
			
		}
		finally {
			wb.close();
	}

	
	}

}

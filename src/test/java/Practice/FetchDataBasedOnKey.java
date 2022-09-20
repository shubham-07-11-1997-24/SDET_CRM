package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataBasedOnKey {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream("src/test/resources/testdata.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sheet= wb.getSheet("COMMONDATA");
		DataFormatter df= new DataFormatter();
		String value= null;
		for(int i=0; i<sheet.getLastRowNum();i++) {
			String key= df.formatCellValue(sheet.getRow(i).getCell(0));
			if(key.equalsIgnoreCase("browser"));
				value = df.formatCellValue(sheet.getRow(i).getCell(1));
				break;
		}
		System.out.println(value);
		
	}

}

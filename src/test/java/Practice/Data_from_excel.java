package Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import CRM.generic.Excelutility;
import CRM.generic.IConstantPath;

public class Data_from_excel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		Excelutility Excel = new Excelutility();
		String username = Excel.getDataFromExcel("./src/test/resources/testdata.xlsx", "COMMONDATA", 2, 1);
		String password = Excel.getDataFromExcel("./src/test/resources/testdata.xlsx", "COMMONDATA", 3, 2);
		String url = Excel.getDataFromExcel("./src/test/resources/testdata.xlsx","COMMONDATA", 0, 1);
		String browser = Excel.getDataFromExcel("./src/test/resources/testdata.xlsx","COMMONDATA", 1, 1);
		System.out.println(username);
		System.out.println(password);
		System.out.println(url);
		System.out.println(browser);

	}
}

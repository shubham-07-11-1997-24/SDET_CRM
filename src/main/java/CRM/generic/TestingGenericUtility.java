package CRM.generic;

import java.io.IOException;

public class TestingGenericUtility {

	public static void main(String[] args) throws IOException {
		new Excelutility().intilaizeExcel(IConstantPath.EXCE_PATH);
		String data = new Excelutility().getDataFromExcel(IConstantPath.EXCE_PATH,"CAMPAIGN" , 1, 1);
		System.out.println(data);

		new FileUtility().initializePropertyFile(IConstantPath.PROPERTY_FILE_PATH);
		String browser = new FileUtility().getDataFromPropertyFile("browser");
		System.out.println(browser);

		int randomNumber = new JavaUtility().getRandomNumber(1000);
		System.out.println(randomNumber);
		
		long res = (long) new JavaUtility().convertToAnyDataType("10", DataType.LONG);
		System.out.println(res);

	}
	 }
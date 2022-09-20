package Practice;

import java.util.List;
import java.util.Map;


import CRM.generic.Excelutility;
import CRM.generic.IConstantPath;

public class FetchDataFromExcelThroughListMap {

	public static void main(String[] args) throws Throwable {
		Excelutility excelutility= new Excelutility();
		excelutility.intilaizeExcel(IConstantPath.EXCE_PATH);
		List<Map<String, String>>list=excelutility.getDataFromExcelInList("form");
		System.out.println(list.get(2).get("Firstname"));
		System.out.println(list.get(2).get("LastName"));
		System.out.println(list.get(2).get("Email"));
		System.out.println(list.get(2).get("PhoneNumber"));
		System.out.println(list.get(2).get("adress"));
		System.out.println(list.get(2).get("pincode"));
		System.out.println(list.get(2).get("country"));
		System.out.println(list.get(2).get("state"));


	}

}

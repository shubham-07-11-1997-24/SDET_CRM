package vtiger1;

import java.sql.SQLException;
import java.util.List;

import CRM.generic.DataBaseUtility;
import CRM.generic.IConstantPath;



public class FetechDataFromDatabase {

	public static void main(String[] args) throws SQLException {
		DataBaseUtility dbu= new DataBaseUtility();
		dbu.openDBConnection(IConstantPath.DB_URL, "root", "root");
		List<String> data = dbu.getDataFromdatabase("select * from sdet40;", "emp_name");
		List<String> data1 = dbu.getDataFromdatabase("select * from sdet40;", "emp_name");
		List<String> data2 = dbu.getDataFromdatabase("select * from sdet40;", "emp_name");
		dbu.modifyDataIntoDB("insert data sdet40 value(1007,'shubh',850706,'kolkata')");
		System.out.println(data);
		System.out.println(data1);
		System.out.println(data2);
		dbu.closeDB();
			
	}

}

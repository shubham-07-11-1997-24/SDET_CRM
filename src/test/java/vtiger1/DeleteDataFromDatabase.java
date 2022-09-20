package vtiger1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DeleteDataFromDatabase {

	public static void main(String[] args) throws SQLException {
		Driver driver = null;
		try {
			driver = new Driver();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Connection con = null;
		try {
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss", "root", "root");
			Statement stmt = con.createStatement();
			String query = "delete from sdet40 where emp_id=107";
			int res = stmt.executeUpdate(query);
			if (res != 0) {
				System.out.println("record deleted");
			}
		}

		finally {
			con.close();
		}


	}

}

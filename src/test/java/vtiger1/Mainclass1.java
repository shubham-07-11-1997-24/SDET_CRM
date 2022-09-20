package vtiger1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Mainclass1 {

	public static void main(String[] args) throws SQLException {
		Driver driver = new Driver();
		Connection con = null;
		try {
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss", "root", "root");
			Statement stmt = con.createStatement();
			String query = "insert into sdet40 values (107,'Dhoni',1234789,'Ranchi')";
			int res = stmt.executeUpdate(query);
			if (res != 0) {
				System.out.println("record inserted");
			}
		}

		finally {
			con.close();
		}

	}
}

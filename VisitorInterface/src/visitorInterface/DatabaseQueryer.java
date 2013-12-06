package visitorInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseQueryer {
		private static String hostName = "localhost";
		private static Integer portNumber = 3306;
		private static String userName = "root";
		private static String password = "12345678";

		public static ResultSet connectToAndQueryDatabase(String query) {
			Connection dbConn;
			try {
				dbConn = DriverManager.getConnection(
						"jdbc:mysql://" + hostName + ":" + portNumber + "/341?user=" + userName + "&password=" + password);
				Statement stmt = dbConn.createStatement();
				return stmt.executeQuery(query);
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("FUCK");
				return null;
			}
		}
}

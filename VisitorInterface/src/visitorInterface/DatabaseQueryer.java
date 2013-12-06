package visitorInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseQueryer {
		private static String hostName = "54.201.38.30";
		private static Integer portNumber = 3306;
		private static String userName = "admin";
		private static String password = "12345678";

		public static ResultSet connectToAndQueryDatabase(String query) throws SQLException {
			Connection dbConn;
			dbConn = DriverManager.getConnection(
					"jdbc:mysql://" + hostName + ":" + portNumber + "/databaseproject?user=" + userName + "&password=" + password);
			Statement stmt = dbConn.createStatement();
			return stmt.executeQuery(query);
		}
}

package visitorInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;

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
		
		public static void populateMenuButtonWithHabitatNames(ObservableList<MenuItem> list) {
			if (!list.isEmpty())
				list.clear();
			try {
				String query = "SELECT name FROM habitats";
				ResultSet habitatNames = DatabaseQueryer.connectToAndQueryDatabase(query);
				if (habitatNames == null) {
					return;
				}
				while (habitatNames.next()) {
					MenuItem item = new MenuItem(habitatNames.getString(1));
					list.add(item);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.err.println("Error reading from result set");
			}
		}
		
		public static void connectToAndUpdateDatabase(String statement) throws SQLException {
			Connection dbCon = DriverManager.getConnection(
					"jdbc:mysql://" + hostName + ":" + portNumber + "/databaseproject?user=" + userName + "&password=" + password);
			Statement stmt = dbCon.createStatement();
			stmt.executeUpdate(statement);
		}
}

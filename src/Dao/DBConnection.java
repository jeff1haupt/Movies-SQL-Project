package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

//import dao.DBConnection;

public class DBConnection {
	
	
	static Scanner scanner = new Scanner(System.in);

	private final static String URL = "jdbc:mysql://use0r7eloh1nhl52:LZ69FY5XiHT07lWtGy6z@bisto6yhwq3qietv0eon-mysql.services.clever-cloud.com:3306/bisto6yhwq3qietv0eon";
	private final static String USERNAME = "use0r7eloh1nhl52";
	private final static String PASSWORD = "LZ69FY5XiHT07lWtGy6z";
	private static Connection connection;
	private static DBConnection instance;
	
	private DBConnection(Connection connection) {
		DBConnection.connection = connection;
	}
	
	private static String getPassword() {
		System.out.println("Enter the database password: ");
		String userPassword = scanner.nextLine();
		return userPassword;
	}

	public static Connection getConnection() {
		if ( instance == null ) {
			try {
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				instance = new DBConnection(connection);
				System.out.println("Connection successful.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return DBConnection.connection;
	}
	
}

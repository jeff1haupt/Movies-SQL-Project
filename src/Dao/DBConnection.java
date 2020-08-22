package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

//import dao.DBConnection;

public class DBConnection {
	
	
	static Scanner scanner = new Scanner(System.in);

	private final static String URL = "jdbc:mysql://localhost:3306/movies";
	private final static String USERNAME = "root";
	private final static String PASSWORD = getPassword();
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

package hu.ak_akademia.shc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import hu.ak_akademia.shc.exceptions.ShcRuntimeException;

public class ConnectionFactory {

	public static Connection open() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "shc", "admin");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Unable to connect to database");
			throw new ShcRuntimeException("Could not establish connection to database", e);
		}
	}

}

package com.revature.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class ConnectionDebugger {
	private static ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
	public static void main(String[] args) throws SQLException {
		Connection conn = cf.getConnection();
		System.out.println("connected");
	}
}

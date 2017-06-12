package id.doublesinlove.TodoPlanner;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @file    	: SqliteConnnection.java
 * @author 		: Novia Ismi Nuqoyati
 * @date		: 8 Jun 2017
 */

public class SqliteConnnection {
	Connection conn=null;
	
	public static Connection dbConnector() throws Exception{
		Class.forName("org.sqlite.JDBC");
		Connection conn=DriverManager.getConnection("jdbc:sqlite:order.sqlite");
		return conn;
	}
}
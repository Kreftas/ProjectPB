package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletBase")
public class ServletBase extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Define database
	private static String databaseServerAddress = "vm23.cs.lth.se";
	private static String databaseUser = "pusp2101hbg"; // database login user
	private static String databasePassword = "789hg54s"; // database login password
	private static String database = "pusp2101hbg"; // the database to use, i.e. default schema
	
	// Define roles
	protected static final int INVALID = 0;
	protected static final int ADMIN = 1;
	protected static final int LEADER = 2;
	protected static final int USER = 3;

	protected Connection conn = null;

	// Establish connection and JDBC driver
	public ServletBase() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://" + databaseServerAddress + "/" + database, databaseUser,
					databasePassword);
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}

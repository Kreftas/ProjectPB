package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Servlets.ServletBase;

public class LoginDao extends ServletBase {
	private static final long serialVersionUID = 1L;

	public int loginRole(String userName, String password) {
		String sql = "select userName, password, role from Users where userName=? and password=?";

		String userNameDB = "";
		String passwordDB = "";
		String roleDB = "";

		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, userName);
			ps.setString(2, password);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					userNameDB = rs.getString("userName");
					passwordDB = rs.getString("password");
					roleDB = rs.getString("role");

					if (userName.equals(userNameDB) && password.equals(passwordDB)) {
						switch (roleDB) {
						case "admin":
							return ADMIN;
						case "leader":
							return LEADER;
						case "user":
							return USER;
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return INVALID;
	}
}

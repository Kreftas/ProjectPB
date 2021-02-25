package dao;



	


	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;
	import controller.ServletBase;

	public class Database extends servletBase {
		private static final long serialVersionUID = 1L;

		public boolean createProjectGroup(String projectName) {
			String sql = "INSERT INTO ProjectGroup (projectName) VALUES(?)";
			String sql1 = "SELECT COUNT(*) FROM ProjectGroup";
			try (PreparedStatement ps = conn.prepareStatement(sql1); ResultSet RS = ps.executeQuery()) {
				if (RS.next()) {
					return false;
				}
				conn.setAutoCommit(false);
				PreparedStatement ps1 = conn.prepareStatement(sql);
				ps1.setString(1, projectName);
				conn.commit();
				return true;
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					conn.setAutoCommit(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return false;
		}

		public boolean deleteProjectGroup(String projectName) {

			String sql = "DELETE FROM ProjectGroup WHERE projectName = ?";

			try (PreparedStatement ps = conn.prepareStatement(sql)) {
				conn.setAutoCommit(false);
				ps.setString(1, projectName);
				try (ResultSet rs = ps.executeQuery()) {
					if (rs.next()) {
						return true;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					conn.setAutoCommit(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return false;
		}

		public boolean changeNameGroup(String newName) {
			String sql = "UPDATE ProjectGroup SET projectName = ? LIMIT 1";

			try (PreparedStatement ps = conn.prepareStatement(sql)) {
				conn.setAutoCommit(false);
				ps.setString(1, newName);
				try (ResultSet rs = ps.executeQuery()) {
					if (rs.next()) {
						return true;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					conn.setAutoCommit(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return false;
		}

		public boolean removeUserFromGroup(String userToBeRemoved) {
			String sql = "DELETE FROM Users WHERE userName = ?";

			try (PreparedStatement ps = conn.prepareStatement(sql)) {
				conn.setAutoCommit(false);
				ps.setString(1, userToBeRemoved);
				try (ResultSet rs = ps.executeQuery()) {
					if (rs.next()) {
						return true;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					conn.setAutoCommit(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return false;
		}

		public boolean assignUserToGroup(String userToBeAssigned) {
			String sql = "UPDATE Users SET inProject = 1 WHERE userName = ?";

			try (PreparedStatement ps = conn.prepareStatement(sql)) {
				conn.setAutoCommit(false);
				ps.setString(1, userToBeAssigned);
				try (ResultSet rs = ps.executeQuery()) {
					if (rs.next()) {
						return true;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					conn.setAutoCommit(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return false;
		}

		public List<UserBean> getGroupMembers() {

			return new ArrayList<UserBean>();
		}
	}

}

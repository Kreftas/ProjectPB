package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends ServletBase {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		HttpSession session = request.getSession(true);

		Dao.LoginDao loginDB = new Dao.LoginDao();

		int state;

		try {
			int roleID = loginDB.loginRole(userName, password);

			switch (roleID) {
			case ADMIN:
				session.setAttribute("role", roleID);
				session.setAttribute("userName", userName);
				request.getRequestDispatcher("AdminPage.jsp").forward(request, response);
			case LEADER:
				session.setAttribute("role", roleID);
				session.setAttribute("userName", userName);
				request.getRequestDispatcher("ProjectLeaderPage.jsp").forward(request, response);
			case USER:
				session.setAttribute("role", roleID);
				session.setAttribute("userName", userName);
				request.getRequestDispatcher("UserPage.jsp").forward(request, response);
			case INVALID:
				doGet(request, response);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
	}

}

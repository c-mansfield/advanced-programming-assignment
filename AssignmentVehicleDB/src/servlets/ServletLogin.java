package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.UserDAO;

public class ServletLogin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher view = req.getRequestDispatcher("login.jsp");
		view.forward(req, resp);
	}
	
	/* Posts user inputs checks validity of login, redirects if wrong
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDAO userdao = new UserDAO();
		boolean check = false;
		HttpSession session = req.getSession();
		
		String username = (String) req.getParameter("username");
		String password = (String) req.getParameter("password");
		
		
		try {
			check = userdao.usrCheck(username, password);
			System.out.println(check);
			if (check == true) {
				resp.sendRedirect("home");
				session.setAttribute("userLog", check);            //Set attribute, user logged in
			} else {
				resp.sendRedirect("login");
			}
		} catch (SQLException e) {
			System.out.println("Invalid");
		}
	}
}
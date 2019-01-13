package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.VehicleDAO;

public class ServletDelete extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	VehicleDAO dao = new VehicleDAO();
	
	/* Gets which id of row which wants to be deleted and deletes using
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
        try {
			dao.deleteVehicle(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        resp.sendRedirect(req.getContextPath() + "/home");
	}
		
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


	}
}
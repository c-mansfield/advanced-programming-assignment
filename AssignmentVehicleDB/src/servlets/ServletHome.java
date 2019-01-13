package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Vehicle;
import models.VehicleDAO;

public class ServletHome extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	VehicleDAO dao = new VehicleDAO();
	
	/* Gets all data of vehicles in DB to show on front-end
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			ArrayList<Vehicle> allVehicles;
			allVehicles = dao.getAllVehicles();
			RequestDispatcher view = req.getRequestDispatcher("index.jsp");
			req.setAttribute("allVehicles", allVehicles);
			view.forward(req, resp);		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}

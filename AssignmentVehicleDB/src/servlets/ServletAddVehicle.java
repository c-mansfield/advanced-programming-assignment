package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Vehicle;
import models.VehicleDAO;

public class ServletAddVehicle extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	/* Gets vehicle id for vehicle user wants to insert
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher view = req.getRequestDispatcher("newvehicle.jsp");
		HttpSession session = req.getSession();
		
		
		try {
			VehicleDAO dao = new VehicleDAO();
			int vehicle_id = dao.getNextVehicle_ID() + 1;
			req.setAttribute("vehicle_ID", vehicle_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//Check whether user is logged in or not, if no back to login
		if (session.getAttribute("userLog") == null) {
            resp.sendRedirect("/login"); 
        }
		
		view.forward(req, resp);
	}
	
	/* Posts all user inputs which is inserted into DB as vehicle object
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try
		{
		VehicleDAO dao = new VehicleDAO();
		int vehicle_id = 0;
		
		try {
			vehicle_id = dao.getNextVehicle_ID() + 1;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String make = (String) req.getParameter("make");
		String model = (String) req.getParameter("model");
		int year = Integer.parseInt(req.getParameter("year"));
		int price = Integer.parseInt(req.getParameter("price"));
		String license_number = (String) req.getParameter("license_number");
		String colour = (String) req.getParameter("colour");
		int number_doors = Integer.parseInt(req.getParameter("number_doors"));
		String transmission = (String) req.getParameter("transmission");
		int mileage = Integer.parseInt(req.getParameter("mileage"));
		String fuel_type = (String) req.getParameter("fuel_type");
		int engine_size = Integer.parseInt(req.getParameter("engine_size"));
		String body_style = (String) req.getParameter("body_style");
		String condition = (String) req.getParameter("condition");
		String notes = (String) req.getParameter("notes");
		
		Vehicle v = new Vehicle(vehicle_id, make, model, year, price,
				   license_number, colour, number_doors, transmission,
				   mileage, fuel_type, engine_size, body_style,
				   condition, notes);
		
		
		try {
			boolean done = dao.insertVehicle(v);
			System.out.println(done);
			if (done) {
				resp.sendRedirect("home");
			}
		} catch (SQLException e) {
			System.out.println("Primary Key Already in use!" + e);
		}
		
		} catch (NumberFormatException e) {
			System.out.println("Invalid all inputs needed");
			resp.sendRedirect("newvehicle");
		}
	}
	
}

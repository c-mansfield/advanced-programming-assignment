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

public class ServletEdit extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private VehicleDAO dao = new VehicleDAO();
	private int vehicle_id;
	
	/* Gets vehicle data of one which is being edited to show data on screen
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			vehicle_id = Integer.parseInt(req.getParameter("id"));
			Vehicle vehicle;
			HttpSession session = req.getSession();
			
			vehicle = dao.getVehicle(vehicle_id);
			RequestDispatcher view = req.getRequestDispatcher("editvehicle.jsp");
			req.setAttribute("vehicle", vehicle);
			
			if (session.getAttribute("userLog") == null) {
	            resp.sendRedirect("/login"); 
	        }
			
			view.forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
		
	/* Posts all user inputs which are then updated
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
	
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
		
			boolean done;
			try {
				done = dao.updateVehicle(v, vehicle_id);
				System.out.println(done);
				
				if (done) {
					resp.sendRedirect("home");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}  catch (NumberFormatException e) {		//Catch if any fields empty or wrong data type
			System.out.println("Invalid all inputs needed");
			resp.sendRedirect("edit?id=" + vehicle_id);
		}

	}
}
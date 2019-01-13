/*Author - Cole Mansfield
 *Student Number - 17069311
 **/

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import models.Vehicle;
import models.VehicleDAO;

public class ControllerConsole  {

	public static void main(String[] args) throws SQLException{
		Scanner input = new Scanner(System.in);
		VehicleDAO dao = new VehicleDAO();
		
		while(true)
		{
			int menuInput = crudMenu();	
			
			switch(menuInput)
			{
			case 1:		
			
				ArrayList<Vehicle> allVehicles = null;
				allVehicles = dao.getAllVehicles();				//Initialises get vehicles in DAO
				
				for (Vehicle v : allVehicles)				//Loops round all vehicles in database, prints out
				{	
					System.out.println("--------------------------------");
					System.out.println(v);
				}
				break;
				
			case 2:
				System.out.println("Which vehicle would you like to view?");
				int vehicleView = input.nextInt();
				
				System.out.println("--------------------------------");
				System.out.println(dao.getVehicle(vehicleView));				//Gets vehicle wants to view based on ID
				break;
		
			case 3:
				Scanner input2 = new Scanner(System.in);
				System.out.println("Please Enter vehicle details...");
				int vehicle_ID = dao.getNextVehicle_ID() + 1;
				System.out.println("Insert make: ");
				String make = input2.nextLine();
				System.out.println("Insert model: ");
				String model = input2.nextLine();
				System.out.println("Insert year car was made: ");
				int year = input2.nextInt();
				input2.nextLine();
				System.out.println("Insert price: ");
				int price = input2.nextInt();
				input2.nextLine();
				System.out.println("Insert registration number: ");
				String license_number = input2.nextLine();
				System.out.println("Insert colour: ");
				String colour = input2.nextLine();
				System.out.println("Insert number of doors: ");
				int number_doors = input2.nextInt();
				input2.nextLine();
				System.out.println("Insert transmission (Manual/Auto): ");
				String transmission = input2.nextLine();
				System.out.println("Insert mileage: ");
				int mileage = input2.nextInt();
				input2.nextLine();
				System.out.println("Insert fuel type (Diesel, Petrol, Hybrid, Electric): ");
				String fuel_type = input2.nextLine();
				System.out.println("Insert engine size (cc): ");
				int engine_size = input2.nextInt();
				input2.nextLine();
				System.out.println("Insert body style (Hatchback, Estate, SUV, MVP Coupe): ");
				String body_style = input2.nextLine();
				System.out.println("Insert condition (Like new, Good, Fair etc...): ");
				String condition = input2.nextLine();
				System.out.println("Insert notes (Special Features): ");
				String notes = input2.nextLine();
			
				Vehicle vehicleIn = new Vehicle(vehicle_ID , make, model, year, price,
					   license_number, colour, number_doors, transmission,
					   mileage, fuel_type, engine_size, body_style,
					   condition, notes);
			
				System.out.println("--------------------------------");
				System.out.println(dao.insertVehicle(vehicleIn));				//Inserts vehicle into db based on object created through user inputs
				break;
			
			case 4:
				System.out.println("Insert Vehicle id in which you'd like to update: ");
				int vehicle_ID1 = input.nextInt();
				input.nextLine();
				Vehicle usrUp = dao.getVehicle(vehicle_ID1);
				System.out.println("Please Enter vehicle details...");
				System.out.println("Insert make (" + usrUp.get_make() + "): ");
				String make1 = input.nextLine();
				System.out.println("Insert model: (" + usrUp.get_model() + ") ");
				String model1 = input.nextLine();
				System.out.println("Insert year car was made (" + usrUp.get_year() + "): ");
				int year1 = input.nextInt();
				input.nextLine();
				System.out.println("Insert price (" + usrUp.get_price() + "): ");
				int price1 = input.nextInt();
				input.nextLine();
				System.out.println("Insert registration number (" + usrUp.get_license_number() + "): ");
				String license_number1 = input.nextLine();
				System.out.println("Insert colour (" + usrUp.get_colour() + "): ");
				String colour1 = input.nextLine();
				System.out.println("Insert number of doors (" + usrUp.get_number_doors() + "): ");
				int number_doors1 = input.nextInt();
				input.nextLine();
				System.out.println("Insert transmission (Manual/Auto) (" + usrUp.get_transmission() + "): ");
				String transmission1 = input.nextLine();
				System.out.println("Insert mileage (" + usrUp.get_mileage() + "): ");
				int mileage1 = input.nextInt();
				input.nextLine();
				System.out.println("Insert fuel type (Diesel, Petrol, Hybrid, Electric) (" + usrUp.get_fuel_type() + "): ");
				String fuel_type1 = input.nextLine();
				System.out.println("Insert engine size (cc) (" + usrUp.get_engine_size() + "): ");
				int engine_size1 = input.nextInt();
				input.nextLine();
				System.out.println("Insert body style (Hatchback, Estate, SUV, MVP Coupe) (" + usrUp.get_body_style() + "): ");
				String body_style1 = input.nextLine();
				System.out.println("Insert condition (Like new, Good, Fair etc...) (" + usrUp.get_condition() + "): ");
				String condition1 = input.nextLine();
				System.out.println("Insert notes (Special Features) (" + usrUp.get_notes() + "): ");
				String notes1 = input.nextLine();
			
				Vehicle vehicleIn1 = new Vehicle(vehicle_ID1, make1, model1, year1, price1,
					   license_number1, colour1, number_doors1, transmission1,
					   mileage1, fuel_type1, engine_size1, body_style1,
					   condition1, notes1);
			
				System.out.println("--------------------------------");
				System.out.println(dao.updateVehicle(vehicleIn1, vehicle_ID1));
				break;
			case 5:
				System.out.println("Which vehicle would you like to delete?");
				int vehicleDel = input.nextInt();
				
				System.out.println("--------------------------------");
				System.out.println(dao.deleteVehicle(vehicleDel));					//Deletes vehicle based on ID
				break;
			case 6:
				System.exit(0);
				break;
			}
			
		}

	}
	
	//Print of CRUD menu for user options
	public static int crudMenu() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("-------------------------\n"
						 + "Vehicle Inventory System\n"
						 + "Choose from these options\n"
						 + "-------------------------\n"
						 + "1 - Retrieve all vehicles\n"
						 + "2 - Search for vehicle\n"
						 + "3 - Insert new vehicle into database\n"
						 + "4 - Update existing vehicle details\n"
						 + "5 - Delete vehicle from database\n"
						 + "6 - Exit\n"
						 + "Enter choice >");
		int usrInput = input.nextInt();
		
		return usrInput;
	}
}


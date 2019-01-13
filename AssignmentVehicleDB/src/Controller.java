/*Author - Cole Mansfield
 *Student Number - 17069311
 *CRUD controls for vehicle database using jetty*/

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import org.eclipse.jetty.webapp.Configuration.ClassList;

public class Controller {

	public static void main(String[] args) throws Exception {
		Server server = new Server(8005);
		WebAppContext ctx = new WebAppContext();
		ctx.setResourceBase("webapp");
		ctx.setContextPath("/*");
		
		//Configuring 
		ctx.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern", ".*/[^/]*jstl.*\\.jar$");
		ClassList classlist = ClassList.setServerDefault(server);
		classlist.addBefore("org.eclipse.jetty.webapp.JettyWebXmlConfiguration", "org.eclipse.jetty.annotations.AnnotationConfiguration");
		
		//Servlet setup
		ctx.addServlet("servlets.ServletHome", "/home");
		ctx.addServlet("servlets.ServletAddVehicle", "/newvehicle");
		ctx.addServlet("servlets.ServletLogin", "/login");
		ctx.addServlet("servlets.ServletDelete", "/delete");
		ctx.addServlet("servlets.ServletEdit", "/edit");
		ctx.addServlet("servlets.ServletLogout", "/logout");
		
		//Server start-up
		server.setHandler(ctx);
		server.start();
		server.join();
	}

}

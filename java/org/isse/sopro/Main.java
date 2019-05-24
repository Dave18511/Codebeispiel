package org.isse.sopro;

import java.util.Optional;

import org.apache.catalina.startup.Tomcat;
import org.isse.sopro.Servlet.*;

public class Main {

	public static final Optional<String> PORT = Optional.ofNullable(System.getenv("PORT"));
	public static final Optional<String> HOSTNAME = Optional.ofNullable(System.getenv("HOSTNAME"));

	/**
	 *
	 * only for deployment when tomcat runs embetted
	 *
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		String contextPath = "/";
		String appBase = ".";
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(Integer.valueOf(PORT.orElse("8080")));
		tomcat.setHostname(HOSTNAME.orElse("localhost"));
		tomcat.getHost().setAppBase(appBase);
		tomcat.addWebapp(contextPath, appBase);
		tomcat.start();
		tomcat.getServer().await();
		tomcat.addServlet("Users", "Users", new Users());
		tomcat.addServlet("login", "Login", new Login());
		tomcat.addServlet("NewUser", "NewUser", new NewUser());
		tomcat.addServlet("Profile", "Profile", new Profile());
		tomcat.addServlet("PasswordConfig", "PasswordConfig", new PasswordConfig());
		tomcat.addServlet("Logout", "Logout", new Logout());
		tomcat.addServlet("UserEdit", "UserEdit", new UserEdit());
	}

}

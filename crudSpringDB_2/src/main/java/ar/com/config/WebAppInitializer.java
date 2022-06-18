package ar.com.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;

import ar.com.controller.LisController;

public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) {
		ServletRegistration.Dynamic registration = container.addServlet("listado", new LisController());
		registration.setLoadOnStartup(1);
		registration.addMapping("/listar");
	}
}
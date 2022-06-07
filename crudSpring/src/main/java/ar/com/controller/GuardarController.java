package ar.com.controller;

import java.io.IOException;
import ar.com.BO.PersonaService;
import ar.com.bean.Persona;
import ar.com.config.AppConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@WebServlet("/guardar")
public class GuardarController extends HttpServlet {

	private static final long serialVersionUID = 4968995477720956596L;
	
	
	private PersonaService perService;
	
	  @Override
	   	public void init() throws ServletException {
	   		
	   		super.init();
	   		
			AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
			ac.register(AppConfig.class);
			ac.refresh();
			
			perService = ac.getBean(PersonaService.class);
			
			ac.close();
	   		
	   	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Persona per = Persona.builder()
							 .nombre(request.getParameter("nombre"))
							 .apellido(request.getParameter("apellido"))
							 .dni(request.getParameter("dni"))
							 .nacimiento(request.getParameter("nacimiento"))
							 .profesion(request.getParameter("profesion"))
							 .build();

		try {
			perService.agregarPersona(per);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect("listar");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
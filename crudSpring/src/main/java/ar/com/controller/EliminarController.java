package ar.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ar.com.BO.PersonaService;
import ar.com.config.AppConfig;

@WebServlet("/eliminar")
public class EliminarController extends HttpServlet {
	
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/listar");
		try {
			perService.eliminarPersona(request.getParameter("dni"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
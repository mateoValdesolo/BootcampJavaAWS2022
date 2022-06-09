package ar.com.controller;

import java.io.IOException;
import ar.com.BO.*;
import ar.com.config.JDBCConfig;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@WebServlet("/listar")
public class LisController extends HttpServlet {

	private static final long serialVersionUID = 4968995477720956596L;
	
	private PersonaService perService;
	
    @Override
   	public void init() throws ServletException {
   		
   		super.init();
   		
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(JDBCConfig.class);
		ac.refresh();
		
		perService = ac.getBean(PersonaService.class);
		
		ac.close();
   		
   	}
    

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/Listado.jsp");
		request.setAttribute("listaPersonas", perService.getPersonas());
		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
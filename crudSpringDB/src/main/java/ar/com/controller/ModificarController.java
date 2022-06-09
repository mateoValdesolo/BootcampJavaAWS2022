package ar.com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ar.com.BO.PersonaService;
import ar.com.bean.Persona;
import ar.com.config.JDBCConfig;

@WebServlet("/modificar")
public class ModificarController extends HttpServlet {

	private static final long serialVersionUID = 1L;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Persona perActualizada = Persona.builder().nombre(request.getParameter("nombre"))
				.apellido(request.getParameter("apellido")).dni(request.getParameter("dni"))
				.nacimiento(request.getParameter("nacimiento")).profesion(request.getParameter("profesion")).build();

		perService.editar(perActualizada);

		response.sendRedirect("listar");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
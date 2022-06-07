package ar.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.BO.PersonaService;
import ar.com.bean.Persona;

@WebServlet("/cargar")
public class CargarController extends HttpServlet {

	private static final long serialVersionUID = -5677138699339316812L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Persona per;

		per = PersonaService.getInstance().encontrarPersona(request.getParameter("dni"));
		request.setAttribute("nombre", per.getNombre());
		request.setAttribute("apellido", per.getApellido());
		request.setAttribute("dni", per.getDni());
		request.setAttribute("nacimiento", per.getNacimiento());
		request.setAttribute("profesion", per.getProfesion());

		request.setAttribute("accion", "modificar");

		RequestDispatcher dispatcher = request.getRequestDispatcher("/Formulario.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

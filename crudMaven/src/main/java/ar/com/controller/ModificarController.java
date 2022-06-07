package ar.com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.BO.PersonaService;
import ar.com.bean.Persona;

@WebServlet("/modificar")
public class ModificarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Persona perActualizada = Persona.builder()
				 .nombre(request.getParameter("nombre"))
				 .apellido(request.getParameter("apellido"))
				 .dni(request.getParameter("dni"))
				 .nacimiento(request.getParameter("nacimiento"))
				 .profesion(request.getParameter("profesion"))
				 .build();

		try {
			PersonaService.getInstance().editar(perActualizada);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect("listar");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
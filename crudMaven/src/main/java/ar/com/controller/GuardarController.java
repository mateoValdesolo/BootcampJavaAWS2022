package ar.com.controller;

import java.io.IOException;
import ar.com.BO.*;
import ar.com.bean.Persona;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/guardar")
public class GuardarController extends HttpServlet {

	private static final long serialVersionUID = 4968995477720956596L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Persona per = Persona.builder().nombre(request.getParameter("nombre"))
									   .apellido(request.getParameter("apellido"))
									   .dni(request.getParameter("dni"))
									   .nacimiento(request.getParameter("nacimiento"))
									   .profesion(request.getParameter("profesion"))
									   .build();

		
		switch ((String) request.getParameter("opcion")) {
		case "agregar":
			try {
				PersonaService.getInstance().agregarPersona(per);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "modificar":
			try {
				PersonaService.getInstance().editar(per);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
		
		response.sendRedirect("listar");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
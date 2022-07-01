package ar.com.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.com.bo.PersonaService;
import ar.com.model.PersonaLocal;
import ar.com.webServices.personas.crud.service.PersonaNotFoundException;
import ar.com.webServices.personas.crud.service.PersonaRepetidaException;

@Controller
public class HomeController {

	@Autowired
	private PersonaService personaService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() throws IOException {
		List<PersonaLocal> listaPersonas = personaService.getPersonas();
		ModelAndView model = new ModelAndView("Listado");
		model.addObject("listaPersonas", listaPersonas);
		return model;
	}

	@RequestMapping(value = "/crearInit", method = RequestMethod.GET)
	public ModelAndView crearInit() throws IOException {
		ModelAndView model = new ModelAndView("Formulario");
		model.addObject("action", "CREAR");
		model.addObject("person", new PersonaLocal());

		return model;
	}

	@RequestMapping(value = "/crearSave", method = RequestMethod.POST)
	public ModelAndView crearSave(@ModelAttribute("person") PersonaLocal person) throws IOException, PersonaRepetidaException {

		personaService.agregarPersona(person);

		return home();
	}

	@RequestMapping(value = "/editarInit", method = RequestMethod.GET)
	public ModelAndView editarInit(@RequestParam("dni") String dni) throws IOException, PersonaNotFoundException {
		PersonaLocal p = personaService.encontrarPersona(dni);

		ModelAndView model = new ModelAndView("Formulario");
		model.addObject("action", "MODIFICAR");
		model.addObject("person", p);

		return model;
	}

	@RequestMapping(value = "/modificarSave", method = RequestMethod.POST)
	public ModelAndView modificarSave(@ModelAttribute("person") PersonaLocal person) throws IOException, PersonaNotFoundException {

		personaService.editar(person);

		return home();
	}

	@RequestMapping(value = "/eliminar", method = RequestMethod.GET)
	public ModelAndView eliminar(@RequestParam("dni") String dni) throws IOException, PersonaNotFoundException {
		personaService.eliminarPersona(dni);

		return home();
	}

}

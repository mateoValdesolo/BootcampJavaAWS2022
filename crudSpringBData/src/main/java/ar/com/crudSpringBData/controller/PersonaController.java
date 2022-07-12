package ar.com.crudSpringBData.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ar.com.crudSpringBData.entity.Persona;
import ar.com.crudSpringBData.service.PersonaService;

@Controller
public class PersonaController {

	@Autowired
	private PersonaService perService;

	@GetMapping("/")
	public String listarPersonas(Model model) {
		model.addAttribute("LISTA_PERSONAS", perService.getPersonas());

		return "index";
	}

	@GetMapping("/agregar")
	public String agregarPersona(Model model) {
		Persona per = new Persona();
		model.addAttribute("persona", per);
		return "Formulario";
	}

	@PostMapping("/guardar")
	public String guardarPersona(@ModelAttribute("persona") Persona persona) {
		perService.guardar(persona);
		return "redirect:/";
	}

	@GetMapping("/modificar/{dni}")
	public String formularioActualiza(@PathVariable(value = "dni") String dni, Model model) {
		Persona per = perService.obtenerPorDni(dni);
		model.addAttribute("persona", per);
		return "FormularioModifica";
	}

	@GetMapping("/eliminarPersona/{dni}")
	public String eliminarPorDni(@PathVariable(value = "dni") String dni) {
		perService.eliminarporDni(dni);
		return "redirect:/";

	}

}

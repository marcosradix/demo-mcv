package br.com.workmade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.workmade.model.DepartamentoEntity;
import br.com.workmade.service.DepartamentoService;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {
	
	@Autowired
	private DepartamentoService departamentoService;

	@GetMapping("/cadastrar")
	public String cadastrar(DepartamentoEntity departamento) {
		return "/departamento/cadastro";
	}
	

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("departamentos", departamentoService.buscarTodos());
		return "/departamento/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(DepartamentoEntity departamento) {
		departamentoService.salvar(departamento);
		return "redirect:/departamentos/cadastrar";	
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("departamentoEntity", departamentoService.buscarPorId(id));
		return "/departamento/cadastro";
		
	}
	
	@PostMapping("/editar")
	public String editar(DepartamentoEntity departamento) {
		departamentoService.editar(departamento);
		return "redirect:/departamentos/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		 if(!departamentoService.departamentoTemCargos(id)) {
			 departamentoService.excluir(id);
		 }
		return listar(model);
		
	}
	
}

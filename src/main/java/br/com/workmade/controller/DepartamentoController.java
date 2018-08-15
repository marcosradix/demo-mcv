package br.com.workmade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.workmade.model.DepartamentoEntity;
import br.com.workmade.service.DepartamentoService;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {
	
	private static final String DEPARTAMENTO_ADICIONADO_COM_SUCESSO = "Departamento adicionado com sucesso.";
	private static final String DEPARTAMENTO_EDITADO_COM_SUCESSO = "Departamento editado com sucesso.";
	private static final String DEPARTAMENTO_EXCLUIDO_COM_SUCESSO = "Departamento excluido com sucesso.";
	private static final String DEPARTAMENTO_COM_CARGO_S_VINCULADO_S = "O Departamento não pode ser excluido pois tem cargo(s) vinculado(s).";
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
	public String salvar(DepartamentoEntity departamento, RedirectAttributes redi) {
		departamentoService.salvar(departamento);
		redi.addFlashAttribute("success", DEPARTAMENTO_ADICIONADO_COM_SUCESSO);
		return "redirect:/departamentos/cadastrar";	
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("departamentoEntity", departamentoService.buscarPorId(id));
		return "/departamento/cadastro";
		
	}
	
	@PostMapping("/editar")
	public String editar(DepartamentoEntity departamento, RedirectAttributes redi) {
		departamentoService.editar(departamento);
		redi.addFlashAttribute("success", DEPARTAMENTO_EDITADO_COM_SUCESSO);
		return "redirect:/departamentos/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		 if(departamentoService.departamentoTemCargos(id)) {
			 model.addAttribute("fail", DEPARTAMENTO_COM_CARGO_S_VINCULADO_S);
		 }else {
			 departamentoService.excluir(id);	
			 model.addAttribute("success", DEPARTAMENTO_EXCLUIDO_COM_SUCESSO);
		 }
		return listar(model);
		
	}
	
}

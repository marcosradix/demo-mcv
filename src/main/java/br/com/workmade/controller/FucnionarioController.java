package br.com.workmade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.workmade.model.CargoEntity;
import br.com.workmade.model.FuncionarioEntity;
import br.com.workmade.service.CargoService;
import br.com.workmade.service.FuncionarioService;
import br.com.workmade.ufEnum.UF;

@Controller
@RequestMapping("/funcionarios")
public class FucnionarioController {
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private CargoService cargoService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(FuncionarioEntity funcionario) {
		return "funcionario/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("funcionarios", funcionarioService.buscarTodos());
		return "funcionario/lista";
	}
	
	
	@PostMapping("/salvar")
	public String salvar(FuncionarioEntity funcionario, RedirectAttributes redi) {
		funcionarioService.salvar(funcionario);
		redi.addFlashAttribute("success", "Funcionário inserido com uscesso.");
		return "redirect:/funcionarios/cadastrar";
	}
	
	@ModelAttribute("cargos")
	public List<CargoEntity> getCargos(){
		return cargoService.buscarTodos();
	}
	
	@ModelAttribute("ufs")
	public UF[] getUFs() {
		return UF.values();
	}

}









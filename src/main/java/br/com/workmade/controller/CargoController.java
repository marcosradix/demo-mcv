package br.com.workmade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.workmade.model.CargoEntity;
import br.com.workmade.model.DepartamentoEntity;
import br.com.workmade.service.CargoService;
import br.com.workmade.service.DepartamentoService;

@Controller
@RequestMapping("/cargos")
public class CargoController {

	@Autowired
	private CargoService cargoService;
	
	@Autowired
	private DepartamentoService departamentoService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(CargoEntity cargo) {
		return "/cargo/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("cargos", cargoService.buscarTodos());
		return "/cargo/lista";
	}
	@PostMapping("/salvar")
	public String salvar(CargoEntity cargo, RedirectAttributes redi) {
		cargoService.salvar(cargo);
		redi.addFlashAttribute("success", "Cargo inserido com uscesso.");
		return "redirect:/cargos/cadastrar";
	}
	
	@ModelAttribute("departamentos")
	public List<DepartamentoEntity> listaDeDepartamentos(){
		return departamentoService.buscarTodos();
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("cargoEntity", cargoService.buscarPorId(id));
		return "cargo/cadastro";
		
	}
	
	@PostMapping("/editar")
	public String editar(CargoEntity cargo, RedirectAttributes redi) {
		cargoService.editar(cargo);
		redi.addFlashAttribute("success", "Cargo cadastrado com sucesso.");
		return "redirect:/cargos/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes redi) {
		 if(cargoService.cargoTemFuncionarios(id)) {
			 redi.addFlashAttribute("fail", "Cargo não excluido, tem funcionário(s) vinculado(s)");
		 }else {
			 cargoService.excluir(id);	
			 redi.addFlashAttribute("success", "Cargo excluído com sucesso.");
		 }
		return "redirect:/cargos/listar";
		
	}
	
}













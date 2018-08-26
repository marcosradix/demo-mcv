package br.com.workmade.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("funcionarioEntity", funcionarioService.buscarPorId(id));
		return "funcionario/cadastro";
		
	}
	
	@PostMapping("/editar")
	public String editar(FuncionarioEntity funcionario, RedirectAttributes redi) {
		funcionarioService.editar(funcionario);
		redi.addFlashAttribute("success", "Funcionario atualizado com sucesso.");
		return "redirect:/funcionarios/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes redi) {
		 	 funcionarioService.excluir(id);
			 redi.addFlashAttribute("success", "Funcionario excluido com sucesso.");
		return "redirect:/funcionarios/listar";
		
	}
		@GetMapping("/buscar/nome")
		public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {
			model.addAttribute("funcionarios", funcionarioService.buscarPorNome(nome));
			return "funcionario/lista";
		}

		@GetMapping("/buscar/cargo")
		public String getPorCargo(@RequestParam("idCargo") Long id, ModelMap model) {
			model.addAttribute("funcionarios", funcionarioService.buscarPorCargo(id));
			return "/funcionario/lista";
		}
		
		

		@GetMapping("/buscar/data")
		public String getPorData(@RequestParam("entrada") LocalDate entrada,@RequestParam("entrada") LocalDate saida,  ModelMap model) {
			model.addAttribute("funcionarios", funcionarioService.buscarPorDatas(entrada, saida));
			return "/funcionario/lista";
		}
}









































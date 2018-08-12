package br.com.workmade.service;

import java.util.List;

import br.com.workmade.model.FuncionarioEntity;

public interface FuncionarioService {

	
	void salvar (FuncionarioEntity funcionario);
	void editar (FuncionarioEntity funcionario);
	void excluir (Long id);
	FuncionarioEntity buscarPorId(Long id);
	List<FuncionarioEntity> buscarTodos();
}

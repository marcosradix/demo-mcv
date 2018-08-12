package br.com.workmade.service;

import java.util.List;

import br.com.workmade.model.DepartamentoEntity;

public interface DepartamentoService {

	void salvar (DepartamentoEntity departamento);
	void editar (DepartamentoEntity departamento);
	void excluir (Long id);
	DepartamentoEntity buscarPorId(Long id);
	List<DepartamentoEntity> buscarTodos();
	boolean departamentoTemCargos(Long id);
	
	
}

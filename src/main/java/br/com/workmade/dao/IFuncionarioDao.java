package br.com.workmade.dao;

import java.util.List;

import br.com.workmade.model.FuncionarioEntity;

public interface IFuncionarioDao {
	
	void save (FuncionarioEntity funcionario);
	void update (FuncionarioEntity funcionario);
	void delete (Long id);
	FuncionarioEntity findById(Long id);
	List<FuncionarioEntity> findAll();

}

package br.com.workmade.dao;

import java.util.List;

import br.com.workmade.model.DepartamentoEntity;

public interface IDepartamentoDao {
	
	
	void save (DepartamentoEntity departamento);
	void update (DepartamentoEntity departamento);
	void delete (Long id);
	DepartamentoEntity findById(Long id);
	List<DepartamentoEntity> findAll();

}

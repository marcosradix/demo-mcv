package br.com.workmade.dao;

import java.time.LocalDate;
import java.util.List;

import br.com.workmade.model.FuncionarioEntity;

public interface IFuncionarioDao {
	
	void save (FuncionarioEntity funcionario);
	void update (FuncionarioEntity funcionario);
	void delete (Long id);
	FuncionarioEntity findById(Long id);
	List<FuncionarioEntity> findAll();
	List<FuncionarioEntity> finByNome(String nome);
	List<FuncionarioEntity> findByCargoId(Long id);
	List<FuncionarioEntity> findFuncionarioByDataEntradaDataSaida(LocalDate entrada, LocalDate saida);
	List<FuncionarioEntity> findByDataEntrada(LocalDate entrada);
	List<FuncionarioEntity> findByDataSaida(LocalDate saida);
	

}

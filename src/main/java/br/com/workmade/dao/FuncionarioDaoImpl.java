package br.com.workmade.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.workmade.model.FuncionarioEntity;

@Repository
public class FuncionarioDaoImpl extends AbstractDaoGeneric<FuncionarioEntity, Long>  implements IFuncionarioDao{

	@Override
	public List<FuncionarioEntity> finByNome(String nome) {
		return createQuery("select f from  FuncionarioEntity f  where f.nome  like concat('%', ?1, '%')", nome);
	}

	@Override
	public List<FuncionarioEntity> findByCargoId(Long id) {
		return createQuery("select f from FuncionarioEntity  f where f.cargo.id = ?1", id);
	}

	@Override
	public List<FuncionarioEntity> findFuncionarioByDataEntradaDataSaida(LocalDate dataEntrada, LocalDate dataSaida) {
		StringBuilder jpql = new StringBuilder("select f from FuncionarioEntity f ")
				.append("where f.dataEntrada >= ?1 and f.dataSaida <= ?2 ")
				.append("order by f.dataEntrada asc");
		return createQuery(jpql.toString(), dataEntrada, dataSaida);
	}

	@Override
	public List<FuncionarioEntity> findByDataEntrada(LocalDate dataEntrada) {
		StringBuilder jpql = new StringBuilder("select f from FuncionarioEntity f ")
				.append("where f.dataEntrada = ?1 ")
				.append("order by f.dataEntrada asc");
		return createQuery(jpql.toString(), dataEntrada);
	}

	@Override
	public List<FuncionarioEntity> findByDataSaida(LocalDate dataSaida) {
		StringBuilder jpql = new StringBuilder("select f from FuncionarioEntity f ")
				.append("where  f.dataSaida = ?1 ")
				.append("order by f.dataEntrada asc");
		return createQuery(jpql.toString(), dataSaida);
	}


	}



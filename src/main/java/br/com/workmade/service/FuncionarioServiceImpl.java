package br.com.workmade.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.workmade.dao.IFuncionarioDao;
import br.com.workmade.model.FuncionarioEntity;

@Service
@Transactional(readOnly=true)
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private IFuncionarioDao funcionarioDao;
	
	@Transactional(readOnly=false)
	@Override
	public void salvar(FuncionarioEntity funcionario) {
		funcionarioDao.save(funcionario);

	}
	@Transactional(readOnly=false)
	@Override
	public void editar(FuncionarioEntity funcionario) {
		funcionarioDao.update(funcionario);

	}

	@Transactional(readOnly=false)
	@Override
	public void excluir(Long id) {
		funcionarioDao.delete(id);

	}

	@Override
	public FuncionarioEntity buscarPorId(Long id) {
		return funcionarioDao.findById(id);
	}

	@Override
	public List<FuncionarioEntity> buscarTodos() {
		return funcionarioDao.findAll();
	}
	@Override
	public List<FuncionarioEntity> buscarPorNome(String nome) {
		return funcionarioDao.finByNome(nome);
	}
	@Override
	public List<FuncionarioEntity> buscarPorCargo(Long id) {
		return funcionarioDao.findByCargoId(id);
	}
	@Override
	public List<FuncionarioEntity> buscarPorDatas(LocalDate entrada, LocalDate saida) {
		if(entrada != null && saida != null) {
			return funcionarioDao.findFuncionarioByDataEntradaDataSaida(entrada, saida);
		}else if(entrada != null) {
			return funcionarioDao.findByDataEntrada(entrada);
		}else if(saida != null) {
			return funcionarioDao.findByDataSaida(saida);
		}else {
			return new ArrayList<>();
		}
		
	}

}






























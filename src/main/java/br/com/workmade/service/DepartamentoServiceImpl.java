package br.com.workmade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.workmade.dao.IDepartamentoDao;
import br.com.workmade.model.DepartamentoEntity;

@Service
@Transactional(readOnly=false)
public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired
	private IDepartamentoDao departamentoDao;
	
	
	@Override
	public void salvar(DepartamentoEntity departamento) {
		departamentoDao.save(departamento);

	}

	@Override
	public void editar(DepartamentoEntity departamento) {
		departamentoDao.update(departamento);

	}

	@Override
	public void excluir(Long id) {
		departamentoDao.delete(id);

	}

	@Override
	@Transactional(readOnly=true)
	public DepartamentoEntity buscarPorId(Long id) {
		return departamentoDao.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<DepartamentoEntity> buscarTodos() {
		return departamentoDao.findAll();
	}

}

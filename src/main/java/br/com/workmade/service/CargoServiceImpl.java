package br.com.workmade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.workmade.dao.ICargoDao;
import br.com.workmade.model.CargoEntity;

@Service
@Transactional(readOnly=false)
public class CargoServiceImpl implements CargoService {	

	@Autowired
	private ICargoDao cargoDao;
	
	@Override
	public void salvar(CargoEntity cargo) {
		cargoDao.save(cargo);

	}

	@Override
	public void editar(CargoEntity cargo) {
		cargoDao.update(cargo);

	}

	@Override
	public void excluir(Long id) {
		cargoDao.delete(id);

	}
	@Transactional(readOnly=true)
	@Override
	public CargoEntity buscarPorId(Long id) {
		return cargoDao.findById(id);
	}
	@Transactional(readOnly=true)
	@Override
	public List<CargoEntity> buscarTodos() { 
		return cargoDao.findAll();
	}

}

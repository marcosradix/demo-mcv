package br.com.workmade.dao;

import java.util.List;

import br.com.workmade.model.CargoEntity;

public interface ICargoDao {
	
	void save (CargoEntity cargo);
	void update (CargoEntity cargo);
	void delete (Long id);
	CargoEntity findById(Long id);
	List<CargoEntity> findAll();

}

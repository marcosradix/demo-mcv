package br.com.workmade.dao;

import org.springframework.stereotype.Repository;

import br.com.workmade.model.CargoEntity;

@Repository
public class CargoDaoImpl extends AbstractDaoGeneric<CargoEntity, Long>  implements ICargoDao {

}

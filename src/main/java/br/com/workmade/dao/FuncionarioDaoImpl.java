package br.com.workmade.dao;

import org.springframework.stereotype.Repository;

import br.com.workmade.model.FuncionarioEntity;

@Repository
public class FuncionarioDaoImpl extends AbstractDaoGeneric<FuncionarioEntity, Long>  implements IFuncionarioDao{

}

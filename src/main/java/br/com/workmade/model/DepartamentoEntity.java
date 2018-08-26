package br.com.workmade.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.workmade.domain.AbstractEntity;

@Entity
@Table(name= "DEPARTAMENTOS")
public class DepartamentoEntity extends AbstractEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7039774417807945958L;
	
	@Column(nullable=false, unique=true, length=60)
	private String nome;
	
	
	@OneToMany(mappedBy= "departamento")
	private List<CargoEntity> cargos;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<CargoEntity> getCargos() {
		return cargos;
	}

	public void setCargos(List<CargoEntity> cargos) {
		this.cargos = cargos;
	}
	
	
	

}

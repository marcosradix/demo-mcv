package br.com.workmade.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import br.com.workmade.domain.AbstractEntity;

@SuppressWarnings("deprecation")
@Entity
@Table(name= "DEPARTAMENTOS")
public class DepartamentoEntity extends AbstractEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7039774417807945958L;
	

	@NotNull(message="Informe um nome, esse campo não pode ser vazio.")
	@NotBlank(message="Informe um nome.")
	@Size(min= 3, max= 60,  message="O nome do departamento deve ter entre {min} e {max} caracters.")
	@Column(nullable=true, unique=true, length=60)
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

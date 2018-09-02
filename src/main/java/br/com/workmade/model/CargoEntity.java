package br.com.workmade.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import br.com.workmade.domain.AbstractEntity;

@SuppressWarnings("deprecation")
@Entity
@Table(name= "CARGOS")
public class CargoEntity extends AbstractEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2820444668893292364L;
	
	@NotBlank(message="O nome do cargo é obrigatório.")
	@Size(max= 60, message="O nome do cargo deve conter no máximo {max} caracteres.")
	@Column(nullable=false, unique=true, length=60)
	private String nome;
	
	@NotNull(message="Selecione o departamento relativo ao cargo.")
	@ManyToOne
	@JoinColumn(name= "id_departamento_fk")
	private DepartamentoEntity departamento;

	@OneToMany(mappedBy="cargo")
	private List<FuncionarioEntity> funcionarios;
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public DepartamentoEntity getDepartamento() {
		return departamento;
	}

	public void setDepartamento(DepartamentoEntity departamento) {
		this.departamento = departamento;
	}
	
	public List<FuncionarioEntity> getFuncionarios() {
		return funcionarios;
	}
	
	public void setFuncionarios(List<FuncionarioEntity> funcionarios) {
		this.funcionarios = funcionarios;
	}
}

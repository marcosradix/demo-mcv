package br.com.workmade.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat.Style;

import br.com.workmade.domain.AbstractEntity;

@Entity
@Table(name= "FUNCIONARIOS")
public class FuncionarioEntity extends AbstractEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2315641069381826622L;
	
	@Column(nullable=false, unique=true)
	private String nome;

	// Total de 7 digitos e duas casas decimais e se não houver valor não será null e sim 0.00
	@NumberFormat(pattern = "#,##0.00", style= Style.CURRENCY)
	@Column(nullable=false, columnDefinition="DECIMAl(7,2) DEFAULT 0.00")
	private BigDecimal salario;
	
	@DateTimeFormat(iso= ISO.DATE)
	@Column(name="data_entrada", nullable=false, columnDefinition="DATE")
	private LocalDate dataEntrada;
	
	@DateTimeFormat(iso= ISO.DATE)
	@Column(name="data_saida", nullable=true, columnDefinition="DATE")
	private LocalDate dataSaida;
	
	
	//Será inserido por cascata um endereço para o funcionário
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="endereco_id_fk")
	private EnderecoEntity endereco;
	
	@ManyToOne
	@JoinColumn(name= "cargo_id_fk")
	private CargoEntity cargo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}

	public EnderecoEntity getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoEntity endereco) {
		this.endereco = endereco;
	}

	public CargoEntity getCargo() {
		return cargo;
	}

	public void setCargo(CargoEntity cargo) {
		this.cargo = cargo;
	}
	
	
	
}

















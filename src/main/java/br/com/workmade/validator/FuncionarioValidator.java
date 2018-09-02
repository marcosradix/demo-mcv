package br.com.workmade.validator;

import java.time.LocalDate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.workmade.model.FuncionarioEntity;

public class FuncionarioValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return FuncionarioEntity.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		FuncionarioEntity funcionario = (FuncionarioEntity) object;
		LocalDate entrada = funcionario.getDataEntrada();
		if(funcionario.getDataSaida() != null) {
			if(funcionario.getDataSaida().isBefore(entrada) || funcionario.getDataSaida().isEqual(entrada)) {
				errors.rejectValue("dataSaida", "PosteriorDataEntrada.funcionario.dataSaida");
			}
		}
		
	}

}

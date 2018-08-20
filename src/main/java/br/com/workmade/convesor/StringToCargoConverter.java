package br.com.workmade.convesor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.workmade.model.CargoEntity;
import br.com.workmade.service.CargoService;

@Component
public class StringToCargoConverter implements Converter<String, CargoEntity> {

	@Autowired
	private CargoService cargoService;
	
	@Override
	public CargoEntity convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		
		Long id = Long.valueOf(text);		
		return cargoService.buscarPorId(id);
	}

}

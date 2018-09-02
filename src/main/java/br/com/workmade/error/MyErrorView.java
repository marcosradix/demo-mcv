package br.com.workmade.error;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
public class MyErrorView implements ErrorViewResolver{
private Logger log =  Logger.getLogger(MyErrorView.class);

	@Override
	public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> map) {
		ModelAndView model = new ModelAndView("/error");
		model.addObject("status", status.value());
		
		switch (status.value()) {
		case 404:
			model.addObject("error", "Página não encontrada");
			model.addObject("message", String.format("A URL da página ' %s ' não existe", map.get("path")));
			break;

		case 500:
			model.addObject("error", "Ocorreu um erro interno no servidor.");
			model.addObject("message", "Erro inesperado, por favor tente mais tarde :(");
			break;
		default:
			model.addObject("error", map.get("error"));
			model.addObject("message", map.get("message"));
			break;
		}
		
		map.forEach((k,v) -> log.info(k +":" + v + "\n") );
		return model;
	}

}

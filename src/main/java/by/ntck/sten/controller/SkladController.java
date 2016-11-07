package by.ntck.sten.controller;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.ntck.sten.model.Sklad;
import by.ntck.sten.service.IKladovshikService;
import by.ntck.sten.service.IService;

@Controller
@RequestMapping("sklad")
public class SkladController {
	public static  final Logger LOG = Logger.getLogger(SkladController.class);
	private IService<Sklad> skladService;
	
	private IKladovshikService kladovshikService;
	
	@Autowired(required = true)
	@Qualifier(value = "kladovshikService")
	public void setKladovshikService(IKladovshikService kladovshikService) {
		this.kladovshikService = kladovshikService;
	}

	@Autowired(required = true)
	@Qualifier(value = "skladService")
	public void setSkladService(IService<Sklad> skladService) {
		this.skladService = skladService;
	}
	
	
	@RequestMapping(value = "/sklads", method = RequestMethod.POST)
	public String listSklad(Model model){
		model.addAttribute("sklad", new Sklad());
		model.addAttribute("listSklad", this.skladService.list());
		
		return "sklad/sklads";
	}
	
	@RequestMapping(value = "/sklad_kladovschik/{id}", method = RequestMethod.GET)
	public String sklad_kladovschik(@PathVariable("id") int id,Model model){
		model.addAttribute("sklad", new Sklad());
		Sklad sklad= this.skladService.getById(id);
		model.addAttribute("listSkladKladovschik", this.kladovshikService.kladovshikBySklad(sklad.getId()));
		
		return "sklad/sklads";
	}


}

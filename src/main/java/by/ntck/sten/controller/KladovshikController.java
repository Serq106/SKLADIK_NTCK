package by.ntck.sten.controller;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import by.ntck.sten.model.Kladovshik;
import by.ntck.sten.service.IKladovshikService;
import static by.ntck.sten.constant.Constants.*;
@Controller
@RequestMapping("kladovshik")
public class KladovshikController {
	public static  final Logger LOG = Logger.getLogger(KladovshikController.class);

	private IKladovshikService kladovshikService;
	
	public int her = 1;
	
	@Autowired(required = true)
	@Qualifier(value = "kladovshikService")
	public void setKladovshikService(IKladovshikService kladovshikService) {
		this.kladovshikService = kladovshikService;
	}

	@RequestMapping(value = "/login" )
	public String login(Model model, HttpServletRequest request) {
		model.addAttribute("kladovshik", new Kladovshik());
		request.getSession().invalidate();
		
		return "/login";
	}

	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public String login_auth(@RequestParam("login") String login, @RequestParam("password") String password,
			 Model model, HttpServletRequest request) {		
		model.addAttribute("kladovshik", new Kladovshik());
		Kladovshik kladovshik = kladovshikService.login(login, password);

		model.addAttribute("kladovshik", (kladovshik.equals(EMPTY_KLADOVSHIK))?EMPTY_KLADOVSHIK:kladovshik);
		request.getSession().setAttribute("kladovshik",kladovshik);
		if(kladovshik.getId()!= 0 ){
			her = 1;
			return "redirect:/sklad/sklad_kladovschik/"+ kladovshik.getId();	
		} else {
			her = -1;
			return "redirect:/kladovshik/login";
		}
				
		
	}
}

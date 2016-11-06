package by.ntck.sten.controller;

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

@Controller
@RequestMapping("kladovshik")
public class KladovshikController {
	public static  final Logger LOG = Logger.getLogger(KladovshikController.class);

	private IKladovshikService kladovshikService;

	@Autowired(required = true)
	@Qualifier(value = "kladovshikService")
	public void setKladovshikService(IKladovshikService kladovshikService) {
		this.kladovshikService = kladovshikService;
	}

	@RequestMapping(value = "/login")
	public String login(Model model) {
		model.addAttribute("kladovshik", new Kladovshik());


		return "login";
	}

	@RequestMapping(value = "/kladovshik_data", method = RequestMethod.POST)
	public String login_auth(@RequestParam("login") String login, @RequestParam("password") String password,
			Model model) {
		model.addAttribute("kladovshik", new Kladovshik());
		Kladovshik kladovshik = kladovshikService.login(login, password);
		model.addAttribute("kladovshik", (kladovshik==null)?"מיי¸ימ¸מימ¸י":kladovshik);
		
		LOG.error(kladovshik);
		if (kladovshik == null) {
			return "login";
		} else {
			return "/kladovshik/kladovshik_data";
		}
	}

}

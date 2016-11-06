package by.ntck.sten.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {
	
	@RequestMapping(value = "/index")
	public String root(Model model)
	{
		return "index";
	}
}

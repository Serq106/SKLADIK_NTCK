package by.ntck.sten.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.ntck.sten.model.User;
import by.ntck.sten.service.IService;

@Controller
@RequestMapping("user")
public class UserController {
	private IService<User> userService;

	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setBookService(IService<User> userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/user_data/{id}", method = RequestMethod.POST)
	public String userData(Model model, @PathVariable("id") int id, HttpServletRequest request) {
		model.addAttribute("user", new User());
		model.addAttribute("findUser", userService.getById(id));
		return "user/user_data";
	}	
}

package by.ntck.sten.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import by.ntck.sten.model.Sklad;
import by.ntck.sten.model.Kladovshik;
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
	
	@RequestMapping(value = "/sklad_data/{id}")
	public String getById(@PathVariable("id") int id, Model model, HttpServletRequest request){
		model.addAttribute("sklad", new Sklad());
		model.addAttribute("sklads", skladService.getById(id));

		return "sklad/sklad_data";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@RequestParam("id") int id, @RequestParam("bismt") String bismt, @RequestParam("close_kadr") String close_kadr, 
			@RequestParam("edin") String edin, @RequestParam("imports") String imports, @RequestParam("in_bd") String in_bd, 
			@RequestParam("isdel") String isdel, @RequestParam("karta") String karta, @RequestParam("kolvo") float kolvo, 
			@RequestParam("naim") String naim, @RequestParam("naim2") String naim2, @RequestParam("price") String price, 
			@RequestParam("sap_kod") String sap_kod, @RequestParam("sklad_key") int sklad_key, @RequestParam("stelach") String stelach, 
			@RequestParam("testing") String testing, @RequestParam("tolling") String tolling, @RequestParam("used") String used,
			@RequestParam("yatheika") String yatheika, @RequestParam("user_id") int user_id, Model model, HttpServletRequest request) {

		Sklad sklad = new Sklad();
		sklad.setId(id);
		sklad.setBismt(bismt);
		sklad.setClose_kadr(close_kadr);
		sklad.setEdin(edin);
		sklad.setImports(imports);
		sklad.setIn_bd(in_bd);
		sklad.setIsdel(isdel);
		sklad.setKarta(karta);
		sklad.setKolvo(kolvo);
		sklad.setNaim(naim);
		sklad.setNaim2(naim2);
		sklad.setPrice(price);
		sklad.setSap_kod(sap_kod);
		sklad.setSklad_key(sklad_key);
		sklad.setStelach(stelach);
		sklad.setTesting(testing);
		sklad.setTolling(tolling);
		sklad.setUsed(used);
		sklad.setYatheika(yatheika);
		List<Kladovshik> list = new ArrayList<Kladovshik>();
		list.add(kladovshikService.getById(user_id));
		sklad.setKladovshik( list);
		skladService.add(sklad);
		int id_kladovshik = ((Kladovshik)request.getSession().getAttribute("kladovshik")).getId();
		return  "redirect:/sklad/sklad_kladovschik/"+ id_kladovshik;// "redirect:"+request.getHeader("referer"); //";
	}

	@RequestMapping(value = "/sklad_create")
	public String add(Model model) {
		model.addAttribute("sklad", new Sklad());
		model.addAttribute("kladovshikList",kladovshikService.list());
		
		return "sklad/sklad_create";
	}
	
	@RequestMapping("/cklad_edit/{id}")
	public String edit(Model model, @PathVariable("id") int id, HttpServletRequest request){
		model.addAttribute("sklad", new Sklad());
		model.addAttribute("findSklad", skladService.getById(id));
		
		return "sklad/sklad_edit";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(@RequestParam("id") int id, @RequestParam("bismt") String bismt, @RequestParam("close_kadr") String close_kadr, 
			@RequestParam("edin") String edin, @RequestParam("imports") String imports, @RequestParam("in_bd") String in_bd, 
			@RequestParam("isdel") String isdel, @RequestParam("karta") String karta, @RequestParam("kolvo") float kolvo, 
			@RequestParam("naim") String naim, @RequestParam("naim2") String naim2, @RequestParam("price") String price, 
			@RequestParam("sap_kod") String sap_kod, @RequestParam("sklad_key") int sklad_key, @RequestParam("stelach") String stelach, 
			@RequestParam("testing") String testing, @RequestParam("tolling") String tolling, @RequestParam("used") String used,
			@RequestParam("yatheika") String yatheika, Model model, HttpServletRequest request) {
		
		int id_kladovshik = ((Kladovshik)request.getSession().getAttribute("kladovshik")).getId();
		Sklad sklad = new Sklad();
		sklad.setId(id);
		sklad.setBismt(bismt);
		sklad.setClose_kadr(close_kadr);
		sklad.setEdin(edin);
		sklad.setImports(imports);
		sklad.setIn_bd(in_bd);
		sklad.setIsdel(isdel);
		sklad.setKarta(karta);
		sklad.setKolvo(kolvo);
		sklad.setNaim(naim);
		sklad.setNaim2(naim2);
		sklad.setPrice(price);
		sklad.setSap_kod(sap_kod);
		sklad.setSklad_key(sklad_key);
		sklad.setStelach(stelach);
		sklad.setTesting(testing);
		sklad.setTolling(tolling);
		sklad.setUsed(used);
		sklad.setYatheika(yatheika);
		List<Kladovshik> list = new ArrayList<Kladovshik>();		
		list.add(kladovshikService.getById(id_kladovshik));
		sklad.setKladovshik( list);
		skladService.update(sklad);
		
		return  "redirect:/sklad/sklad_kladovschik/"+ id_kladovshik;// "redirect:"+request.getHeader("referer"); //";
	}
	
	@RequestMapping("/remove/{id}")
	public String remove(@PathVariable("id") int id, HttpServletRequest request){
		this.skladService.remove(id);
		return "redirect:" + request.getHeader("referer");
	}
	
	@RequestMapping(value = "/sklads", method = RequestMethod.GET)
	public String listSklad(Model model){
		model.addAttribute("sklad", new Sklad());
		model.addAttribute("listSklad", this.skladService.list());
		
		return "sklad/sklads";
	}
	
	@RequestMapping(value = "/sklad_kladovschik/{id}", method = RequestMethod.GET)
	public String sklad_kladovschik(@PathVariable("id") int id,Model model){
			model.addAttribute("kladovshik", new Kladovshik());
		Kladovshik kladocshik = this.kladovshikService.getById(id);
		model.addAttribute("listKladovschikSklad", this.kladovshikService.SkladBykladovshik(kladocshik.getId()));
		model.addAttribute("kladovshik", this.kladovshikService.getById(kladocshik.getId()));
		
		return "sklad/sklads";
	}
}

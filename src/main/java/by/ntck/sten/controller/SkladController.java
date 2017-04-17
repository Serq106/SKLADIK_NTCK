package by.ntck.sten.controller;

import java.util.ArrayList;
import java.util.Date;
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
import by.ntck.sten.model.HistoryOperation;
import by.ntck.sten.model.Kladovshik;
import by.ntck.sten.service.IHistoryOperationService;
import by.ntck.sten.service.IKladovshikService;
import by.ntck.sten.service.ISkladHService;
import by.ntck.sten.service.ISkladService;

@Controller
@RequestMapping("sklad")
public class SkladController {
	public static final Logger LOG = Logger.getLogger(SkladController.class);

	private ISkladService skladService;

	private ISkladHService skladHService;

	private IKladovshikService kladovshikService;

	private IHistoryOperationService historyOperationService;

	@Autowired(required = true)
	@Qualifier(value = "historyOperationService")
	public void setHistoryOperationService(IHistoryOperationService historyOperationService) {
		this.historyOperationService = historyOperationService;
	}

	@Autowired(required = true)
	@Qualifier(value = "kladovshikService")
	public void setKladovshikService(IKladovshikService kladovshikService) {
		this.kladovshikService = kladovshikService;
	}

	@Autowired(required = true)
	@Qualifier(value = "skladService")
	public void setSkladService(ISkladService skladService) {
		this.skladService = skladService;
	}

	@Autowired(required = true)
	@Qualifier(value = "skladHService")
	public void setSkladHService(ISkladHService skladHService) {
		this.skladHService = skladHService;
	}

	public void history(int id_historyOperation, String Dates, int Id_row, String TableName, String Operation,
			int id_kladovshik) {
		HistoryOperation historyOperation = new HistoryOperation();
		historyOperation.setId_historyOperation(id_historyOperation);
		historyOperation.setDate(Dates);
		historyOperation.setId_row(Id_row);
		historyOperation.setOperation(Operation);
		historyOperation.setTableName(TableName);
		historyOperation.setKladovshik(kladovshikService.getById(id_kladovshik));
		this.historyOperationService.add(historyOperation);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@RequestParam("id_sklad") int id_sklad, @RequestParam("bismt") String bismt,
			@RequestParam("close_kadr") String close_kadr, @RequestParam("edin") String edin,
			@RequestParam("imports") String imports, @RequestParam("in_bd") String in_bd,
			@RequestParam("isdel") String isdel, @RequestParam("karta") String karta, @RequestParam("naim") String naim,
			@RequestParam("naim2") String naim2, @RequestParam("price") String price,
			@RequestParam("sap_kod") String sap_kod, @RequestParam("sklad_key") int sklad_key,
			@RequestParam("stelach") String stelach, @RequestParam("testing") String testing,
			@RequestParam("tolling") String tolling, @RequestParam("used") String used,
			@RequestParam("yatheika") String yatheika, Model model, HttpServletRequest request) {

		int id_kladovshik = ((Kladovshik) request.getSession().getAttribute("kladovshik")).getId();
		Date currentDate = new Date();
		Sklad sklad = new Sklad();
		sklad.setId_sklad(id_sklad);
		sklad.setBismt(bismt);
		sklad.setClose_kadr(close_kadr);
		sklad.setEdin(edin);
		sklad.setImports(imports);
		sklad.setIn_bd(in_bd);
		sklad.setIsdel(isdel);
		sklad.setKarta(karta);
		sklad.setKolvo(0);
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
		sklad.setKladovshik(list);
		skladService.add(sklad);

		this.history(0, currentDate.toString(), sklad.getId_sklad(), "Sklad", "add", id_kladovshik);

		return "redirect:/sklad/sklad_kladovschik/" + id_kladovshik;
	}

	@RequestMapping(value = "/sklad_create")
	public String add(Model model, HttpServletRequest request) {
		model.addAttribute("sklad", new Sklad());
		int id_kladovshik = ((Kladovshik) request.getSession().getAttribute("kladovshik")).getId();
		model.addAttribute("id_klad", id_kladovshik);
		model.addAttribute("kladovshikList", kladovshikService.list());

		return "sklad/sklad_create";
	}

	@RequestMapping("/cklad_edit/{id_sklad}")
	public String edit(Model model, @PathVariable("id_sklad") int id_sklad, HttpServletRequest request) {
		model.addAttribute("findSklad", skladService.getById(id_sklad));
		int id_kladovshik = ((Kladovshik) request.getSession().getAttribute("kladovshik")).getId();
		model.addAttribute("id_klad", id_kladovshik);
		return "sklad/sklad_edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(@RequestParam("id_sklad") int id_sklad, @RequestParam("edin") String edin,
			/*@RequestParam("kolvo") float kolvo,*/ @RequestParam("naim") String naim, /*@RequestParam("price") String price,*/
			@RequestParam("used") String used, Model model, HttpServletRequest request) {

		int id_kladovshik = ((Kladovshik) request.getSession().getAttribute("kladovshik")).getId();
		Sklad sklad = skladService.getById(id_sklad);
		sklad.setId_sklad(id_sklad);
		sklad.setEdin(edin);
		sklad.setNaim(naim);
		sklad.setUsed(used);
		List<Kladovshik> list = new ArrayList<Kladovshik>();
		list.add(kladovshikService.getById(id_kladovshik));
		sklad.setKladovshik(list);
		skladService.update(sklad);

		Date currentDate = new Date();
		this.history(0, currentDate.toString(), id_sklad, "Sklad", "edit", id_kladovshik);

		return "redirect:/sklad/sklad_kladovschik/" + id_kladovshik;
	}

	@RequestMapping("/remove/{id_sklad}")
	public String remove(@PathVariable("id_sklad") int id_sklad, HttpServletRequest request, Model model) {

		Sklad sklad = skladService.getById(id_sklad);
		sklad.setIsdel("1");
		skladService.update(sklad);

		Date currentDate = new Date();
		int id_kladovshik = ((Kladovshik) request.getSession().getAttribute("kladovshik")).getId();
		this.history(0, currentDate.toString(), id_sklad, "Sklad", "remove", id_kladovshik);
		return "redirect:/sklad/sklad_kladovschik/" + id_kladovshik;
	}

	@RequestMapping(value = "/sklad_kladovschik/{id}", method = RequestMethod.GET)
	public String sklad_kladovschik(@PathVariable("id") int id, Model model, HttpServletRequest request) {

		Kladovshik kladocshik = this.kladovshikService.getById(id);
		model.addAttribute("listKladovschikSklad", this.kladovshikService.SkladBykladovshik(kladocshik.getId()));
		int id_kladovshik = ((Kladovshik) request.getSession().getAttribute("kladovshik")).getId();
		model.addAttribute("id_klad", id_kladovshik);
		model.addAttribute("role", this.kladovshikService.getRole(kladocshik.getId()));

		return "sklad/sklads";
	}
}

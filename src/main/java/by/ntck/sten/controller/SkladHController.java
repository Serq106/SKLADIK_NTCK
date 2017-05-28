package by.ntck.sten.controller;

import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Locale;

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
import by.ntck.sten.model.HistoryOperation;
import by.ntck.sten.model.Kladovshik;
import by.ntck.sten.model.Sklad;
import by.ntck.sten.model.SkladH;
import by.ntck.sten.service.IHistoryOperationService;
import by.ntck.sten.service.IKladovshikService;
import by.ntck.sten.service.ISkladHService;
import by.ntck.sten.service.ISkladService;

@Controller
@RequestMapping("skladH")
public class SkladHController {
	public static  final Logger LOG = Logger.getLogger(SkladHController.class);
	
	private ISkladService skladService;
	 
	private ISkladHService skladHService;	
	
	private IKladovshikService kladovshikService;	
	
	private IHistoryOperationService historyOperationService;
	
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
		
	@RequestMapping(value = "/skladsH/{id}")
	public String liStringSkladH(@PathVariable("id") int id ,Model model, HttpServletRequest request){
		int index = (int) request.getSession().getAttribute("view_edit");
		model.addAttribute("view_edit", index);
		model.addAttribute("skladsH", skladHService.skladHById(id));
		request.getSession().setAttribute("id_karta", id);
		model.addAttribute("id", id);
		Sklad sklad = skladService.getById(id);
		request.getSession().setAttribute("sklad", sklad);
		int id_kladovshik = ((Kladovshik) request.getSession().getAttribute("kladovshik")).getId();
		model.addAttribute("id_klad", id_kladovshik);
		Kladovshik kladocshik = this.kladovshikService.getById(id_kladovshik);
		model.addAttribute("role", this.kladovshikService.getRole(kladocshik.getId()));	
		return "skladH/skladsH";
	}
	
	@RequestMapping(value = "/skladH_in")
	public String in(Model model, HttpServletRequest request){
		model.addAttribute("skladH", new SkladH());

		return "skladH/skladH_create";
	}
	
	@RequestMapping(value = "/skladH_out")
	public String out(Model model, HttpServletRequest request){

		int sklad_id = ((Sklad)request.getSession().getAttribute("sklad")).getId_sklad();	
		model.addAttribute("skladHList", skladHService.skladHById(sklad_id));
		int id_kladovshik = ((Kladovshik)request.getSession().getAttribute("kladovshik")).getId();
		model.addAttribute("id_klad", id_kladovshik);	
		
		model.addAttribute("count", ""+ skladHService.Count(id_kladovshik, sklad_id));
		
		return "skladH/skladH_out";
	}
	
	public void history(int id_historyOperation, String Dates, int Id_row, String TableName,  String Operation,  int id_kladovshik, double kol_vo, double kol_vo_old, int id_sklad){
		HistoryOperation historyOperation = new HistoryOperation();
		historyOperation.setId_historyOperation(id_historyOperation);;
		historyOperation.setDate(Dates);
		historyOperation.setId_row(Id_row);
		historyOperation.setOperation(Operation);
		historyOperation.setTableName(TableName);		
		historyOperation.setKol_vo(kol_vo);
		historyOperation.setKol_vo_old(kol_vo_old);
		historyOperation.setId_sklad(id_sklad);
		historyOperation.setKladovshik(kladovshikService.getById(id_kladovshik));
		this.historyOperationService.add(historyOperation);			
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@RequestParam("id") int id, @RequestParam("operthiya") String operthiya, @RequestParam("kol_vo") float kol_vo,
			@RequestParam("data_oper") String data_oper, @RequestParam("ttn") String ttn, @RequestParam("postavhik") String postavhik,
			@RequestParam("data_zayavki") String data_zayavki, @RequestParam("data_ttn") String data_ttn, @RequestParam("kod_zatrat") String kod_zatrat,
			/*@RequestParam("naim") String naim,*/ @RequestParam("ttni") String ttni, @RequestParam("fio_zakazchika") String fio_zakazchika,
			@RequestParam("isdel") String isdel, @RequestParam("is_del") String is_del, @RequestParam("kol_vo_old") int kol_vo_old,
			@RequestParam("obrabotano") String obrabotano, @RequestParam("naim_doc") String naim_doc, @RequestParam("rep_in") String rep_in,
			@RequestParam("tab_nom_mol") String tab_nom_mol, @RequestParam("sklad_out_key") int sklad_out_key, @RequestParam("sklad_in_key") int sklad_in_key,
			@RequestParam("rep_status") int rep_status, @RequestParam("alt_edin") String alt_edin, @RequestParam("alt_kol_vo") float alt_kol_vo,
			@RequestParam("imports") String imports, @RequestParam("id_zayavka") int id_zayavka, @RequestParam("id_ord") int id_ord,			
			@RequestParam("real_data_oper") String real_data_oper, @RequestParam("link") int link, @RequestParam("master") String master,
			HttpServletRequest request, Model model){
		
		int sklad_id = ((Sklad)request.getSession().getAttribute("sklad")).getId_sklad();	
		String naim = ((Sklad)request.getSession().getAttribute("sklad")).getNaim();	 
		SkladH skladH = new SkladH();	
		skladH.setId(id);
		skladH.setOperthiya(operthiya);
		skladH.setKol_vo(kol_vo);
		skladH.setData_oper(data_oper);		
		skladH.setTtn(ttn);
		skladH.setPostavhik(postavhik);
		skladH.setData_zayavki(data_zayavki);
		skladH.setData_ttn(data_ttn);
		skladH.setKod_zatrat(kod_zatrat);
		skladH.setNaim(naim);
		skladH.setTtni(ttni);
		skladH.setFio_zakazchika(fio_zakazchika);
		skladH.setIsdel(isdel);
		skladH.setIs_del(is_del);
		skladH.setKol_vo_old(kol_vo);
		skladH.setObrabotano(obrabotano);
		skladH.setNaim_doc(naim_doc);
		skladH.setRep_in(rep_in);
		skladH.setTab_nom_mol(tab_nom_mol);
		skladH.setSklad_out_key(sklad_out_key);
		skladH.setSklad_in_key(sklad_in_key);
		skladH.setRep_status(rep_status);
		skladH.setAlt_edin(alt_edin);
		skladH.setAlt_kol_vo(alt_kol_vo);
		skladH.setImport_(imports);
		skladH.setId_zayavka(id_zayavka);
		skladH.setId_ord(id_ord);
		skladH.setReal_data_oper(real_data_oper);
		skladH.setLink(link);
		skladH.setMaster(master);
		skladH.setSklad(skladService.getById(sklad_id));
		skladHService.add(skladH);

		int id_kladovshik = ((Kladovshik)request.getSession().getAttribute("kladovshik")).getId();	
		double count = skladHService.Count(id_kladovshik, sklad_id);
		Sklad sklad = skladService.getById(sklad_id);
		sklad.setKolvo(count);
		skladService.update(sklad);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		model.addAttribute("id_klad", id_kladovshik);
		
		this.history(0, dateFormat.format( new Date() ), skladH.getId(), "SkladH", operthiya, id_kladovshik, count, 0, sklad_id );
		
		return "redirect:/skladH/skladsH/"+ sklad_id;
	}
	
	@RequestMapping("/remove/{id_sklad}")
	public String remove(@PathVariable("id_sklad") int id_sklad, HttpServletRequest request, Model model) {
		int id_karta = (int) request.getSession().getAttribute("id_karta");
		
		if(skladHService.getById(id_sklad).getLink() != 0) {
			SkladH skladH = skladHService.getById(skladHService.getById(id_sklad).getLink());
			skladH.setKol_vo(skladHService.getById(id_sklad).getKol_vo() + skladH.getKol_vo());
			skladHService.update(skladH);
			
		}
		skladHService.remove(id_sklad);
		
	
		return "redirect:/skladH/skladsH/" + id_karta;
	}
	
	@RequestMapping(value = "/adds", method = RequestMethod.GET)
	public String add(@RequestParam("id") int id, @RequestParam("kol_vo") float kol_vo, HttpServletRequest request, Model model,
			@RequestParam("fio_zakazchika") String fio_zakazchika, @RequestParam("tab_nom_mol") String tab_nom_mol){
		int id_kladovshik = ((Kladovshik)request.getSession().getAttribute("kladovshik")).getId();				
		int sklad_id = ((Sklad)request.getSession().getAttribute("sklad")).getId_sklad();	
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		List<SkladH> skladH_out = skladHService.Count_uzdel(0, sklad_id);
		SkladH skladH = new SkladH();
		int summa = 0;
		
		if(id != 0){
			SkladH skladH_ = skladHService.getById(id);
			double kol = skladH_.getKol_vo();
			if(kol > kol_vo){
				skladH_.setKol_vo(kol - kol_vo);
				skladHService.update(skladH_);
				skladH.setKol_vo(kol_vo);
				kol_vo = (float) (kol_vo - kol);
				
			} else if(kol < kol_vo){
				skladH_.setKol_vo(0);
				skladHService.update(skladH_);	
				kol_vo = (float) (kol_vo - kol);
				skladH.setKol_vo(kol);
			}
			
			
			this.history(0, dateFormat.format( new Date() ), skladH_.getId(), "SkladH", "out", id_kladovshik, skladH.getKol_vo(), kol_vo, sklad_id );
			
			skladH.setId(0);
			skladH.setOperthiya("out");			
			skladH.setData_oper(dateFormat.format( new Date() ));
			skladH.setSklad(skladService.getById(sklad_id));
			skladH.setLink(skladH_.getId());
			skladH.setNaim(skladH_.getNaim());
			skladH.setTtni(skladH_.getTtni());
			skladH.setFio_zakazchika(fio_zakazchika);
			skladH.setTab_nom_mol(tab_nom_mol);
			skladHService.add(skladH);
			double count = skladHService.Count(id_kladovshik, sklad_id);
			Sklad sklad = skladService.getById(sklad_id);
			sklad.setKolvo(count);
			skladService.update(sklad);	
			id = 0;
		}
		
		if(id == 0){
			for (SkladH skladH2 : skladH_out) {	
				if (kol_vo > 0 ){
					summa = (int) (kol_vo - skladH2.getKol_vo());
					if(summa > 0 && skladH2.getKol_vo() != 0){
						
						SkladH skladH_ = skladHService.getById(skladH2.getId());						
						skladH_.setKol_vo(0);
						skladHService.update(skladH_);
						
						this.history(0, dateFormat.format( new Date() ), skladH_.getId(), "SkladH", "out", id_kladovshik, skladH.getKol_vo(), skladH2.getKol_vo(), sklad_id );
						skladH.setKol_vo(skladH2.getKol_vo());
						double count = skladHService.Count(id_kladovshik, sklad_id);
						Sklad sklad = skladService.getById(sklad_id);
						sklad.setKolvo(count);
						skladService.update(sklad);	

					}else if (summa <= 0 && skladH2.getKol_vo() != 0 ){
						
						SkladH skladH_ = skladHService.getById(skladH2.getId());
						skladH_.setKol_vo(skladH2.getKol_vo() - kol_vo);
						skladHService.update(skladH_);	
						
						this.history(0, dateFormat.format( new Date() ), skladH_.getId(), "SkladH", "out", id_kladovshik, skladH.getKol_vo(), kol_vo, sklad_id );
						skladH.setKol_vo(kol_vo);
						double count = skladHService.Count(id_kladovshik, sklad_id);
						Sklad sklad = skladService.getById(sklad_id);
						sklad.setKolvo(count);
						skladService.update(sklad);	
					} 
					
					skladH.setId(0);
					skladH.setOperthiya("out");
					skladH.setData_oper(dateFormat.format( new Date() ));
					skladH.setSklad(skladService.getById(sklad_id));
					skladH.setLink(skladH2.getId());
					skladH.setNaim(skladH2.getNaim());
					skladH.setTtni(skladH2.getTtni());
					skladH.setFio_zakazchika(fio_zakazchika);
					skladH.setTab_nom_mol(tab_nom_mol);
					skladHService.add(skladH);
					
					kol_vo = summa;
			
				}
			}
		}
			
		
		return "redirect:/skladH/skladsH/"+ sklad_id;
	}

	@RequestMapping(value = "/skladH_report")
	public String report(Model model, HttpServletRequest request){
		int id = (int) request.getSession().getAttribute("id_karta");
		model.addAttribute("skladsH", skladHService.skladHById(id));
		
		int id_kladovshik = ((Kladovshik) request.getSession().getAttribute("kladovshik")).getId();
		model.addAttribute("id_klad", id_kladovshik);

		return "skladH/skladH_report";
	}
}



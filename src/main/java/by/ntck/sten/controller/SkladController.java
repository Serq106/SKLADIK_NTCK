package by.ntck.sten.controller;

import java.text.SimpleDateFormat;
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
import static by.ntck.sten.constant.Constants.DATE_FORMAT;

@Controller
@RequestMapping("sklad")
public class SkladController {
    private static final String ATTRIBUTE_KLADOVSHIK = "kladovshik";

    private static final int ACCESS_OPEN_FOR_ALL_0 = 0;

    public static final Logger LOG = Logger.getLogger(SkladController.class);

    private ISkladService skladService;

    private ISkladHService skladHService;

    private IKladovshikService kladovshikService;

    private IHistoryOperationService historyOperationService;

    @Autowired(required = true)
    @Qualifier(value = "historyOperationService")
    public void setHistoryOperationService(final IHistoryOperationService historyOperationService) {
        this.historyOperationService = historyOperationService;
    }

    @Autowired(required = true)
    @Qualifier(value = "kladovshikService")
    public void setKladovshikService(final IKladovshikService kladovshikService) {
        this.kladovshikService = kladovshikService;
    }

    @Autowired(required = true)
    @Qualifier(value = "skladService")
    public void setSkladService(final ISkladService skladService) {
        this.skladService = skladService;
    }

    @Autowired(required = true)
    @Qualifier(value = "skladHService")
    public void setSkladHService(final ISkladHService skladHService) {
        this.skladHService = skladHService;
    }

    public void history(final int idHistoryOperation, final String dates, final int idRow, final String tableName,
            final String operation, final int idKladovshik) {
        HistoryOperation historyOperation = new HistoryOperation();
        historyOperation.setId_historyOperation(idHistoryOperation);
        historyOperation.setDate(dates);
        historyOperation.setId_row(idRow);
        historyOperation.setOperation(operation);
        historyOperation.setTableName(tableName);
        historyOperation.setKladovshik(kladovshikService.getById(idKladovshik));
        this.historyOperationService.add(historyOperation);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestParam("id_sklad") final int id_sklad, @RequestParam("bismt") final String bismt,
            @RequestParam("close_kadr") final String close_kadr, @RequestParam("edin") final String edin,
            @RequestParam("imports") final String imports, @RequestParam("in_bd") final String in_bd,
            @RequestParam("isdel") final String isdel, @RequestParam("karta") final String karta, @RequestParam("naim") final String naim,
            @RequestParam("naim2") final String naim2, @RequestParam("price") final String price,
            @RequestParam("sap_kod") final String sap_kod, @RequestParam("sklad_key") final int sklad_key,
            @RequestParam("stelach") final String stelach, @RequestParam("testing") final String testing,
            @RequestParam("tolling") final String tolling, @RequestParam("used") final String used,
            @RequestParam("yatheika") final String yatheika, final Model model, final HttpServletRequest request) {

        int id_kladovshik = ((Kladovshik) request.getSession().getAttribute(ATTRIBUTE_KLADOVSHIK)).getId();
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

        this.history(0, DATE_FORMAT.format(new Date()), sklad.getId_sklad(), "Sklad", "add", id_kladovshik);

        return "redirect:/sklad/sklad_kladovschik/" + id_kladovshik;
    }

    @RequestMapping(value = "/sklad_create")
    public String add(final Model model, final HttpServletRequest request) {
        model.addAttribute("sklad", new Sklad());
        int id_kladovshik = ((Kladovshik) request.getSession().getAttribute(ATTRIBUTE_KLADOVSHIK)).getId();
        model.addAttribute("id_klad", id_kladovshik);
        model.addAttribute("kladovshikList", kladovshikService.list());

        return "sklad/sklad_create";
    }

    @RequestMapping("/cklad_edit/{id_sklad}")
    public String edit(final Model model, @PathVariable("id_sklad") final int id_sklad, final HttpServletRequest request) {
        model.addAttribute("findSklad", skladService.getById(id_sklad));
        int id_kladovshik = ((Kladovshik) request.getSession().getAttribute(ATTRIBUTE_KLADOVSHIK)).getId();
        model.addAttribute("id_klad", id_kladovshik);
        return "sklad/sklad_edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@RequestParam("id_sklad") final int id_sklad, @RequestParam("edin") final String edin,
            @RequestParam("naim") final String naim, @RequestParam("used") final String used,
            final Model model, final HttpServletRequest request) {

        int id_kladovshik = ((Kladovshik) request.getSession().getAttribute(ATTRIBUTE_KLADOVSHIK)).getId();
        Sklad sklad = skladService.getById(id_sklad);
        sklad.setId_sklad(id_sklad);
        sklad.setEdin(edin);
        sklad.setNaim(naim);
        sklad.setUsed(used);
        List<Kladovshik> list = new ArrayList<Kladovshik>();
        list.add(kladovshikService.getById(id_kladovshik));
        sklad.setKladovshik(list);
        skladService.update(sklad);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        this.history(0, DATE_FORMAT.format(new Date()), id_sklad, "Sklad", "edit", id_kladovshik);
        int index = (int) request.getSession().getAttribute("view_edit");
        if (index != 0) {
            return "redirect:/sklad/sklad_kladovschik/" + id_kladovshik;
        } else {
            return "redirect:/sklad/view_edit";
        }
    }

    @RequestMapping("/remove/{id_sklad}")
    public String remove(@PathVariable("id_sklad") final int id_sklad, final HttpServletRequest request,
            final Model model) {

        Sklad sklad = skladService.getById(id_sklad);
        sklad.setIsdel("1");
        skladService.update(sklad);
        int index = (int) request.getSession().getAttribute("view_edit");
        Date currentDate = new Date();
        int id_kladovshik = ((Kladovshik) request.getSession().getAttribute(ATTRIBUTE_KLADOVSHIK)).getId();
        this.history(0, currentDate.toString(), id_sklad, "Sklad", "remove", id_kladovshik);
        if (index != 0) {
            return "redirect:/sklad/sklad_kladovschik/" + id_kladovshik;
        } else {
            return "redirect:/sklad/view_edit";
        }
    }

    @RequestMapping(value = "/sklad_kladovschik/{id}", method = RequestMethod.GET)
    public String sklad_kladovschik(@PathVariable("id") final int id, final Model model,
            final HttpServletRequest request) {

        Kladovshik kladocshik = this.kladovshikService.getById(id);
        model.addAttribute("listKladovschikSklad", this.kladovshikService.SkladBykladovshik(kladocshik.getId()));
        int id_kladovshik = ((Kladovshik) request.getSession().getAttribute(ATTRIBUTE_KLADOVSHIK)).getId();
        model.addAttribute("id_klad", id_kladovshik);
        request.getSession().setAttribute("view_edit", 1);
        int view_edit = ((int) request.getSession().getAttribute("view_edit"));
        model.addAttribute("view_edit", view_edit);
        model.addAttribute("role", this.kladovshikService.getRole(kladocshik.getId()));

        return "sklad/sklads";
    }

    @RequestMapping(value = "/search/{id}", method = RequestMethod.GET)
    public String search(@PathVariable("id") final int id, @RequestParam("naim") final String naim,
            final Model model, final HttpServletRequest request) {
        request.getSession().setAttribute("view_edit", ACCESS_OPEN_FOR_ALL_0);
        Kladovshik kladocshik = this.kladovshikService.getById(id);
        int index = (int) request.getSession().getAttribute("view_edit");
        model.addAttribute("listKladovschikSklad", this.kladovshikService.SkladBykladovshikSearch(id, index, naim));
        int id_kladovshik = ((Kladovshik) request.getSession().getAttribute(ATTRIBUTE_KLADOVSHIK)).getId();
        int view_edit = ((int) request.getSession().getAttribute("view_edit"));
        model.addAttribute("view_edit", view_edit);
        model.addAttribute("id_klad", id_kladovshik);
        model.addAttribute("role", this.kladovshikService.getRole(kladocshik.getId()));

        return "sklad/sklads";

    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view(final Model model, final HttpServletRequest request) {
        model.addAttribute("listSklads", this.skladService.list());
        return "sklad/view";
    }

    @RequestMapping(value = "/view_edit", method = RequestMethod.GET)
    public String view_edit(final Model model, final HttpServletRequest request) {
        request.getSession().setAttribute("view_edit", 0);
        model.addAttribute("listKladovschikSklad", this.skladService.list());
        int id_kladovshik = ((Kladovshik) request.getSession().getAttribute(ATTRIBUTE_KLADOVSHIK)).getId();
        Kladovshik kladocshik = this.kladovshikService.getById(id_kladovshik);
        model.addAttribute("view_edit", 0);
        model.addAttribute("id_klad", id_kladovshik);
        model.addAttribute("role", this.kladovshikService.getRole(kladocshik.getId()));

        return "sklad/sklads";
    }
}

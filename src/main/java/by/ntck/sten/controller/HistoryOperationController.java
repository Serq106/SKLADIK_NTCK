package by.ntck.sten.controller;

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

import by.ntck.sten.service.IHistoryOperationService;

@Controller
@RequestMapping("historyOperation")
public class HistoryOperationController {
    public static final Logger LOG = Logger.getLogger(HistoryOperationController.class);

    private IHistoryOperationService historyOperationService;

    @Autowired(required = true)
    @Qualifier(value = "historyOperationService")
    public void setHistoryOperationService(final IHistoryOperationService historyOperationService) {
        this.historyOperationService = historyOperationService;
    }

    @RequestMapping(value = "/historyOperation/{id}")
    public String history(@PathVariable("id") final int id, final Model model) {
        model.addAttribute("listHistory", this.historyOperationService.HistoryOperationById(id));
        return "historyOperation/historyOperations";
    }

    @RequestMapping(value = "/historyOperations", method = RequestMethod.GET)
    public String listHistoryOperation(final Model model) {
        model.addAttribute("historyOperation", new HistoryOperation());
        model.addAttribute("listHistory", this.historyOperationService.list());
        return "historyOperation/historyOperations";
    }

    @RequestMapping(value = "/historyOperation_create")
    public String add(final Model model) {
        model.addAttribute("historyOperation", new HistoryOperation());
        return "historyOperation/historyOperation_create";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(@RequestParam("id") final int id_historyOperation, @RequestParam("date") final String Dates,
            @RequestParam("id_row") final int Id_row, @RequestParam("tableName") final String TableName,
            @RequestParam("operation") final String Operation, final Model model, final HttpServletRequest request) {
        HistoryOperation historyOperation = new HistoryOperation();
        historyOperation.setDate(Dates);
        historyOperation.setId_historyOperation(id_historyOperation);
        historyOperation.setId_row(Id_row);
        historyOperation.setTableName(TableName);
        historyOperation.setOperation(Operation);
        this.historyOperationService.add(historyOperation);

    }

}

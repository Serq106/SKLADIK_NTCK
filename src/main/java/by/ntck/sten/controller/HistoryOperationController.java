package by.ntck.sten.controller;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import by.ntck.sten.service.IHistoryOperation;

@Controller
@RequestMapping("HistoryOperation")
public class HistoryOperationController {
	public static  final Logger LOG = Logger.getLogger(KladovshikController.class);
	
	private IHistoryOperation historyOperationService;
	
	@Autowired(required = true)
	@Qualifier(value = "historyOperationService")
	public void setHistoryOperationService(IHistoryOperation historyOperationService) {
		this.historyOperationService = historyOperationService;
	}
	

}

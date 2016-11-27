package by.ntck.sten.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.web.bind.annotation.RequestParam;

import by.ntck.sten.model.HistoryOperation;
import by.ntck.sten.model.Kladovshik;
import by.ntck.sten.service.IHistoryOperationService;
import by.ntck.sten.service.IKladovshikService;

public class History {
	
	private IHistoryOperationService historyOperationService;
	
	private IKladovshikService kladovshikService;
	
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


}

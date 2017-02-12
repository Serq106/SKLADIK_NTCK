package by.ntck.sten.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

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

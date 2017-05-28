package by.ntck.sten.dao;

import java.util.List;

import by.ntck.sten.model.HistoryOperation;
import by.ntck.sten.model.SkladH;


public interface IHistoryOperationDao extends IDAO<HistoryOperation> {
	
	public List<HistoryOperation> HistoryOperationById(int id);
}

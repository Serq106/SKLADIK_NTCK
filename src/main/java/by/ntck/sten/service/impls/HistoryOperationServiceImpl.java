package by.ntck.sten.service.impls;

import java.util.List;

import by.ntck.sten.dao.IHistoryOperationDao;
import by.ntck.sten.model.HistoryOperation;
import by.ntck.sten.service.IHistoryOperation;

public class HistoryOperationServiceImpl implements IHistoryOperation {
	private IHistoryOperationDao daoHistoryOperation;
	
	public void setDaoHistoryOperation(IHistoryOperationDao daoHistoryOperation) {
		this.daoHistoryOperation = daoHistoryOperation;
	}

	@Override
	public void add(HistoryOperation historyOperation) {
		this.daoHistoryOperation.add(historyOperation);		
	}

	@Override
	public void update(HistoryOperation historyOperation) {
		this.daoHistoryOperation.update(historyOperation);		
	}

	@Override
	public void remove(int id) {
		this.daoHistoryOperation.remove(id);
		
	}

	@Override
	public HistoryOperation getById(int id) {
		return this.daoHistoryOperation.getById(id);
	}

	@Override
	public List<HistoryOperation> list() {
		return this.daoHistoryOperation.list();
	}

}

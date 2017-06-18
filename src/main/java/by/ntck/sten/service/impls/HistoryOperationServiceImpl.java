package by.ntck.sten.service.impls;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.ntck.sten.dao.IHistoryOperationDao;
import by.ntck.sten.model.HistoryOperation;
import by.ntck.sten.service.IHistoryOperationService;

@Service
@Transactional
public class HistoryOperationServiceImpl implements IHistoryOperationService {
    private IHistoryOperationDao daoHistoryOperation;

    public void setDaoHistoryOperation(final IHistoryOperationDao dao) {
        this.daoHistoryOperation = dao;
    }

    @Override
    public void add(final HistoryOperation historyOperation) {
        this.daoHistoryOperation.add(historyOperation);
    }

    @Override
    public void update(final HistoryOperation historyOperation) {
        this.daoHistoryOperation.update(historyOperation);
    }

    @Override
    public void remove(final int id) {
        this.daoHistoryOperation.remove(id);

    }

    @Override
    public HistoryOperation getById(final int id) {
        return this.daoHistoryOperation.getById(id);
    }

    @Override
    public List<HistoryOperation> list() {
        return this.daoHistoryOperation.list();
    }

    @Override
    public List<HistoryOperation> HistoryOperationById(final int id) {
        return this.daoHistoryOperation.HistoryOperationById(id);
    }

}

package by.ntck.sten.dao;

import java.util.List;

import by.ntck.sten.model.HistoryOperation;

public interface IHistoryOperationDao extends IDAO<HistoryOperation> {

    public List<HistoryOperation> HistoryOperationById(int id);
}

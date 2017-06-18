package by.ntck.sten.service;

import java.util.List;

import by.ntck.sten.model.HistoryOperation;

public interface IHistoryOperationService extends IService<HistoryOperation> {

    public List<HistoryOperation> HistoryOperationById(int id);

}

package by.ntck.sten.dao.impls;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import by.ntck.sten.dao.IHistoryOperationDao;
import by.ntck.sten.model.HistoryOperation;

@Repository
public class HistoryOperationDaoImpl implements IHistoryOperationDao {
	private static final Logger LOG = LoggerFactory.getLogger(HistoryOperationDaoImpl.class);
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(HistoryOperation historyOperation) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(historyOperation);
		LOG.info("historyOperation successfully saved. historyOperation details: " + historyOperation);		
	}

	@Override
	public void update(HistoryOperation historyOperation) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(historyOperation);
	}

	@Override
	public void remove(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		HistoryOperation historyOperation = (HistoryOperation) session.load(HistoryOperation.class, new Integer(id));
		
		if (historyOperation != null){
			session.delete(historyOperation);
		}
		LOG.info("Sklad successfully removed. Sklad details: " + historyOperation);
	
	}

	@Override
	public HistoryOperation getById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		HistoryOperation historyOperation = (HistoryOperation) session.load(HistoryOperation.class, new Integer(id));

		LOG.info("Sklad successfully loaded. Sklad detalis: " + historyOperation);
		return historyOperation;
	}

	@Override
	public List<HistoryOperation> list() {
		Session session = this.sessionFactory.getCurrentSession();
		List<HistoryOperation> historyOperationList = (List<HistoryOperation>) session.createQuery("from HistoryOperation").list();
		
		for(HistoryOperation historyOperation : historyOperationList ){
			LOG.info("historyOperation list: " + historyOperation);
		}
		return historyOperationList;
	}
}

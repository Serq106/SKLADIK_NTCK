package by.ntck.sten.dao.impls;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import by.ntck.sten.dao.ISkladDao;
import by.ntck.sten.model.Kladovshik;
import by.ntck.sten.model.Sklad;

@Repository
public class SkladDaoImpl implements ISkladDao {
	private static final Logger LOG = LoggerFactory.getLogger(SkladDaoImpl.class);
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(Sklad sklad) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(sklad);
		LOG.info("Sklad successfully saved. Sklad details: " + sklad);		
	}

	@Override
	public void update(Sklad sklad) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(sklad);
		LOG.info("Sklad successfully update. Sklad details: " + sklad);		
	}

	@Override
	public void remove(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Sklad sklad = (Sklad) session.load(Sklad.class, new Integer(id));
		
		if (sklad != null){
			session.delete(sklad);
		}
		LOG.info("Sklad successfully removed. Sklad details: " + sklad);
	}

	@Override
	public Sklad getById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Sklad sklad = (Sklad) session.load(Sklad.class, new Integer(id));
		
		LOG.info("Sklad successfully loaded. Sklad detalis: " + sklad);
		return sklad;
	}

	@Override
	public List<Sklad> list() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Sklad> skladList = (List<Sklad>) session.createQuery("from Sklad").list();
		
		for(Sklad sklad : skladList){
			LOG.info("Sklad list: " + sklad);
		}
		return skladList;
	}
}

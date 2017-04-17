package by.ntck.sten.dao.impls;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import by.ntck.sten.dao.ISkladHDao;
import by.ntck.sten.model.Kladovshik;
import by.ntck.sten.model.Sklad;
import by.ntck.sten.model.SkladH;

@Repository
public class SkladHDaoImpl implements ISkladHDao  {
	private static final Logger LOG = LoggerFactory.getLogger(SkladHDaoImpl.class);
	
	private SessionFactory sessionFactory;
				
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(SkladH skladH) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(skladH);
		LOG.info("skladH successfully saved. skladH details: " + skladH);		
	}

	@Override
	public void update(SkladH skladH) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(skladH);
		LOG.info("skladH successfully update. skladH details: " + skladH);		

	}

	@Override
	public void remove(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		SkladH skladH = (SkladH) session.load(SkladH.class, new Integer(id));
		
		if (skladH != null){
			session.delete(skladH);
		}
		LOG.info("skladH successfully removed. skladH details: " + skladH);

	}

	@Override
	public SkladH getById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		SkladH skladH = (SkladH) session.load(SkladH.class, new Integer(id));
		LOG.info("SkladH successfully loaded. SkladH detalis: " + skladH);

		return skladH;
	}

	@Override
	public List<SkladH> list() {
		Session session = this.sessionFactory.getCurrentSession();
		List<SkladH> skladHList = (List<SkladH>) session.createQuery("from SkladH").list();
		
		for(SkladH skladH : skladHList){
			LOG.info("Sklad list: " + skladH);
		}
		return skladHList;
	}

	@Override
	public List<SkladH> skladHById(int sklad_id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<SkladH> skladHList = (List<SkladH>) session.createQuery(
				"from SkladH as skladH where skladH.sklad = '" + sklad_id + "'").list();
		
		LOG.info("skladHById successfully loaded. skladHById detalis: ");

		return skladHList;
	}

	@Override
	public SkladH Kol(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		SkladH sklad = (SkladH) session.createQuery("from SkladH as skladH where skladH.id='" + id  + "'").getSingleResult();
		return sklad;

	}

	@Override
	public Double Count(int id_klad, int id_sklad) {
	Session session = this.sessionFactory.getCurrentSession();
		Double count = (Double) session.createNativeQuery(
				"SELECT sum(kol_vo) FROM sklad s INNER JOIN SkladH sh ON (sh.id_sklad = s.id_sklad) "+
				" INNER JOIN sklad_sk sk ON (sk.sklad_id =s.id_sklad)"+
				" INNER JOIN sklad_kladovshik k ON (k.id = sk.kladovshik_id)"+
				" WHERE sh.operthiya='in' AND k.id='" + id_klad  + "' AND sh.id_sklad = '" + id_sklad  + "'")
				.getSingleResult();
		return count;
	}

	@Override
	public List<SkladH> Count_uzdel(int id_klad, int id_sklad) { 
		Session session = this.sessionFactory.getCurrentSession();
		
		List<SkladH> skladHList = (List<SkladH>) session.createQuery(
				"from SkladH as skladH where skladH.operthiya='in' and skladH.sklad = '" + id_sklad + "'").list();
		
		return skladHList;	
	}
}
	
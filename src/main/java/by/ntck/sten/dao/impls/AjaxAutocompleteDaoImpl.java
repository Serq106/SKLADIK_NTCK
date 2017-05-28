package by.ntck.sten.dao.impls;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import by.ntck.sten.dao.IAjaxAutocompleteDao;
import by.ntck.sten.model.SkladH;

@Repository
public class AjaxAutocompleteDaoImpl implements IAjaxAutocompleteDao {
	private static final Logger LOG = LoggerFactory.getLogger(AjaxAutocompleteDaoImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Set<String> getAutocompleteDocByType(String docType) {
		Session session = this.sessionFactory.getCurrentSession();
		List<SkladH> skladHList = (List<SkladH>) session.createQuery(
				"from SkladH as skladH where skladH.ttni LIKE '%" + docType + "%'").list();
		//.ttni LIKE %" + docType + "% "
		Set<String> ttniList = new HashSet();
		for (SkladH ttni : skladHList) {
			ttniList.add(ttni.getTtni());
			LOG.info(ttni.toString());
		}

		return ttniList;

	}

}

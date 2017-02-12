package by.ntck.sten.dao.impls;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import by.ntck.sten.dao.IKladovshikDao;
import by.ntck.sten.model.Kladovshik;
import by.ntck.sten.model.Sklad;
import by.ntck.sten.model.User;

import static by.ntck.sten.constant.Constants.*;

@Repository
public class KladovshikDaoImpl implements IKladovshikDao {
	private static final Logger LOG = LoggerFactory.getLogger(KladovshikDaoImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(Kladovshik kladovshik) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(kladovshik);
		LOG.info("Book successfully saved. Book details: " + kladovshik);
	}

	@Override
	public void update(Kladovshik kladovshik) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(kladovshik);
		LOG.info("Book successfully update. Book details: " + kladovshik);
	}

	@Override
	public void remove(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Kladovshik kladovshik = (Kladovshik) session.load(Kladovshik.class, new Integer(id));

		if (kladovshik != null) {
			session.delete(kladovshik);
		}
		LOG.info("Book successfully removed. Book details: " + kladovshik);
	}

	@Override
	public Kladovshik getById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Kladovshik kladovshik = (Kladovshik) session.load(Kladovshik.class, new Integer(id));
		if (kladovshik == null) {
			return EMPTY_KLADOVSHIK;
		}
		LOG.info("Book successfully loaded. Book detalis: " + kladovshik);
		return kladovshik;
	}

	@Override
	public List<Kladovshik> list() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Kladovshik> kladovshikList = (List<Kladovshik>) session.createQuery("from Kladovshik").list();
		for (Kladovshik kladovshik : kladovshikList) {
			LOG.info("Kladovshik list: " + kladovshik);
		}
		return kladovshikList;
	}

	@Override
	public Kladovshik login(String login, String password) {
		Session session = this.sessionFactory.getCurrentSession();

		List<Kladovshik> kladovshiks = (List<Kladovshik>) session
				.createQuery("from Kladovshik as kladovshik where kladovshik.login='" + login
						+ "' and kladovshik.password ='" + password + "'")
				.list();

		if (kladovshiks.size() == 0) {
			return EMPTY_KLADOVSHIK;
		} else {
			return kladovshiks.get(0);
		}

	}

	@Override
	public List<Kladovshik> kladovshikBySklad(int id_sklad) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session
				.createQuery(
						" select k " + " from Kladovshik k INNER JOIN k.sklad sklad" + " where sklad.id = :skladId ")
				.setLong("skladId", id_sklad);

		List<Kladovshik> kladovshikList = q.list();
		LOG.info("kladovshikBySklad successfully loaded. kladovshikBySklad detalis: ");
		return kladovshikList;
	}

	@Override
	public List<Sklad> SkladBykladovshik(int id_kladovshok) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("select s " + " from Sklad s INNER JOIN s.kladovshik kladovshik"
				+ " where kladovshik.id = :kladovshikId ").setLong("kladovshikId", id_kladovshok);
		List<Sklad> SkladList = q.list();
		LOG.info("kladovshikBySklad successfully loaded. kladovshikBySklad detalis: ");

		return SkladList;
	}

	@Override
	public String getRole(int id) {
		Session session = this.sessionFactory.getCurrentSession();

		Query q = session.createQuery("select u " + " from User u INNER JOIN u.kladovshik kladovshik"
				+ " where kladovshik.id = :kladovshikId ").setLong("kladovshikId", id);
		List<User> userList = q.list();
		
		if (userList != null) {
			int department_id = userList.get(0).getDepartment_id();

			switch (department_id) {
			case ADMINISTRATOR:
				return ROLE_ADMINISTRATOR;
			case KLADOVSHIK:
				return ROLE_KLADOVSHIK;
			default:
				return EMPTY_ROLE;
			}

		}
		return EMPTY_ROLE;

	}
}
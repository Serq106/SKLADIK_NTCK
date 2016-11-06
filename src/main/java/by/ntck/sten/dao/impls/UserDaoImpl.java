package by.ntck.sten.dao.impls;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import by.ntck.sten.dao.IDAO;
import by.ntck.sten.dao.IUserDao;
import by.ntck.sten.model.User;

@Repository
public class UserDaoImpl implements IUserDao {
	private static final Logger LOG = LoggerFactory.getLogger(UserDaoImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(user);
		LOG.info("Book successfully saved. Book details: " + user);

	}

	@Override
	public void update(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(user);
		LOG.info("Book successfully update. Book details: " + user);

	}

	@Override
	public void remove(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) session.load(User.class, new Integer(id));

		if (user != null) {
			session.delete(user);
		}
		LOG.info("Book successfully removed. Book details: " + user);

	}

	@Override
	public User getById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) session.load(User.class, new Integer(id));

		LOG.info("Book successfully loaded. Book detalis: " + user);
		return user;
	}

	@Override
	public List<User> list() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> userList = (List<User>) session.createQuery("from User").list();

		for (User user : userList) {
			LOG.info("Book list: " + user);
		} //

		return userList;
	}

}

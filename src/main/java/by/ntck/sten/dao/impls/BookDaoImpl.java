package by.ntck.sten.dao.impls;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import by.ntck.sten.dao.IBookDao;
import by.ntck.sten.model.Book;

@Repository
public class BookDaoImpl implements IBookDao {
	private static final Logger LOG = LoggerFactory.getLogger(BookDaoImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addBook(Book book) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(book);
		LOG.info("Book successfully saved. Book details: " + book);
	}

	@Override
	public void updateBook(Book book) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(book);
		LOG.info("Book successfully update. Book details: " + book);
	}

	@Override
	public void removeBook(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Book book = (Book) session.load(Book.class, new Integer(id));

		if (book != null) {
			session.delete(book);
		}
		LOG.info("Book successfully removed. Book details: " + book);
	}

	@Override
	public Book getBookById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Book book = (Book) session.load(Book.class, new Integer(id));

		LOG.info("Book successfully loaded. Book detalis: " + book);
		return book;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Book> listBooks() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Book> bookList = (List<Book>) session.createQuery("from Book").list();

		for (Book book : bookList) {
			LOG.info("Book list: " + book);
		}
		return bookList;
	}
}
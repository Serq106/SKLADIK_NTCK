package by.ntck.sten.service.impls;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.ntck.sten.dao.IBookDao;
import by.ntck.sten.model.Book;
import by.ntck.sten.service.IBookService;

@Service
@Transactional
public class BookServiceImpl implements IBookService {
	private IBookDao dao;

	public void setDao(IBookDao bookDao) {
		this.dao = bookDao;
	}

	@Override
	public void addBook(Book book) {
		this.dao.addBook(book);
	}

	@Override
	public void updateBook(Book book) {
		this.dao.updateBook(book);
	}

	@Override
	public void removeBook(int id) {
		this.dao.removeBook(id);
	}

	@Override
	public Book getBookById(int id) {
		return this.dao.getBookById(id);
	}

	@Override
	public List<Book> listBooks() {

		return this.dao.listBooks();
	}
}
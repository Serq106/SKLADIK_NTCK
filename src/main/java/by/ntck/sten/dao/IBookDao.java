package by.ntck.sten.dao;

import java.util.List;

import by.ntck.sten.model.Book;

public interface IBookDao {
	public void addBook(Book book);

	public void updateBook(Book book);

	public void removeBook(int id);

	public Book getBookById(int id);

	public List<Book> listBooks();
}

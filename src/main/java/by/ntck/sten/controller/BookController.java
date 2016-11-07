package by.ntck.sten.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import by.ntck.sten.model.Book;
import by.ntck.sten.service.IBookService;

@Controller
@RequestMapping("book")
public class BookController {
	private IBookService bookService;

	@Autowired(required = true)
	@Qualifier(value = "bookService")
	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String listBooks(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("listBooks", this.bookService.listBooks());

		return "book/books";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addBook_(@RequestParam("bookTitle") String bookTitle, @RequestParam("bookAuthor") String bookAuthor, @RequestParam("price") int price, @RequestParam("id") int id) {
		Book book = new Book();
		book.setBookAuthor(bookAuthor);
		book.setBookTitle(bookTitle);
		book.setPrice(price);
		book.setId(id);
		bookService.addBook(book);
		return "redirect:/book/books";
	}

	@RequestMapping(value = "/book_create")
	public String add(Model model) {
		model.addAttribute("book", new Book());

		return "book/book_create";
	}

	@RequestMapping("/remove/{id}")
	public String removeBook(@PathVariable("id") int id, HttpServletRequest request) {
		this.bookService.removeBook(id);
		return "redirect:" + request.getHeader("referer");
	}

	@RequestMapping("/book_edit/{id}")
	public String edit(Model model, @PathVariable("id") int id, HttpServletRequest request) {
		model.addAttribute("book", new Book());
		model.addAttribute("findBook", bookService.getBookById(id));

		return "book/book_edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editBook(@RequestParam("bookTitle") String bookTitle, @RequestParam("bookAuthor") String bookAuthor, @RequestParam("price") int price, @RequestParam("id") int id) {
		Book book = new Book();
		book.setBookAuthor(bookAuthor);
		book.setBookTitle(bookTitle);
		book.setPrice(price);
		book.setId(id);
		bookService.updateBook(book);
		return "redirect:/book/books";
	}

	@RequestMapping(value = "/bookdata/{id}")
	public String bookData(Model model, @PathVariable("id") int id, HttpServletRequest request) {
		model.addAttribute("book", new Book());
		model.addAttribute("findBook", bookService.getBookById(id));

		return "book/bookdata";
	}
}
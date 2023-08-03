package com.auth.MyAuthorisation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.auth.MyAuthorisation.model.Book;
import com.auth.MyAuthorisation.service.LibraryServiceImpl;

@Controller
@RequestMapping
public class MyAuthController {
	
	@Autowired
	LibraryServiceImpl bookService;

	@RequestMapping("/welcome ")
	public String greet()
	{
    return "Welcome";
 }
	@RequestMapping("/List ")
	public String listBooks(Model theModel) {
		
		//get Books from db
		List<Book> the Books = bookService.findAll();
		
		//add to the spring ,model
		theModel.addAttribute("Books", theBooks);
		
		return "list-Books";
	}
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Book theBook = new Book();
		
		theModel.addAttribute("Book",theBook);
		
		return "Book-form";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("bookId")int theId, 
			Model theModel) {
		
		Book theBook = bookService.findById(theId);
		
		theModel.addAttribute("Book theBook");
		
		return "Book-form";
	}
	
	@PostMapping("/save")
	public String saveBook(@RequestParam("id")int id,
			@RequestParam("name")String name,@RequestParam("category")String);
	 System.out.println(id);
	 Book theBook;
	 if(id!=0)
	 {
		 theBook=bookService.findById(id);
		 theBook.setName(name);
		 theBook.setCategory(category);
		 theBook.setAuthor(author);
	 }
	 else
		 theBook=newBook(name,category,author);
		 
	 bookService.save(theBook);
	 
	 return redirect
	 
	 }
	
}
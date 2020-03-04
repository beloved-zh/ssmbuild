package com.zh.controller;

import com.zh.pojo.Books;
import com.zh.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    //controller 调 service层
    @Autowired
    @Qualifier("bookService")
    private BookService bookService;

    @RequestMapping("/allBook")
    public String allBook(Model model){

        List<Books> list = bookService.findAll();

        model.addAttribute("list",list);

        return "allBook";
    }

    @RequestMapping("/toAddBook")
    public String toAddBook(){

        return "addBook";
    }


    @RequestMapping("/addBook")
    public String addBook(Books books){

        bookService.addBook(books);

        //添加完成后重定向到查询全部的请求
        return "redirect:/book/allBook";
    }

    @RequestMapping("/del/{id}")
    public String del(@PathVariable("id") int id){

        bookService.deleteBookById(id);

        return "redirect:/book/allBook";
    }

    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(int id,Model model){

        Books books = bookService.findById(id);

        model.addAttribute("book",books);

        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Books books){

        bookService.updateBook(books);

        return "redirect:/book/allBook";
    }

    @RequestMapping("/findByName")
    public String findByName(String bookName,Model model){

        List<Books> list = bookService.findByName(bookName);

        System.out.println("list=================="+list);

        if (list.size() == 0){

            System.out.println("list空");

            list = bookService.findAll();

            model.addAttribute("msg","没有此书籍");
        }

        model.addAttribute("list",list);

        return "allBook";
    }
}


































































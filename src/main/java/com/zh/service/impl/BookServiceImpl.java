package com.zh.service.impl;

import com.zh.mapper.BookMapper;
import com.zh.pojo.Books;
import com.zh.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService{

    //调用dao层的操作，设置一个set接口，方便Spring管理
    private BookMapper bookMapper;
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    @Override
    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    @Override
    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    @Override
    public Books findById(int id) {
        return bookMapper.findById(id);
    }

    @Override
    public List<Books> findAll() {
        return bookMapper.findAll();
    }

    @Override
    public List<Books> findByName(String name) {
        return bookMapper.findByName(name);
    }
}

package com.zh.service;

import com.zh.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {

    //增加一本书
    int addBook(Books books);

    //删除
    int deleteBookById(int id);

    //修改
    int updateBook(Books books);

    //查询
    Books findById(int id);

    List<Books> findAll();


    List<Books> findByName(String name);

}

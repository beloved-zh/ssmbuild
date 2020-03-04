package com.zh.mapper;

import com.zh.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {

    //增加一本书
    int addBook(Books books);

    //删除
    int deleteBookById(@Param("id") int id);

    //修改
    int updateBook(Books books);

    //查询
    Books findById(@Param("id") int id);

    List<Books> findAll();

    //查询
    List<Books> findByName(@Param("name") String name);
}

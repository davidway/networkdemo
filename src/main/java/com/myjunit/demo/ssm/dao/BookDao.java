package com.myjunit.demo.ssm.dao;


import com.myjunit.demo.ssm.dto.BookDto;
import com.myjunit.demo.ssm.entity.Book;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookDao {
    /**
     * 通过ID查询单本图书
     *
     * @param id
     * @return
     */
    Book queryById(long id);

    /**
     * 查询所有图书
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return
     */
    List<Book> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 减少馆藏数量
     *
     * @param bookId
     * @return 如果影响行数等于>1，表示更新的记录行数
     */
    int reduceNumber(long bookId);

    List<Book> queryAll(@Param("bookDto") BookDto bookDto);
}

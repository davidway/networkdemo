package com.myjunit.demo.ssm.service.impl;


import com.myjunit.demo.BaseTest;
import com.myjunit.demo.ssm.dto.AppointExecution;
import com.myjunit.demo.ssm.service.BookService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BookServiceImplTest extends BaseTest {

    @Autowired
    private BookService bookService;

    @Test
    public void testAppoint() throws Exception {
        long bookId = 1001;
        long studentId = 12345678910L;
        AppointExecution execution = bookService.appoint(bookId, studentId);
        System.out.println(execution);
    }

}
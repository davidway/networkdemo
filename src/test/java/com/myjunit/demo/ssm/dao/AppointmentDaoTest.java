package com.myjunit.demo.ssm.dao;

import com.myjunit.demo.ssm.entity.Appointment;
import org.junit.Test;
import com.myjunit.demo.BaseTest;

import javax.annotation.Resource;

public class AppointmentDaoTest extends BaseTest {


    @Resource
    private AppointmentDao appointmentDao;

    @Test
    public void testInsertAppointment() throws Exception {
        long bookId = 1000;
        long studentId = 12345678910L;
        int insert = appointmentDao.insertAppointment(bookId, studentId);
        System.out.println("insert=" + insert);
    }

    @Test
    public void testQueryByKeyWithBook() throws Exception {
        long bookId = 1000;
        long studentId = 12345678910L;
        Appointment appointment = appointmentDao.queryByKeyWithBook(bookId, studentId);
        System.out.println(appointment);
        System.out.println(appointment.getBook());
    }

}
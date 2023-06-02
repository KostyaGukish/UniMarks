package org.example.service;

import org.example.dao.DaoException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class LoginServiceTest {

    LoginService service = new LoginService();
    @Test
    void getPassword() throws Exception {
        String slogin = "s45";
        String tlogin = "t15";
        String spassword = "0000";
        String tpassword = "1111";
        Assert.assertEquals(service.getPassword(slogin), spassword);
        Assert.assertEquals(service.getPassword(tlogin), tpassword);
    }

    @Test
    void isStudent() throws Exception {
        for (int i = 1; i <= 50; i++) {
            StringBuilder slogin = new StringBuilder("s");
            slogin.append(i);
            StringBuilder tlogin = new StringBuilder("t");
            tlogin.append(i);
            Assert.assertTrue(service.isStudent(slogin.toString()));
            Assert.assertTrue(!service.isStudent(tlogin.toString()));
        }
    }

    @Test
    void getStudentId() throws Exception {
        for (int i = 1; i <= 50; i++) {
            StringBuilder slogin = new StringBuilder("s");
            slogin.append(i);
            StringBuilder tlogin = new StringBuilder("t");
            tlogin.append(i);
            Assert.assertEquals(service.getStudentId(slogin.toString()), i);
            Assert.assertEquals(service.getStudentId(tlogin.toString()), 0);
        }
    }

    @Test
    void getTeacherId() throws Exception {
        for (int i = 1; i <= 50; i++) {
            StringBuilder slogin = new StringBuilder("s");
            slogin.append(i);
            StringBuilder tlogin = new StringBuilder("t");
            tlogin.append(i);
            Assert.assertEquals(service.getTeacherId(slogin.toString()), 0);
            Assert.assertEquals(service.getTeacherId(tlogin.toString()), i);
        }
    }

    @Test
    void getName() {
    }
}
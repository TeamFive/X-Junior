package com.exadel.xjunior;

import DAO.BaseDAO;
import DAO.Impl.MarksDAOImpl;
import entity.Marks;
import exceptions.EntityException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import service.MarksService;

import java.util.Date;

/**
 * Created by aancipov on 8/8/2014.
 */
public class MarksTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("d:\\GitHub\\X-Junior\\X-Junior-rest\\src\\main\\webapp\\WEB-INF\\classes\\applicationContext.xml");

        BaseDAO marksDAO = (BaseDAO) applicationContext.getBean("marksDAOImpl");

        try {
            Marks marks = new Marks("hello", "10.10.2014", null, null);

            marksDAO.add(new Marks());
        } catch (EntityException e) {
            e.printStackTrace();
        }


    }


}

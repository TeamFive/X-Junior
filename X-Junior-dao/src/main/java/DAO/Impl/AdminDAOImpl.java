package DAO.Impl;

import entity.Admin;
import org.hibernate.ejb.EntityManagerFactoryImpl;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;

@Repository
public class AdminDAOImpl extends BaseDAOImpl<Admin> {
    public AdminDAOImpl() {
        super(Admin.class);
    }

    public AdminDAOImpl(Class<Admin> type) {
        super(type);
    }
}

package DAO.Impl;

import entity.Admin;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDAOImpl extends BaseDAOImpl<Admin> {
    public AdminDAOImpl() {
        super(Admin.class);
    }

    public AdminDAOImpl(Class<Admin> type) {
        super(type);
    }
}

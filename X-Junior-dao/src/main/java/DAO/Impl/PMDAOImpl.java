package DAO.Impl;

import entity.PM;
import org.springframework.stereotype.Repository;

@Repository
public class PMDAOImpl extends BaseDAOImpl<PM> {
    public PMDAOImpl() {
        super(PM.class);
    }

    public PMDAOImpl(Class<PM> type) {
        super(type);
    }
}

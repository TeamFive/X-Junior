package DAO.Impl;

import entity.HR;
import org.springframework.stereotype.Repository;

@Repository
public class HRDAOImpl extends BaseDAOImpl<HR> {
    public HRDAOImpl() {
        super(HR.class);
    }

    public HRDAOImpl(Class<HR> type) {
        super(type);
    }
}

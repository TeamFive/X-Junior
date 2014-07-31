package DAO.Impl;

import entity.TechnologyStudentNow;
import org.springframework.stereotype.Repository;

@Repository
public class TechnologyStudentNowDAOImpl extends BaseDAOImpl<TechnologyStudentNow> {
    public TechnologyStudentNowDAOImpl() {
        super(TechnologyStudentNow.class);
    }

    public TechnologyStudentNowDAOImpl(Class<TechnologyStudentNow> type) {
        super(type);
    }
}

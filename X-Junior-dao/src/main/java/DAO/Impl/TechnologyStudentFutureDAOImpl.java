package DAO.Impl;

import entity.TechnologyStudentFuture;
import org.springframework.stereotype.Repository;

@Repository
public class TechnologyStudentFutureDAOImpl extends BaseDAOImpl<TechnologyStudentFuture> {
    public TechnologyStudentFutureDAOImpl() {
        super(TechnologyStudentFuture.class);
    }

    public TechnologyStudentFutureDAOImpl(Class<TechnologyStudentFuture> type) {
        super(type);
    }
}

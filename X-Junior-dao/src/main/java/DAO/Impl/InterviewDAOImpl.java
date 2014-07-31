package DAO.Impl;

import entity.Interview;
import org.springframework.stereotype.Repository;

@Repository
public class InterviewDAOImpl extends BaseDAOImpl<Interview> {
    public InterviewDAOImpl() {
        super(Interview.class);
    }

    public InterviewDAOImpl(Class<Interview> type) {
        super(type);
    }
}

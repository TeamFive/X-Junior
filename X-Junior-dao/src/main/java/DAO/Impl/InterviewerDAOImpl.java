package DAO.Impl;

import entity.Interviewer;
import org.springframework.stereotype.Repository;

@Repository
public class InterviewerDAOImpl extends BaseDAOImpl<Interviewer> {
    public InterviewerDAOImpl() {
        super(Interviewer.class);
    }

    public InterviewerDAOImpl(Class<Interviewer> type) {
        super(type);
    }
}

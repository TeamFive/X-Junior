package DAO.Impl;

import entity.Feedback;
import org.springframework.stereotype.Repository;

@Repository
public class FeedbackDAOImpl extends BaseDAOImpl<Feedback> {
    public FeedbackDAOImpl() {
        super(Feedback.class);
    }

    public FeedbackDAOImpl(Class<Feedback> type) {
        super(type);
    }
}

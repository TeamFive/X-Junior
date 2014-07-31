package DAO.Impl;

import entity.Marks;
import org.springframework.stereotype.Repository;

@Repository
public class MarksDAOImpl extends BaseDAOImpl<Marks> {
    public MarksDAOImpl() {
        super(Marks.class);
    }

    public MarksDAOImpl(Class<Marks> type) {
        super(type);
    }
}

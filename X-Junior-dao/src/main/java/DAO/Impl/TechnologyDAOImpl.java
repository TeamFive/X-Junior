package DAO.Impl;

import entity.Technology;
import org.springframework.stereotype.Repository;

@Repository
public class TechnologyDAOImpl extends BaseDAOImpl<Technology> {
    public TechnologyDAOImpl() {
        super(Technology.class);
    }

    public TechnologyDAOImpl(Class<Technology> type) {
        super(type);
    }
}

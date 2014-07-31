package DAO.Impl;

import entity.University;
import org.springframework.stereotype.Repository;

@Repository
public class UniversityDAOImpl extends BaseDAOImpl<University> {
    public UniversityDAOImpl() {
        super(University.class);
    }

    public UniversityDAOImpl(Class<University> type) {
        super(type);
    }
}

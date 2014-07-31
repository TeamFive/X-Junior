package DAO.Impl;

import entity.StudentProject;
import org.springframework.stereotype.Repository;

@Repository
public class StudentProjectDAOImpl extends BaseDAOImpl<StudentProject> {
    public StudentProjectDAOImpl() {
        super(StudentProject.class);
    }

    public StudentProjectDAOImpl(Class<StudentProject> type) {
        super(type);
    }
}

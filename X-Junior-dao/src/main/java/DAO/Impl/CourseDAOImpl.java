package DAO.Impl;

import entity.Course;
import org.springframework.stereotype.Repository;

@Repository
public class CourseDAOImpl extends BaseDAOImpl<Course> {
    public CourseDAOImpl() {
        super(Course.class);
    }

    public CourseDAOImpl(Class<Course> type) {
        super(type);
    }
}

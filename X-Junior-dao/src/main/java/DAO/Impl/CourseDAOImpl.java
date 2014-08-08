package DAO.Impl;

import entity.Course;
import entity.Faculty;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Repository
public class CourseDAOImpl extends BaseDAOImpl<Course> {
    public CourseDAOImpl() {
        super(Course.class);
    }

    public CourseDAOImpl(Class<Course> type) {
        super(type);
    }

    public String createCourse(Course course, long faculty_id){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JaneList");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Faculty faculty = entityManager.find(Faculty.class, faculty_id);
        course.setFaculty(faculty);

        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();

        return "success";
    }
}

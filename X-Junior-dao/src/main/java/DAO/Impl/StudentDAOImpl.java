package DAO.Impl;

import entity.Student;
import entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Repository
public class StudentDAOImpl extends BaseDAOImpl<Student> {
    public StudentDAOImpl() {
        super(Student.class);
    }

    public StudentDAOImpl(Class<Student> type) {
        super(type);
    }

    public Student getStudent(long id){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JaneList");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Student student = entityManager.find(Student.class, id);
        return student;
    }

    public String createStudent(Student student, Long studentId){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JaneList");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Student student1;

        if(studentId != null){
            student1 = entityManager.find(Student.class, studentId);
            if(student.getChangeHoursDate() != null)
                student1.setChangeHoursDate(student.getChangeHoursDate());
            if(student.getStartedWorkDate() != null)
                student1.setStartedWorkDate(student.getStartedWorkDate());
            if(student.isHadProbation() != student1.isHadProbation())
                student1.setHadProbation(student.isHadProbation());
            if(student.getStartAtCourse() != student1.getStartAtCourse())
                student1.setStartAtCourse(student.getStartAtCourse());
            if(student.getWantedWorkHours() != student1.getWantedWorkHours())
                student1.setWantedWorkHours(student.getWantedWorkHours());
            if(student.getEnglishLevel() != null)
                student1.setEnglishLevel(student.getEnglishLevel());
            if(student.getWantedCourses() != null)
                student1.setWantedCourses(student.getWantedCourses());
            if(student.getPhoneNumber() != null)
                student1.setPhoneNumber(student.getPhoneNumber());
            if(student.getSkype() != null)
                student1.setSkype(student.getSkype());
            if(student.isWantEnglishTraining() != student1.isWantEnglishTraining() )
                student1.setWantEnglishTraining(student.isWantEnglishTraining());
            if(student.getCurrentEnglishTraining() != null)
                student1.setCurrentEnglishTraining(student.getCurrentEnglishTraining());

            entityManager.getTransaction().begin();
            entityManager.merge(student1);
            entityManager.getTransaction().commit();

            return "success";

        }

        entityManager.getTransaction().begin();
        entityManager.merge(student);
        entityManager.getTransaction().commit();

        return "success";

    }

    public List<Student> getStudents(){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JaneList");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return null;
    }
}

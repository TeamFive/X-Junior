package DAO.Impl;

import entity.BaseEntity;
import com.google.gson.Gson;
import entity.Certificate;
import entity.Student;
import entity.User;
import exceptions.EntityException;
import org.hibernate.ejb.criteria.ExpressionImplementor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.util.ArrayList;
import java.util.Iterator;
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

    public Student createStudent(Student student, Long studentId){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JaneList");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Student student1;
        Gson gson = new Gson();
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
            if(student.getCertificateList().size() != 0) {
                for(int i = 0; i < student.getCertificateList().size(); i++){
                    int tmp = 0;
                    for(int j = 0; j < student1.getCertificateList().size(); j++){
                        if(student1.getCertificateList().get(j).getName().equals(student.getCertificateList().get(i).getName()))
                            tmp++;
                    }
                    if(tmp == 0)
                        student1.getCertificateList().add(student.getCertificateList().get(i));
                }
            }




            entityManager.getTransaction().begin();
            entityManager.merge(student1);
            entityManager.getTransaction().commit();

            return student1;

        }


        entityManager.getTransaction().begin();
        entityManager.merge(student);
        entityManager.getTransaction().commit();

        return null;

    }

    public List<Student> getListByName(String name){
        Logger logger = LoggerFactory.getLogger(this.getClass());


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JaneList");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createNamedQuery("findAllStudentsByName");
        query.setParameter("name", name);
        List<Student> resultList = query.getResultList();

        logger.info("Find " + resultList.getClass());
        return resultList;
    }

    public List<Student> getStudentsByFilter(String str) throws ParseException {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JaneList");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> query = builder.createQuery(Student.class);
        Root<Student> cust = query.from(Student.class);
        query.select(cust);

        List<Predicate> predicateList = new ArrayList<Predicate>();

        Predicate curPredicate;


        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(str);
        String curParam = new String();


        if(jsonObject.get("started_work_date") != null) {
            curParam = jsonObject.get("started_work_date").toString();
            curPredicate = builder.like(builder.upper(cust.<String>get("startedWorkDate")), "%"+curParam+"%");
            predicateList.add(curPredicate);
        }
        if(jsonObject.get("had_probation") != null) {
            curParam = jsonObject.get("had_probation").toString();
            curPredicate = builder.equal(builder.upper(cust.<String>get("hadProbation")),Boolean.parseBoolean(curParam));
            predicateList.add(curPredicate);
        }
        if(jsonObject.get("start_at_course") != null) {
            curParam = jsonObject.get("start_at_course").toString();
            curPredicate = builder.like(builder.upper(cust.<String>get("startedWorkDate")), "%"+curParam+"%");
            predicateList.add(curPredicate);
        }
        if(jsonObject.get("wanted_work_hours") != null) {
            curParam = jsonObject.get("wanted_work_hours").toString();
            curPredicate = builder.like(builder.upper(cust.<String>get("startedWorkDate")), "%"+curParam+"%");
            predicateList.add(curPredicate);
        }
        if(jsonObject.get("change_hours_date") != null) {
            curParam = jsonObject.get("change_hours_date").toString();
            curPredicate = builder.like(builder.upper(cust.<String>get("startedWorkDate")), "%"+curParam+"%");
            predicateList.add(curPredicate);
        }
        if(jsonObject.get("english_level") != null) {
            curParam = jsonObject.get("english_level").toString();
            curPredicate = builder.like(builder.upper(cust.<String>get("startedWorkDate")), "%"+curParam+"%");
            predicateList.add(curPredicate);
        }
        if(jsonObject.get("wanted_courses") != null) {
            curParam = jsonObject.get("wanted_courses").toString();
            curPredicate = builder.like(builder.upper(cust.<String>get("startedWorkDate")), "%"+curParam+"%");
            predicateList.add(curPredicate);
        }
        if(jsonObject.get("phone_number") != null) {
            curParam = jsonObject.get("phone_number").toString();
            curPredicate = builder.like(builder.upper(cust.<String>get("startedWorkDate")), "%"+curParam+"%");
            predicateList.add(curPredicate);
        }
        if(jsonObject.get("skype") != null) {
            curParam = jsonObject.get("skype").toString();
            curPredicate = builder.like(builder.upper(cust.<String>get("startedWorkDate")), "%"+curParam+"%");
            predicateList.add(curPredicate);
        }
        if(jsonObject.get("want_english_training") != null) {
            curParam = jsonObject.get("want_english_training").toString();
            curPredicate = builder.like(builder.upper(cust.<String>get("startedWorkDate")), "%"+curParam+"%");
            predicateList.add(curPredicate);
        }
        if(jsonObject.get("current_english_training") != null) {
            curParam = jsonObject.get("current_english_training").toString();
            curPredicate = builder.like(builder.upper(cust.<String>get("startedWorkDate")), "%"+curParam+"%");
            predicateList.add(curPredicate);
        }

        Predicate[] predicates = new Predicate[predicateList.size()];
        predicateList.toArray(predicates);
        query.where(predicates);

        return entityManager.createQuery(query).getResultList();
    }
}

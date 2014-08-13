package DAO.Impl;

import DAO.BaseDAO;
import com.google.gson.Gson;
import entity.Certificate;
import entity.Student;
import exceptions.EntityException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.persistence.criteria.*;
import javax.swing.plaf.ListUI;
import java.util.*;

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

    public Student createStudent(Student student, Long studentId) throws EntityException {

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

                Query query = entityManager.createQuery("from " + Certificate.class.getName());
                List<Certificate> databaseCert = query.getResultList();

                for(int i = 0; i < student.getCertificateList().size(); i++){
                    if(!databaseCert.contains(student.getCertificateList().get(i))){
                        student1.getCertificateList().add(student.getCertificateList().get(i));
                    } else if(!student1.getCertificateList().contains(student.getCertificateList().get(i))){
                        int tmp = databaseCert.indexOf(student.getCertificateList().get(i));
                        student1.getCertificateList().add(databaseCert.get(tmp));
                    }
                }

            }
//            if(student.getTechnologyStudentNowList().size() != 0){
//
//            }




            entityManager.getTransaction().begin();
            entityManager.merge(student1);
            entityManager.getTransaction().commit();

            return student1;

        }


        entityManager.getTransaction().begin();
        entityManager.merge(student);
        entityManager.getTransaction().commit();


        List<Student> students = getListByName(student.getUser().getName());


        return students.get(0);

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

    public String getStudentsByFilter(String str) throws ParseException {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JaneList");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> query = builder.createQuery(Student.class);
        Root<Student> studentRoot = query.from(Student.class);
        query.select(studentRoot);

        List<Predicate> predicateList = new ArrayList<Predicate>();

        Predicate curPredicate;


        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(str);
        String curParam = new String();

        if(jsonObject.get("name") != null) {
            curParam = jsonObject.get("name").toString();
            curPredicate = builder.like(builder.upper(studentRoot.<String>get("user").<String>get("name")), "%"+curParam+"%");
            predicateList.add(curPredicate);
        }

        if(jsonObject.get("started_work_date") != null) {
            curParam = jsonObject.get("started_work_date").toString();
            curPredicate = builder.like(builder.upper(studentRoot.<String>get("startedWorkDate")), "%"+curParam+"%");
            predicateList.add(curPredicate);
        }
        if(jsonObject.get("had_probation") != null) {
            curParam = jsonObject.get("had_probation").toString();
            curPredicate = builder.equal(builder.upper(studentRoot.<String>get("hadProbation")), Boolean.parseBoolean(curParam));
            predicateList.add(curPredicate);
        }
        if(jsonObject.get("start_at_course") != null) {
            curParam = jsonObject.get("start_at_course").toString();
            curPredicate = builder.like(builder.upper(studentRoot.<String>get("startAtCourse")), "%"+curParam+"%");
            predicateList.add(curPredicate);
        }
        if(jsonObject.get("wanted_work_hours") != null) {
            curParam = jsonObject.get("wanted_work_hours").toString();
            curPredicate = builder.like(builder.upper(studentRoot.<String>get("wantedWorkHours")), "%"+curParam+"%");
            predicateList.add(curPredicate);
        }
        if(jsonObject.get("change_hours_date") != null) {
            curParam = jsonObject.get("change_hours_date").toString();
            curPredicate = builder.like(builder.upper(studentRoot.<String>get("changeHoursDate")), "%"+curParam+"%");
            predicateList.add(curPredicate);
        }
        if(jsonObject.get("english_level") != null) {
            curParam = jsonObject.get("english_level").toString();
            curPredicate = builder.like(builder.upper(studentRoot.<String>get("englishLevel")), "%"+curParam+"%");
            predicateList.add(curPredicate);
        }
        if(jsonObject.get("wanted_courses") != null) {
            curParam = jsonObject.get("wanted_courses").toString();
            curPredicate = builder.like(builder.upper(studentRoot.<String>get("wantedCourses")), "%"+curParam+"%");
            predicateList.add(curPredicate);
        }
        if(jsonObject.get("phone_number") != null) {
            curParam = jsonObject.get("phone_number").toString();
            curPredicate = builder.like(builder.upper(studentRoot.<String>get("phoneNumber")), "%"+curParam+"%");
            predicateList.add(curPredicate);
        }
        if(jsonObject.get("skype") != null) {
            curParam = jsonObject.get("skype").toString();
            curPredicate = builder.like(builder.upper(studentRoot.<String>get("skype")), "%"+curParam+"%");
            predicateList.add(curPredicate);
        }
        if(jsonObject.get("want_english_training") != null) {
            curParam = jsonObject.get("want_english_training").toString();
            curPredicate = builder.equal(builder.upper(studentRoot.<String>get("wantEnglishTraining")), Boolean.parseBoolean(curParam));
            predicateList.add(curPredicate);
        }
        if(jsonObject.get("current_english_training") != null) {
            curParam = jsonObject.get("current_english_training").toString();
            curPredicate = builder.like(builder.upper(studentRoot.<String>get("currentEnglishTraining")), "%"+curParam+"%");
            predicateList.add(curPredicate);
        }

        Predicate[] predicates = new Predicate[predicateList.size()];
        predicateList.toArray(predicates);
        query.where(predicates);

        List<Student> students = entityManager.createQuery(query).getResultList();

        boolean isFirstArrayItem = true;
        JSONObject jsonItem = null;
        JSONArray jsonArray = new JSONArray();

        if (students.isEmpty()){
            return "[]";
        } else {
            for (Student item : students){
                jsonItem = new JSONObject();

                jsonItem.put("id", item.getId());

                if(jsonObject.get("name") != null) {
                    jsonItem.put("name", item.getUser().getName());
                }
                if(jsonObject.get("started_work_date") != null) {
                    jsonItem.put("started_work_date", item.getStartedWorkDate());
                }
                if(jsonObject.get("had_probation") != null) {
                    jsonItem.put("had_probation", item.isHadProbation());
                }
                if(jsonObject.get("start_at_course") != null) {
                    jsonItem.put("start_at_course", item.getStartAtCourse());
                }
                if(jsonObject.get("wanted_work_hours") != null) {
                    jsonItem.put("wanted_work_hours", item.getWantedWorkHours());
                }
                if(jsonObject.get("change_hours_date") != null) {
                    jsonItem.put("change_hours_date", item.getChangeHoursDate());
                }
                if(jsonObject.get("english_level") != null) {
                    jsonItem.put("english_level", item.getEnglishLevel());
                }
                if(jsonObject.get("wanted_courses") != null) {
                    jsonItem.put("wanted_courses", item.getWantedCourses());
                }
                if(jsonObject.get("phone_number") != null) {
                    jsonItem.put("phone_number", item.getPhoneNumber());
                }
                if(jsonObject.get("skype") != null) {
                    jsonItem.put("skype", item.getSkype());
                }
                if(jsonObject.get("want_english_training") != null) {
                    jsonItem.put("want_english_training", item.isWantEnglishTraining());
                }
                if(jsonObject.get("current_english_training") != null) {
                    jsonItem.put("current_english_training", item.getCurrentEnglishTraining());
                }
                jsonArray.add(jsonItem);
            }
        }
        return jsonArray.toString();
    }
}

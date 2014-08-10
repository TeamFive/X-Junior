package controller;

import DAO.BaseDAO;
import DAO.Impl.*;
import entity.*;
import exceptions.EntityException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Locale;

public class EntityChooserTest {

    public String choseEntity(String entity, String json) throws ParseException, EntityException{
        JSONParser jsonParser = new JSONParser();
        Object object = jsonParser.parse(json);
        JSONObject jsonObject = (JSONObject) object;
        if(entity.equalsIgnoreCase("marks")){
            MarksDAOImpl marksDAO = new MarksDAOImpl();

            return marksDAO.addMark(Long.parseLong(jsonObject.get("group_id").toString()),
                    (Long.parseLong(jsonObject.get("student_id").toString())),
                    jsonObject.get("mark").toString(),
                    jsonObject.get("date").toString());
        }

        if(entity.equalsIgnoreCase("feedback")){
            Feedback feedback = new Feedback();
            feedback.setDate(jsonObject.get("date").toString());  //String
            feedback.setExtra(jsonObject.get("extra").toString());  //String
            feedback.setIncreaseHours(Boolean.parseBoolean(jsonObject.get("increase_hours").toString()));  //Boolean
            feedback.setPeopleRelation(Integer.parseInt(jsonObject.get("people_relation").toString()));    //int
            feedback.setProffSuitab(Integer.parseInt(jsonObject.get("proff_suitab").toString()));          //int
            feedback.setRealProject(jsonObject.get("real_project").toString());     //String
            feedback.setWorkAttitude(Integer.parseInt(jsonObject.get("work_attitude").toString()));   //int

            FeedbackDAOImpl feedbackDAO = new FeedbackDAOImpl();
            return feedbackDAO.createFeedback(feedback,
                    Long.parseLong(jsonObject.get("curator_id").toString()),
                    Long.parseLong(jsonObject.get("student_id").toString()));
        }
        if(entity.equalsIgnoreCase("curator")){

            User user = new User(jsonObject.get("name").toString(),
                    jsonObject.get("email").toString());
            Curator curator = new Curator(user);
            CuratorDAOImpl curatorDAO = new CuratorDAOImpl();
            return curatorDAO.saveCurator(curator);
        }
        if(entity.equalsIgnoreCase("hr")){
            User user = new User(jsonObject.get("name").toString(),
                    jsonObject.get("email").toString());
            HR hr = new HR(user);
            HRDAOImpl hrDAO = new HRDAOImpl();
            return hrDAO.saveHr(hr);
        }
        if(entity.equalsIgnoreCase("admin")){
            User user = new User(jsonObject.get("name").toString(),
                    jsonObject.get("email").toString());
            AdminDAOImpl adminDAO = new AdminDAOImpl();
            Admin admin = new Admin(user);
            return adminDAO.createAdmin(admin);
        }
        if(entity.equalsIgnoreCase("certificate")){
            Certificate certificate = new Certificate(
                    jsonObject.get("certificate_name").toString(),
                    jsonObject.get("date").toString());
            CertificateDAOImpl certificateDAO = new CertificateDAOImpl();
            return certificateDAO.createCertificate(certificate);
        }
        if(entity.equalsIgnoreCase("course")){
            Course course = new Course();
            course.setName(jsonObject.get("course_name").toString());
            CourseDAOImpl courseDAO = new CourseDAOImpl();

            return courseDAO.createCourse(course, Long.parseLong(jsonObject.get("faculty_id").toString()));
        }
        if(entity.equalsIgnoreCase("customfield")){
            CustomField customField = new CustomField();
            customField.setName(jsonObject.get("customfield_name").toString());
            customField.setDefaultValue(jsonObject.get("default_value").toString());
            customField.setFieldType(jsonObject.get("field_type").toString());

            CustomFieldDAOImpl customFieldDAO = new CustomFieldDAOImpl();

            return customFieldDAO.createCustomField(customField,
                    Long.parseLong(jsonObject.get("fieldsgroup_id").toString()));
        }
        if(entity.equalsIgnoreCase("faculty")){
            Faculty faculty = new Faculty();
            faculty.setName(jsonObject.get("faculty_name").toString());

            FacultyDAOImpl facultyDAO = new FacultyDAOImpl();

            return facultyDAO.createFaculty(faculty, Long.parseLong(jsonObject.get("university_id").toString()));
        }
        if(entity.equalsIgnoreCase("group")){
            Group group = new Group();
            group.setName(jsonObject.get("group_name").toString());

            GroupDAOImpl groupDAO = new GroupDAOImpl();

            return groupDAO.createGroup(group, Long.parseLong(jsonObject.get("course_id").toString()));
        }
        if(entity.equalsIgnoreCase("interview")){
            Interview interview = new Interview();
            interview.setDescription(jsonObject.get("description").toString());
            interview.setResults(jsonObject.get("results").toString());

            InterviewDAOImpl interviewDAO = new InterviewDAOImpl();

            return interviewDAO.createInterview(interview, Long.parseLong(jsonObject.get("student_id").toString()),
                    Long.parseLong(jsonObject.get("hr_id").toString()), Long.parseLong(jsonObject.get("interviewer_id").toString()));
        }
        if(entity.equalsIgnoreCase("interviewer")){
            Interviewer interviewer = new Interviewer();
            interviewer = new Interviewer(new User(jsonObject.get("name").toString(),
                    jsonObject.get("email").toString()));

            InterviewerDAOImpl interviewerDAO = new InterviewerDAOImpl();
            return interviewerDAO.createInterviewer(interviewer);
        }


        return null;
    }

}

//Ready GROUP,

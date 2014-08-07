package controller;

import DAO.BaseDAO;
import DAO.Impl.BaseDAOImpl;
import DAO.Impl.CuratorDAOImpl;
import DAO.Impl.GroupDAOImpl;
import DAO.Impl.StudentDAOImpl;
import com.google.gson.Gson;
import entity.*;
import exceptions.EntityException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.BaseService;
import service.Impl.CuratorServiceImpl;
import service.Impl.StudentServiceImpl;

/**
 * Created by Administrator on 05.08.2014.
 */

//TODO feedback, interview, marks, studentCertificate, studentCustomField, studentGroup, studentProject, technologyStudentNow, technologyStudentFuture
@Component
public class EntityChooser {


    private Admin admin;
    private Certificate certificate;
    private Course course;
    private Curator curator;
    private CustomField customField;
    private Faculty faculty;
    private Feedback feedback;
    private FieldsGroup fieldsGroup;
    private Group group;
    private HR hr;
    private Interview interview;
    private Interviewer interviewer;
    private Marks marks;
    private PM pm;
    private Project project;
    private Setting setting;
    private Student student;
    private StudentCertificate studentCertificate;
    private StudentCustomField studentCustomField;
    private StudentGroup studentGroup;
    private StudentProject studentProject;
    private TeamLeader teamLeader;
    private Technology technology;
    private TechnologyStudentFuture technologyStudentFuture;
    private TechnologyStudentNow technologyStudentNow;
    private University university;
    private User user;


    JSONParser jsonParser;



    public BaseEntity choseEntity(String entity, String json) throws ParseException {
        Gson gson = new Gson();
        if(entity.equalsIgnoreCase("admin")){
            jsonParser = new JSONParser();
            Object object = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) object;
            user = new User();
            JSONObject jsonUser = (JSONObject) jsonObject.get("user");
            user.setName(jsonUser.get("name").toString());
            user.setEmail(jsonUser.get("email").toString());
            user.setPassword(jsonUser.get("password").toString());
            admin = new Admin(user);
            return admin;
        } else

        if(entity.equalsIgnoreCase("certificate")){
            Object object = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) object;
            certificate = new Certificate(jsonObject.get("certificate_name").toString(), jsonObject.get("date").toString());
            return certificate;
        }else
        if(entity.equalsIgnoreCase("curator")){
            curator = new Curator();
            curator.setUser(gson.fromJson(json, User.class));
            curator.getUser().setPassword("11111");
            return curator;
        }else
        if(entity.equalsIgnoreCase("customfield")){
            jsonParser = new JSONParser();
            Object object = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) object;
            JSONObject jsonFieldsGroup = (JSONObject) jsonObject.get("fieldsgroup");
            fieldsGroup = new FieldsGroup(jsonFieldsGroup.get("name").toString());
            customField = new CustomField(jsonObject.get("custom_field_name").toString(), jsonObject.get("default_value").toString(), fieldsGroup, jsonObject.get("field_type").toString());
            return customField;
        }else
        if(entity.equalsIgnoreCase("faculty")){
            jsonParser = new JSONParser();
            Object object = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) object;
            JSONObject jsonUniversity = (JSONObject) jsonObject.get("university");
            university = new University(jsonUniversity.get("university_name").toString());
            faculty = new Faculty(jsonObject.get("name").toString(), university);
            return faculty;
        }else
        if(entity.equalsIgnoreCase("feedback")){
            jsonParser = new JSONParser();
            Object object = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) object;
            StudentDAOImpl studentDAO = new StudentDAOImpl();
            CuratorDAOImpl curatorDAO = new CuratorDAOImpl();
            student = studentDAO.getStudent(Long.parseLong(jsonObject.get("student_id").toString()));
            curator = curatorDAO.getCurator(Long.parseLong(jsonObject.get("curator_id").toString()));
            feedback = new Feedback(Integer.parseInt(jsonObject.get("peopleRelation").toString()), Integer.parseInt(jsonObject.get("workAttitude").toString()),
            Boolean.parseBoolean(jsonObject.get("increaseHours").toString()), jsonObject.get("realProject").toString(), jsonObject.get("extra").toString(),
                    jsonObject.get("date").toString(), Integer.parseInt(jsonObject.get("proffSuitab").toString()),
                    curator, student);
            return feedback;
        }else
        if(entity.equalsIgnoreCase("fieldsgroup")){
            jsonParser = new JSONParser();
            Object object = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) object;
            fieldsGroup = new FieldsGroup(jsonObject.get("name").toString());
            return fieldsGroup;
        }else
        if(entity.equalsIgnoreCase("group")){
            jsonParser = new JSONParser();
            Object object = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) object;
            JSONObject jsonCourse = (JSONObject) jsonObject.get("course");
            JSONObject jsonFaculty = (JSONObject) jsonCourse.get("faculty");
            JSONObject jsonUniversity = (JSONObject) jsonFaculty.get("university");
            university = new University(jsonUniversity.get("name").toString());
            faculty = new Faculty(jsonFaculty.get("name").toString(), university);
            course = new Course(jsonCourse.get("name").toString(), faculty);
            group = new Group(jsonObject.get("name").toString(), course);
            return group;
        }else
        if(entity.equalsIgnoreCase("hr")){
            jsonParser = new JSONParser();
            Object object = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) object;
            user = new User(jsonObject.get("name").toString(),
                    jsonObject.get("email").toString(), jsonObject.get("login").toString());
            hr = new HR(user);
            return hr;
        }else
        if(entity.equalsIgnoreCase("inverview")){
            jsonParser = new JSONParser();
            Object object = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) object;
            return null;
        }else
        if(entity.equalsIgnoreCase("interviewer")){
            jsonParser = new JSONParser();
            Object object = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) object;
            user = new User(jsonObject.get("name").toString(),
                    jsonObject.get("email").toString(), jsonObject.get("login").toString());
            interviewer = new Interviewer(user);
            return interviewer;
        }else
        if(entity.equalsIgnoreCase("pm")){
            jsonParser = new JSONParser();
            Object object = jsonParser.parse(json);
            JSONObject jsonUser = (JSONObject) object;
            user = new User(jsonUser.get("name").toString(),
                    jsonUser.get("email").toString(), jsonUser.get("login").toString());
            pm = new PM(user);
            return pm;
        }else
        if(entity.equalsIgnoreCase("project")){
            jsonParser = new JSONParser();
            Object object = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) object;
            JSONObject jsonTL = (JSONObject) jsonObject.get("team_leader");
            JSONObject jsonPM = (JSONObject) jsonObject.get("pm");
            JSONObject jsonTLUser = (JSONObject) jsonTL.get("user");
            JSONObject jsonPMUser = (JSONObject) jsonPM.get("user");
            User userPM = new User(jsonPMUser.get("name").toString(),
                    jsonPMUser.get("email").toString(), jsonPM.get("login").toString());
            User userTL = new User(jsonTLUser.get("name").toString(),
                    jsonTLUser.get("email").toString(), jsonTL.get("login").toString());
            teamLeader = new TeamLeader(userTL);
            pm = new PM(userPM);
            project = new Project(jsonObject.get("name").toString(), pm, teamLeader);
            return project;
        }else
        if(entity.equalsIgnoreCase("setting")){
            jsonParser = new JSONParser();
            Object object = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) object;
            JSONObject jsonUser = (JSONObject) jsonObject.get("user");
            user = new User(jsonUser.get("name").toString(),
                    jsonUser.get("email").toString(), jsonUser.get("login").toString());
            setting = new Setting(jsonObject.get("name").toString(), jsonObject.get("value").toString(),
                    jsonObject.get("description").toString(), user);
            return setting;
        }else
        if(entity.equalsIgnoreCase("teamleader")){
            jsonParser = new JSONParser();
            Object object = jsonParser.parse(json);
            JSONObject jsonUser = (JSONObject) object;
            user = new User(jsonUser.get("name").toString(),
                    jsonUser.get("email").toString(), jsonUser.get("login").toString());
            teamLeader = new TeamLeader(user);
            return teamLeader;
        }else
        if(entity.equalsIgnoreCase("technology")){
            jsonParser = new JSONParser();
            Object object = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) object;
            technology = new Technology(jsonObject.get("technology_name").toString());
            return technology;
        }else
        if(entity.equalsIgnoreCase("university")){
            jsonParser = new JSONParser();
            Object object = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) object;
            university = new University(jsonObject.get("university_name").toString());
            return university;
        }else
        if(entity.equalsIgnoreCase("user")){
            jsonParser = new JSONParser();
            Object object = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) object;
            user = new User(jsonObject.get("name").toString(),
                    jsonObject.get("email").toString(), jsonObject.get("login").toString());
            return user;
        } else
        if (entity.equalsIgnoreCase("student")){
            jsonParser = new JSONParser();
            Object object = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) object;
            user = new User(jsonObject.get("name").toString(), jsonObject.get("email").toString(), jsonObject.get("login").toString());
            student = new Student(user);
            return student;
        } else
        if(entity.equalsIgnoreCase("marks")){
            jsonParser = new JSONParser();
            Object object = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) object;
            GroupDAOImpl groupDAO = new GroupDAOImpl();
            StudentDAOImpl studentDAO = new StudentDAOImpl();
            group = groupDAO.getGroup(Long.parseLong(jsonObject.get("group_id").toString()));
            student = studentDAO.getStudent(Long.parseLong(jsonObject.get("student_id").toString()));
            marks = new Marks(jsonObject.get("mark").toString(), jsonObject.get("date").toString(), student, group);
            return marks;
        }
        return null;
    }
}

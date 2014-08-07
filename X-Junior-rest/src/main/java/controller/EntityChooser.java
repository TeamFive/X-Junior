package controller;

import com.google.gson.Gson;
import entity.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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



    public BaseEntity choseEntity(String entity, String json) throws ParseException{
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
        }

        if(entity.equalsIgnoreCase("certificate")){
            Object object = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) object;
            certificate = new Certificate(jsonObject.get("certificate_name").toString(), jsonObject.get("date").toString());
            return certificate;
        }
        if(entity.equalsIgnoreCase("curator")){
            curator = new Curator();
            curator.setUser(gson.fromJson(json, User.class));
            curator.getUser().setPassword("11111");
            return curator;
        }
        if(entity.equalsIgnoreCase("customfield")){
            jsonParser = new JSONParser();
            Object object = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) object;
            JSONObject jsonFieldsGroup = (JSONObject) jsonObject.get("fieldsgroup");
            fieldsGroup = new FieldsGroup(jsonFieldsGroup.get("name").toString());
            customField = new CustomField(jsonObject.get("custom_field_name").toString(), jsonObject.get("default_value").toString(), fieldsGroup, jsonObject.get("field_type").toString());
            return customField;
        }
        if(entity.equalsIgnoreCase("faculty")){
            jsonParser = new JSONParser();
            Object object = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) object;
            JSONObject jsonUniversity = (JSONObject) jsonObject.get("university");
            university = new University(jsonUniversity.get("university_name").toString());
            faculty = new Faculty(jsonObject.get("name").toString(), university);
            return faculty;
        }
        if(entity.equalsIgnoreCase("feedback")){
            try {
                jsonParser = new JSONParser();
                Object object = jsonParser.parse(json);
                JSONObject jsonObject = (JSONObject) object;
                JSONObject jsonCurator = (JSONObject) jsonObject;
                JSONObject jsonStudent = (JSONObject) jsonObject;
                JSONObject jsonUser = (JSONObject) jsonCurator;
                user = new User(jsonUser.get("name").toString(), jsonUser.get("email").toString());
                curator = new Curator(user);
                JSONObject jsonStudentUser = (JSONObject) jsonStudent;
                User studentUser = new User(jsonStudentUser.get("name").toString(), jsonStudentUser.get("email").toString());

                student = new Student();
            } catch (ParseException ex){
                return null;
            }
        }
        if(entity.equalsIgnoreCase("fieldsgroup")){
            jsonParser = new JSONParser();
            Object object = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) object;
            fieldsGroup = new FieldsGroup(jsonObject.get("name").toString());
            return fieldsGroup;
        }
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
        }
        if(entity.equalsIgnoreCase("hr")){
            jsonParser = new JSONParser();
            Object object = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) object;
            JSONObject jsonUser = (JSONObject) jsonObject.get("user");
            user = new User(jsonUser.get("name").toString(),
                    jsonUser.get("email").toString());
            hr = new HR(user);
            return hr;
        }
        if(entity.equalsIgnoreCase("inverview")){
            jsonParser = new JSONParser();
            Object object = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) object;
            return null;
        }
        if(entity.equalsIgnoreCase("interviewer")){
            jsonParser = new JSONParser();
            Object object = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) object;
            JSONObject jsonUser = (JSONObject) jsonObject.get("user");
            user = new User(jsonUser.get("name").toString(),
                    jsonUser.get("email").toString());
            interviewer = new Interviewer(user);
            return interviewer;
        }
        if(entity.equalsIgnoreCase("pm")){
            jsonParser = new JSONParser();
            Object object = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) object;
            JSONObject jsonUser = (JSONObject) jsonObject.get("user");
            user = new User(jsonUser.get("name").toString(),
                    jsonUser.get("email").toString());
            pm = new PM(user);
            return pm;
        }
        if(entity.equalsIgnoreCase("project")){
            jsonParser = new JSONParser();
            Object object = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) object;
            JSONObject jsonTL = (JSONObject) jsonObject.get("team_leader");
            JSONObject jsonPM = (JSONObject) jsonObject.get("pm");
            JSONObject jsonTLUser = (JSONObject) jsonTL.get("user");
            JSONObject jsonPMUser = (JSONObject) jsonPM.get("user");
            User userPM = new User(jsonPMUser.get("name").toString(),
                    jsonPMUser.get("email").toString());
            User userTL = new User(jsonTLUser.get("name").toString(),
                    jsonTLUser.get("email").toString());
            teamLeader = new TeamLeader(userTL);
            pm = new PM(userPM);
            project = new Project(jsonObject.get("name").toString(), pm, teamLeader);
            return project;
        }
        if(entity.equalsIgnoreCase("setting")){
            jsonParser = new JSONParser();
            Object object = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) object;
            JSONObject jsonUser = (JSONObject) jsonObject.get("user");
            user = new User(jsonUser.get("name").toString(),
                    jsonUser.get("email").toString());
            setting = new Setting(jsonObject.get("name").toString(), jsonObject.get("value").toString(),
                    jsonObject.get("description").toString(), user);
            return setting;
        }
        if(entity.equalsIgnoreCase("teamleader")){
            jsonParser = new JSONParser();
            Object object = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) object;
            JSONObject jsonUser = (JSONObject) jsonObject.get("user");
            user = new User(jsonUser.get("name").toString(),
                    jsonUser.get("email").toString());
            teamLeader = new TeamLeader(user);
            return teamLeader;
        }
        if(entity.equalsIgnoreCase("technology")){
            jsonParser = new JSONParser();
            Object object = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) object;
            technology = new Technology(jsonObject.get("technology_name").toString());
            return technology;
        }
        if(entity.equalsIgnoreCase("university")){
            jsonParser = new JSONParser();
            Object object = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) object;
            university = new University(jsonObject.get("university_name").toString());
            return university;
        }
        if(entity.equalsIgnoreCase("user")){
            jsonParser = new JSONParser();
            Object object = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) object;
            user = new User(jsonObject.get("name").toString(),
                    jsonObject.get("email").toString());
            return user;
        }
        return null;
    }
}

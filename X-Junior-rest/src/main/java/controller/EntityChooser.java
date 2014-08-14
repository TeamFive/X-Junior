package controller;

import DAO.BaseDAO;
import DAO.Impl.*;
import VO.*;
import com.google.gson.Gson;
import entity.*;
import exceptions.EntityException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class EntityChooser {

    private Long id = null;

    public String choseEntity(String entity, String json) throws ParseException, EntityException{
        JSONParser jsonParser = new JSONParser();
        Object object = jsonParser.parse(json);
        Gson gson = new Gson();
        JSONObject jsonObject = (JSONObject) object;
        if(entity.equalsIgnoreCase("marks")){
            Marks mark = new Marks();
            MarksDAOImpl marksDAO = new MarksDAOImpl();

            if(id != null){
                mark.setId(id);
                if(jsonObject.get("date") != null){
                    mark.setDate(jsonObject.get("date").toString());
                }

                if(jsonObject.get("mark") != null){
                    mark.setMark(jsonObject.get("mark").toString());
                }

                if(jsonObject.get("group_id") != null){
                    Group group = new Group();
                    group.setId(Long.parseLong(jsonObject.get("group_id").toString()));
                    mark.setGroup(group);
                }

                if(jsonObject.get("student_id") != null){
                    Student student = new Student();
                    student.setId(Long.parseLong(jsonObject.get("student_id").toString()));
                    mark.setStudent(student);
                }

                return "{\"status\":\"success\", \"data\":" + gson.toJson(marksDAO.updateMark(mark)) + "}";
            }



            mark.setDate(jsonObject.get("date").toString());
            mark.setMark(jsonObject.get("mark").toString());

//            return marksDAO.addMark(Long.parseLong(jsonObject.get("group_id").toString()),
   //                 (Long.parseLong(jsonObject.get("student_id").toString())), mark);
        }

        if(entity.equalsIgnoreCase("feedback")){
            Feedback feedback = new Feedback();
            FeedbackDAOImpl feedbackDAO = new FeedbackDAOImpl();
            if(id != null){
                feedback.setId(id);
                if(jsonObject.get("date") != null){
                    feedback.setDate(jsonObject.get("date").toString());
                }

                if(jsonObject.get("extra") != null){
                    feedback.setExtra(jsonObject.get("extra").toString());
                }

                if(jsonObject.get("increase_hours") != null){
                    feedback.setIncreaseHours(Boolean.parseBoolean(jsonObject.get("increase_hours").toString()));
                }

                if(jsonObject.get("people_relation") != null){
                    feedback.setPeopleRelation(Integer.parseInt(jsonObject.get("people_relation").toString()));
                }

                if(jsonObject.get("proff_suitab") != null){
                    feedback.setProffSuitab(Integer.parseInt(jsonObject.get("proff_suitab").toString()));
                }

                if(jsonObject.get("real_project") != null){
                    feedback.setRealProject(jsonObject.get("real_project").toString());
                }

                if(jsonObject.get("work_attitude") != null){
                    feedback.setWorkAttitude(Integer.parseInt(jsonObject.get("work_attitude").toString()));
                }

                if(jsonObject.get("curator_id") != null){
                    Curator curator = new Curator();
                    curator.setId(Long.parseLong(jsonObject.get("curator_id").toString()));
                    feedback.setCurator(curator);
                }

                if(jsonObject.get("student_id") != null){
                    Student student = new Student();
                    student.setId(Long.parseLong(jsonObject.get("student_id").toString()));
                    feedback.setStudent(student);
                }

                return "{\"status\":\"success\", \"data\":" + gson.toJson(new FeedbackVO(feedbackDAO.updateFeedback(feedback))) + "}";

            }

            feedback.setDate(jsonObject.get("date").toString());  //String
            feedback.setExtra(jsonObject.get("extra").toString());  //String
            feedback.setIncreaseHours(Boolean.parseBoolean(jsonObject.get("increase_hours").toString()));  //Boolean
            feedback.setPeopleRelation(Integer.parseInt(jsonObject.get("people_relation").toString()));    //int
            feedback.setProffSuitab(Integer.parseInt(jsonObject.get("proff_suitab").toString()));          //int
            feedback.setRealProject(jsonObject.get("real_project").toString());     //String
            feedback.setWorkAttitude(Integer.parseInt(jsonObject.get("work_attitude").toString()));   //int


            return feedbackDAO.createFeedback(feedback,
                    Long.parseLong(jsonObject.get("curator_id").toString()),
                    Long.parseLong(jsonObject.get("student_id").toString()));
        }
        if(entity.equalsIgnoreCase("curator")){

            Curator curator = new Curator();
            curator.setStudentList(new ArrayList<Student>());

            if(id == null){
                User user = new User(jsonObject.get("name").toString(),
                        jsonObject.get("email").toString());
                curator.setUser(user);
            }

            if(jsonObject.get("students") != null){
                JSONArray jsonArray = (JSONArray) jsonObject.get("students");

                for(int i = 0; i < jsonArray.size(); i++){
                    curator.getStudentList().add(new Student());
                    curator.getStudentList().get(i).setId(Long.parseLong(jsonArray.get(i).toString()));
                }
            }
            curator.setId(id);

            CuratorDAOImpl curatorDAO = new CuratorDAOImpl();
            id = null;
            String result = "{\"status\":\"success\" \"data\":" + gson.toJson(new CuratorVO(curatorDAO.saveCurator(curator))) + "}";
            return result;
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
                    jsonObject.get("certificate_name").toString());
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
            customField.setFieldType(jsonObject.get("field_type").toString());
            customField.setOptions(jsonObject.get("options").toString());

            CustomFieldDAOImpl customFieldDAO = new CustomFieldDAOImpl();

            CustomField customField1 = customFieldDAO.createCustomField(customField);

            return "{\"status\":\"success\", \"data\":" + gson.toJson(new CustomFieldVO(customField1));
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
            Interviewer interviewer = new Interviewer(new User(jsonObject.get("name").toString(),
                    jsonObject.get("email").toString()));

            InterviewerDAOImpl interviewerDAO = new InterviewerDAOImpl();
            return interviewerDAO.createInterviewer(interviewer);
        }
        if(entity.equalsIgnoreCase("pm")){
            PM pm = new PM(new User(jsonObject.get("name").toString(), jsonObject.get("email").toString()));

            PMDAOImpl pmdao = new PMDAOImpl();

            return pmdao.createPM(pm);
        }
        if(entity.equalsIgnoreCase("project")){
            Project project = new Project();
            project.setName(jsonObject.get("project_name").toString());

            ProjectDAOImpl projectDAO = new ProjectDAOImpl();

            return projectDAO.createProject(project, Long.parseLong(jsonObject.get("pm_id").toString()),
                    Long.parseLong(jsonObject.get("teamleader_id").toString()));
        }
        if(entity.equalsIgnoreCase("setting")){
            Setting setting = new Setting();

            setting.setName(jsonObject.get("name").toString());
            setting.setDescription(jsonObject.get("description").toString());
            setting.setValue(jsonObject.get("values").toString());

            SettingsDAOImpl settingsDAO = new SettingsDAOImpl();

            return settingsDAO.createSetting(setting, Long.parseLong(jsonObject.get("user_id").toString()));
        }
        if(entity.equalsIgnoreCase("student")){
            Student student = new Student();
            student.setCertificateList(new ArrayList<Certificate>());
            student.setTechnologyStudentNowList(new ArrayList<Technology>());
            student.setTechnologyStudentFutureList(new ArrayList<Technology>());

            if(id == null)
                student.setUser(new User(jsonObject.get("name").toString(), jsonObject.get("email").toString()));

            if(jsonObject.get("status") != null){
                student.setStatus(jsonObject.get("status").toString());
            }
            if(jsonObject.get("started_work_date") != null)
                student.setStartedWorkDate(jsonObject.get("started_work_date").toString());
            if(jsonObject.get("had_probation") != null)
                student.setHadProbation(Boolean.parseBoolean(jsonObject.get("had_probation").toString()));
            if(jsonObject.get("start_at_course") != null)
                student.setStartAtCourse(Integer.parseInt(jsonObject.get("start_at_course").toString()));
            if(jsonObject.get("wanted_work_hours") != null)
                student.setWantedWorkHours(Integer.parseInt(jsonObject.get("wanted_work_hours").toString()));
            if(jsonObject.get("change_hours_date") != null)
                student.setChangeHoursDate(jsonObject.get("change_hours_date").toString());
            if(jsonObject.get("english_level") != null)
                student.setEnglishLevel(jsonObject.get("english_level").toString());
            if(jsonObject.get("wanted_courses") != null)
                student.setWantedCourses(jsonObject.get("wanted_courses").toString());
            if(jsonObject.get("phone_number") != null)
                student.setPhoneNumber(jsonObject.get("phone_number").toString());
            if(jsonObject.get("skype") != null)
                student.setSkype(jsonObject.get("skype").toString());
            if(jsonObject.get("want_english_training") != null )
                student.setWantEnglishTraining(Boolean.parseBoolean(jsonObject.get("want_english_training").toString()));
            if(jsonObject.get("current_english_training") != null)
                student.setCurrentEnglishTraining(jsonObject.get("current_english_training").toString());
            if(jsonObject.get("student_certificate") != null){
                String[] certificates = jsonObject.get("student_certificate").toString().split(";");
                int i = 0;
                while (i != certificates.length){
                    student.getCertificateList().add(new Certificate(certificates[i]));
                    i++;
                }
            }
            if(jsonObject.get("student_technology_now") != null){
                String[] technologies = jsonObject.get("student_technology_now").toString().split(";");
                int i = 0;
                while (i != technologies.length){
                    student.getTechnologyStudentNowList().add(new Technology(technologies[i]));
                    i++;
                }
            }
            if(jsonObject.get("student_technology_future") != null){
                String[] technologies = jsonObject.get("student_technology_future").toString().split(";");
                int i = 0;
                while (i != technologies.length){
                    student.getTechnologyStudentFutureList().add(new Technology(technologies[i]));
                    i++;
                }
            }

            StudentDAOImpl studentDAO = new StudentDAOImpl();

            //String result = "success\" } {\" " + gson.toJson(new StudentVO(studentDAO.createStudent(student, id)));
            if(id == null){
                return "{\"status\":\"success\", \"data\": " + gson.toJson(new StudentElem(studentDAO.createStudent(student, id))) + "}";
            }
            String result = "{\"status\":\"success\", \"data\": " + gson.toJson(new StudentVO(studentDAO.createStudent(student, id))) + "}";
            id = null;
            return result;
        }
        if(entity.equalsIgnoreCase("teamleader")){
            TeamLeader teamLeader = new TeamLeader();

            TeamLeaderDAOImpl teamLeaderDAO = new TeamLeaderDAOImpl();

            return teamLeaderDAO.createTeamLeader(teamLeader, Long.parseLong(jsonObject.get("user_id").toString()));
        }
        if(entity.equalsIgnoreCase("technology")){
            Technology technology = new Technology();
            if(id != null)
                technology.setId(id);
            technology.setTechnology_name(jsonObject.get("technology_name").toString());

            TechnologyDAOImpl technologyDAO = new TechnologyDAOImpl();
            return technologyDAO.createTechnology(technology);
        }
        if(entity.equalsIgnoreCase("university")){
            University university = new University();
            university.setUniversity_name((jsonObject.get("university_name").toString()));

            UniversityDAOImpl universityDAO = new UniversityDAOImpl();


            String result = "{\" status\":\"success\", \"data\":" + gson.toJson(new UniversityVO(universityDAO.createUniversity(university)))
                    + "}";
            return result;
        }

        return null;
    }


    public void setId(Long id) {
        this.id = id;
    }
}

//Ready GROUP,

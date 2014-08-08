package controller;

import DAO.BaseDAO;
import DAO.Impl.*;
import entity.Curator;
import entity.Feedback;
import entity.HR;
import entity.User;
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

        return null;
    }

}

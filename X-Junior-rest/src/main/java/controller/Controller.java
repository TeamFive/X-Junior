package controller;


import com.google.gson.Gson;
import entity.Technology;
import exceptions.EntityException;
import org.hibernate.exception.JDBCConnectionException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.BaseService;


/**
 * Created by Administrator on 24.07.2014.
 */
@org.springframework.stereotype.Controller
@RequestMapping("/")

//TODO need to fix DAO add check;
public class Controller {

    @Autowired
    EntityServiceChooser serviceChooser;

    public void setServiceChooser(EntityServiceChooser serviceChooser) {
        this.serviceChooser = serviceChooser;
    }

    @RequestMapping(value = "/{entity}/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getEntity(@PathVariable("entity") String entity, @PathVariable("id") long id) {
        BaseService baseService = serviceChooser.serviceChooser(entity);
        String json;
        Gson gson = new Gson();
        try {
            json = gson.toJson(baseService.find(id));
            return "{\"status\":\"success\"," +
                    "\"data\":" + json + "}";
        } catch (JDBCConnectionException ex){
            return "{\"status\":\"error\"," +
                    "\"message\":\"Database is offline\"}";
        } catch (EntityException ex){
            return "{\"status\":\"error\"," +
                    "\"message\":\"" + ex.getMessage() + "\"}";
        }


    }

    @RequestMapping(value = "/{entity}/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteEntity(@PathVariable("entity") String entity, @PathVariable("id") long id){
        BaseService baseService = serviceChooser.serviceChooser(entity);
        try {
            return "{\"status\":\"" + baseService.delete(id) + "\"}";
        } catch (JDBCConnectionException ex){
            return "{\"status\":\"error\"," +
                    "\"message\":\"Database is offline\"}";
        } catch (EntityException ex){
            return "{\"status\":\"error\"," +
                    "\"message\":\"" + ex.getMessage() + "\"}";
        }
    }

    @RequestMapping(value = "{entity}", method = RequestMethod.GET)
    @ResponseBody
    public String getListEntity(@PathVariable("entity") String entity){
        BaseService baseService = serviceChooser.serviceChooser(entity);
        Gson gson = new Gson();
        try {
            return "{\"status\":\"success\"," +
                    "\"data\":" + gson.toJson(baseService.getList()) + "}";
        } catch (EntityException ex){
            return "{\"status\":\"error\"," +
                    "\"message\":\"" + ex.getMessage() + "\"}";
        } catch (JDBCConnectionException ex){
            return "{\"status\":\"error\"," +
                    "\"message\":\"Database is offline\"}";
        }
    }



    @RequestMapping(value = "/{entity}", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String createEntity(@PathVariable("entity") String entity, @RequestBody String str)  {
        BaseService baseService = serviceChooser.serviceChooser(entity);
        JSONParser parser = new JSONParser();
        try {
            Object object = parser.parse(str);
            JSONObject jsonObject = (JSONObject) object;
            Technology technology = new Technology(jsonObject.get("technology_name").toString());
            try {
                return "{\"status\":\"" + baseService.add(technology) + "\"}";
            } catch (JDBCConnectionException ex) {
                return "{\"status\":\"error\"," +
                        "\"message\":\"Database is offline\"}";
            } catch (EntityException ex) {
                return "{\"status\":\"error\"," +
                        "\"message\":\"" + ex.getMessage() + "\"}";
            }
        } catch (ParseException ex){
            return "{\"status\":\"error\"," +
                    "\"message\":\"invalid JSON\"}";
        }
    }
//
//    @RequestMapping(value = "/{entity}/update", method = RequestMethod.POST, produces = "application/json")
//    @ResponseBody
//    public String updateEntity(@PathVariable("entity") String entity, @RequestBody String str){
//        setEntityService(entity);
//        JSONParser parser = new JSONParser();
//        try {
//            Object object = parser.parse(str);
//            JSONObject jsonObject = (JSONObject) object;
//            User user = new User(jsonObject.get("name").toString(), jsonObject.get("password").toString(), jsonObject.get("email").toString());
//            try{
//                return "{ \n" +
//                        "     status: \"" + entityService.updateEntity(user) + "} \n";
//            } catch (JDBCConnectionException ex){
//                return "{ \n" +
//                        "     status: \" error }\n" +
//                        "     message: \" Database is offline\" \n";
//            } catch (EntityException ex){
//                return "{ \n" +
//                        "     status: \" error }\n" +
//                        "     message: \" " + ex.getMessage() + " \" \n";
//            }
//        } catch (ParseException ex){
//            return "{ \n" +
//                    "     status: \" error }\n" +
//                    "     message: \" Soo invalid JSON \" \n";
//        }
//    }


}
package controller;


import DAO.Impl.CuratorDAOImpl;
import com.google.gson.Gson;
import entity.BaseEntity;
import entity.Student;
import exceptions.EntityException;
import org.hibernate.exception.JDBCConnectionException;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.BaseService;
import service.Impl.StudentServiceImpl;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 24.07.2014.
 */
@org.springframework.stereotype.Controller
@RequestMapping("/")

//TODO need to fix DAO add check;
public class Controller {

    @Autowired
    private EntityServiceChooser serviceChooser;

    @Autowired
    private VOConverter voConverter;

    private EntityChooser entityChooser;



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
            json = gson.toJson(voConverter.convert((BaseEntity) baseService.find(id)));
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

    @RequestMapping(value = "/getcurator/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String getEntityByName(@PathVariable("name") String name){
        CuratorDAOImpl curatorDAO = new CuratorDAOImpl();
        Gson gson = new Gson();

        try {
            String result = gson.toJson(curatorDAO.getCuratorByName(name));

            return "{\"status\":\"success\"," +
                    "\"data\":" + result + "}";
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
                    "\"data\":" +         gson.toJson(voConverter.convertList(entity, baseService.getList())) + "}";
        } catch (EntityException ex){
            return "{\"status\":\"error\"," +
                    "\"message\":\"" + ex.getMessage() + "\"}";
        } catch (JDBCConnectionException ex){
            return "{\"status\":\"error\"," +
                    "\"message\":\"Database is offline\"}";
        }
    }

    @PostConstruct
    private void initMethod(){
        entityChooser = new EntityChooser();

    }



    @RequestMapping(value = "/{entity}", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String createEntity(@PathVariable("entity") String entity, @RequestBody String str)  {
            try {
                return "{\"status\":\"" + entityChooser.choseEntity(entity, str) + "\"}";
            } catch (JDBCConnectionException ex) {
                return "{\"status\":\"error\"," +
                        "\"message\":\"Database is offline\"}";
            }
            catch (ParseException ex){
                return "{\"status\":\"error\"," +
                        "\"message\":\"invalid JSON\"}";
            } catch (EntityException ex){
                return "{\"status\":\"error\"," +
                        "\"message\":\"invalid JSON\"}";
            }
    }


    @RequestMapping(value = "/{entity}/{id}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public String updateEntity(@PathVariable("entity") String entity, @PathVariable("id") long id, @RequestBody String str){
        try {
            entityChooser.setId(id);
            return "{\"status\":\"" + entityChooser.choseEntity(entity, str) + "\"}";
        } catch (JDBCConnectionException ex) {
            return "{\"status\":\"error\"," +
                    "\"message\":\"Database is offline\"}";
        }
        catch (ParseException ex){
            return "{\"status\":\"error\"," +
                    "\"message\":\"invalid JSON\"}";
        } catch (EntityException ex){
            return "{\"status\":\"error\"," +
                    "\"message\":\"invalid JSON\"}";
        }
    }

//    @RequestMapping(value = "/students", method = RequestMethod.PUT, produces = "application/json")
//    @ResponseBody
//    public String getStudents(){
//        try {
//            BaseService studentService = new StudentServiceImpl();
//            List<Student> studentList = new ArrayList<Student>();
//
//            return "{\"status\":\"" + entityChooser.choseEntity(entity, str) + "\"}";
//        } catch (JDBCConnectionException ex) {
//            return "{\"status\":\"error\"," +
//                    "\"message\":\"Database is offline\"}";
//        }
//        catch (ParseException ex){
//            return "{\"status\":\"error\"," +
//                    "\"message\":\"invalid JSON\"}";
//        } catch (EntityException ex){
//            return "{\"status\":\"error\"," +
//                    "\"message\":\"invalid JSON\"}";
//        }
//    }
}

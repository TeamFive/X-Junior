package controller;

import DAO.Impl.StudentDAOImpl;
import VO.StudentVO;
import com.google.gson.Gson;
import entity.Student;

/**
 * Created by Administrator on 14.08.2014.
 */
public class GetStudentInfos {
    private Long id = null;
    public String getStudentInfo(Long id){

        this.id = id;

        Gson gson = new Gson();
        StudentDAOImpl studentDAO = new StudentDAOImpl();
        Student student = studentDAO.getStudentInfo(id);

        return "{\"status\":\"success\", \"data\":" + gson.toJson(new StudentVO(student)) + "}";

    }
}

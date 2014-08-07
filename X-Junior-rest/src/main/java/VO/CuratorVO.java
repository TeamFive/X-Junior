package VO;

import entity.BaseEntity;
import entity.Curator;
import entity.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ALEX on 06.08.2014.
 */

public class CuratorVO implements BaseVO{
    private Long id;
    private String name;
    private String email;
    private List<StudentVO> studentList;

    public CuratorVO() {
    }

    public CuratorVO (Curator curator) {
        this.id = curator.getId();
        this.name = curator.getUser().getName();
        this.email = curator.getUser().getEmail();
        this.studentList = new ArrayList<StudentVO>();
        for (Student s: curator.getStudentList()){
            this.studentList.add(new StudentVO(s));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<StudentVO> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<StudentVO> studentList) {
        this.studentList = studentList;
    }
}

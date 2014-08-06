package VO;

import entity.Curator;
import entity.Student;

import java.util.List;

/**
 * Created by ALEX on 06.08.2014.
 */
public class CuratorVO {
    private String name;
    private String email;
    private List<Student> studentList;

    public CuratorVO() {
    }

    public CuratorVO(Curator curator) {
        this.name = curator.getUser().getName();
        this.email = curator.getUser().getEmail();
        this.studentList = curator.getStudentList();
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

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}

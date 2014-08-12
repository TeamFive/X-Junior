package VO;

import entity.Curator;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ALEX on 06.08.2014.
 */

public class CuratorVO implements BaseVO{
    private Long id;
    private String name;
    private String email;
    private List<StudentElem> students;

    public CuratorVO() {
    }

    public CuratorVO (Curator curator) {
        this.id = curator.getId();
        this.name = curator.getUser().getName();
        this.email = curator.getUser().getEmail();
        this.students = new ArrayList<StudentElem>();
        for (Student s: curator.getStudentList()){
            this.students.add(new StudentElem(s));
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

    public List<StudentElem> getStudents() {
        return students;
    }

    public void setStudents(List<StudentElem> students) {
        this.students = students;
    }
}

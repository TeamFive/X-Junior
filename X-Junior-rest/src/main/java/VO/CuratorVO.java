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
    private List<StudentListItem> students;

    private class StudentListItem{
        private Long id;
        private String name;
        private String email;

        private StudentListItem(Student student) {
            this.id = student.getId();
            this.name = student.getUser().getName();
            this.email = student.getUser().getEmail();
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
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
    }

    public CuratorVO() {
    }

    public CuratorVO (Curator curator) {
        this.id = curator.getId();
        this.name = curator.getUser().getName();
        this.email = curator.getUser().getEmail();
        this.students = new ArrayList<StudentListItem>();
        for (Student s: curator.getStudentList()){
            this.students.add(new StudentListItem(s));
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

    public List<StudentListItem> getStudents() {
        return students;
    }

    public void setStudents(List<StudentListItem> students) {
        this.students = students;
    }
}

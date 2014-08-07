package VO;

import entity.Group;
import entity.Marks;
import entity.Student;

/**
 * Created by ALEX on 07.08.2014.
 */
public class MarksVO implements BaseVO {
    private Long id;
    private String mark;
    private String date;
    private Student student;
    private Group group;

    public MarksVO(Marks marks) {
        this.id = marks.getId();
        this.mark = marks.getMark();
        this.date = marks.getDate();
        this.student = marks.getStudent();
        this.group = marks.getGroup();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}

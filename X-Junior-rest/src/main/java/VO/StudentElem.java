package VO;

import entity.Student;

/**
 * Created by ALEX on 12.08.2014.
 */
public class StudentElem implements BaseVO{
    private Long id;
    private String name;

    public StudentElem (Student student) {
        this.id = student.getId();
        this.name = student.getUser().getName();
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
}

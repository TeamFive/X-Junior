package VO;

import entity.Student;

/**
 * Created by ALEX on 12.08.2014.
 */
public class StudentElem implements BaseVO{
    private Long id;
    private String name;
    private String status;

    public StudentElem (Student student) {
        this.id = student.getId();
        this.name = student.getUser().getName();
        this.status = student.getStatus();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

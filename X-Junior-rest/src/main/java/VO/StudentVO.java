package VO;

import entity.Student;

/**
 * Created by ALEX on 07.08.2014.
 */
public class StudentVO implements BaseVO {
    private Long id;
    private String name;
    private String email;

    public StudentVO() {
    }

    public StudentVO(Student student) {
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

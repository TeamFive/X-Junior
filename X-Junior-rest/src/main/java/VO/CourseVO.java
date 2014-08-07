package VO;

import entity.Course;
import entity.Faculty;

/**
 * Created by ALEX on 07.08.2014.
 */
public class CourseVO implements BaseVO {
    private Long id;
    private String name;
    private Faculty faculty;

    public CourseVO(Course course) {
        this.id = course.getId();
        this.name = course.getName();
        this.faculty = course.getFaculty();
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

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}

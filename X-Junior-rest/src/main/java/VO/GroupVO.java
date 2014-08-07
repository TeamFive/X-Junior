package VO;

import entity.Course;
import entity.Group;

/**
 * Created by ALEX on 07.08.2014.
 */
public class GroupVO implements BaseVO {
    private Long id;
    private String name;
    private Course course;

    public GroupVO(Group group) {
        this.id = group.getId();
        this.name = group.getName();
        this.course = group.getCourse();
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}

package VO;

import entity.Faculty;
import entity.University;

/**
 * Created by ALEX on 07.08.2014.
 */
public class FacultyVO implements BaseVO {
    private Long id;
    private String name;
    private University university;

    public FacultyVO(Faculty faculty) {
        this.id = faculty.getId();
        this.name = faculty.getName();
        this.university = faculty.getUniversity();
    }
}

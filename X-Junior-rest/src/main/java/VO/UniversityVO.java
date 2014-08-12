package VO;

import entity.University;

/**
 * Created by ALEX on 12.08.2014.
 */
public class UniversityVO implements BaseVO {
    private Long id;
    private String university_name;

    public UniversityVO(University university) {
        this.id = university.getId();
        this.university_name = university.getUniversity_name();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUniversity_name() {
        return university_name;
    }

    public void setUniversity_name(String university_name) {
        this.university_name = university_name;
    }
}

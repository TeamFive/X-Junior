package VO;

import entity.Technology;

/**
 * Created by ALEX on 08.08.2014.
 */
public class TechnologyVO implements BaseVO {
    private Long id;
    private String technology_name;

    public TechnologyVO(Technology technology) {
        this.id = technology.getId();
        this.technology_name = technology.getTechnology_name();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTechnology_name() {
        return technology_name;
    }

    public void setTechnology_name(String technology_name) {
        this.technology_name = technology_name;
    }
}

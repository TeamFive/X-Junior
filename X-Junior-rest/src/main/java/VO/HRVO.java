package VO;

import entity.HR;

/**
 * Created by ALEX on 07.08.2014.
 */
public class HRVO implements BaseVO {
    private Long id;
    private String name;
    private String email;

    public HRVO(HR hr) {
        this.id = hr.getId();
        this.name = hr.getUser().getName();
        this.email = hr.getUser().getEmail();
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

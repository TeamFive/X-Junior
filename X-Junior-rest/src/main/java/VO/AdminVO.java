package VO;

import entity.Admin;

/**
 * Created by ALEX on 07.08.2014.
 */
public class AdminVO implements BaseVO {
    private Long id;
    private String name;
    private String email;

    public AdminVO(Admin admin) {
        this.id = admin.getId();
        this.name = admin.getUser().getName();
        this.email = admin.getUser().getEmail();
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

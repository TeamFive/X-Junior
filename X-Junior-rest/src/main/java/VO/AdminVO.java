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
}

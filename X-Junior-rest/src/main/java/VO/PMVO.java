package VO;

import entity.PM;

/**
 * Created by ALEX on 07.08.2014.
 */
public class PMVO implements BaseVO{
    private Long id;
    private String name;
    private String email;

    public PMVO(PM pm) {
        this.id = pm.getId();
        this.name = pm.getUser().getName();
        this.email = pm.getUser().getEmail();
    }
}

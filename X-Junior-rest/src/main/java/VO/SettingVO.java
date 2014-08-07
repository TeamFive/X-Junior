package VO;

import entity.Setting;
import entity.User;

/**
 * Created by ALEX on 07.08.2014.
 */
public class SettingVO implements BaseVO {
    private Long id;
    private String name;
    private String value;
    private String description;
    private User user;

    public SettingVO(Setting setting) {
        this.id = setting.getId();
        this.name = setting.getName();
        this.value = setting.getValue();
        this.description = setting.getDescription();
        this.user = setting.getUser();
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

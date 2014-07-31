package DAO.Impl;

import entity.Setting;
import org.springframework.stereotype.Repository;

@Repository
public class SettingsDAOImpl extends BaseDAOImpl<Setting> {
    public SettingsDAOImpl() {
        super(Setting.class);
    }

    public SettingsDAOImpl(Class<Setting> type) {
        super(type);
    }
}

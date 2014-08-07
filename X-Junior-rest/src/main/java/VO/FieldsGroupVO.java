package VO;

import entity.FieldsGroup;

/**
 * Created by ALEX on 07.08.2014.
 */
public class FieldsGroupVO implements BaseVO {
    private Long id;
    private String name;

    public FieldsGroupVO(FieldsGroup fieldsGroup) {
        this.id = fieldsGroup.getId();
        this.name = fieldsGroup.getName();
    }
}

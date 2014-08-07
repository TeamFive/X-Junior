package VO;

import entity.CustomField;
import entity.FieldsGroup;

/**
 * Created by ALEX on 07.08.2014.
 */
public class CustomFieldVO implements BaseVO {
    private Long id;
    private String name;
    private String defaultValue;
    private String fieldType;
    private FieldsGroup fieldsGroup;

    public CustomFieldVO(CustomField customField) {
        this.id = id;
        this.name = name;
        this.defaultValue = defaultValue;
        this.fieldType = fieldType;
        this.fieldsGroup = fieldsGroup;
    }
}

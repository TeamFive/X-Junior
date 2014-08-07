package controller;

import VO.BaseVO;
import VO.CuratorVO;
import VO.StudentVO;
import entity.BaseEntity;
import entity.Curator;
import entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.BaseService;
import service.Impl.*;


@Component
public class VOSetter {
    public BaseVO voSetter(String entity, BaseEntity baseEntity){
        if(entity.equalsIgnoreCase("curator"))
            return new CuratorVO((Curator) baseEntity);
        if(entity.equalsIgnoreCase("student"))
            return new StudentVO((Student) baseEntity);
        return null;
    }
}

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

import java.util.ArrayList;
import java.util.List;


@Component
public class VOConverter {
    public BaseVO convert(BaseEntity baseEntity){
        if(baseEntity instanceof Curator)
            return new CuratorVO((Curator) baseEntity);
        if(baseEntity instanceof Student)
            return new StudentVO((Student) baseEntity);
        return null;
    }

    public List<BaseVO> convertList(String entity, List<BaseEntity> entityList){
        List<BaseVO> baseVOList = new ArrayList<BaseVO>();
        if (entity.equalsIgnoreCase("curator")) {
            for (BaseEntity item : entityList){
                baseVOList.add(new CuratorVO((Curator) item));
            }
            return baseVOList;
        }
        if (entity.equalsIgnoreCase("student")) {
            for (BaseEntity item : entityList){
                baseVOList.add(new StudentVO((Student) item));
            }
            return baseVOList;
        }
        return null;
    }
}

package controller;

import VO.*;
import entity.*;
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
        if(baseEntity instanceof Admin)
            return new AdminVO((Admin) baseEntity);
        if(baseEntity instanceof Certificate)
            return new CertificateVO((Certificate) baseEntity);
        if(baseEntity instanceof Course)
            return new CourseVO((Course) baseEntity);
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
        if (entity.equalsIgnoreCase("admin")) {
            for (BaseEntity item : entityList){
                baseVOList.add(new AdminVO((Admin) item));
            }
            return baseVOList;
        }
        if (entity.equalsIgnoreCase("certificate")) {
            for (BaseEntity item : entityList){
                baseVOList.add(new CertificateVO((Certificate) item));
            }
            return baseVOList;
        }
        if (entity.equalsIgnoreCase("course")) {
            for (BaseEntity item : entityList){
                baseVOList.add(new CourseVO((Course) item));
            }
            return baseVOList;
        }
        return null;
    }
}

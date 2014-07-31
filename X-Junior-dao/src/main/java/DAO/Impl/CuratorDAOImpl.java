package DAO.Impl;

import entity.Curator;
import org.springframework.stereotype.Repository;

@Repository
public class CuratorDAOImpl extends BaseDAOImpl<Curator> {
    public CuratorDAOImpl() {
        super(Curator.class);
    }

    public CuratorDAOImpl(Class<Curator> type) {
        super(type);
    }
}

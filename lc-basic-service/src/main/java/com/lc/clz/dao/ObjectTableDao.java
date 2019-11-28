package com.lc.clz.dao;

import com.lc.clz.entities.ObjectTable;
import com.lc.clz.entities.ObjectTablePK;
import org.springframework.data.repository.CrudRepository;

public interface ObjectTableDao  extends CrudRepository<ObjectTable, ObjectTablePK> {

    ObjectTable getObjectTableByLogicalTableNameAndAndPhysicalTableName(String logicalTableName,String physicalTableName);


    @Override
    <S extends ObjectTable> S save(S s);
}

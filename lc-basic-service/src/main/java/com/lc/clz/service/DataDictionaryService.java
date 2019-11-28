package com.lc.clz.service;

import com.lc.clz.constant.ReturnStatusConstant;
import com.lc.clz.dao.ObjectTableDao;
import com.lc.clz.entities.ObjectTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataDictionaryService {


    @Autowired
    private ObjectTableDao objectTableDao;


    public int createObjectTableDataByTableName(String tableNames){
        try{
            String [] classNameArray=tableNames.split(",");
            for (String tableName: classNameArray) {
                tableName=tableName.toUpperCase();
                ObjectTable objectTable=new ObjectTable();
                objectTable.setPhysicalTableName(tableName);
                objectTable.setLogicalTableName(tableName);
                objectTable.setTableComment(tableName);
                if(objectTableDao.getObjectTableByLogicalTableNameAndAndPhysicalTableName(tableName,tableName)==null){
                    objectTableDao.save(objectTable);
                }
            }
            return ReturnStatusConstant.SUCCESSFUL;
        }catch (Exception e){
            e.printStackTrace();
            return ReturnStatusConstant.FAILED;
        }
    }



}

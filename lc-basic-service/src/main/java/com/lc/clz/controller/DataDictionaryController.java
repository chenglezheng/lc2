package com.lc.clz.controller;

import com.lc.clz.service.DataDictionaryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "数据字典服务")
public class DataDictionaryController {

    @Autowired
    private DataDictionaryService dataDictionaryService;

    /**
     * 通过表名串创建表名表数据
     * @param tableName
     * @return
     */
    @PostMapping("/createObjectTableDataByTableNames")
    public int createObjectTableDataByTableNames(String tableName){
        return dataDictionaryService.createObjectTableDataByTableName(tableName);
    }


}

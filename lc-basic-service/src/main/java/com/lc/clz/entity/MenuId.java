package com.lc.clz.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
public class MenuId {

    private String menuCode;  //菜单代码
    private String menuActualValue;//菜单实际值


}

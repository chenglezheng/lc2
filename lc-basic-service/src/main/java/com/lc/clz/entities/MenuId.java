package com.lc.clz.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class MenuId implements Serializable {

    private String menuCode;  //菜单代码

    private String menuActualValue;//菜单实际值


}

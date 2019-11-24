package com.lc.clz.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "menu")
@Data
@IdClass(MenuId.class)
public class Menu implements Serializable {

    @Id
    private String menuCode;  //菜单代码
    @Id
    private String menuActualValue;//菜单实际值
    private String menuDisplayValue;   //菜单显示值


}

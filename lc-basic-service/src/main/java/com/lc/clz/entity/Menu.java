package com.lc.clz.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "menu")
@Data
public class Menu {

    @Id
    private MenuId menuId;
    private String menuDisplayValue;   //菜单显示值


}

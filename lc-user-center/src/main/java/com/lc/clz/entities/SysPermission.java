package com.lc.clz.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 权限表
 */
@Entity
@Table(name = "sys_permission")
@Data
public class SysPermission implements Serializable {

	private static final long serialVersionUID = 280565233032255804L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String permission;
	private String name;
	private Date createTime;
	private Date updateTime;

}

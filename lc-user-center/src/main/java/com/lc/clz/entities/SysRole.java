package com.lc.clz.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 角色表
 */
@Entity
@Table(name = "sys_role")
@Data
public class SysRole implements Serializable {

	private static final long serialVersionUID = -2054359538140713354L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String code;
	private String name;
	private Date createTime;
	private Date updateTime;
}

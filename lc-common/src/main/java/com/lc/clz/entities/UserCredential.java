package com.lc.clz.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 用户账号类型
 *
 *
 */
@Data
@Entity
@Table(name = "user_credential")
public class UserCredential implements Serializable {

	private static final long serialVersionUID = -958701617717204974L;

	private String username;
	private String type;
	private Long userId;

}

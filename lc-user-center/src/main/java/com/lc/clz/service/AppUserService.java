package com.lc.clz.service;


import com.lc.clz.entities.user.AppUser;
import com.lc.clz.oauth2.LoginAppUser;
import com.lc.clz.entities.user.SysRole;
import com.lc.clz.oauth2.constants.Page;

import java.util.Map;
import java.util.Set;


public interface AppUserService {

	void addAppUser(AppUser appUser);

	void updateAppUser(AppUser appUser);

	LoginAppUser findByUsername(String username);

	AppUser findById(Long id);

	void setRoleToUser(Long id, Set<Long> roleIds);

	void updatePassword(Long id, String oldPassword, String newPassword);

	Page<AppUser> findUsers(Map<String, Object> params);

	Set<SysRole> findRolesByUserId(Long userId);

	void bindingPhone(Long userId, String phone);
}

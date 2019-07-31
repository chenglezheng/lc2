package com.lc.clz.controller;

import com.lc.clz.service.AppUserService;
import com.lc.clz.utils.AppUserUtils;
import com.lc.clz.oauth2.AppUser;
import com.lc.clz.oauth2.LoginAppUser;
import com.lc.clz.oauth2.SysRole;
import com.lc.clz.oauth2.constants.Page;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@Slf4j
@RestController
@Api(description = "用戶中心")
public class UserController {

    @Autowired
    private AppUserService appUserServiceImpl;

    /**
     * 当前登录用户 LoginAppUser
     */
    @GetMapping("/users/current")
    public LoginAppUser getLoginAppUser() {
        return AppUserUtils.getLoginAppUser();
    }

    @GetMapping(value = "/users-anon/internal", params = "username")
    public LoginAppUser findByUsername(String username) {
        return appUserServiceImpl.findByUsername(username);
    }

    /**
     * 用户查询
     *
     * @param params
     */
    @PreAuthorize("hasAuthority('back:user:query')")
    @GetMapping("/users")
    public Page<AppUser> findUsers(@RequestParam Map<String, Object> params) {
        return appUserServiceImpl.findUsers(params);
    }

    @PreAuthorize("hasAuthority('back:user:query')")
    @GetMapping("/users/{id}")
    public AppUser findUserById(@PathVariable Long id) {
        return appUserServiceImpl.findById(id);
    }

    /**
     * 添加用户,根据用户名注册
     *
     * @param appUser
     */
    @PostMapping("/users-anon/register")
    public AppUser register(@RequestBody AppUser appUser) {
        // 用户名等信息的判断逻辑挪到service了
        appUserServiceImpl.addAppUser(appUser);

        return appUser;
    }

    /**
     * 修改自己的个人信息
     *
     * @param appUser
     */
    @PutMapping("/users/me")
    public AppUser updateMe(@RequestBody AppUser appUser) {
        AppUser user = AppUserUtils.getLoginAppUser();
        appUser.setId(user.getId());

        appUserServiceImpl.updateAppUser(appUser);

        return appUser;
    }

    /**
     * 修改密码
     *
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     */
    @PutMapping(value = "/users/password", params = {"oldPassword", "newPassword"})
    public void updatePassword(String oldPassword, String newPassword) {
        if (StringUtils.isBlank(oldPassword)) {
            throw new IllegalArgumentException("旧密码不能为空");
        }
        if (StringUtils.isBlank(newPassword)) {
            throw new IllegalArgumentException("新密码不能为空");
        }

        AppUser user = AppUserUtils.getLoginAppUser();
        appUserServiceImpl.updatePassword(user.getId(), oldPassword, newPassword);
    }

    /**
     * 管理后台，给用户重置密码
     *
     * @param id          用户id
     * @param newPassword 新密码
     */
    @PreAuthorize("hasAuthority('back:user:password')")
    @PutMapping(value = "/users/{id}/password", params = {"newPassword"})
    public void resetPassword(@PathVariable Long id, String newPassword) {
        appUserServiceImpl.updatePassword(id, null, newPassword);
    }

    /**
     * 管理后台修改用户
     *
     * @param appUser
     */
    @PreAuthorize("hasAuthority('back:user:update')")
    @PutMapping("/users")
    public void updateAppUser(@RequestBody AppUser appUser) {
        appUserServiceImpl.updateAppUser(appUser);
    }

    /**
     * 管理后台给用户分配角色
     *
     * @param id      用户id
     * @param roleIds 角色ids
     */
    @PreAuthorize("hasAuthority('back:user:role:set')")
    @PostMapping("/users/{id}/roles")
    public void setRoleToUser(@PathVariable Long id, @RequestBody Set<Long> roleIds) {
        appUserServiceImpl.setRoleToUser(id, roleIds);
    }

    /**
     * 获取用户的角色
     *
     * @param id 用户id
     */
    @PreAuthorize("hasAnyAuthority('back:user:role:set','user:role:byuid')")
    @GetMapping("/users/{id}/roles")
    public Set<SysRole> findRolesByUserId(@PathVariable Long id) {
        return appUserServiceImpl.findRolesByUserId(id);
    }

}
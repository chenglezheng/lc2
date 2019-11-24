package com.lc.clz.dao;

import com.lc.clz.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface RoleDao extends JpaRepository<Role,Long> {

    @Query(value = "select id,code,name,create_time,update_time  from role where id in ( select role_id from role_user where user_id=?1)",nativeQuery = true )
    Set<Role> getRolesByUserId(Long userId);

    @Query(value = "select id from role where id in ( select role_id from role_user where user_id=?1)",nativeQuery = true )
    Set<Long> getRoleIdsByUserId(Long userId);

}

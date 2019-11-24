package com.lc.clz.dao;

import com.lc.clz.entities.Permission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface PermissionDao extends CrudRepository<Permission,Long> {


    @Query(value = "select id,code,permission,create_time,update_time  from permission where id in ( select permission_id from role_permission where role_id in (?1))",nativeQuery = true)
    Set<Permission> getPermissionByRoledIds(Set<Long> roleIds);

}

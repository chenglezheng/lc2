package com.lc.clz.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "role_permission", schema = "lc", catalog = "")
@IdClass(RolePermissionPK.class)
public class RolePermission {
    private long roleId;
    private long permissionId;

    @Id
    @Column(name = "role_id", nullable = false)
    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Id
    @Column(name = "permission_id", nullable = false)
    public long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(long permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolePermission that = (RolePermission) o;
        return roleId == that.roleId &&
                permissionId == that.permissionId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(roleId, permissionId);
    }
}

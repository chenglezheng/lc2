package com.lc.clz.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "role_user", schema = "lc", catalog = "")
@IdClass(RoleUserPK.class)
public class RoleUser {
    private long roleId;
    private long userId;

    @Id
    @Column(name = "role_id", nullable = false)
    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Id
    @Column(name = "user_id", nullable = false)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleUser roleUser = (RoleUser) o;
        return roleId == roleUser.roleId &&
                userId == roleUser.userId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(roleId, userId);
    }
}

package com.lc.clz.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_credentials", schema = "lc", catalog = "")
@IdClass(UserCredentialsPK.class)
public class UserCredentials {
    private String userName;
    private String type;
    private long userId;

    @Basic
    @Column(name = "user_name", nullable = false, length = 16)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Id
    @Column(name = "type", nullable = false, length = 50)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        UserCredentials that = (UserCredentials) o;
        return userId == that.userId &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userName, type, userId);
    }
}

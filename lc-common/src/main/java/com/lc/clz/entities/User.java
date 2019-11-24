package com.lc.clz.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class User {
    private long id;
    private String userName;
    private String password;
    private String nickName;
    private String sex;
    private Integer age;
    private String eMail;
    private String eMailFlag;
    private Integer phoneNumber;
    private Integer qq;
    private String wechat;
    private String vipLevel;
    private BigInteger roleId;
    private Boolean isEnabled;
    private Integer universityId;
    private Integer major;
    private String headImage;
    private BigInteger register;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_name", nullable = true, length = 16)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 200)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "nick_name", nullable = false, length = 16)
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Basic
    @Column(name = "sex", nullable = true, length = 1)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "age", nullable = true, precision = 0)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "e_mail", nullable = true, length = 100)
    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Basic
    @Column(name = "e_mail_flag", nullable = true, length = 1)
    public String geteMailFlag() {
        return eMailFlag;
    }

    public void seteMailFlag(String eMailFlag) {
        this.eMailFlag = eMailFlag;
    }

    @Basic
    @Column(name = "phone_number", nullable = true, precision = 0)
    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "qq", nullable = true, precision = 0)
    public Integer getQq() {
        return qq;
    }

    public void setQq(Integer qq) {
        this.qq = qq;
    }

    @Basic
    @Column(name = "wechat", nullable = true, length = 200)
    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    @Basic
    @Column(name = "vip_level", nullable = true, length = 1)
    public String getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(String vipLevel) {
        this.vipLevel = vipLevel;
    }

    @Basic
    @Column(name = "role_id", nullable = true, precision = 0)
    public BigInteger getRoleId() {
        return roleId;
    }

    public void setRoleId(BigInteger roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "is_enabled", nullable = true)
    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    @Basic
    @Column(name = "university_id", nullable = true, precision = 0)
    public Integer getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Integer universityId) {
        this.universityId = universityId;
    }

    @Basic
    @Column(name = "major", nullable = true, precision = 0)
    public Integer getMajor() {
        return major;
    }

    public void setMajor(Integer major) {
        this.major = major;
    }

    @Basic
    @Column(name = "head_image", nullable = true, length = 500)
    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    @Basic
    @Column(name = "register", nullable = true, precision = 0)
    public BigInteger getRegister() {
        return register;
    }

    public void setRegister(BigInteger register) {
        this.register = register;
    }

    @Basic
    @Column(name = "create_time", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time", nullable = false)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(password, user.password) &&
                Objects.equals(nickName, user.nickName) &&
                Objects.equals(sex, user.sex) &&
                Objects.equals(age, user.age) &&
                Objects.equals(eMail, user.eMail) &&
                Objects.equals(eMailFlag, user.eMailFlag) &&
                Objects.equals(phoneNumber, user.phoneNumber) &&
                Objects.equals(qq, user.qq) &&
                Objects.equals(wechat, user.wechat) &&
                Objects.equals(vipLevel, user.vipLevel) &&
                Objects.equals(roleId, user.roleId) &&
                Objects.equals(isEnabled, user.isEnabled) &&
                Objects.equals(universityId, user.universityId) &&
                Objects.equals(major, user.major) &&
                Objects.equals(headImage, user.headImage) &&
                Objects.equals(register, user.register) &&
                Objects.equals(createTime, user.createTime) &&
                Objects.equals(updateTime, user.updateTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userName, password, nickName, sex, age, eMail, eMailFlag, phoneNumber, qq, wechat, vipLevel, roleId, isEnabled, universityId, major, headImage, register, createTime, updateTime);
    }
}

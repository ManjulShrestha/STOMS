/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.am.stoms.model.identity.entity;

import com.am.stoms.model.common.entity.BaseEntity;
import com.am.stoms.model.common.entity.EmbeddedName;
import com.am.stoms.model.common.entity.ReferenceableByChild;
import java.io.Serializable;
import java.util.Set;
import javax.enterprise.inject.Model;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author manjul
 */
@Model
@Entity
@Table(name = "am_user")
public class User extends BaseEntity implements Serializable, ReferenceableByChild {

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "firstName", column = @Column(name = "FIRST_NAME"))
        ,
			@AttributeOverride(name = "middleName", column = @Column(name = "MIDDLE_NAME"))
        ,
			@AttributeOverride(name = "lastName", column = @Column(name = "LAST_NAME"))})
    private EmbeddedName nameEnglish;

    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private boolean active;

    @Column(name = "contact_no")
    private String contactNo;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String userName;

    @Column(name = "u_id")
    private String uuId;

    @Column(name = "login_attempt")
    private Integer loginAttempt;

    @Column(name = "first_time_login")
    private boolean firstTimeLogin;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_TYPE")
    private UserType userType;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = RoleGroup.class)
    @JoinTable(name = "am_user_role_group", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_group_id"))
    private Set<RoleGroup> roleGroupList;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Role.class)
    @JoinTable(name = "am_user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roleList;

    @Transient
    private String newPassword;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getUuId() {
        return uuId;
    }

    public void setUuId(String uuId) {
        this.uuId = uuId;
    }

    @Override
    public void setReferenceInChildren() {
        // TODO Auto-generated method stub

    }

    public Integer getLoginAttempt() {
        return loginAttempt;
    }

    public void setLoginAttempt(Integer loginAttempt) {
        this.loginAttempt = loginAttempt;
    }

    public EmbeddedName getNameEnglish() {
        return nameEnglish;
    }

    public void setNameEnglish(EmbeddedName nameEnglish) {
        this.nameEnglish = nameEnglish;
    }

    public boolean isFirstTimeLogin() {
        return firstTimeLogin;
    }

    public void setFirstTimeLogin(boolean firstTimeLogin) {
        this.firstTimeLogin = firstTimeLogin;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public Set<RoleGroup> getRoleGroupList() {
        return roleGroupList;
    }

    public void setRoleGroupList(Set<RoleGroup> roleGroupList) {
        this.roleGroupList = roleGroupList;
    }

    public Set<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(Set<Role> roleList) {
        this.roleList = roleList;
    }
    
    
}

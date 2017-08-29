/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.am.stoms.controller;

import com.am.stoms.commons.NavigationService;
import com.am.stoms.model.identity.entity.User;
import com.am.stoms.model.identity.service.IdentityService;
import com.am.stoms.utils.SHAHash;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author manjul
 */
@ManagedBean
@ViewScoped
public class LoginController {

    @Inject
    IdentityService identityService;
     
    @ManagedProperty("#{navigationService}")
    NavigationService navService;
    
    
    private String userName;
    private String password;
    
    @PostConstruct
    public void init(){
        
    }

    public void login() {
        User u=new User();
        u.setUserName(userName);
        u.setPassword(SHAHash.hash(password));
        System.out.println(u.getPassword());
        if(identityService.checkUser(u)){
            growl("Login Success", FacesMessage.SEVERITY_INFO);     
            navService.redirect(navService.getHome());
        }else{
            growl("Login Invalid", FacesMessage.SEVERITY_ERROR);
        }
     
    }
    
    public String logout(){
        return "";
    }

    private void growl(String msg, FacesMessage.Severity severity) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(severity, "", msg));
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public IdentityService getIdentityService() {
        return identityService;
    }

    public void setIdentityService(IdentityService identityService) {
        this.identityService = identityService;
    }

    public NavigationService getNavService() {
        return navService;
    }

    public void setNavService(NavigationService navService) {
        this.navService = navService;
    }
    
    
}

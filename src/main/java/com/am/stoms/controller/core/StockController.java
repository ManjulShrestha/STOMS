/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.am.stoms.controller.core;

import com.am.stoms.commons.NavigationService;
import com.am.stoms.model.core.service.CoreService;
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
public class StockController {

    @Inject
    CoreService coreService;
     
    @ManagedProperty("#{navigationService}")
    NavigationService navService;
    
    
  
    @PostConstruct
    public void init(){
        
    }

    

    private void growl(String msg, FacesMessage.Severity severity) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(severity, "", msg));
    }

  

    public NavigationService getNavService() {
        return navService;
    }

    public void setNavService(NavigationService navService) {
        this.navService = navService;
    }
    
    
}

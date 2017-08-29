/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.am.stoms.model.identity.service;

import com.am.stoms.model.common.SearchCriteria;
import com.am.stoms.model.identity.control.UserDao;
import com.am.stoms.model.identity.control.UserTypeDao;
import com.am.stoms.model.identity.entity.User;
import com.am.stoms.model.identity.entity.UserType;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author manjul
 */
@Stateless
public class IdentityService {
    
    @Inject
    UserTypeDao userTypeDao;
    
    @Inject
    UserDao userDao;
    
    public List<UserType> getUserType(){
        return userTypeDao.getUserTypes(null);
    }
    
    public User getUser(User u){
        SearchCriteria criteria=new SearchCriteria();
        criteria.setUserName(u.getUserName());
        return userDao.getUser(criteria);
    }
    
    public boolean checkUser(User u){
        SearchCriteria criteria=new SearchCriteria();
        criteria.setUserName(u.getUserName());
        User tempUser=userDao.getUser(criteria);
        if (u.getPassword().equals(tempUser.getPassword())){
            return true;
        }
        else{
            return false;
        }
    }
    
}

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.am.stoms.commons;

import com.am.stoms.model.identity.entity.Resource;
import com.am.stoms.model.identity.entity.Role;
import com.am.stoms.model.identity.entity.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author manjul.shrestha
 */
@ManagedBean(name = "authorizationService")
@SessionScoped
public class AuthorizationService {    
    User user;
    List<Role> roleList;
    List<Resource> urlResourceList;
    Map<String, Resource> visualElemResourceMap; 
  
    
    public AuthorizationService() {
    }
    
    public List<Role> getRoleList() {
        return roleList;
    }
    
    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
        // when role list is set, also set url resource list
        setUrlResourceList();
        setVisualElemResourceMap();
    }
    
    // add context path to url
    public Resource getUrlResource(String requestUrl, String contextPath) {
        // Iterate over URLs to identify accessibility
        for (Resource urlResource: urlResourceList) {
         
            if (requestUrl.startsWith(contextPath+urlResource.getData())) {
                return urlResource;
            }
        }
        return null;
    }
    
    // Set all accessible urls for the user
    private void setUrlResourceList() {
        urlResourceList = new ArrayList<>();
        for (Role r: getRoleList()) {
            for (Resource resource: r.getResourceList()) {
                if (resource.getResourceType().equals("page")) {
                    urlResourceList.add(resource);
                }
            }
        }
    }
    
    public List<Resource> getUrlResourceList() {
        return urlResourceList;
    }
    
    public Resource getVisualElemResource(String name) {
        return visualElemResourceMap.get(name);
    }
    
    private void setVisualElemResourceMap() {
        visualElemResourceMap = new HashMap<>();
        for (Role r: getRoleList()) {
            for (Resource resource: r.getResourceList()) {
                // NOTE: Assumed all non pages resource are visual element resource
                if (!resource.getResourceType().equals("page")) {
                    visualElemResourceMap.put(resource.getName(), resource);
                }
            }
        }
    }  
    public Map<String, Resource> getVisualElemResourceMap() {
        return visualElemResourceMap;
    }
    
    public void setVisualElemResourceMap(Map<String, Resource> visualElemResourceList) {
        this.visualElemResourceMap = visualElemResourceList;
    }
    
    public User getUser() {
        return user;
    }   
    
    public void setUser(User user) {
        this.user = user;
    }  
}

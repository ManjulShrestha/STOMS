/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.am.stoms.model.common.entity;

/**
 *
 * @author manjul
 */
public interface ReferenceableByChild {
    // Sets reference of the parent object (this) in the children objects (composition)
    // NOTE: This method is called before any entity is being saved in PersistentManager
    public void setReferenceInChildren();
}

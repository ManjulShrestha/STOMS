/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.am.stoms.model.identity.entity;

import com.am.stoms.model.common.entity.BaseEntity;
import com.am.stoms.model.common.entity.ReferenceableByChild;
import java.io.Serializable;
import javax.enterprise.inject.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author manjul
 */
@Model
@Entity
@Table(name = "am_user_type")
public class UserType extends BaseEntity implements Serializable, ReferenceableByChild{

	@Column(name = "NAME_ENGLISH")
	private String englishName;

	@Column(name = "NAME_NEPALI")
	private String nepaliName;
	
	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getNepaliName() {
		return nepaliName;
	}

	public void setNepaliName(String nepaliName) {
		this.nepaliName = nepaliName;
	}

	@Override
	public void setReferenceInChildren() {
		// TODO Auto-generated method stub
		
	}
}

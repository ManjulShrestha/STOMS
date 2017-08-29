/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.am.stoms.model.common;


import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author manjul
 */

public class FilterQueryGenerator {

	public static Query generateSelect(StringBuilder base, EntityManager em, SearchCriteria searchCriteria) {
		if (searchCriteria != null) {
			if (searchCriteria.getId() != null && searchCriteria.getId() != 0) {
				base.append(" and entity.id=:id");
			}
			if (searchCriteria.getName() != null && !searchCriteria.getName().isEmpty()) {
				base.append(" and lower(entity.name) like :name || '%'");
			}
			if (searchCriteria.getDescription() != null && !searchCriteria.getDescription().isEmpty()) {
				base.append(" and lower(entity.description) like :description || '%'");
			}			
			if (null != searchCriteria.getActive()) {
				base.append(" and entity.active=:active");
			}
			if (null != searchCriteria.getDeleted()) {
				base.append(" and entity.deleted=:deleted");
			}
                        if (null != searchCriteria.getUserName()) {
				base.append(" and entity.userName=:userName");
			}
		}
		

		Query query = em.createQuery(base.toString());

		if (searchCriteria != null) {
			if (searchCriteria.getId() != null && searchCriteria.getId() != 0) {
				query.setParameter("id", searchCriteria.getId());
			}
			if (searchCriteria.getName() != null && !searchCriteria.getName().isEmpty()) {
				query.setParameter("name", searchCriteria.getName());
			}
			if (searchCriteria.getDescription() != null && !searchCriteria.getDescription().isEmpty()) {
				query.setParameter("description", searchCriteria.getDescription());
			}
			if (searchCriteria.getActive() != null) {
				query.setParameter("active", searchCriteria.getActive());
			}
			if (searchCriteria.getDeleted() != null) {
				query.setParameter("deleted", searchCriteria.getDeleted());
			}
                        if (searchCriteria.getUserName()!= null) {
				query.setParameter("userName", searchCriteria.getUserName());
			}
		}
		return query;
	}

}


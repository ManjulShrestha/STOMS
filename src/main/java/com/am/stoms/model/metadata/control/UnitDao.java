/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.am.stoms.model.metadata.control;

import com.am.stoms.model.common.FilterQueryGenerator;
import com.am.stoms.model.common.PersistenceManager;
import com.am.stoms.model.common.SearchCriteria;
import com.am.stoms.model.metadata.entity.Unit;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.persistence.Query;


/**
 *
 * @author manjul
 */
@Dependent
public class UnitDao extends PersistenceManager<Unit, Serializable> {
	@SuppressWarnings("unchecked")
	public List<Unit> getAllUnit(SearchCriteria searchCriteria){		
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("SELECT entity FROM Unit entity where 1=1");			
		Query query = FilterQueryGenerator.generateSelect(strBuilder, super.em, searchCriteria);
		return (List<Unit>) query.getResultList();
	}
}

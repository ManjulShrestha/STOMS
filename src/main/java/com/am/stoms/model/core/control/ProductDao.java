/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.am.stoms.model.core.control;

import com.am.stoms.model.common.FilterQueryGenerator;
import com.am.stoms.model.common.PersistenceManager;
import com.am.stoms.model.common.SearchCriteria;
import com.am.stoms.model.core.entity.Product;
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
public class ProductDao extends PersistenceManager<Product, Serializable> {
	@SuppressWarnings("unchecked")
	public List<Product> getAllProduct(SearchCriteria searchCriteria){		
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("SELECT entity FROM Product entity where 1=1");			
		Query query = FilterQueryGenerator.generateSelect(strBuilder, super.em, searchCriteria);
		return (List<Product>) query.getResultList();
	}
}

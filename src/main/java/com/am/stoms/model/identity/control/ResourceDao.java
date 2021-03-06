package com.am.stoms.model.identity.control;

import com.am.stoms.model.common.FilterQueryGenerator;
import com.am.stoms.model.common.PersistenceManager;
import com.am.stoms.model.common.SearchCriteria;
import com.am.stoms.model.identity.entity.Resource;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

public class ResourceDao extends PersistenceManager<Resource, Serializable> {

	@SuppressWarnings("unchecked")
	public List<Resource> getSearchedResources(SearchCriteria searchCriteria) {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("SELECT entity FROM Resource entity where 1=1");
		// String jpql = "SELECT entity FROM Resource entity where 1=1";
		Query query = FilterQueryGenerator.generateSelect(strBuilder, super.em, searchCriteria);
		return (List<Resource>) query.getResultList();
	}
}

package com.am.stoms.model.identity.control;

import com.am.stoms.model.common.FilterQueryGenerator;
import com.am.stoms.model.common.PersistenceManager;
import com.am.stoms.model.common.SearchCriteria;
import com.am.stoms.model.identity.entity.RoleGroup;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

public class RoleGroupDao extends PersistenceManager<RoleGroup, Serializable> {

	@SuppressWarnings("unchecked")
	public List<RoleGroup> getSearchedRoleGroups(SearchCriteria searchCriteria) {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("SELECT entity FROM RoleGroup entity where 1=1");
		// String jpql = "SELECT entity FROM RoleGroup entity where 1=1";
		Query query = FilterQueryGenerator.generateSelect(strBuilder, super.em, searchCriteria);
		return (List<RoleGroup>) query.getResultList();
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.am.stoms.model.common;

import com.am.stoms.model.common.entity.ReferenceableByChild;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.Dependent;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Manjul
 *
 * @param <T>
 * @param <PK>
 */
public class PersistenceManager<T extends ReferenceableByChild, PK extends Serializable> {

	@PersistenceContext(unitName = "stoms")
	protected EntityManager em;

	private final Class<T> clazz;

	@SuppressWarnings("unchecked")
	public PersistenceManager() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.clazz = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
		// this.clazz = (Class<T>) ((ParameterizedType)
		// getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void save(T t) {
		t.setReferenceInChildren();
		em.persist(t);
	}

	public void update(T t) {
		t.setReferenceInChildren();
		em.merge(t);
	}

	public T read(PK id) {
		return em.find(clazz, id);
	}
	
	@SuppressWarnings("unchecked")
	public T read(PK id, String entityGraphName){
		EntityGraph graph = this.em.getEntityGraph(entityGraphName);
		Map hints = new HashMap();
		hints.put("javax.persistence.fetchgraph", graph);
		return (T) this.em.find(clazz, id, hints);
	}
	
	public void delete(T t) {
		em.remove(t);
	}
	
	public T saveAndReturnObject(T t) {
		t.setReferenceInChildren();
		em.persist(t);
		return t;
	}

	/**
	 * Queries the state of any entity object at a specific revision Is used to
	 * obtain the audit trail of the entities
	 * 
	 * @param id
	 *            ID of the entity
	 * @param version
	 *            Version number generated by enver
	 * @return T
	 */
	// public T readVersioned(PK id, int version){
	// AuditReader reader = AuditReaderFactory.get(em);
	// return reader.find(clazz, id, version);
	// }

}

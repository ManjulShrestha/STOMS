/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.am.stoms.model.common.entity;

import java.util.Date;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 *
 * @author manjul
 */
@MappedSuperclass
public class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Access(AccessType.PROPERTY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "DELETED")
	private boolean deleted;

	@Column(name = "DELETED_BY")
	private Integer deletedBy;

	@Column(name = "DELETED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date deletedOn;

	@Column(name = "ADDED_BY")
	private Integer addedBy;

	// @CreationTimestamp
	@Column(name = "ADDED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date addedDate;

	@Column(name = "MODIFIED_BY")
	private Integer modifiedBy;

	// @UpdateTimestamp
	@Column(name = "MODIFIED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;

	// NOTE: VersionId of -1 means Unsaved Object
	@Version
	@Column(name = "VERSION_ID")
	private Integer versionId = -1;
	
	// Save addedBy and addedDate before creating object
	@PrePersist
	public void prePersist() {
		this.addedBy = this.modifiedBy;
		this.addedDate = new Date();
		this.modifiedDate = new Date();
	}

	// Save modifiedBy and modifiedDate before updating object
	// Save deletedBy and deletedDate before soft-deleting object
	// Delete operation is indicated by the deleted flag
	@PreUpdate
	public void preUpdate() {
		// modifiedBy is always set by the object crawler
		// The value from modifiedBy is also used to populate the values
		// for addedBy and deletedBy
		this.modifiedDate = new Date();

		// Soft-delete by setting meta-data
		if (this.deleted) {
			this.deletedOn = new Date();
			this.deletedBy = this.modifiedBy;
		}
	}

	// NOTE:
	// No @PreRemove
	// We never hard-delete information persisted in database

	// The string representation of the object
	// is the unique identifier
	// NOTE: Has been used in Audit Log
	@Override
	public String toString() {
		if (id == null)
			return null;
		return id.toString();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Integer getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(Integer deletedBy) {
		this.deletedBy = deletedBy;
	}

	public Date getDeletedOn() {
		return deletedOn;
	}

	public void setDeletedOn(Date deletedOn) {
		this.deletedOn = deletedOn;
	}

	public Integer getVersionId() {
		return versionId;
	}

	public void setVersionId(Integer versionId) {
		this.versionId = versionId;
	}

	public Integer getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(Integer addedBy) {
		this.addedBy = addedBy;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}


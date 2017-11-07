/****************************************************************************************
 **   Copyright 2013-14 USCS.  All rights reserved.
 **   
 **   No Part of this file should be copied or distributed without the permission of USCS.
 **   Application       :     eWMS
 **   Module            :     
 **   File              :     ContactDetailsService.java
 **   Description       :     This is a Value Object class for list of Contact Details.
 **   Author            :     Cognizant Technology Solutions
 **   Created Date      :     Sep 26, 2013
 *****************************************************************************************
 */

package com.rgs.util.reflection;

public class ContactDetailsService {

	/** *contactName: represents Contact Name */
	private String contactName;

	/** *title: represents title */
	private String title;

	/** *attention: represents attention */
	private String attention;

	/** *contactType: represents Contact Type */
	private Integer contactType;

	/** *contactPriority: represents Contact Priority */
	private Integer contactPriority;

	/** *phonNo: represents Contact Phone No. */
	private Long phonNo;

	/** *eMail: represents Contact Email Id */
	private String eMail;

	/** *phonExtension: represents Contact Phone Extension */
	private Long phonExtension;

	/** *faxPhno: represents Contact Fax No. */
	private Long faxPhno;

	/** *contactId: represents Contact Id */
	private Long contactId;

	/** *comments: represents comments for Contact Details */
	private String comments;
	
	/** *createdBy: represents created */
	private String created;

	/** *lastUpdated: represents lastUpdated */
	private String updated;
	
	/** *updatedBy: represents createdBy */
	private String createdBy;
	
	/** *updatedBy: represents updatedBy */
	private String updatedBy;

	/**
	 * @return the contactName
	 */
	public String getContactName() {
		return this.contactName;
	}

	/**
	 * @param contactName the contactName to set
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the attention
	 */
	public String getAttention() {
		return this.attention;
	}

	/**
	 * @param attention the attention to set
	 */
	public void setAttention(String attention) {
		this.attention = attention;
	}

	/**
	 * @return the contactType
	 */
	public Integer getContactType() {
		return this.contactType;
	}

	/**
	 * @param contactType the contactType to set
	 */
	public void setContactType(Integer contactType) {
		this.contactType = contactType;
	}

	/**
	 * @return the contactPriority
	 */
	public Integer getContactPriority() {
		return this.contactPriority;
	}

	/**
	 * @param contactPriority the contactPriority to set
	 */
	public void setContactPriority(Integer contactPriority) {
		this.contactPriority = contactPriority;
	}

	/**
	 * @return the phonNo
	 */
	public Long getPhonNo() {
		return this.phonNo;
	}

	/**
	 * @param phonNo the phonNo to set
	 */
	public void setPhonNo(Long phonNo) {
		this.phonNo = phonNo;
	}

	/**
	 * @return the eMail
	 */
	public String geteMail() {
		return this.eMail;
	}

	/**
	 * @param eMail the eMail to set
	 */
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	/**
	 * @return the phonExtension
	 */
	public Long getPhonExtension() {
		return this.phonExtension;
	}

	/**
	 * @param phonExtension the phonExtension to set
	 */
	public void setPhonExtension(Long phonExtension) {
		this.phonExtension = phonExtension;
	}

	/**
	 * @return the faxPhno
	 */
	public Long getFaxPhno() {
		return this.faxPhno;
	}

	/**
	 * @param faxPhno the faxPhno to set
	 */
	public void setFaxPhno(Long faxPhno) {
		this.faxPhno = faxPhno;
	}

	/**
	 * @return the contactId
	 */
	public Long getContactId() {
		return this.contactId;
	}

	/**
	 * @param contactId the contactId to set
	 */
	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return this.comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 * @return the created
	 */
	public String getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(String created) {
		this.created = created;
	}

	/**
	 * @return the updated
	 */
	public String getUpdated() {
		return this.updated;
	}

	/**
	 * @param updated the updated to set
	 */
	public void setUpdated(String updated) {
		this.updated = updated;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

}

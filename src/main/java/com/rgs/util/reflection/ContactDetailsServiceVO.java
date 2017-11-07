/****************************************************************************************
 **   Copyright 2013-14 USCS.  All rights reserved.
 **   
 **   No Part of this file should be copied or distributed without the permission of USCS.
 **   Application       :     eWMS
 **   Module            :     
 **   File              :     ContactDetailsServiceVO.java
 **   Description       :     This is a Wrapper class for the ContactDetailsService class.
 **   Author            :     Cognizant Technology Solutions
 **   Created Date      :     Dec 31, 2013
 *****************************************************************************************
 */
package com.rgs.util.reflection;

import java.util.ArrayList;
import java.util.List;

public class ContactDetailsServiceVO {

	/** contactDetailsServiceList represents Contact Details Service List */
	private List<ContactDetailsService> contactDetailsServiceList;

	/** comment represents Comment */
	private String comment;

	/**
	 * @return the contactDetailsServiceList
	 */
	public List<ContactDetailsService> getContactDetailsServiceList() {
		if (contactDetailsServiceList == null)
			contactDetailsServiceList = new ArrayList<ContactDetailsService>();
		return contactDetailsServiceList;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return this.comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

}

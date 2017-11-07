package com.rgs.util.reflection;

public class CustomerVO {

	private SomeOtherCustomerRelatedVO someVO;

	private ContactDetailsServiceVO contactDetailsServiceVO;

	private Long customerId;

	public SomeOtherCustomerRelatedVO getSomeVO() {
		return this.someVO;
	}

	public void setSomeVO(SomeOtherCustomerRelatedVO someVO) {
		this.someVO = someVO;
	}

	public ContactDetailsServiceVO getContactDetailsServiceVO() {
		if (contactDetailsServiceVO == null) {
			contactDetailsServiceVO = new ContactDetailsServiceVO();
		}
		return contactDetailsServiceVO;
	}

	public void setContactDetailsServiceVO(ContactDetailsServiceVO contactDetailsServiceVO) {
		this.contactDetailsServiceVO = contactDetailsServiceVO;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

}

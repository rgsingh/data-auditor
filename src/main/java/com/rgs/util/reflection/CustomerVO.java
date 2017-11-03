package com.rgs.util.reflection;

public class CustomerVO {

	private SomeOtherCustomerRelatedVO someVO;

	private Long customerId;

	public SomeOtherCustomerRelatedVO getSomeVO() {
		return this.someVO;
	}

	public void setSomeVO(SomeOtherCustomerRelatedVO someVO) {
		this.someVO = someVO;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

}


package com.rgs.util.reflection;

public class SomeOtherCustomerRelatedVO {

	/** addressLine1 represents Address Line 1 */
	private String addressLine1;

	/** addressLine2 represents Address Line 2 */
	private String addressLine2;

	/** addressLine3 represents Address Line 3 */
	private String addressLine3;

	/** city represents City */
	private String city;

	/** state represents State */
	private Long state;

	/** zip represents ZIP Code */
	private String zip;

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getState() {
		return state;
	}

	public void setState(Long state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
}

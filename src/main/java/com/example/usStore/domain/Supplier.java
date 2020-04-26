package com.example.usStore.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Supplier  implements Serializable {
	/* Private Fields */
	private String supplierId;	 //(PK)
	private String name;		 
	private String address1;
	private String address2;
	private String city;
	private String zip;
	private String phone;
		
	/* JavaBeans Properties */
	public String getSupplierId() { return supplierId; }
	public void setSupplierId(String supplierId) { this.supplierId = supplierId; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public String getAddress1() { return address1; }
	public void setAddress1(String address1) { this.address1 = address1; }
	
	public String getAddress2() { return address2; }
	public void setAddress2(String address2) { this.address2 = address2; }
	
	public String getCity() { return city; }
	public void setCity(String city) { this.city = city; }
	
	public String getZip() { return zip; }
	public void setZip(String zip) { this.zip = zip; }
	
	public String getPhone() { return phone; }
	public void setPhone(String phone) { this.phone = phone; }
		
	/* Public Methods */
	public String toString() {
		return "ÆÇ¸ÅÀÚ : " + getSupplierId() + " (" + getName() + ")";
	}
}

package model;

public class Custemer {
	private int customerId;
	private String name;
	private String email;
	private Long phoneNo;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Custemer(int customerId, String name, String email, Long phoneNo) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
	}
	@Override
	public String toString() {
		 return "\n------------------------------"
		            + "\nCustomer ID : " + customerId
		            + "\nName        : " + name
		            + "\nEmail       : " + email
		            + "\nPhone No    : " + phoneNo
		            + "\n------------------------------";	
	}
	
}

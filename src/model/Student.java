package model;

public class Student {

	private String email;
	private String upass;
	private String upass1;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String email, String upass, String upass1) {
		super();
		
		this.email = email;
		this.upass = upass;
		this.upass1 = upass1;
	}
	
	
	public Student(String email, String upass) {
		super();
		this.email = email;
		this.upass = upass;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public String getUpass1() {
		return upass1;
	}
	public void setUpass1(String upass1) {
		this.upass1 = upass1;
	}
	

}

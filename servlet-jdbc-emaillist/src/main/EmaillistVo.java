package main;

public class EmaillistVo {

	private int no;
	private String lastName;
	private String firstName;
	private String email;

	
	public EmaillistVo() {}

	public EmaillistVo(int no, String lastName, String firstName, String email) {
		this.no = no;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
	}

	public EmaillistVo(String lastName, String firstName, String email) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "EmaillistVo [no=" + no + ", lastName=" + lastName + ", firstName=" + firstName + ", email=" + email
				+ "]";
	}
	
	
	
	
}

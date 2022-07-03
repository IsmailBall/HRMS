package kodlamaio.hrms.entities.dtos;

public class EmployerSignUpDto {

	private String email;

	private String password;

	private String passwordAgain;
	
	private String companyName;

	private String WebSite;

	private String phoneNumber;

	public EmployerSignUpDto(String email, String password, String passwordAgain, String companyName, String webSite,
			String phoneNumber) {
		super();
		this.email = email;
		this.password = password;
		this.passwordAgain = passwordAgain;
		this.companyName = companyName;
		WebSite = webSite;
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordAgain() {
		return passwordAgain;
	}

	public void setPasswordAgain(String passwordAgain) {
		this.passwordAgain = passwordAgain;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getWebSite() {
		return WebSite;
	}

	public void setWebSite(String webSite) {
		WebSite = webSite;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "EmployerSignUpDto [email=" + email + ", password=" + password + ", passwordAgain=" + passwordAgain
				+ ", companyName=" + companyName + ", WebSite=" + WebSite + ", phoneNumber=" + phoneNumber + "]";
	}
	
}
